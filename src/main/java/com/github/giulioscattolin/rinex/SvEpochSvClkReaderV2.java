package com.github.giulioscattolin.rinex;

import static com.github.giulioscattolin.rinex.Utilities.*;

class SvEpochSvClkReaderV2 implements SvEpochSvClkReader {
    private final char itsSatelliteSystem;

    SvEpochSvClkReaderV2(char itsSatelliteSystem) {this.itsSatelliteSystem = itsSatelliteSystem;}

    public char getSatelliteSystem(String line) {
        return itsSatelliteSystem;
    }

    public int getSatelliteNumberOrNegative(String line) {
        return parseTwoDigitIntegerOrDefault(line.substring(0, 2), -1);
    }

    public int getTocYearOrNegative(String line) {
        int year = parseTwoDigitIntegerOrDefault(line.substring(3, 5), -1);
        if (year < 0)
            return year;
        if (year > 50)
            return year + 1900;
        else
            return year + 2000;
    }

    public int getTocMonthOrNegative(String line) {
        return parseTwoDigitIntegerOrDefault(line.substring(6, 8), -1);
    }

    public int getTocDayOrNegative(String line) {
        return parseTwoDigitIntegerOrDefault(line.substring(9, 11), -1);
    }

    public int getTocHourOrNegative(String line) {
        return parseTwoDigitIntegerOrDefault(line.substring(12, 14), -1);
    }

    public int getTocMinuteOrNegative(String line) {
        return parseTwoDigitIntegerOrDefault(line.substring(15, 17), -1);
    }

    public int getTocSecondOrNegative(String line) {
        String second = line.substring(18, 20);
        if (isBlank(second))
            return 0;
        else
            return parseTwoDigitIntegerOrDefault(second, -1);
    }

    public double getFirstTimeParameterOrNaN(String line) {
        return toFloatingPointNumberOrNaN(line.substring(22, 41));
    }

    public double getSecondTimeParameterOrNaN(String line) {
        return toFloatingPointNumberOrNaN(line.substring(41, 60));
    }

    public double getThirdTimeParameterOrNaN(String line) {
        return toFloatingPointNumberOrNaN(line.substring(60, 79));
    }
}
