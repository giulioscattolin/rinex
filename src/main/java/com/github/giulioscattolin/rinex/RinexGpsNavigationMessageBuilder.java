package com.github.giulioscattolin.rinex;

import java.time.LocalDateTime;

abstract class RinexGpsNavigationMessageBuilder implements RinexNavigationMessageBuilder {
    private final MutableRinexGpsNavigationMessage itsNavigationMessage = new MutableRinexGpsNavigationMessage();
    private int itsTocYear;
    private int itsTocMonth;
    private int itsTocDay;
    private int itsTocHour;
    private int itsTocMinute;
    private int itsTocSecond;
    private boolean itsReadyFlag;

    public void setParameter(int index, int value) {
        switch (index) {
            case 0:
                itsNavigationMessage.setPrn(value);
                return;
            case 1:
                itsTocYear = value;
                return;
            case 2:
                itsTocMonth = value;
                return;
            case 3:
                itsTocDay = value;
                return;
            case 4:
                itsTocHour = value;
                return;
            case 5:
                itsTocMinute = value;
                return;
            case 6:
                itsTocSecond = value;
                buildToc();
        }
    }

    private void buildToc() {
        LocalDateTime toc = LocalDateTime.of(itsTocYear, itsTocMonth, itsTocDay, itsTocHour, itsTocMinute, itsTocSecond);
        itsNavigationMessage.setToc(toc);
    }

    public void setParameter(int index, double value) {
        if (index == getLastIndex())
            itsReadyFlag = true;
        switch (index) {
            case 10:
                itsNavigationMessage.setIode((int) value);
                return;
            case 18:
                itsNavigationMessage.setToe((int) value);
                return;
            case 7:
                itsNavigationMessage.setSvClockBias(value);
                return;
            case 8:
                itsNavigationMessage.setSvClockDrift(value);
                return;
            case 9:
                itsNavigationMessage.setSvClockDriftRate(value);
                return;
            case 11:
                itsNavigationMessage.setCrs(value);
                return;
            case 12:
                itsNavigationMessage.setDeltaN(value);
                return;
            case 13:
                itsNavigationMessage.setM0(value);
                return;
            case 14:
                itsNavigationMessage.setCuc(value);
                return;
            case 15:
                itsNavigationMessage.setE(value);
                return;
            case 16:
                itsNavigationMessage.setCus(value);
                return;
            case 17:
                itsNavigationMessage.setSqrtA(value);
                return;
            case 19:
                itsNavigationMessage.setCic(value);
                return;
            case 20:
                itsNavigationMessage.setBigOmega(value);
                return;
            case 21:
                itsNavigationMessage.setCis(value);
                return;
            case 22:
                itsNavigationMessage.setI0(value);
                return;
            case 23:
                itsNavigationMessage.setCrc(value);
                return;
            case 24:
                itsNavigationMessage.setSmallOmega(value);
                return;
            case 25:
                itsNavigationMessage.setOmegaDot(value);
                return;
            case 26:
                itsNavigationMessage.setIDot(value);
                return;
            case 27:
                itsNavigationMessage.setCodesOnL2Channel((int) value);
                return;
            case 28:
                itsNavigationMessage.setGpsWeekNumber((int) value);
                return;
            case 29:
                itsNavigationMessage.setL2PDataFlag((int) value);
                return;
            case 30:
                itsNavigationMessage.setSvAccuracy((int) value);
                return;
            case 31:
                itsNavigationMessage.setSvHealth((int) value);
                return;
            case 32:
                itsNavigationMessage.setTgd(value);
                return;
            case 33:
                itsNavigationMessage.setIodc((int) value);
                return;
            case 34:
                itsNavigationMessage.setTransmissionTimeOfMessage((int) value);
                return;
            case 35:
                itsNavigationMessage.setFitIntervalInHours((int) value);
                itsReadyFlag = true;
                return;
        }
    }

    protected abstract int getLastIndex();

    public RinexData build() {
        return itsNavigationMessage;
    }

    public boolean isReady() {
        return itsReadyFlag;
    }
}
