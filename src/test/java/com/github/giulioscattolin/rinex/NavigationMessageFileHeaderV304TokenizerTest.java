package com.github.giulioscattolin.rinex;

import org.junit.Test;

import static com.github.giulioscattolin.rinex.RinexTokenizerProvider.TokenizerName.BROADCAST_ORBIT_V304;
import static com.github.giulioscattolin.rinex.RinexTokenizerProvider.TokenizerName.SV_EPOCH_SV_CLK_V304;
import static com.google.common.truth.Truth.assertThat;

public class NavigationMessageFileHeaderV304TokenizerTest extends RinexTokenizerTestTemplate {
    protected RinexTokenizer provideTokenizer() {
        return new NavigationMessageFileHeaderV304Tokenizer(this, this, this);
    }

    @Test
    public void whenHeaderInUnknown_thenErrorIsEmitted() {
        itsTokenizer.readLine("sbf2rin-13.8.0                          20210526 000841 UTC FAKE FAKE FAKE");

        assertThat(itsError).isEqualTo("At line 1, while reading headers: unknown header \"FAKE FAKE FAKE\"");
    }

    @Test
    public void whenHeaderInUnknown_thenTokenIsNotEmitted() {
        itsTokenizer.readLine("sbf2rin-13.8.0                          20210526 000841 UTC FAKE FAKE FAKE");

        verifyTokenIsNotEmitted();
    }

    @Test
    public void whenHeaderInUnknown_thenTokenizerIsNotSet() {
        itsTokenizer.readLine("sbf2rin-13.8.0                          20210526 000841 UTC FAKE FAKE FAKE");

        verifyTokenizerIsNotSet();
    }

    @Test
    public void verifyPgmRunByDateHeader() {
        itsTokenizer.readLine("sbf2rin-13.8.0                          20210526 000841 UTC PGM / RUN BY / DATE");

        assertThat(itsToken).isEqualTo(new RinexPgmRunByDateHeader("sbf2rin-13.8.0", "", "20210526 000841 UTC"));
        verifyErrorIsNotEmitted();
        verifyTokenizerIsNotSet();
    }

    @Test
    public void whenEndOfHeaderIsFound_thenSvEpochSvClkV304TokenizerIsSelected() {
        itsTokenizer.readLine("                                                            END OF HEADER    ");

        assertThat(itsSelectedTokenizer).isEqualTo(SV_EPOCH_SV_CLK_V304);
    }

    @Test
    public void whenEndOfHeaderIsFound_thenTokenIsNotEmitted() {
        itsTokenizer.readLine("                                                            END OF HEADER    ");

        verifyTokenIsNotEmitted();
    }

    @Test
    public void whenEndOfHeaderIsFound_thenErrorIsNotEmitted() {
        itsTokenizer.readLine("                                                            END OF HEADER    ");

        verifyErrorIsNotEmitted();
    }
}