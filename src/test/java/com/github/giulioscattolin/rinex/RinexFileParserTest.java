package com.github.giulioscattolin.rinex;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class RinexFileParserTest {
    RinexFileParser itsParser;
    List<RinexFile> itsRinexFiles;

    @Before
    public void beforeEach() {
        itsRinexFiles = new LinkedList<>();
        itsParser = new RinexFileParser(this::collect);
    }

    private void collect(RinexFile rinexFile) {
        itsRinexFiles.add(rinexFile);
    }

    @Test
    public void parseRinexV200GpsNavigationMessageFile() throws URISyntaxException, IOException {
        parse("dlft3640.99n");

        assertThat(itsRinexFiles).hasSize(1);
        RinexFile file = itsRinexFiles.get(0);

        assertThat(file.getHeaders()).hasSize(2);
        RinexVersionTypeHeader rinexVersionType = (RinexVersionTypeHeader) file.getHeaders().get(0);
        assertThat(rinexVersionType.getFormatVersion()).isEqualTo("2");
        assertThat(rinexVersionType.getFileType()).isEqualTo('N');
        RinexPgmRunByDateHeader pgmRunByDate = (RinexPgmRunByDateHeader) file.getHeaders().get(1);
        assertThat(pgmRunByDate.getProgram()).isEqualTo("JPS2RIN 1.03");
        assertThat(pgmRunByDate.getAgency()).isEqualTo("TU DELFT");
        assertThat(pgmRunByDate.getTimestamp()).isEqualTo("03-JAN-00 11:50");

        assertThat(file.getRecords()).hasSize(172);
        RinexGpsNavigationData sampleRinexGpsNavigationData = (RinexGpsNavigationData) file.getRecords().get(18);
        assertThat(sampleRinexGpsNavigationData.getPrn()).isEqualTo(3);
        assertThat(sampleRinexGpsNavigationData.getToc()).isEqualTo(LocalDateTime.of(1999, 12, 30, 18, 0, 0));
        assertThat(sampleRinexGpsNavigationData.getSvClockBias()).isEqualTo(.729192979634E-04);
        assertThat(sampleRinexGpsNavigationData.getSvClockDrift()).isEqualTo(.341060513165E-11);
        assertThat(sampleRinexGpsNavigationData.getSvClockDriftRate()).isEqualTo(.000000000000E+00);
        assertThat(sampleRinexGpsNavigationData.getIode()).isEqualTo((int) .000000000000E+00);
        assertThat(sampleRinexGpsNavigationData.getCrs()).isEqualTo(.290000000000E+02);
        assertThat(sampleRinexGpsNavigationData.getDeltaN()).isEqualTo(.513235664040E-08);
        assertThat(sampleRinexGpsNavigationData.getM0()).isEqualTo(-.835077022481E+00);
        assertThat(sampleRinexGpsNavigationData.getCuc()).isEqualTo(.141747295856E-05);
        assertThat(sampleRinexGpsNavigationData.getE()).isEqualTo(.103990267962E-02);
        assertThat(sampleRinexGpsNavigationData.getCus()).isEqualTo(.426545739174E-05);
        assertThat(sampleRinexGpsNavigationData.getSqrtA()).isEqualTo(.515367406082E+04);
        assertThat(sampleRinexGpsNavigationData.getToe()).isEqualTo((int) .410400000000E+06);
        assertThat(sampleRinexGpsNavigationData.getCic()).isEqualTo(-.242143869400E-07);
        assertThat(sampleRinexGpsNavigationData.getBigOmega()).isEqualTo(-.277683507314E+01);
        assertThat(sampleRinexGpsNavigationData.getCis()).isEqualTo(-.260770320892E-07);
        assertThat(sampleRinexGpsNavigationData.getI0()).isEqualTo(.943291640226E+00);
        assertThat(sampleRinexGpsNavigationData.getCrc()).isEqualTo(.283906250000E+03);
        assertThat(sampleRinexGpsNavigationData.getSmallOmega()).isEqualTo(.127078799500E+01);
        assertThat(sampleRinexGpsNavigationData.getOmegaDot()).isEqualTo(-.852464079979E-08);
        assertThat(sampleRinexGpsNavigationData.getIDot()).isEqualTo(-.187507810453E-09);
        assertThat(sampleRinexGpsNavigationData.getCodesOnL2Channel()).isEqualTo((int) .000000000000E+00);
        assertThat(sampleRinexGpsNavigationData.getGpsWeekNumber()).isEqualTo((int) .104200000000E+04);
        assertThat(sampleRinexGpsNavigationData.getL2PDataFlag()).isEqualTo((int) .000000000000E+00);
        assertThat(sampleRinexGpsNavigationData.getSvAccuracy()).isEqualTo((int) .320000000000E+02);
        assertThat(sampleRinexGpsNavigationData.getSvHealth()).isEqualTo((int) .000000000000E+00);
        assertThat(sampleRinexGpsNavigationData.getTgd()).isEqualTo(-.419095158577E-08);
        assertThat(sampleRinexGpsNavigationData.getIodc()).isEqualTo((int) .000000000000E+00);
        assertThat(sampleRinexGpsNavigationData.getTransmissionTimeOfMessage()).isEqualTo((int) .410399000000E+06);
        assertThat(sampleRinexGpsNavigationData.hasFitIntervalInHours()).isFalse();

        // Ensure every field of time of clock get parsed correctly
        sampleRinexGpsNavigationData = (RinexGpsNavigationData) file.getRecords().get(4);
        assertThat(sampleRinexGpsNavigationData.getPrn()).isEqualTo(1);
        assertThat(sampleRinexGpsNavigationData.getToc()).isEqualTo(LocalDateTime.of(1999, 12, 30, 15, 59, 44));
        assertThat(sampleRinexGpsNavigationData.getSvClockBias()).isEqualTo(.111320987344E-03);
        assertThat(sampleRinexGpsNavigationData.getSvClockDrift()).isEqualTo(.136424205266E-11);
        assertThat(sampleRinexGpsNavigationData.getSvClockDriftRate()).isEqualTo(.000000000000E+00);
    }

    @Test
    public void parseRinexNavigationFileV200_Year2000() throws URISyntaxException, IOException {
        parse("yarr0030.00n");

        assertThat(itsRinexFiles).hasSize(1);
        RinexFile file = itsRinexFiles.get(0);

        assertThat(file.getHeaders()).hasSize(2);
        RinexVersionTypeHeader rinexVersionType = (RinexVersionTypeHeader) file.getHeaders().get(0);
        assertThat(rinexVersionType.getFormatVersion()).isEqualTo("2");
        assertThat(rinexVersionType.getFileType()).isEqualTo('N');
        RinexPgmRunByDateHeader pgmRunByDate = (RinexPgmRunByDateHeader) file.getHeaders().get(1);
        assertThat(pgmRunByDate.getProgram()).isEqualTo("ASRINEXN V2.4.6 UX");
        assertThat(pgmRunByDate.getAgency()).isEqualTo("AIUB");
        assertThat(pgmRunByDate.getTimestamp()).isEqualTo("07-FEB- 0 15:51");

        assertThat(file.getRecords()).hasSize(149);
        RinexGpsNavigationData sampleRinexGpsNavigationData = (RinexGpsNavigationData) file.getRecords().get(0);
        assertThat(sampleRinexGpsNavigationData.getToc()).isEqualTo(LocalDateTime.of(2000, 1, 3, 0, 0, 0, 0));
    }

    @Test
    public void parseRinexV210GpsNavigationMessageFile() throws URISyntaxException, IOException {
        parse("usn81000.16n");

        assertThat(itsRinexFiles).hasSize(1);
        RinexFile file = itsRinexFiles.get(0);

        assertThat(file.getHeaders()).hasSize(2);
        RinexVersionTypeHeader rinexVersionType = (RinexVersionTypeHeader) file.getHeaders().get(0);
        assertThat(rinexVersionType.getFormatVersion()).isEqualTo("2.10");
        assertThat(rinexVersionType.getFileType()).isEqualTo('N');
        RinexPgmRunByDateHeader pgmRunByDate = (RinexPgmRunByDateHeader) file.getHeaders().get(1);
        assertThat(pgmRunByDate.getProgram()).isEqualTo("sbf2rin-5.2.0");
        assertThat(pgmRunByDate.getAgency()).isEqualTo("");
        assertThat(pgmRunByDate.getTimestamp()).isEqualTo("(10-APR-16 00:15)");

        assertThat(file.getRecords()).hasSize(289);
        RinexGpsNavigationData sampleRinexGpsNavigationData = (RinexGpsNavigationData) file.getRecords().get(3);
        assertThat(sampleRinexGpsNavigationData.getPrn()).isEqualTo(2);
        assertThat(sampleRinexGpsNavigationData.getToc()).isEqualTo(LocalDateTime.of(2016, 4, 8, 8, 0, 0));
        assertThat(sampleRinexGpsNavigationData.getSvClockBias()).isEqualTo(5.980534479022E-04);
        assertThat(sampleRinexGpsNavigationData.getSvClockDrift()).isEqualTo(-1.364242052659E-12);
        assertThat(sampleRinexGpsNavigationData.getSvClockDriftRate()).isEqualTo(0.000000000000E+00);
        assertThat(sampleRinexGpsNavigationData.getIode()).isEqualTo((int) 1.120000000000E+02);
        assertThat(sampleRinexGpsNavigationData.getCrs()).isEqualTo(8.718750000000E+00);
        assertThat(sampleRinexGpsNavigationData.getDeltaN()).isEqualTo(5.678807973718E-09);
        assertThat(sampleRinexGpsNavigationData.getM0()).isEqualTo(-1.424485266866E+00);
        assertThat(sampleRinexGpsNavigationData.getCuc()).isEqualTo(7.562339305878E-07);
        assertThat(sampleRinexGpsNavigationData.getE()).isEqualTo(1.562534947880E-02);
        assertThat(sampleRinexGpsNavigationData.getCus()).isEqualTo(2.725049853325E-06);
        assertThat(sampleRinexGpsNavigationData.getSqrtA()).isEqualTo(5.153744359970E+03);
        assertThat(sampleRinexGpsNavigationData.getToe()).isEqualTo((int) 4.608000000000E+05);
        assertThat(sampleRinexGpsNavigationData.getCic()).isEqualTo(2.905726432800E-07);
        assertThat(sampleRinexGpsNavigationData.getBigOmega()).isEqualTo(-1.328300869634E+00);
        assertThat(sampleRinexGpsNavigationData.getCis()).isEqualTo(1.490116119385E-07);
        assertThat(sampleRinexGpsNavigationData.getI0()).isEqualTo(9.423953937051E-01);
        assertThat(sampleRinexGpsNavigationData.getCrc()).isEqualTo(3.134375000000E+02);
        assertThat(sampleRinexGpsNavigationData.getSmallOmega()).isEqualTo(-2.134346742189E+00);
        assertThat(sampleRinexGpsNavigationData.getOmegaDot()).isEqualTo(-8.692862092598E-09);
        assertThat(sampleRinexGpsNavigationData.getIDot()).isEqualTo(1.682212928064E-10);
        assertThat(sampleRinexGpsNavigationData.getCodesOnL2Channel()).isEqualTo((int) 1.000000000000E+00);
        assertThat(sampleRinexGpsNavigationData.getGpsWeekNumber()).isEqualTo((int) 1.891000000000E+03);
        assertThat(sampleRinexGpsNavigationData.getL2PDataFlag()).isEqualTo((int) 0.000000000000E+00);
        assertThat(sampleRinexGpsNavigationData.getSvAccuracy()).isEqualTo((int) 2.800000000000E+00);
        assertThat(sampleRinexGpsNavigationData.getSvHealth()).isEqualTo((int) 0.000000000000E+00);
        assertThat(sampleRinexGpsNavigationData.getTgd()).isEqualTo(-2.002343535423E-08);
        assertThat(sampleRinexGpsNavigationData.getIodc()).isEqualTo((int) 1.120000000000E+02);
        assertThat(sampleRinexGpsNavigationData.getTransmissionTimeOfMessage()).isEqualTo((int) 4.536180000000E+05);
        assertThat(sampleRinexGpsNavigationData.hasFitIntervalInHours()).isTrue();
        assertThat(sampleRinexGpsNavigationData.getFitIntervalInHours()).isEqualTo((int) 4.000000000000E+00);
    }

    @Test
    public void parseRinexV302GpsNavigationMessageFile() throws URISyntaxException, IOException {
        parse("KOUR00GUF_R_20153620000_01D_GN.rnx");

        assertThat(itsRinexFiles).hasSize(1);
        RinexFile file = itsRinexFiles.get(0);

        assertThat(file.getHeaders()).hasSize(2);
        RinexVersionTypeHeader rinexVersionType = (RinexVersionTypeHeader) file.getHeaders().get(0);
        assertThat(rinexVersionType.getFormatVersion()).isEqualTo("3.02");
        assertThat(rinexVersionType.getFileType()).isEqualTo('N');
        assertThat(rinexVersionType.getSatelliteSystem()).isEqualTo('G');
        RinexPgmRunByDateHeader pgmRunByDate = (RinexPgmRunByDateHeader) file.getHeaders().get(1);
        assertThat(pgmRunByDate.getProgram()).isEqualTo("sbf2rin-9.3.3");
        assertThat(pgmRunByDate.getAgency()).isEqualTo("");
        assertThat(pgmRunByDate.getTimestamp()).isEqualTo("20151229 000419 LCL");

        assertThat(file.getRecords()).hasSize(276);
    }

    @Test
    public void parseRinexV303GpsNavigationMessageFile() throws URISyntaxException, IOException {
        parse("STJ300CAN_R_20200600000_01D_GN.rnx");

        assertThat(itsRinexFiles).hasSize(1);
        RinexFile file = itsRinexFiles.get(0);

        assertThat(file.getHeaders()).hasSize(2);
        RinexVersionTypeHeader rinexVersionType = (RinexVersionTypeHeader) file.getHeaders().get(0);
        assertThat(rinexVersionType.getFormatVersion()).isEqualTo("3.03");
        assertThat(rinexVersionType.getFileType()).isEqualTo('N');
        assertThat(rinexVersionType.getSatelliteSystem()).isEqualTo('G');
        RinexPgmRunByDateHeader pgmRunByDate = (RinexPgmRunByDateHeader) file.getHeaders().get(1);
        assertThat(pgmRunByDate.getProgram()).isEqualTo("sbf2rin-13.2.1");
        assertThat(pgmRunByDate.getAgency()).isEqualTo("");
        assertThat(pgmRunByDate.getTimestamp()).isEqualTo("20200301 005013 UTC");

        assertThat(file.getRecords()).hasSize(206);
        RinexGpsNavigationData sampleRinexGpsNavigationData = (RinexGpsNavigationData) file.getRecords().get(37);
        assertThat(sampleRinexGpsNavigationData.getPrn()).isEqualTo(17);
        assertThat(sampleRinexGpsNavigationData.getToc()).isEqualTo(LocalDateTime.of(2020, 2, 29, 4, 0, 0));
        assertThat(sampleRinexGpsNavigationData.getSvClockBias()).isEqualTo(2.239849418402E-04);
        assertThat(sampleRinexGpsNavigationData.getSvClockDrift()).isEqualTo(6.480149750132E-12);
        assertThat(sampleRinexGpsNavigationData.getSvClockDriftRate()).isEqualTo(0.000000000000E+00);
        assertThat(sampleRinexGpsNavigationData.getIode()).isEqualTo((int) 4.900000000000E+01);
        assertThat(sampleRinexGpsNavigationData.getCrs()).isEqualTo(-3.015625000000E+01);
        assertThat(sampleRinexGpsNavigationData.getDeltaN()).isEqualTo(3.971951161995E-09);
        assertThat(sampleRinexGpsNavigationData.getM0()).isEqualTo(-1.469544031699E+00);
        assertThat(sampleRinexGpsNavigationData.getCuc()).isEqualTo(-1.303851604462E-06);
        assertThat(sampleRinexGpsNavigationData.getE()).isEqualTo(1.334943575785E-02);
        assertThat(sampleRinexGpsNavigationData.getCus()).isEqualTo(9.544193744659E-06);
        assertThat(sampleRinexGpsNavigationData.getSqrtA()).isEqualTo(5.153662807465E+03);
        assertThat(sampleRinexGpsNavigationData.getToe()).isEqualTo((int) 5.328000000000E+05);
        assertThat(sampleRinexGpsNavigationData.getCic()).isEqualTo(-2.235174179077E-08);
        assertThat(sampleRinexGpsNavigationData.getBigOmega()).isEqualTo(-2.580839590648E+00);
        assertThat(sampleRinexGpsNavigationData.getCis()).isEqualTo(3.632158041000E-07);
        assertThat(sampleRinexGpsNavigationData.getI0()).isEqualTo(9.843603150154E-01);
        assertThat(sampleRinexGpsNavigationData.getCrc()).isEqualTo(2.085000000000E+02);
        assertThat(sampleRinexGpsNavigationData.getSmallOmega()).isEqualTo(-1.649001798767E+00);
        assertThat(sampleRinexGpsNavigationData.getOmegaDot()).isEqualTo(-7.755680198068E-09);
        assertThat(sampleRinexGpsNavigationData.getIDot()).isEqualTo(-8.000333245992E-11);
        assertThat(sampleRinexGpsNavigationData.getCodesOnL2Channel()).isEqualTo((int) 1.000000000000E+00);
        assertThat(sampleRinexGpsNavigationData.getGpsWeekNumber()).isEqualTo((int) 2.094000000000E+03);
        assertThat(sampleRinexGpsNavigationData.getL2PDataFlag()).isEqualTo((int) 0.000000000000E+00);
        assertThat(sampleRinexGpsNavigationData.getSvAccuracy()).isEqualTo((int) 2.800000000000E+00);
        assertThat(sampleRinexGpsNavigationData.getSvHealth()).isEqualTo((int) 0.000000000000E+00);
        assertThat(sampleRinexGpsNavigationData.getTgd()).isEqualTo(-1.117587089539E-08);
        assertThat(sampleRinexGpsNavigationData.getIodc()).isEqualTo((int) 4.900000000000E+01);
        assertThat(sampleRinexGpsNavigationData.getTransmissionTimeOfMessage()).isEqualTo((int) 5.256180000000E+05);
        assertThat(sampleRinexGpsNavigationData.hasFitIntervalInHours()).isTrue();
        assertThat(sampleRinexGpsNavigationData.getFitIntervalInHours()).isEqualTo((int) 4.000000000000E+00);
    }

    @Test
    public void parseRinexV304GpsNavigationMessageFile() throws URISyntaxException, IOException {
        parse("BOGI00POL_R_20210600000_01D_GN.rnx");

        assertThat(itsRinexFiles).hasSize(1);
        RinexFile file = itsRinexFiles.get(0);

        assertThat(file.getHeaders()).hasSize(2);
        RinexVersionTypeHeader rinexVersionType = (RinexVersionTypeHeader) file.getHeaders().get(0);
        assertThat(rinexVersionType.getFormatVersion()).isEqualTo("3.04");
        assertThat(rinexVersionType.getFileType()).isEqualTo('N');
        assertThat(rinexVersionType.getSatelliteSystem()).isEqualTo('G');
        RinexPgmRunByDateHeader pgmRunByDate = (RinexPgmRunByDateHeader) file.getHeaders().get(1);
        assertThat(pgmRunByDate.getProgram()).isEqualTo("JPS2RIN v.2.0.168");
        assertThat(pgmRunByDate.getAgency()).isEqualTo("BASH SCRIPT");
        assertThat(pgmRunByDate.getTimestamp()).isEqualTo("20210301 010023 UTC");

        assertThat(file.getRecords()).hasSize(209);
    }

    @Test
    public void parseRinexObservationFileMixedV210() throws URISyntaxException, IOException {
        parse("nist1450.21o");

        assertThat(itsRinexFiles).hasSize(1);
        RinexFile file = itsRinexFiles.get(0);

        assertThat(file.getHeaders()).hasSize(4);
        RinexVersionTypeHeader rinexVersionType = (RinexVersionTypeHeader) file.getHeaders().get(0);
        assertThat(rinexVersionType.getFormatVersion()).isEqualTo("2.10");
        assertThat(rinexVersionType.getFileType()).isEqualTo('O');
        assertThat(rinexVersionType.getSatelliteSystem()).isEqualTo('M');
        RinexPgmRunByDateHeader pgmRunByDate = (RinexPgmRunByDateHeader) file.getHeaders().get(1);
        assertThat(pgmRunByDate.getProgram()).isEqualTo("LoggerServer.exe");
        assertThat(pgmRunByDate.getAgency()).isEqualTo("NIST");
        assertThat(pgmRunByDate.getTimestamp()).isEqualTo("24-May-21 23:59");
        RinexMarkerNameHeader markerNameHeader = (RinexMarkerNameHeader) file.getHeaders().get(2);
        assertThat(markerNameHeader.getAntennaMarkerName()).isEqualTo("NIST");
        RinexObserverAgencyHeader observerAgencyHeader = (RinexObserverAgencyHeader) file.getHeaders().get(3);
        assertThat(observerAgencyHeader.getObserverName()).isEqualTo("NIST");
        assertThat(observerAgencyHeader.getAgencyName()).isEqualTo("NIST");
    }

    private void parse(String path) throws IOException, URISyntaxException {
        try (BufferedReader reader = openBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null)
                itsParser.readLine(line);
            itsParser.flush();
        }
    }

    private BufferedReader openBufferedReader(String path) throws FileNotFoundException, URISyntaxException {
        return new BufferedReader(new FileReader(new File(RinexFileParserTest.class.getResource(path).toURI())));
    }
}