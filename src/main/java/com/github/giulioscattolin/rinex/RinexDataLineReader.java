package com.github.giulioscattolin.rinex;

import java.util.function.Function;
import java.util.function.Supplier;

import static java.lang.Double.isNaN;

public class RinexDataLineReader {
    private final RinexDataCollector itsCollector;
    MutableRinexGpsNavigationMessage itsGpsNavigationMessage;
    RinexNavigationMessageBuilder itsNavigationMessageBuilder;
    private LineReader itsReader = new VersionTypeReader();
    private Supplier<LineReader> itsDataReaderSupplier;

    public RinexDataLineReader(RinexDataCollector collector) {
        this.itsCollector = collector;
    }

    public void readLine(String line) {
        itsReader.readLine(line);
    }

    class VersionTypeReader extends LineReader {
        protected void readLine() {
            if (isHeader("RINEX VERSION / TYPE"))
                parseLine();
        }

        private void parseLine() {
            String version = itsLine.substring(0, 9).trim();
            char fileType = itsLine.charAt(20);
            char satelliteSystem = itsLine.charAt(40);
            switch (version) {
                case "2":
                    switch (fileType) {
                        case 'N':
                            itsReader = new HeaderReader();
                            itsDataReaderSupplier = () ->
                                new SvEpochSvClk(
                                    new SvEpochSvClkReaderV2('G'),
                                    (ignored) -> new RinexGpsNavigationMessageBuilderV2(),
                                    () -> new BroadcastOrbitReader(new BroadcastOrbitParameterReaderV2()));
                            return;
                    }
                case "2.10":
                    switch (fileType) {
                        case 'N':
                            itsReader = new HeaderReader();
                            itsDataReaderSupplier = () ->
                                new SvEpochSvClk(
                                    new SvEpochSvClkReaderV2('G'),
                                    (ignored) -> new RinexGpsNavigationMessageBuilderV210(),
                                    () -> new BroadcastOrbitReader(new BroadcastOrbitParameterReaderV2()));
                            return;
                    }
                case "3.02":
                case "3.03":
                case "3.04":
                    switch (fileType) {
                        case 'N':
                            switch (satelliteSystem) {
                                case 'G':
                                    itsReader = new HeaderReader();
                                    itsDataReaderSupplier = () ->
                                        new SvEpochSvClk(
                                            new SvEpochSvClkReaderV3(),
                                            (ignored) -> new RinexGpsNavigationMessageBuilderV302(),
                                            () -> new BroadcastOrbitReader(new BroadcastOrbitParameterReaderV3()));
                                    return;
                            }
                    }
            }
        }
    }

    class HeaderReader extends LineReader {
        protected void readLine() {
            if (!findPgmRunByDate())
                findEndOfHeader();
        }

        private boolean findPgmRunByDate() {
            return false;
        }

        private void findEndOfHeader() {
            if (isHeaderLabelEqualTo("END OF HEADER"))
                itsReader = itsDataReaderSupplier.get();
        }
    }

    class SvEpochSvClk extends LineReader {
        private final SvEpochSvClkReader itsSvEpochSvClkReader;
        private final Function<Character, RinexNavigationMessageBuilder> itsNavigationMessageBuilderSupplier;
        private final Supplier<LineReader> itsBroadcastOrbitCompilerSupplier;

        SvEpochSvClk(SvEpochSvClkReader svEpochSvClkReader, Function<Character, RinexNavigationMessageBuilder> navigationMessageBuilderSupplier, Supplier<LineReader> broadcastOrbitCompilerSupplier) {
            itsSvEpochSvClkReader = svEpochSvClkReader;
            itsNavigationMessageBuilderSupplier = navigationMessageBuilderSupplier;
            itsBroadcastOrbitCompilerSupplier = broadcastOrbitCompilerSupplier;
        }

        protected void readLine() {
            if (isHeader("RINEX VERSION / TYPE")) {
                itsReader = new VersionTypeReader();
                return;
            }
            whichSatelliteSystem();
        }

        private void whichSatelliteSystem() {
            char satelliteSystem = itsSvEpochSvClkReader.getSatelliteSystem(itsLine);
            itsNavigationMessageBuilder = itsNavigationMessageBuilderSupplier.apply(satelliteSystem);
            switch (satelliteSystem) {
                case 'G':
                    itsGpsNavigationMessage = new MutableRinexGpsNavigationMessage();
                    itsReader = itsBroadcastOrbitCompilerSupplier.get();
                    findPrn();
                    return;
            }
        }

        private void findPrn() {
            int prn = itsSvEpochSvClkReader.getSatelliteNumberOrNegative(itsLine);
            if (prn < 0)
                return;
            itsNavigationMessageBuilder.setParameter(0, prn);
            findToc();
        }

        private void findToc() {
            int year = itsSvEpochSvClkReader.getTocYearOrNegative(itsLine);
            int month = itsSvEpochSvClkReader.getTocMonthOrNegative(itsLine);
            int day = itsSvEpochSvClkReader.getTocDayOrNegative(itsLine);
            int hour = itsSvEpochSvClkReader.getTocHourOrNegative(itsLine);
            int minute = itsSvEpochSvClkReader.getTocMinuteOrNegative(itsLine);
            int second = itsSvEpochSvClkReader.getTocSecondOrNegative(itsLine);
            if (year < 0 || month < 0 || day < 0 || hour < 0 || minute < 0 || second < 0)
                return;
            itsNavigationMessageBuilder.setParameter(1, year);
            itsNavigationMessageBuilder.setParameter(2, month);
            itsNavigationMessageBuilder.setParameter(3, day);
            itsNavigationMessageBuilder.setParameter(4, hour);
            itsNavigationMessageBuilder.setParameter(5, minute);
            itsNavigationMessageBuilder.setParameter(6, second);
            findSvClock();
        }

        private void findSvClock() {
            double first = itsSvEpochSvClkReader.getFirstTimeParameterOrNaN(itsLine);
            double second = itsSvEpochSvClkReader.getSecondTimeParameterOrNaN(itsLine);
            double third = itsSvEpochSvClkReader.getThirdTimeParameterOrNaN(itsLine);
            if (isNaN(first) || isNaN(second) || isNaN(third))
                return;
            itsNavigationMessageBuilder.setParameter(7, first);
            itsNavigationMessageBuilder.setParameter(8, second);
            itsNavigationMessageBuilder.setParameter(9, third);
        }
    }

    private class BroadcastOrbitReader extends LineReader {
        private final BroadcastOrbitParameterReader itsParameterReader;
        private int itsIndex = 10;
        private boolean shouldContinue = true;

        private BroadcastOrbitReader(BroadcastOrbitParameterReader parameterReader) {
            itsParameterReader = parameterReader;
        }

        protected void readLine() {
            for (int i = 0; i < 4 && shouldContinue; i++)
                readParameter(i);
        }

        private void readParameter(int i) {
            double value = itsParameterReader.getParameterOrNaN(itsLine, i);
            tellIfShouldContinue(value);
            if (shouldContinue) {
                itsNavigationMessageBuilder.setParameter(itsIndex++, value);
                collectIfBuilderIsReady();
            }
        }

        private void collectIfBuilderIsReady() {
            if (itsNavigationMessageBuilder.isReady()) {
                itsCollector.collect(itsNavigationMessageBuilder.build());
                itsReader = itsDataReaderSupplier.get();
                shouldContinue = false;
            }
        }

        private void tellIfShouldContinue(double value) {
            if (isNaN(value)) {
                itsReader = itsDataReaderSupplier.get();
                shouldContinue = false;
            }
        }
    }
}
