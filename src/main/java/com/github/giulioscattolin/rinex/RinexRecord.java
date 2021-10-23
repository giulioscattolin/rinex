package com.github.giulioscattolin.rinex;

public interface RinexRecord {
    void accept(RinexRecordVisitor visitor);
}
