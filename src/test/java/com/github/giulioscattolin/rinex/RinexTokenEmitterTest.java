package com.github.giulioscattolin.rinex;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.List;

import static com.github.giulioscattolin.rinex.TestHelper.toBufferedReader;
import static com.google.common.truth.Truth.assertThat;

public class RinexTokenEmitterTest {
    RinexTokenizer itsTokenizer;
    List<RinexToken> itsTokens;
    List<String> itsErrors;

    @Before
    public void setup() {
        itsTokens = new LinkedList<>();
        itsErrors = new LinkedList<>();
        itsTokenizer = new RinexTokenEmitter(new RinexTokenCollector() {
            public void token(RinexToken token) {itsTokens.add(token);}

            public void error(String error) {itsErrors.add(error);}
        });
    }

    @Test
    public void tokenizeRinexV304GpsNavigationFile() {
        read("BOGI00POL_R_20210600000_01D_GN.rnx");

        assertThat(itsTokens).hasSize(1674);
        assertThat(itsErrors).hasSize(48);

        assertThat(itsTokens.get(0)).isEqualTo(new RinexVersionTypeHeader("3.04", 'N', 'G'));
        assertThat(itsTokens.get(1)).isEqualTo(new RinexPgmRunByDateHeader("JPS2RIN v.2.0.168", "BASH SCRIPT", "20210301 010023 UTC"));
    }

    private void read(String path) {
        try (BufferedReader reader = toBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null)
                itsTokenizer.readLine(line);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}