package com.github.giulioscattolin.rinex;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class RinexDataLineReaderTest implements RinexDataVisitor {
    RinexDataLineReader itsReader;
    List<RinexData> itsRinexData;
    List<RinexGpsNavigationMessage> itsRinexGpsNavigationMessages;

    @Before
    public void beforeEach() {
        itsRinexData = new LinkedList<>();
        itsRinexGpsNavigationMessages = new LinkedList<>();
        itsReader = new RinexDataLineReader(this::collect);
    }

    private void collect(RinexData rinexData) {
        itsRinexData.add(rinexData);
        rinexData.accept(this);
    }

    public void visit(RinexGpsNavigationMessage rinexGpsNavigationMessage) {
        itsRinexGpsNavigationMessages.add(rinexGpsNavigationMessage);
    }

    @Test
    public void parseRinexV200GpsNavigationMessageFile() throws URISyntaxException, IOException {
        try (BufferedReader reader = openBufferedReader("dlft3640.99n")) {
            String line;
            while ((line = reader.readLine()) != null)
                itsReader.readLine(line);
        }

        assertThat(itsRinexData).hasSize(172);
        assertThat(itsRinexGpsNavigationMessages).hasSize(172);

        RinexGpsNavigationMessage sampleRinexGpsNavigationMessage = itsRinexGpsNavigationMessages.get(18);
        assertThat(sampleRinexGpsNavigationMessage.getPrn()).isEqualTo(3);
        assertThat(sampleRinexGpsNavigationMessage.getToc()).isEqualTo(LocalDateTime.of(1999, 12, 30, 18, 0, 0));
        assertThat(sampleRinexGpsNavigationMessage.getSvClockBias()).isEqualTo(.729192979634E-04);
        assertThat(sampleRinexGpsNavigationMessage.getSvClockDrift()).isEqualTo(.341060513165E-11);
        assertThat(sampleRinexGpsNavigationMessage.getSvClockDriftRate()).isEqualTo(.000000000000E+00);
        assertThat(sampleRinexGpsNavigationMessage.getIode()).isEqualTo((int) .000000000000E+00);
        assertThat(sampleRinexGpsNavigationMessage.getCrs()).isEqualTo(.290000000000E+02);
        assertThat(sampleRinexGpsNavigationMessage.getDeltaN()).isEqualTo(.513235664040E-08);
        assertThat(sampleRinexGpsNavigationMessage.getM0()).isEqualTo(-.835077022481E+00);
        assertThat(sampleRinexGpsNavigationMessage.getCuc()).isEqualTo(.141747295856E-05);
        assertThat(sampleRinexGpsNavigationMessage.getE()).isEqualTo(.103990267962E-02);
        assertThat(sampleRinexGpsNavigationMessage.getCus()).isEqualTo(.426545739174E-05);
        assertThat(sampleRinexGpsNavigationMessage.getSqrtA()).isEqualTo(.515367406082E+04);
        assertThat(sampleRinexGpsNavigationMessage.getToe()).isEqualTo((int) .410400000000E+06);
        assertThat(sampleRinexGpsNavigationMessage.getCic()).isEqualTo(-.242143869400E-07);
        assertThat(sampleRinexGpsNavigationMessage.getBigOmega()).isEqualTo(-.277683507314E+01);
        assertThat(sampleRinexGpsNavigationMessage.getCis()).isEqualTo(-.260770320892E-07);
        assertThat(sampleRinexGpsNavigationMessage.getI0()).isEqualTo(.943291640226E+00);
        assertThat(sampleRinexGpsNavigationMessage.getCrc()).isEqualTo(.283906250000E+03);
        assertThat(sampleRinexGpsNavigationMessage.getSmallOmega()).isEqualTo(.127078799500E+01);
        assertThat(sampleRinexGpsNavigationMessage.getOmegaDot()).isEqualTo(-.852464079979E-08);
        assertThat(sampleRinexGpsNavigationMessage.getIDot()).isEqualTo(-.187507810453E-09);
        assertThat(sampleRinexGpsNavigationMessage.getCodesOnL2Channel()).isEqualTo((int) .000000000000E+00);
        assertThat(sampleRinexGpsNavigationMessage.getGpsWeekNumber()).isEqualTo((int) .104200000000E+04);
        assertThat(sampleRinexGpsNavigationMessage.getL2PDataFlag()).isEqualTo((int) .000000000000E+00);
        assertThat(sampleRinexGpsNavigationMessage.getSvAccuracy()).isEqualTo((int) .320000000000E+02);
        assertThat(sampleRinexGpsNavigationMessage.getSvHealth()).isEqualTo((int) .000000000000E+00);
        assertThat(sampleRinexGpsNavigationMessage.getTgd()).isEqualTo(-.419095158577E-08);
        assertThat(sampleRinexGpsNavigationMessage.getIodc()).isEqualTo((int) .000000000000E+00);
        assertThat(sampleRinexGpsNavigationMessage.getTransmissionTimeOfMessage()).isEqualTo((int) .410399000000E+06);
        assertThat(sampleRinexGpsNavigationMessage.hasFitIntervalInHours()).isFalse();
    }

    @Test
    public void parseRinexV210GpsNavigationMessageFile() throws URISyntaxException, IOException {
        try (BufferedReader reader = openBufferedReader("usn81000.16n")) {
            String line;
            while ((line = reader.readLine()) != null)
                itsReader.readLine(line);
        }

        assertThat(itsRinexData).hasSize(289);
        assertThat(itsRinexGpsNavigationMessages).hasSize(289);

        RinexGpsNavigationMessage sampleRinexGpsNavigationMessage = itsRinexGpsNavigationMessages.get(3);
        assertThat(sampleRinexGpsNavigationMessage.getPrn()).isEqualTo(2);
        assertThat(sampleRinexGpsNavigationMessage.getToc()).isEqualTo(LocalDateTime.of(2016, 4, 8, 8, 0, 0));
        assertThat(sampleRinexGpsNavigationMessage.getSvClockBias()).isEqualTo(5.980534479022E-04);
        assertThat(sampleRinexGpsNavigationMessage.getSvClockDrift()).isEqualTo(-1.364242052659E-12);
        assertThat(sampleRinexGpsNavigationMessage.getSvClockDriftRate()).isEqualTo(0.000000000000E+00);
        assertThat(sampleRinexGpsNavigationMessage.getIode()).isEqualTo((int) 1.120000000000E+02);
        assertThat(sampleRinexGpsNavigationMessage.getCrs()).isEqualTo(8.718750000000E+00);
        assertThat(sampleRinexGpsNavigationMessage.getDeltaN()).isEqualTo(5.678807973718E-09);
        assertThat(sampleRinexGpsNavigationMessage.getM0()).isEqualTo(-1.424485266866E+00);
        assertThat(sampleRinexGpsNavigationMessage.getCuc()).isEqualTo(7.562339305878E-07);
        assertThat(sampleRinexGpsNavigationMessage.getE()).isEqualTo(1.562534947880E-02);
        assertThat(sampleRinexGpsNavigationMessage.getCus()).isEqualTo(2.725049853325E-06);
        assertThat(sampleRinexGpsNavigationMessage.getSqrtA()).isEqualTo(5.153744359970E+03);
        assertThat(sampleRinexGpsNavigationMessage.getToe()).isEqualTo((int) 4.608000000000E+05);
        assertThat(sampleRinexGpsNavigationMessage.getCic()).isEqualTo(2.905726432800E-07);
        assertThat(sampleRinexGpsNavigationMessage.getBigOmega()).isEqualTo(-1.328300869634E+00);
        assertThat(sampleRinexGpsNavigationMessage.getCis()).isEqualTo(1.490116119385E-07);
        assertThat(sampleRinexGpsNavigationMessage.getI0()).isEqualTo(9.423953937051E-01);
        assertThat(sampleRinexGpsNavigationMessage.getCrc()).isEqualTo(3.134375000000E+02);
        assertThat(sampleRinexGpsNavigationMessage.getSmallOmega()).isEqualTo(-2.134346742189E+00);
        assertThat(sampleRinexGpsNavigationMessage.getOmegaDot()).isEqualTo(-8.692862092598E-09);
        assertThat(sampleRinexGpsNavigationMessage.getIDot()).isEqualTo(1.682212928064E-10);
        assertThat(sampleRinexGpsNavigationMessage.getCodesOnL2Channel()).isEqualTo((int) 1.000000000000E+00);
        assertThat(sampleRinexGpsNavigationMessage.getGpsWeekNumber()).isEqualTo((int) 1.891000000000E+03);
        assertThat(sampleRinexGpsNavigationMessage.getL2PDataFlag()).isEqualTo((int) 0.000000000000E+00);
        assertThat(sampleRinexGpsNavigationMessage.getSvAccuracy()).isEqualTo((int) 2.800000000000E+00);
        assertThat(sampleRinexGpsNavigationMessage.getSvHealth()).isEqualTo((int) 0.000000000000E+00);
        assertThat(sampleRinexGpsNavigationMessage.getTgd()).isEqualTo(-2.002343535423E-08);
        assertThat(sampleRinexGpsNavigationMessage.getIodc()).isEqualTo((int) 1.120000000000E+02);
        assertThat(sampleRinexGpsNavigationMessage.getTransmissionTimeOfMessage()).isEqualTo((int) 4.536180000000E+05);
        assertThat(sampleRinexGpsNavigationMessage.hasFitIntervalInHours()).isTrue();
        assertThat(sampleRinexGpsNavigationMessage.getFitIntervalInHours()).isEqualTo((int) 4.000000000000E+00);
    }

    @Test
    public void parseRinexV302GpsNavigationMessageFile() throws URISyntaxException, IOException {
        try (BufferedReader reader = openBufferedReader("KOUR00GUF_R_20153620000_01D_GN.rnx")) {
            String line;
            while ((line = reader.readLine()) != null)
                itsReader.readLine(line);
        }

        assertThat(itsRinexData).hasSize(276);
    }

    @Test
    public void parseRinexV303GpsNavigationMessageFile() throws URISyntaxException, IOException {
        try (BufferedReader reader = openBufferedReader("STJ300CAN_R_20200600000_01D_GN.rnx")) {
            String line;
            while ((line = reader.readLine()) != null)
                itsReader.readLine(line);
        }

        assertThat(itsRinexData).hasSize(206);
        assertThat(itsRinexGpsNavigationMessages).hasSize(206);

        RinexGpsNavigationMessage sampleRinexGpsNavigationMessage = itsRinexGpsNavigationMessages.get(37);
        assertThat(sampleRinexGpsNavigationMessage.getPrn()).isEqualTo(17);
        assertThat(sampleRinexGpsNavigationMessage.getToc()).isEqualTo(LocalDateTime.of(2020, 2, 29, 4, 0, 0));
        assertThat(sampleRinexGpsNavigationMessage.getSvClockBias()).isEqualTo(2.239849418402E-04);
        assertThat(sampleRinexGpsNavigationMessage.getSvClockDrift()).isEqualTo(6.480149750132E-12);
        assertThat(sampleRinexGpsNavigationMessage.getSvClockDriftRate()).isEqualTo(0.000000000000E+00);
        assertThat(sampleRinexGpsNavigationMessage.getIode()).isEqualTo((int) 4.900000000000E+01);
        assertThat(sampleRinexGpsNavigationMessage.getCrs()).isEqualTo(-3.015625000000E+01);
        assertThat(sampleRinexGpsNavigationMessage.getDeltaN()).isEqualTo(3.971951161995E-09);
        assertThat(sampleRinexGpsNavigationMessage.getM0()).isEqualTo(-1.469544031699E+00);
        assertThat(sampleRinexGpsNavigationMessage.getCuc()).isEqualTo(-1.303851604462E-06);
        assertThat(sampleRinexGpsNavigationMessage.getE()).isEqualTo(1.334943575785E-02);
        assertThat(sampleRinexGpsNavigationMessage.getCus()).isEqualTo(9.544193744659E-06);
        assertThat(sampleRinexGpsNavigationMessage.getSqrtA()).isEqualTo(5.153662807465E+03);
        assertThat(sampleRinexGpsNavigationMessage.getToe()).isEqualTo((int) 5.328000000000E+05);
        assertThat(sampleRinexGpsNavigationMessage.getCic()).isEqualTo(-2.235174179077E-08);
        assertThat(sampleRinexGpsNavigationMessage.getBigOmega()).isEqualTo(-2.580839590648E+00);
        assertThat(sampleRinexGpsNavigationMessage.getCis()).isEqualTo(3.632158041000E-07);
        assertThat(sampleRinexGpsNavigationMessage.getI0()).isEqualTo(9.843603150154E-01);
        assertThat(sampleRinexGpsNavigationMessage.getCrc()).isEqualTo(2.085000000000E+02);
        assertThat(sampleRinexGpsNavigationMessage.getSmallOmega()).isEqualTo(-1.649001798767E+00);
        assertThat(sampleRinexGpsNavigationMessage.getOmegaDot()).isEqualTo(-7.755680198068E-09);
        assertThat(sampleRinexGpsNavigationMessage.getIDot()).isEqualTo(-8.000333245992E-11);
        assertThat(sampleRinexGpsNavigationMessage.getCodesOnL2Channel()).isEqualTo((int) 1.000000000000E+00);
        assertThat(sampleRinexGpsNavigationMessage.getGpsWeekNumber()).isEqualTo((int) 2.094000000000E+03);
        assertThat(sampleRinexGpsNavigationMessage.getL2PDataFlag()).isEqualTo((int) 0.000000000000E+00);
        assertThat(sampleRinexGpsNavigationMessage.getSvAccuracy()).isEqualTo((int) 2.800000000000E+00);
        assertThat(sampleRinexGpsNavigationMessage.getSvHealth()).isEqualTo((int) 0.000000000000E+00);
        assertThat(sampleRinexGpsNavigationMessage.getTgd()).isEqualTo(-1.117587089539E-08);
        assertThat(sampleRinexGpsNavigationMessage.getIodc()).isEqualTo((int) 4.900000000000E+01);
        assertThat(sampleRinexGpsNavigationMessage.getTransmissionTimeOfMessage()).isEqualTo((int) 5.256180000000E+05);
        assertThat(sampleRinexGpsNavigationMessage.hasFitIntervalInHours()).isTrue();
        assertThat(sampleRinexGpsNavigationMessage.getFitIntervalInHours()).isEqualTo((int) 4.000000000000E+00);
    }

    @Test
    public void parseRinexV304GpsNavigationMessageFile() throws URISyntaxException, IOException {
        try (BufferedReader reader = openBufferedReader("BOGI00POL_R_20210600000_01D_GN.rnx")) {
            String line;
            while ((line = reader.readLine()) != null)
                itsReader.readLine(line);
        }

        assertThat(itsRinexData).hasSize(209);
    }

    private BufferedReader openBufferedReader(String path) throws FileNotFoundException, URISyntaxException {
        return new BufferedReader(new FileReader(new File(RinexDataLineReaderTest.class.getResource(path).toURI())));
    }
}