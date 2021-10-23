package com.github.giulioscattolin.rinex;

import java.time.LocalDateTime;

class MutableRinexGpsNavigationMessage extends RinexGpsNavigationMessage {
    private static final int INVALID_INT = Integer.MIN_VALUE;
    private int itsPrn;
    private LocalDateTime itsToc;
    private double itsSvClockBias;
    private double itsSvClockDrift;
    private double itsSvClockDriftRate;
    private int itsIode;
    private double itsCrs;
    private double itsDeltaN;
    private double itsM0;
    private double itsCuc;
    private double itsE;
    private double itsCus;
    private double itsSqrtA;
    private int itsToe;
    private double itsCic;
    private double itsBigOmega;
    private double itsCis;
    private double itsI0;
    private double itsCrc;
    private double itsSmallOmega;
    private double itsOmegaDot;
    private double itsIDot;
    private int itsCodesOnL2Channel;
    private int itsGpsWeekNumber;
    private int itsL2PDataFlag;
    private int itsSvAccuracy;
    private int itsSvHealth;
    private double itsTgd;
    private int itsIodc;
    private int itsTransmissionTimeOfMessage;
    private int itsFitIntervalInHours = INVALID_INT;

    public int getPrn() {
        return itsPrn;
    }

    public void setPrn(int itsPrn) {
        this.itsPrn = itsPrn;
    }

    public LocalDateTime getToc() {
        return itsToc;
    }

    public void setToc(LocalDateTime itsToc) {
        this.itsToc = itsToc;
    }

    public double getSvClockBias() {
        return itsSvClockBias;
    }

    public void setSvClockBias(double itsSvClockBias) {
        this.itsSvClockBias = itsSvClockBias;
    }

    public double getSvClockDrift() {
        return itsSvClockDrift;
    }

    public void setSvClockDrift(double itsSvClockDrift) {
        this.itsSvClockDrift = itsSvClockDrift;
    }

    public double getSvClockDriftRate() {
        return itsSvClockDriftRate;
    }

    public void setSvClockDriftRate(double itsSvClockDriftRate) {
        this.itsSvClockDriftRate = itsSvClockDriftRate;
    }

    public int getIode() {
        return itsIode;
    }

    public void setIode(int itsIode) {
        this.itsIode = itsIode;
    }

    public double getCrs() {
        return itsCrs;
    }

    public void setCrs(double itsCrs) {
        this.itsCrs = itsCrs;
    }

    public double getDeltaN() {
        return itsDeltaN;
    }

    public void setDeltaN(double itsDeltaN) {
        this.itsDeltaN = itsDeltaN;
    }

    public double getM0() {
        return itsM0;
    }

    public void setM0(double itsM0) {
        this.itsM0 = itsM0;
    }

    public double getCuc() {
        return itsCuc;
    }

    public void setCuc(double itsCuc) {
        this.itsCuc = itsCuc;
    }

    public double getE() {
        return itsE;
    }

    public void setE(double itsE) {
        this.itsE = itsE;
    }

    public double getCus() {
        return itsCus;
    }

    public void setCus(double itsCus) {
        this.itsCus = itsCus;
    }

    public double getSqrtA() {
        return itsSqrtA;
    }

    public void setSqrtA(double itsSqrtA) {
        this.itsSqrtA = itsSqrtA;
    }

    public int getToe() {
        return itsToe;
    }

    public void setToe(int itsToe) {
        this.itsToe = itsToe;
    }

    public double getCic() {
        return itsCic;
    }

    public void setCic(double itsCic) {
        this.itsCic = itsCic;
    }

    public double getBigOmega() {
        return itsBigOmega;
    }

    public void setBigOmega(double itsBigOmega) {
        this.itsBigOmega = itsBigOmega;
    }

    public double getCis() {
        return itsCis;
    }

    public void setCis(double itsCis) {
        this.itsCis = itsCis;
    }

    public double getI0() {
        return itsI0;
    }

    public void setI0(double itsI0) {
        this.itsI0 = itsI0;
    }

    public double getCrc() {
        return itsCrc;
    }

    public void setCrc(double itsCrc) {
        this.itsCrc = itsCrc;
    }

    public double getSmallOmega() {
        return itsSmallOmega;
    }

    public void setSmallOmega(double itsSmallOmega) {
        this.itsSmallOmega = itsSmallOmega;
    }

    public double getOmegaDot() {
        return itsOmegaDot;
    }

    public void setOmegaDot(double itsOmegaDot) {
        this.itsOmegaDot = itsOmegaDot;
    }

    public double getIDot() {
        return itsIDot;
    }

    public void setIDot(double itsIDot) {
        this.itsIDot = itsIDot;
    }

    public int getCodesOnL2Channel() {
        return itsCodesOnL2Channel;
    }

    public void setCodesOnL2Channel(int itsCodesOnL2Channel) {
        this.itsCodesOnL2Channel = itsCodesOnL2Channel;
    }

    public int getGpsWeekNumber() {
        return itsGpsWeekNumber;
    }

    public void setGpsWeekNumber(int itsGpsWeekNumber) {
        this.itsGpsWeekNumber = itsGpsWeekNumber;
    }

    public int getL2PDataFlag() {
        return itsL2PDataFlag;
    }

    public void setL2PDataFlag(int itsL2PDataFlag) {
        this.itsL2PDataFlag = itsL2PDataFlag;
    }

    public int getSvAccuracy() {
        return itsSvAccuracy;
    }

    public void setSvAccuracy(int itsSvAccuracy) {
        this.itsSvAccuracy = itsSvAccuracy;
    }

    public int getSvHealth() {
        return itsSvHealth;
    }

    public void setSvHealth(int itsSvHealth) {
        this.itsSvHealth = itsSvHealth;
    }

    public double getTgd() {
        return itsTgd;
    }

    public void setTgd(double itsTgd) {
        this.itsTgd = itsTgd;
    }

    public int getIodc() {
        return itsIodc;
    }

    public void setIodc(int itsIodc) {
        this.itsIodc = itsIodc;
    }

    public int getTransmissionTimeOfMessage() {
        return itsTransmissionTimeOfMessage;
    }

    public void setTransmissionTimeOfMessage(int itsTransmissionTimeOfMessage) {
        this.itsTransmissionTimeOfMessage = itsTransmissionTimeOfMessage;
    }

    public boolean hasFitIntervalInHours() {
        return itsFitIntervalInHours != INVALID_INT;
    }

    public int getFitIntervalInHours() {
        return itsFitIntervalInHours;
    }

    public void setFitIntervalInHours(int itsFitIntervalInHours) {
        this.itsFitIntervalInHours = itsFitIntervalInHours;
    }
}
