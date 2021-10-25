package com.github.giulioscattolin.rinex;

import java.time.LocalDateTime;

@Deprecated
abstract class RinexGpsNavigationDataBuilder implements RinexNavigationDataBuilder {
    private final MutableRinexGpsNavigationDataBuilder itsSatelliteNavigationData = new MutableRinexGpsNavigationDataBuilder();
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
                itsSatelliteNavigationData.setPrn(value);
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
        itsSatelliteNavigationData.setToc(toc);
    }

    public void setParameter(int index, double value) {
        if (index == getLastIndex())
            itsReadyFlag = true;
        switch (index) {
            case 10:
                itsSatelliteNavigationData.setIode((int) value);
                return;
            case 18:
                itsSatelliteNavigationData.setToe((int) value);
                return;
            case 7:
                itsSatelliteNavigationData.setSvClockBias(value);
                return;
            case 8:
                itsSatelliteNavigationData.setSvClockDrift(value);
                return;
            case 9:
                itsSatelliteNavigationData.setSvClockDriftRate(value);
                return;
            case 11:
                itsSatelliteNavigationData.setCrs(value);
                return;
            case 12:
                itsSatelliteNavigationData.setDeltaN(value);
                return;
            case 13:
                itsSatelliteNavigationData.setM0(value);
                return;
            case 14:
                itsSatelliteNavigationData.setCuc(value);
                return;
            case 15:
                itsSatelliteNavigationData.setE(value);
                return;
            case 16:
                itsSatelliteNavigationData.setCus(value);
                return;
            case 17:
                itsSatelliteNavigationData.setSqrtA(value);
                return;
            case 19:
                itsSatelliteNavigationData.setCic(value);
                return;
            case 20:
                itsSatelliteNavigationData.setBigOmega(value);
                return;
            case 21:
                itsSatelliteNavigationData.setCis(value);
                return;
            case 22:
                itsSatelliteNavigationData.setI0(value);
                return;
            case 23:
                itsSatelliteNavigationData.setCrc(value);
                return;
            case 24:
                itsSatelliteNavigationData.setSmallOmega(value);
                return;
            case 25:
                itsSatelliteNavigationData.setOmegaDot(value);
                return;
            case 26:
                itsSatelliteNavigationData.setIDot(value);
                return;
            case 27:
                itsSatelliteNavigationData.setCodesOnL2Channel((int) value);
                return;
            case 28:
                itsSatelliteNavigationData.setGpsWeekNumber((int) value);
                return;
            case 29:
                itsSatelliteNavigationData.setL2PDataFlag((int) value);
                return;
            case 30:
                itsSatelliteNavigationData.setSvAccuracy((int) value);
                return;
            case 31:
                itsSatelliteNavigationData.setSvHealth((int) value);
                return;
            case 32:
                itsSatelliteNavigationData.setTgd(value);
                return;
            case 33:
                itsSatelliteNavigationData.setIodc((int) value);
                return;
            case 34:
                itsSatelliteNavigationData.setTransmissionTimeOfMessage((int) value);
                return;
            case 35:
                itsSatelliteNavigationData.setFitIntervalInHours((int) value);
                itsReadyFlag = true;
                return;
        }
    }

    protected abstract int getLastIndex();

    public RinexRecord build() {
        return itsSatelliteNavigationData;
    }

    public boolean isReady() {
        return itsReadyFlag;
    }
}
