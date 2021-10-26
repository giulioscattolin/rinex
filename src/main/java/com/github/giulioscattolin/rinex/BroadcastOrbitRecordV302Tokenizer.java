package com.github.giulioscattolin.rinex;

import static com.github.giulioscattolin.rinex.RinexTokenizerProvider.TokenizerName.SV_EPOCH_SV_CLK_V302;
import static com.github.giulioscattolin.rinex.RinexTokenizerProvider.TokenizerName.SV_EPOCH_SV_CLK_V304;
import static com.github.giulioscattolin.rinex.Utilities.toFloatingPointNumberOrNaN;
import static java.lang.Double.isNaN;

class BroadcastOrbitRecordV302Tokenizer extends RinexTokenizerTemplate {
    private int itsOrbitNumber = 1;

    public BroadcastOrbitRecordV302Tokenizer(RinexTokenCollector tokenCollector, RinexTokenizerProvider tokenizerProvider, RinexTokenizerDriver tokenDriver) {
        super(tokenCollector, tokenizerProvider, tokenDriver);
    }

    protected void readLine() {
        if (validateLine())
            tokenizeBroadcastOrbit();
    }

    private void tokenizeBroadcastOrbit() {
        double[] parameters = getParameters();
        if (validate(parameters))
            emit(parameters);
    }

    private boolean validateLine() {
        boolean isValid = false;
        if (itsOrbitNumber < 7)
            if (itsLine.length() >= 80)
                isValid = true;
            else
                emitError("line is incomplete");
        else
            isValid = true;
        return isValid;
    }

    private double[] getParameters() {
        if (itsOrbitNumber < 7)
            return new double[]{
                toFloatingPointNumberOrNaN(itsLine.substring(4, 23)),
                toFloatingPointNumberOrNaN(itsLine.substring(23, 42)),
                toFloatingPointNumberOrNaN(itsLine.substring(42, 61)),
                toFloatingPointNumberOrNaN(itsLine.substring(61, 80))
            };
        else
            return new double[]{
                toFloatingPointNumberOrNaN(itsLine.substring(4, 23)),
                toFloatingPointNumberOrNaN(itsLine.substring(23, 42))
            };
    }

    private void emit(double[] parameters) {
        token(new ImmutableRinexBroadcastOrbitRecord(parameters));
        if (isDone())
            selectTokenizer(SV_EPOCH_SV_CLK_V302);
    }

    private boolean isDone() {
        return ++itsOrbitNumber == 8;
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
        selectTokenizer(SV_EPOCH_SV_CLK_V302);
    }

    private String formatError(String message) {
        return "error while reading \"BROADCAST ORBIT - " + itsOrbitNumber + "\": " + message;
    }
}
