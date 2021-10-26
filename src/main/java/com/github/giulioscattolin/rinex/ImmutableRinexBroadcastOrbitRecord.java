package com.github.giulioscattolin.rinex;

import java.util.Arrays;

class ImmutableRinexBroadcastOrbitRecord extends RinexBroadcastOrbitRecord {
    private final double[] itsParameters;

    public ImmutableRinexBroadcastOrbitRecord(double[] parameters) {
        itsParameters = parameters;
    }

    public double getParameter(int index) {
        return itsParameters[index];
    }

    public double[] getParameters() {
        return itsParameters;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableRinexBroadcastOrbitRecord that = (ImmutableRinexBroadcastOrbitRecord) o;
        return Arrays.equals(itsParameters, that.itsParameters);
    }

    public int hashCode() {
        return Arrays.hashCode(itsParameters);
    }

    public String toString() {
        return "ImmutableRinexBroadcastOrbitRecord{" +
            "itsParameters=" + Arrays.toString(itsParameters) +
            '}';
    }
}
