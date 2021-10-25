package com.github.giulioscattolin.rinex;

@Deprecated
public interface RinexRecord {
    void accept(RinexRecordVisitor visitor);
}
