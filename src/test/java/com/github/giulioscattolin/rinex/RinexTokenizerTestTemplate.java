package com.github.giulioscattolin.rinex;

import org.junit.Before;

import static com.google.common.truth.Truth.assertThat;

public abstract class RinexTokenizerTestTemplate implements RinexTokenCollector, RinexTokenizerDriver, RinexTokenizerProvider {
    protected RinexTokenizer itsTokenizer;
    protected RinexToken itsToken;
    protected String itsError;
    protected TokenizerName itsSelectedTokenizer;

    @Before
    public void setup() {
        itsTokenizer = provideTokenizer();
        itsToken = null;
        itsError = null;
        itsSelectedTokenizer = null;
    }

    protected abstract RinexTokenizer provideTokenizer();

    protected void verifyTokenIsNotEmitted() {
        assertThat(itsToken).isNull();
    }

    protected void verifyErrorIsNotEmitted() {
        assertThat(itsError).isNull();
    }

    protected void verifyTokenizerIsNotSet() {
        assertThat(itsSelectedTokenizer).isNull();
    }

    public void token(RinexToken token) {
        itsToken = token;
    }

    public void error(String error) {
        itsError = error;
    }

    public void setTokenizer(RinexTokenizer tokenizer) {
    }

    public RinexTokenizer provideTokenizer(TokenizerName name) {
        itsSelectedTokenizer = name;
        return new TokenizerDummy();
    }
}