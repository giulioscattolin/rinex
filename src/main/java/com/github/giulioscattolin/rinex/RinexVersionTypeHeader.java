package com.github.giulioscattolin.rinex;

import java.util.Objects;

public class RinexVersionTypeHeader implements RinexHeader, RinexToken {
    private final String itsFormatVersion;
    private final char itsFileType;
    private final char itsSatelliteSystem;

    RinexVersionTypeHeader(String formatVersion, char fileType) {
        itsFormatVersion = formatVersion;
        itsFileType = fileType;
        itsSatelliteSystem = '?';
    }

    RinexVersionTypeHeader(String formatVersion, char fileType, char satelliteSystem) {
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

    public void accept(RinexTokenVisitor visitor) {
        visitor.visit(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RinexVersionTypeHeader that = (RinexVersionTypeHeader) o;
        return itsFileType == that.itsFileType && itsSatelliteSystem == that.itsSatelliteSystem && itsFormatVersion.equals(that.itsFormatVersion);
    }

    public int hashCode() {
        return Objects.hash(itsFormatVersion, itsFileType, itsSatelliteSystem);
    }

    public String toString() {
        return "RinexVersionTypeHeader{" +
            "itsFormatVersion='" + itsFormatVersion + '\'' +
            ", itsFileType=" + itsFileType +
            ", itsSatelliteSystem=" + itsSatelliteSystem +
            '}';
    }
}
