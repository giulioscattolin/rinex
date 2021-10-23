package com.github.giulioscattolin.rinex;

public interface RinexRecordVisitor {
    void visit(RinexGpsNavigationData gpsNavigationData);
}
