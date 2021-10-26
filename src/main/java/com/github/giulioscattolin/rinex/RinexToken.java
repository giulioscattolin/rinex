package com.github.giulioscattolin.rinex;

public interface RinexToken {
    void accept(RinexTokenVisitor visitor);
}
