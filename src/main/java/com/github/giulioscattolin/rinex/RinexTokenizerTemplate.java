package com.github.giulioscattolin.rinex;

public abstract class RinexTokenizerTemplate implements RinexTokenizer {
    protected final RinexTokenizerProvider itsTokenizerProvider;
    protected final RinexTokenizerDriver itsDriver;
    private final RinexTokenCollector itsTokenCollector;
    protected String itsLine;
    private int itsLineNumber;

    protected RinexTokenizerTemplate(RinexTokenCollector itsTokenCollector, RinexTokenizerProvider itsTokenizerProvider, RinexTokenizerDriver itsDriver) {
        this.itsTokenCollector = itsTokenCollector;
        this.itsTokenizerProvider = itsTokenizerProvider;
        this.itsDriver = itsDriver;
    }

    public void setLineNumber(int lineNumber) {
        itsLineNumber = lineNumber;
    }

    public void readLine(String line) {
        itsLine = line;
        itsLineNumber++;
        readLine();
    }

    protected abstract void readLine();

    protected String getHeaderLabel() {
        return itsLine.substring(60).trim();
    }

    protected void tokenizePgmRunByDate() {
        String program = itsLine.substring(0, 20).trim();
        String agency = itsLine.substring(20, 40).trim();
        String timestamp = itsLine.substring(40, 60).trim();
        itsTokenCollector.token(new RinexPgmRunByDateHeader(program, agency, timestamp));
    }

    protected void error(String error) {
        itsTokenCollector.error("At line " + itsLineNumber + ", " + error);
    }

    protected void selectTokenizer(RinexTokenizerProvider.TokenizerName name) {
        RinexTokenizer tokenizer = itsTokenizerProvider.provideTokenizer(name);
        tokenizer.setLineNumber(itsLineNumber);
        itsDriver.setTokenizer(tokenizer);
    }

    protected void token(RinexToken token) {
        itsTokenCollector.token(token);
    }

    protected void backup(RinexTokenizerProvider.TokenizerName name) {
        RinexTokenizer tokenizer = itsTokenizerProvider.provideTokenizer(name);
        tokenizer.setLineNumber(itsLineNumber - 1); // rewind
        readLine(itsLine);
    }
}
