package com.github.giulioscattolin.rinex;

public interface RinexHeaderVisitor {
    default void visit(RinexVersionTypeHeader rinexVersionTypeHeader) {
    }

    default void visit(RinexPgmRunByDateHeader rinexPgmRunByDateHeader) {
    }
}
