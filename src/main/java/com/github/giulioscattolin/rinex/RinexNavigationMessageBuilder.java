package com.github.giulioscattolin.rinex;

interface RinexNavigationMessageBuilder {
    void setParameter(int index, int value);

    void setParameter(int index, double value);

    RinexData build();

    boolean isReady();
}
