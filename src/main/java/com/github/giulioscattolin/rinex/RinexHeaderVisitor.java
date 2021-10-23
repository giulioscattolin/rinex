package com.github.giulioscattolin.rinex;

public interface RinexHeaderVisitor {
    default void visit(RinexVersionType rinexVersionType) {
    }

    default void visit(RinexPgmRunByDateHeader rinexPgmRunByDateHeader) {
    }
}
