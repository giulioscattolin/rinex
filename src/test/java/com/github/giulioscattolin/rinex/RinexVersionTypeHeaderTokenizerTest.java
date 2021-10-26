package com.github.giulioscattolin.rinex;

import org.junit.Test;

import static com.github.giulioscattolin.rinex.RinexTokenizerProvider.TokenizerName.NAVIGATION_FILE_HEADER_V304;
import static com.google.common.truth.Truth.assertThat;

public class RinexVersionTypeHeaderTokenizerTest extends RinexTokenizerTestTemplate {
    @Test
    public void whenLineIsCompliant_thenTokenIsEmitted() {
        itsTokenizer.readLine("     3.04           N: GNSS NAV DATA    G: GPS              RINEX VERSION / TYPE");

        assertThat(itsToken).isEqualTo(new RinexVersionTypeHeader("3.04", 'N', 'G'));
    }

    @Test
    public void whenLineIsCompliant_thenErrorIsNotEmmitted() {
        itsTokenizer.readLine("     3.04           N: GNSS NAV DATA    G: GPS              RINEX VERSION / TYPE");

        verifyErrorIsNotEmitted();
    }

    @Test
    public void whenLineIsCompliant_thenNavigationFileHeaderTokenizerV304IsSet() {
        itsTokenizer.readLine("     3.04           N: GNSS NAV DATA    G: GPS              RINEX VERSION / TYPE");

        assertThat(itsSelectedTokenizer).isEqualTo(NAVIGATION_FILE_HEADER_V304);
    }

    @Test
    public void whenLineIsIncomplete_thenTokenIsNotEmitted() {
        itsTokenizer.readLine("     3.04           N: GN");

        verifyTokenIsNotEmitted();
    }

    @Test
    public void whenLineIsIncomplete_thenErrorIsEmitted() {
        itsTokenizer.readLine("     3.04           N: GN");

        assertThat(itsError).isEqualTo("At line 1, while reading \"RINEX VERSION / TYPE\": incomplete line");
    }

    @Test
    public void whenLineIsIncomplete_thenTokenizerIsNotSelected() {
        itsTokenizer.readLine("     3.04           N: GN");

        verifyTokenizerIsNotSet();
    }

    protected RinexTokenizer provideTokenizer() {
        return new RinexVersionTypeHeaderTokenizer(this, this, this);
    }
}