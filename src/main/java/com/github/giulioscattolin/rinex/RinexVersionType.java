package com.github.giulioscattolin.rinex;

public class RinexVersionType implements RinexHeader {
    private final String itsFormatVersion;
    private final char itsFileType;
    private final char itsSatelliteSystem;

    RinexVersionType(String formatVersion, char fileType) {
        itsFormatVersion = formatVersion;
        itsFileType = fileType;
        itsSatelliteSystem = '?';
    }

    RinexVersionType(String formatVersion, char fileType, char satelliteSystem) {
        itsFormatVersion = formatVersion;
        itsFileType = fileType;
        itsSatelliteSystem = satelliteSystem;
    }

    public void accept(RinexHeaderVisitor visitor) {
        visitor.visit(this);
    }

    public String getFormatVersion() {
        return itsFormatVersion;
    }

    public char getFileType() {
        return itsFileType;
    }

    public char getSatelliteSystem() {
        return itsSatelliteSystem;
    }
}
