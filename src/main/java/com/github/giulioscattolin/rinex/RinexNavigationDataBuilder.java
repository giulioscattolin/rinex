package com.github.giulioscattolin.rinex;

@Deprecated
interface RinexNavigationDataBuilder {
    void setParameter(int index, int value);

    void setParameter(int index, double value);

    RinexRecord build();

    boolean isReady();
}
