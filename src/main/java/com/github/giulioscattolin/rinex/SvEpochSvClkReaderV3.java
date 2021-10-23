package com.github.giulioscattolin.rinex;

import static com.github.giulioscattolin.rinex.Utilities.*;

class SvEpochSvClkReaderV3 implements SvEpochSvClkReader {
    public char getSatelliteSystem(String line) {
        return line.charAt(0);
    }

    public int getSatelliteNumberOrNegative(String line) {
        return parseTwoDigitIntegerOrDefault(line.substring(1, 3), -1);
    }

    public int getTocYearOrNegative(String line) {
        return parseFourDigitIntegerOrDefault(line.substring(4, 8), -1);
    }

    public int getTocMonthOrNegative(String line) {
        return parseTwoDigitIntegerOrDefault(line.substring(9, 11), -1);
    }

    public int getTocDayOrNegative(String line) {
        return parseTwoDigitIntegerOrDefault(line.substring(12, 14), -1);
    }

    public int getTocHourOrNegative(String line) {
        return parseTwoDigitIntegerOrDefault(line.substring(15, 17), -1);
    }

    public int getTocMinuteOrNegative(String line) {
        return parseTwoDigitIntegerOrDefault(line.substring(18, 20), -1);
    }

    public int getTocSecondOrNegative(String line) {
        return parseTwoDigitIntegerOrDefault(line.substring(21, 23), -1);
    }

    public double getFirstTimeParameterOrNaN(String line) {
        return toFloatingPointNumberOrNaN(line.substring(24, 42));
    }

    public double getSecondTimeParameterOrNaN(String line) {
        return toFloatingPointNumberOrNaN(line.substring(42, 61));
    }

    public double getThirdTimeParameterOrNaN(String line) {
        return toFloatingPointNumberOrNaN(line.substring(61, 80));
    }
}
