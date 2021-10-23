package com.github.giulioscattolin.rinex;

public interface RinexDataVisitor {
    void visit(RinexGpsNavigationMessage rinexGpsNavigationMessage);
}
