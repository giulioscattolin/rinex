package com.github.giulioscattolin.rinex;

@Deprecated
public interface RinexHeaderVisitor {
    default void visit(RinexVersionTypeHeader rinexVersionTypeHeader) {
    }

    default void visit(RinexPgmRunByDateHeader rinexPgmRunByDateHeader) {
    }

    default void visit(RinexMarkerNameHeader rinexMarkerNameHeader) {
    }

    default void visit(RinexObserverAgencyHeader rinexObserverAgencyHeader) {
    }
}
