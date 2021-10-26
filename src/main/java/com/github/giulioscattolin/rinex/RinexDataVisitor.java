package com.github.giulioscattolin.rinex;

public interface RinexDataVisitor {
    default void visit(RinexGpsNavigationMessage rinexGpsNavigationMessage) {
    }
}
