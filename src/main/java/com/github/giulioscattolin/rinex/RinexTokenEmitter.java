package com.github.giulioscattolin.rinex;

import static com.github.giulioscattolin.rinex.RinexTokenizerProvider.TokenizerName.RINEX_VERSION_TYPE;

class RinexTokenEmitter implements RinexTokenizer, RinexTokenizerDriver {
    private final RinexTokenCollector itsTokenCollector;
    private RinexTokenizer itsTokenizer;

    public RinexTokenEmitter(RinexTokenCollector tokenCollector) {
        itsTokenCollector = tokenCollector;
        itsTokenizer = getRinexTokenizerProvider().provideTokenizer(RINEX_VERSION_TYPE);
    }

    private RinexTokenizerProviderFacade getRinexTokenizerProvider() {
        RinexTokenizerProviderFacade tokenizerProvider = new RinexTokenizerProviderFacade();
        tokenizerProvider.setTokenCollector(itsTokenCollector);
        tokenizerProvider.setTokenizerDriver(this);
        return tokenizerProvider;
    }

    public void setLineNumber(int lineNumber) {
        itsTokenizer.setLineNumber(lineNumber);
    }

    public void readLine(String line) {
        itsTokenizer.readLine(line);
    }

    public void setTokenizer(RinexTokenizer tokenizer) {
        itsTokenizer = tokenizer;
    }
}
