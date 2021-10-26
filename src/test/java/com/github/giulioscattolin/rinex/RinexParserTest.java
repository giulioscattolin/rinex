package com.github.giulioscattolin.rinex;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.List;

import static com.github.giulioscattolin.rinex.TestHelper.toBufferedReader;
import static com.google.common.truth.Truth.assertThat;

public class RinexParserTest {
    List<RinexData> itsData;
    List<String> itsTokenizerErrors;
    List<String> itsSemanticErrors;
    RinexParser itsRinexParser;

    @Before
    public void setup() {
        itsData = new LinkedList<>();
        itsTokenizerErrors = new LinkedList<>();
        itsSemanticErrors = new LinkedList<>();
        itsRinexParser = new RinexParser(new RinexParser.User() {
            public void data(RinexData data) {
                itsData.add(data);
            }

            public void tokenizerError(String error) {
                itsTokenizerErrors.add(error);
            }

            public void semanticError(String error) {
                itsSemanticErrors.add(error);
            }
        });
    }

    @Test
    public void parseRinexV304GpsNavigationFile() {
        read("BOGI00POL_R_20210600000_01D_GN.rnx");

        assertThat(itsData).hasSize(209);
        assertThat(itsTokenizerErrors).hasSize(48);
        assertThat(itsSemanticErrors).hasSize(0);
    }

    private void read(String path) {
        try (BufferedReader reader = toBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null)
                itsRinexParser.readLine(line);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}