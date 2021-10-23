package com.github.giulioscattolin.rinex;

public class RinexPgmRunByDateHeader implements RinexHeader {
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
}
