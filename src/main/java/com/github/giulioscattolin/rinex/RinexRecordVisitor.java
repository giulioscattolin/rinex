package com.github.giulioscattolin.rinex;

@Deprecated
public interface RinexRecordVisitor {
    void visit(RinexGpsNavigationData gpsNavigationData);
}
