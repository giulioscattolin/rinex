package com.github.giulioscattolin.rinex;

import static com.github.giulioscattolin.rinex.RinexTokenizerProvider.TokenizerName.NAVIGATION_FILE_HEADER_V302;
import static com.github.giulioscattolin.rinex.RinexTokenizerProvider.TokenizerName.NAVIGATION_FILE_HEADER_V304;

public class RinexVersionTypeHeaderTokenizer extends RinexTokenizerTemplate {
    private boolean itsSkipping;

    protected RinexVersionTypeHeaderTokenizer(RinexTokenCollector itsTokenCollector, RinexTokenizerProvider itsTokenizerProvider, RinexTokenizerDriver itsDriver) {
        super(itsTokenCollector, itsTokenizerProvider, itsDriver);
    }

    protected void readLine() {
        if (validateLine())
            tokenize();
    }

    private boolean validateLine() {
        boolean isValid = itsLine.length() >= 80;
        if (!isValid && !itsSkipping)
            emitError("incomplete line");
        return isValid && isRinexVersionTypeHeader();
    }

    private boolean isRinexVersionTypeHeader() {
        return "RINEX VERSION / TYPE".equals(getHeaderLabel());
    }

    private void tokenize() {
        String formatVersion = itsLine.substring(0, 9).trim();
        char fileType = itsLine.charAt(20);
        char satelliteSystem = itsLine.charAt(40);
        token(new RinexVersionTypeHeader(formatVersion, fileType, satelliteSystem));
        selectTokenizer(formatVersion, fileType, satelliteSystem);
    }

    private void selectTokenizer(String formatVersion, char fileType, char satelliteSystem) {
        if (trySelectTokenizer(formatVersion, fileType))
            activate();
        else
            skip(formatVersion, fileType, satelliteSystem);
    }

    private void activate() {
        itsSkipping = false;
    }

    private void skip(String formatVersion, char fileType, char satelliteSystem) {
        itsSkipping = true;
        emitError("unsupported format: (" + formatVersion + ", " + fileType + ", " + satelliteSystem +") (version, fileType, satelliteSystem)");
    }

    private boolean trySelectTokenizer(String formatVersion, char fileType) {
        switch (formatVersion) {
            case "3.04":
                return trySelectTokenizerForV304(fileType);
            case "3.02":
                return trySelectTokenizerForV302(fileType);
        }
        return false;
    }

    private boolean trySelectTokenizerForV304(char fileType) {
        switch (fileType) {
            case 'N':
                selectTokenizer(NAVIGATION_FILE_HEADER_V304);
                return true;
        }
        return false;
    }

    private boolean trySelectTokenizerForV302(char fileType) {
        switch (fileType) {
            case 'N':
                selectTokenizer(NAVIGATION_FILE_HEADER_V302);
                return true;
        }
        return false;
    }

    private void emitError(String message) {
        error(formatError(message));
    }

    private String formatError(String message) {
        return "while reading \"RINEX VERSION / TYPE\": " + message;
    }
}
