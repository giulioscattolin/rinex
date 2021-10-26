package com.github.giulioscattolin.rinex;

import static com.github.giulioscattolin.rinex.RinexTokenizerProvider.TokenizerName.*;
import static com.github.giulioscattolin.rinex.Utilities.*;
import static java.lang.Double.isNaN;

class SvEpochSvClockRecordV302Tokenizer extends RinexTokenizerTemplate {
    public static final int INVALID_INTEGER = -1;

    protected SvEpochSvClockRecordV302Tokenizer(RinexTokenCollector itsTokenCollector, RinexTokenizerProvider itsTokenizerProvider, RinexTokenizerDriver itsDriver) {
        super(itsTokenCollector, itsTokenizerProvider, itsDriver);
    }

    protected void readLine() {
        if (validateLine())
            tokenize();
    }

    private boolean validateLine() {
        boolean isValid = itsLine.length() >= 80;
        if (!isValid)
            emitError("incomplete line");
        return isValid;
    }

    private void tokenize() {
        char satelliteSystem = itsLine.charAt(0);
        int satelliteNumber = parseTwoDigitIntegerOrDefault(itsLine.substring(1, 3), INVALID_INTEGER);
        int year = parseFourDigitIntegerOrDefault(itsLine.substring(4, 8), INVALID_INTEGER);
        int month = parseTwoDigitIntegerOrDefault(itsLine.substring(9, 11), INVALID_INTEGER);
        int day = parseTwoDigitIntegerOrDefault(itsLine.substring(12, 14), INVALID_INTEGER);
        int hour = parseTwoDigitIntegerOrDefault(itsLine.substring(15, 17), INVALID_INTEGER);
        int minute = parseTwoDigitIntegerOrDefault(itsLine.substring(18, 20), INVALID_INTEGER);
        int second = parseTwoDigitIntegerOrDefault(itsLine.substring(21, 23), INVALID_INTEGER);
        double[] parameters = new double[]{
            toFloatingPointNumberOrNaN(itsLine.substring(23, 42)),
            toFloatingPointNumberOrNaN(itsLine.substring(42, 61)),
            toFloatingPointNumberOrNaN(itsLine.substring(61, 80))
        };
        if (isInvalid(satelliteSystem, satelliteNumber, year, month, day, hour, minute, second, parameters))
            return;
        token(new ImmutableSvEpochSvClkRecord(satelliteSystem, satelliteNumber, year, month, day, hour, minute, second, parameters));
        selectTokenizer(BROADCAST_ORBIT_V302);
    }

    private boolean isInvalid(char satelliteSystem, int satelliteNumber, int year, int month, int day, int hour, int minute, int second, double[] parameters) {
        return false ||
            isInvalid(satelliteSystem) ||
            isInvalid(satelliteNumber) ||
            isInvalid(year) ||
            isInvalid(month) ||
            isInvalid(day) ||
            isInvalid(hour) ||
            isInvalid(minute) ||
            isInvalid(second) ||
            !validate(parameters);
    }

    private boolean validate(double[] parameters) {
        int index = 0;
        int limit = parameters.length;
        boolean areValid = true;
        while (index < limit && areValid)
            areValid &= !isNaN(parameters[index++]);
        if (!areValid)
            emitError("invalid floating point number");
        return areValid;
    }

    private void emitError(String message) {
        error(formatError(message));
        selectTokenizer(RINEX_VERSION_TYPE);
    }

    private String formatError(String message) {
        return "while reading \"SV / EPOCH / SV CLK\": " + message;
    }

    private boolean isInvalid(int value) {
        boolean isInvalid = value == INVALID_INTEGER;
        if (isInvalid)
            emitError("invalid integer");
        return isInvalid;
    }
}
