package com.github.giulioscattolin.rinex;

public interface RinexDataCollector {
    void data(RinexData data);
    void error(String error);
}
