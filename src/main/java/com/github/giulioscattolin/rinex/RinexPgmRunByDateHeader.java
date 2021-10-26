package com.github.giulioscattolin.rinex;

import java.util.Objects;

public class RinexPgmRunByDateHeader implements RinexHeader, RinexToken {
    private final String itsProgram;
    private final String itsAgency;
    private final String itsTimestamp;

    RinexPgmRunByDateHeader(String itsProgram, String itsAgency, String itsTimestamp) {
        this.itsProgram = itsProgram;
        this.itsAgency = itsAgency;
        this.itsTimestamp = itsTimestamp;
    }

    public void accept(RinexHeaderVisitor visitor) {
        visitor.visit(this);
    }

    public String getProgram() {
        return itsProgram;
    }

    public String getAgency() {
        return itsAgency;
    }

    public String getTimestamp() {
        return itsTimestamp;
    }

    public void accept(RinexTokenVisitor visitor) {
        visitor.visit(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RinexPgmRunByDateHeader that = (RinexPgmRunByDateHeader) o;
        return itsProgram.equals(that.itsProgram) && itsAgency.equals(that.itsAgency) && itsTimestamp.equals(that.itsTimestamp);
    }

    public int hashCode() {
        return Objects.hash(itsProgram, itsAgency, itsTimestamp);
    }

    public String toString() {
        return "RinexPgmRunByDateHeader{" +
            "itsProgram='" + itsProgram + '\'' +
            ", itsAgency='" + itsAgency + '\'' +
            ", itsTimestamp='" + itsTimestamp + '\'' +
            '}';
    }
}
