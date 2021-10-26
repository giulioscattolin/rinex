package com.github.giulioscattolin.rinex;

import java.util.Arrays;
import java.util.Objects;

class ImmutableSvEpochSvClkRecord extends RinexSvEpochSvClkRecord {
    private static final char UNKNOWN_SATELLITE_SYSTEM = '?';
    private final char itsSatelliteSystem;
    private final int itsSatelliteNumber;
    private final int itsYear;
    private final int itsMonth;
    private final int itsDay;
    private final int itsHour;
    private final int itsMinute;
    private final int itsSecond;
    private final double[] itsParameters;

    ImmutableSvEpochSvClkRecord(int itsSatelliteNumber, int itsYear, int itsMonth, int itsDay, int itsHour, int itsMinute, int itsSecond, double[] itsParameters) {
        this.itsSatelliteNumber = itsSatelliteNumber;
        this.itsSatelliteSystem = UNKNOWN_SATELLITE_SYSTEM;
        this.itsYear = itsYear;
        this.itsMonth = itsMonth;
        this.itsDay = itsDay;
        this.itsHour = itsHour;
        this.itsMinute = itsMinute;
        this.itsSecond = itsSecond;
        this.itsParameters = itsParameters;
    }

    ImmutableSvEpochSvClkRecord(char itsSatelliteSystem, int itsSatelliteNumber, int itsYear, int itsMonth, int itsDay, int itsHour, int itsMinute, int itsSecond, double[] itsParameters) {
        this.itsSatelliteSystem = itsSatelliteSystem;
        this.itsSatelliteNumber = itsSatelliteNumber;
        this.itsYear = itsYear;
        this.itsMonth = itsMonth;
        this.itsDay = itsDay;
        this.itsHour = itsHour;
        this.itsMinute = itsMinute;
        this.itsSecond = itsSecond;
        this.itsParameters = itsParameters;
    }

    public boolean hasSatelliteSystem() {
        return itsSatelliteSystem != UNKNOWN_SATELLITE_SYSTEM;
    }

    public char getSatelliteSystem() {
        return itsSatelliteSystem;
    }

    public int getSatelliteNumber() {
        return itsSatelliteNumber;
    }

    public int getYear() {
        return itsYear;
    }

    public int getMonth() {
        return itsMonth;
    }

    public int getDay() {
        return itsDay;
    }

    public int getHour() {
        return itsHour;
    }

    public int getMinute() {
        return itsMinute;
    }

    public int getSecond() {
        return itsSecond;
    }

    public double[] getParameters() {
        return itsParameters;
    }

    public double getParameter(int index) {
        return itsParameters[index];
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableSvEpochSvClkRecord that = (ImmutableSvEpochSvClkRecord) o;
        return itsSatelliteSystem == that.itsSatelliteSystem && itsYear == that.itsYear && itsMonth == that.itsMonth && itsDay == that.itsDay && itsHour == that.itsHour && itsMinute == that.itsMinute && itsSecond == that.itsSecond && Arrays.equals(itsParameters, that.itsParameters);
    }

    public int hashCode() {
        int result = Objects.hash(itsSatelliteSystem, itsYear, itsMonth, itsDay, itsHour, itsMinute, itsSecond);
        result = 31 * result + Arrays.hashCode(itsParameters);
        return result;
    }

    public String toString() {
        return "ImmutableSvEpochSvClkRecord{" +
            "itsSatelliteSystem=" + itsSatelliteSystem +
            ", itsYear=" + itsYear +
            ", itsMonth=" + itsMonth +
            ", itsDay=" + itsDay +
            ", itsHour=" + itsHour +
            ", itsMinute=" + itsMinute +
            ", itsSecond=" + itsSecond +
            ", itsParameters=" + Arrays.toString(itsParameters) +
            '}';
    }
}
