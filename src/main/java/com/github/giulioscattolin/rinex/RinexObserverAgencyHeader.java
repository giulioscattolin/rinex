package com.github.giulioscattolin.rinex;

public class RinexObserverAgencyHeader implements RinexHeader{
    private final String itsObserver;
    private final String itsAgency;

    public RinexObserverAgencyHeader(String type, String itsAgency) {
        this.itsObserver = type;
        this.itsAgency = itsAgency;
    }

    public void accept(RinexHeaderVisitor visitor) {
        visitor.visit(this);
    }

    public String getObserverName() {
        return itsObserver;
    }

    public String getAgencyName() {
        return itsAgency;
    }

    public String toString() {
        return "RinexObserverAgencyHeader{" +
            "itsObserver='" + itsObserver + '\'' +
            ", itsAgency='" + itsAgency + '\'' +
            '}';
    }
}
