package com.github.giulioscattolin.rinex;

import org.junit.Test;

import static com.github.giulioscattolin.rinex.RinexTokenizerProvider.TokenizerName.*;
import static com.google.common.truth.Truth.assertThat;

public class SvEpochSvClockRecordV304TokenizerTest extends RinexTokenizerTestTemplate {
    @Test
    public void whenLineIsCompliant_thenTokenIsEmitted() {
        itsTokenizer.readLine("G02 2021 05 25 00 00 00-6.069629453123E-04-3.069544618484E-12 0.000000000000E+00");

        double[] parameters = new double[]{-6.069629453123E-04, -3.069544618484E-12, 0.000000000000E+00};
        assertThat(itsToken).isEqualTo(new ImmutableSvEpochSvClkRecord('G', 2, 2021, 5, 25, 0, 0, 0, parameters));
    }

    @Test
    public void whenLineIsCompliant_thenErrorIsNotEmitted() {
        itsTokenizer.readLine("G02 2021 05 25 00 00 00-6.069629453123E-04-3.069544618484E-12 0.000000000000E+00");

        verifyErrorIsNotEmitted();
    }

    @Test
    public void whenLineIsCompliant_thenBroadcastOrbitV304TokenizerIsSelected() {
        itsTokenizer.readLine("G02 2021 05 25 00 00 00-6.069629453123E-04-3.069544618484E-12 0.000000000000E+00");

        assertThat(itsSelectedTokenizer).isEqualTo(BROADCAST_ORBIT_V304);
    }

    @Test
    public void whenParameterIsNotCompliant_thenTokenIsNotEmitted() {
        itsTokenizer.readLine("G02 2021 05 25 00 00 00-6.069629453123E-04-3.069544618484E-12 A.BC0000000000E+00");

        verifyTokenIsNotEmitted();
    }

    @Test
    public void whenParameterIsNotCompliant_thenErrorIsEmitted() {
        itsTokenizer.readLine("G02 2021 05 25 00 00 00-6.069629453123E-04-3.069544618484E-12 A.BC0000000000E+00");

        assertThat(itsError).isEqualTo("At line 1, while reading \"SV / EPOCH / SV CLK\": invalid floating point number");
    }

    @Test
    public void whenYearIsNotCompliant_thenErrorIsEmitted() {
        itsTokenizer.readLine("G02 ABCD 05 25 00 00 00-6.069629453123E-04-3.069544618484E-12 0.000000000000E+00");

        assertThat(itsError).isEqualTo("At line 1, while reading \"SV / EPOCH / SV CLK\": invalid integer");
    }

    @Test
    public void whenYearIsNotCompliant_thenNavigationRecordV304TokenizerIsSelected() {
        itsTokenizer.readLine("G02 ABCD 05 25 00 00 00-6.069629453123E-04-3.069544618484E-12 0.000000000000E+00");

        assertThat(itsSelectedTokenizer).isEqualTo(RINEX_VERSION_TYPE);
    }

    @Test
    public void whenLineIsIncomplete_thenTokenIsNotEmitted() {
        itsTokenizer.readLine("G02 2021 05 25 00 00 00-6.069629453123E-04-3.0");

        verifyTokenIsNotEmitted();
    }

    @Test
    public void whenLineIsIncomplete_thenErrorIsEmitted() {
        itsTokenizer.readLine("G02 2021 05 25 00 00 00-6.069629453123E-04-3.0");

        assertThat(itsError).isEqualTo("At line 1, while reading \"SV / EPOCH / SV CLK\": incomplete line");
    }

    @Test
    public void whenLineIsIncomplete_thenNavigationRecordV304TokenizerIsSelected() {
        itsTokenizer.readLine("G02 2021 05 25 00 00 00-6.069629453123E-04-3.0");

        assertThat(itsSelectedTokenizer).isEqualTo(RINEX_VERSION_TYPE);
    }

    protected RinexTokenizer provideTokenizer() {
        return new SvEpochSvClockRecordV304Tokenizer(this, this, this);
    }
}