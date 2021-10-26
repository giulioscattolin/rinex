package com.github.giulioscattolin.rinex;

public abstract class RinexGpsNavigationMessage implements RinexData {
    public abstract int getSatelliteNumber();

    public abstract int getTocYear();

    public abstract int getTocMonth();

    public abstract int getTocDay();

    public abstract int getTocHour();

    public abstract int getTocMinute();

    public abstract int getTocSecond();

    public abstract double getSvClockBias();

    public abstract double getSvClockDrift();

    public abstract double getSvClockDriftRate();

    public abstract int getIODE();

    public abstract double getCrs();

    public abstract double getDeltaN();

    public abstract double getM0();

    public abstract double getCuc();

    public abstract double getE();

    public abstract double getCus();

    public abstract double getSqrtA();

    public abstract int getToe();

    public abstract double getCic();

    public abstract double getOmega0();

    public abstract double getCis();

    public abstract double getI0();

    public abstract double getCrc();

    public abstract double getOmega();

    public abstract double getOmegaDot();

    public abstract double getIDot();

    public abstract int getCodesOnL2Channel();

    public abstract int getGpsWeekNumber();

    public abstract int getL2PDataFlag();

    public abstract int getSvAccuracy();

    public abstract int getSvHealth();

    public abstract double getTgd();

    public abstract int getIODC();

    public abstract int getTransmissionTimeOfMessage();

    public abstract boolean hasFitIntervalInHours();

    public abstract int getFitIntervalInHours();

    public void accept(RinexDataVisitor visitor) {
        visitor.visit(this);
    }
}
