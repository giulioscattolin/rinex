package com.github.giulioscattolin.rinex;

import org.junit.Test;

import static com.github.giulioscattolin.rinex.RinexTokenizerProvider.TokenizerName.SV_EPOCH_SV_CLK_V304;
import static com.google.common.truth.Truth.assertThat;

public class BroadcastOrbitRecordV304TokenizerTest extends RinexTokenizerTestTemplate {
    @Test
    public void givenNewTokenizer_whenLineIsCompliant_thenTokenIsEmitted() {
        itsTokenizer.readLine("     3.000000000000e+00 1.008750000000e+02 4.281249759808e-09 1.081547729844e+00");

        double[] parameters = new double[]{3.000000000000e+00, 1.008750000000e+02, 4.281249759808e-09, 1.081547729844e+00};
        assertThat(itsToken).isEqualTo(new ImmutableRinexBroadcastOrbitRecord(parameters));
    }

    @Test
    public void givenNewTokenizer_whenLineIsCompliant_thenTokenizerIsNotSelected() {
        itsTokenizer.readLine("     3.000000000000e+00 1.008750000000e+02 4.281249759808e-09 1.081547729844e+00");

        verifyTokenizerIsNotSet();
    }

    @Test
    public void whenTokenizerEmitsAllOrbits_thenSvEpochSvClkV304TokenizerIsSelected() {
        String content = "" +
            "     7.900000000000E+01-9.865625000000E+01 4.169816546739E-09-1.919926448712E+00\n" +
            "    -4.798173904419E-06 2.018611039966E-02 1.337565481663E-05 5.153687427521E+03\n" +
            "     1.728000000000E+05 2.626329660416E-07 2.763284965590E+00 3.613531589508E-07\n" +
            "     9.633318785023E-01 1.158125000000E+02-1.516935728085E+00-7.550314500905E-09\n" +
            "     1.817932867058E-10 1.000000000000E+00 2.159000000000E+03 0.000000000000E+00\n" +
            "     2.000000000000E+00 0.000000000000E+00-1.769512891769E-08 7.900000000000E+01\n" +
            "     1.656180000000E+05 4.000000000000E+00";

        for (String line : content.split("\n"))
            itsTokenizer.readLine(line);

        assertThat(itsSelectedTokenizer).isEqualTo(SV_EPOCH_SV_CLK_V304);
    }

    @Test
    public void whenEntireLineIsNotCompliant_thenTokenIsNotEmitted() {
        itsTokenizer.readLine("     A.BCDE00000000e+00 B.008750000000e+02 C.CCCC49759808e-09 D.DDDD47729844e+00");

        verifyTokenIsNotEmitted();
    }

    @Test
    public void whenLineIsNotCompliant_thenSvEpochSvClkTokenizerIsSelected() {
        itsTokenizer.readLine("     A.BCDE00000000e+00 1.008750000000e+02 4.281249759808e-09 1.081547729844e+00");

        assertThat(itsSelectedTokenizer).isEqualTo(SV_EPOCH_SV_CLK_V304);
    }

    @Test
    public void givenNewTokenizer_whenEntireLineIsNotCompliant_thenErrorIsEmitted() {
        itsTokenizer.readLine("     A.BCDE00000000e+00 1.008750000000e+02 4.281249759808e-09 1.081547729844e+00");

        assertThat(itsError).isEqualTo("At line 1, error while reading \"BROADCAST ORBIT - 1\": invalid floating point number");
    }

    @Test
    public void givenNewTokenizer_whenLineIsNotLongEnough_thenErrorIsEmitted() {
        itsTokenizer.readLine("     A.BCDE00000000e+00 1.008");

        assertThat(itsError).isEqualTo("At line 1, error while reading \"BROADCAST ORBIT - 1\": line is incomplete");
    }

    @Test
    public void whenBroadcastError3IsNotCompliant_thenErrorIsEmitted() {
        String content = "" +
            "     7.900000000000E+01-9.865625000000E+01 4.169816546739E-09-1.919926448712E+00\n" +
            "    -4.798173904419E-06 2.018611039966E-02 1.337565481663E-05 5.153687427521E+03\n" +
            "     D.728000000000E+05 C.626329660416E-07 B.763284965590E+00 A.613531589508E-07";

        for (String line : content.split("\n"))
            itsTokenizer.readLine(line);

        assertThat(itsError).isEqualTo("At line 3, error while reading \"BROADCAST ORBIT - 3\": invalid floating point number");
    }

    protected RinexTokenizer provideTokenizer() {
        return new BroadcastOrbitRecordV304Tokenizer(this, this, this);
    }
}