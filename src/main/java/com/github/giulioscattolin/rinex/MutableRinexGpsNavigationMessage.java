package com.github.giulioscattolin.rinex;

class MutableRinexGpsNavigationMessage extends RinexGpsNavigationMessage {
    private static final int INVALID_INTEGER = -1;
    private int itsSatelliteNumber;
    private int itsTocYear;
    private int itsTocMonth;
    private int itsTocDay;
    private int itsTocHour;
    private int itsTocMinute;
    private int itsTocSecond;
    private double itsSvClockBias;
    private double itsSvClockDrift;
    private double itsSvClockDriftRate;
    private int itsIODE;
    private double itsCrs;
    private double itsDeltaN;
    private double itsM0;
    private double itsCuc;
    private double itsE;
    private double itsCus;
    private double itsSqrtA;
    private int itsToe;
    private double itsCic;
    private double itsOmega0;
    private double itsCis;
    private double itsI0;
    private double itsCrc;
    private double itsOmega;
    private double itsOmegaDot;
    private double itsIDot;
    private int itsCodesOnL2Channel;
    private int itsGpsWeekNumber;
    private int itsL2PDataFlag;
    private int itsSvAccuracy;
    private int itsSvHealth;
    private double itsTgd;
    private int itsIODC;
    private int itsTransimissionTimeOfMessage;
    private int itsFitIntervalInHours = INVALID_INTEGER;

    public int getSatelliteNumber() {
        return itsSatelliteNumber;
    }

    public int getTocYear() {
        return itsTocYear;
    }

    public int getTocMonth() {
        return itsTocMonth;
    }

    public int getTocDay() {
        return itsTocDay;
    }

    public int getTocHour() {
        return itsTocHour;
    }

    public int getTocMinute() {
        return itsTocMinute;
    }

    public int getTocSecond() {
        return itsTocSecond;
    }

    public double getSvClockBias() {
        return itsSvClockBias;
    }

    public double getSvClockDrift() {
        return itsSvClockDrift;
    }

    public double getSvClockDriftRate() {
        return itsSvClockDriftRate;
    }

    public int getIODE() {
        return itsIODE;
    }

    public double getCrs() {
        return itsCrs;
    }

    public double getDeltaN() {
        return itsDeltaN;
    }

    public double getM0() {
        return itsM0;
    }

    public double getCuc() {
        return itsCuc;
    }

    public double getE() {
        return itsE;
    }

    public double getCus() {
        return itsCus;
    }

    public double getSqrtA() {
        return itsSqrtA;
    }

    public int getToe() {
        return itsToe;
    }

    public double getCic() {
        return itsCic;
    }

    public double getOmega0() {
        return itsOmega0;
    }

    public double getCis() {
        return itsCis;
    }

    public double getI0() {
        return itsI0;
    }

    public double getCrc() {
        return itsCrc;
    }

    public double getOmega() {
        return itsOmega;
    }

    public double getOmegaDot() {
        return itsOmegaDot;
    }

    public double getIDot() {
        return itsIDot;
    }

    public int getCodesOnL2Channel() {
        return itsCodesOnL2Channel;
    }

    public int getGpsWeekNumber() {
        return itsGpsWeekNumber;
    }

    public int getL2PDataFlag() {
        return itsL2PDataFlag;
    }

    public int getSvAccuracy() {
        return itsSvAccuracy;
    }

    public int getSvHealth() {
        return itsSvHealth;
    }

    public double getTgd() {
        return itsTgd;
    }

    public int getIODC() {
        return itsIODC;
    }

    public int getTransmissionTimeOfMessage() {
        return itsTransimissionTimeOfMessage;
    }

    public boolean hasFitIntervalInHours() {
        return itsFitIntervalInHours != INVALID_INTEGER;
    }

    public int getFitIntervalInHours() {
        return itsFitIntervalInHours;
    }

    public void setSatelliteNumber(int itsSatelliteNumber) {
        this.itsSatelliteNumber = itsSatelliteNumber;
    }

    public void setTocYear(int itsTocYear) {
        this.itsTocYear = itsTocYear;
    }

    public void setTocMonth(int itsTocMonth) {
        this.itsTocMonth = itsTocMonth;
    }

    public void setTocDay(int itsTocDay) {
        this.itsTocDay = itsTocDay;
    }

    public void setTocHour(int itsTocHour) {
        this.itsTocHour = itsTocHour;
    }

    public void setTocMinute(int itsTocMinute) {
        this.itsTocMinute = itsTocMinute;
    }

    public void setTocSecond(int itsTocSecond) {
        this.itsTocSecond = itsTocSecond;
    }

    public void setSvClockBias(double itsSvClockBias) {
        this.itsSvClockBias = itsSvClockBias;
    }

    public void setSvClockDrift(double itsSvClockDrift) {
        this.itsSvClockDrift = itsSvClockDrift;
    }

    public void setSvClockDriftRate(double itsSvClockDriftRate) {
        this.itsSvClockDriftRate = itsSvClockDriftRate;
    }

    public void setIODE(int itsIODE) {
        this.itsIODE = itsIODE;
    }

    public void setCrs(double itsCrs) {
        this.itsCrs = itsCrs;
    }

    public void setDeltaN(double itsDeltaN) {
        this.itsDeltaN = itsDeltaN;
    }

    public void setM0(double itsM0) {
        this.itsM0 = itsM0;
    }

    public void setCuc(double itsCuc) {
        this.itsCuc = itsCuc;
    }

    public void setE(double itsE) {
        this.itsE = itsE;
    }

    public void setCus(double itsCus) {
        this.itsCus = itsCus;
    }

    public void setSqrtA(double itsSqrtA) {
        this.itsSqrtA = itsSqrtA;
    }

    public void setToe(int itsToe) {
        this.itsToe = itsToe;
    }

    public void setCic(double itsCic) {
        this.itsCic = itsCic;
    }

    public void setOmega0(double itsOmega0) {
        this.itsOmega0 = itsOmega0;
    }

    public void setCis(double itsCis) {
        this.itsCis = itsCis;
    }

    public void setI0(double itsI0) {
        this.itsI0 = itsI0;
    }

    public void setCrc(double itsCrc) {
        this.itsCrc = itsCrc;
    }

    public void setOmega(double itsOmega) {
        this.itsOmega = itsOmega;
    }

    public void setOmegaDot(double itsOmegaDot) {
        this.itsOmegaDot = itsOmegaDot;
    }

    public void setIDOT(double itsIDot) {
        this.itsIDot = itsIDot;
    }

    public void setCodesOnL2Channel(int itsCodesOnL2Channel) {
        this.itsCodesOnL2Channel = itsCodesOnL2Channel;
    }

    public void setGpsWeekNumber(int itsGpsWeekNumber) {
        this.itsGpsWeekNumber = itsGpsWeekNumber;
    }

    public void setL2PDataFlag(int itsL2PDataFlag) {
        this.itsL2PDataFlag = itsL2PDataFlag;
    }

    public void setSvAccuracy(int itsSvAccuracy) {
        this.itsSvAccuracy = itsSvAccuracy;
    }

    public void setSvHealth(int itsSvHealth) {
        this.itsSvHealth = itsSvHealth;
    }

    public void setTGD(double itsTgd) {
        this.itsTgd = itsTgd;
    }

    public void setIODC(int itsIODC) {
        this.itsIODC = itsIODC;
    }

    public void setTransimissionTimeOfMessage(int itsTransimissionTimeOfMessage) {
        this.itsTransimissionTimeOfMessage = itsTransimissionTimeOfMessage;
    }

    public void setFitIntervalInHours(int itsFitIntervalInHours) {
        this.itsFitIntervalInHours = itsFitIntervalInHours;
    }
}
