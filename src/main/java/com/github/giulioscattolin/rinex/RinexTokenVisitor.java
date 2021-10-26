package com.github.giulioscattolin.rinex;

public interface RinexTokenVisitor {
    default void visit(RinexPgmRunByDateHeader pgmRunByDate) {
    }

    default void visit(RinexBroadcastOrbitRecord broadcastOrbit) {
    }

    default void visit(RinexSvEpochSvClkRecord svEpochSvClk) {
    }

    default void visit(RinexVersionTypeHeader versionType) {
    }
}
