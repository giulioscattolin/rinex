package com.github.giulioscattolin.rinex;

import java.time.LocalDateTime;

public abstract class RinexGpsNavigationData implements RinexRecord {
    public void accept(RinexRecordVisitor visitor) {
        visitor.visit(this);
    }

    public abstract int getPrn();

    public abstract LocalDateTime getToc();

    public abstract double getSvClockBias();

    public abstract double getSvClockDrift();

    public abstract double getSvClockDriftRate();

    public abstract int getIode();

    public abstract double getCrs();

    public abstract double getDeltaN();

    public abstract double getM0();

    public abstract double getCuc();

    public abstract double getE();

    public abstract double getCus();

    public abstract double getSqrtA();

    public abstract int getToe();

    public abstract double getCic();

    public abstract double getBigOmega();

    public abstract double getCis();

    public abstract double getI0();

    public abstract double getCrc();

    public abstract double getSmallOmega();

    public abstract double getOmegaDot();

    public abstract double getIDot();

    public abstract int getCodesOnL2Channel();

    public abstract int getGpsWeekNumber();

    public abstract int getL2PDataFlag();

    public abstract int getSvAccuracy();

    public abstract int getSvHealth();

    public abstract double getTgd();

    public abstract int getIodc();

    public abstract int getTransmissionTimeOfMessage();

    /**
     * Returns <code>true</code> if this navigation message reports the fit interval.
     *
     * The fit interval is not available in RINEX V2.
     */
    public abstract boolean hasFitIntervalInHours();

    public abstract int getFitIntervalInHours();
}
