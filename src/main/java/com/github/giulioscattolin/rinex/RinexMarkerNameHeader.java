package com.github.giulioscattolin.rinex;

public class RinexMarkerNameHeader implements RinexHeader{
    private final String itsName ;

    public RinexMarkerNameHeader(String name) {
        this.itsName = name;
    }

    public void accept(RinexHeaderVisitor visitor) {
        visitor.visit(this);
    }

    public String getAntennaMarkerName() {
        return itsName;
    }
}
