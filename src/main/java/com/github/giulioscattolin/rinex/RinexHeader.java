package com.github.giulioscattolin.rinex;

public interface RinexHeader {
    void accept(RinexHeaderVisitor visitor);
}
