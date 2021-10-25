package com.github.giulioscattolin.rinex;

@Deprecated
public interface RinexHeader {
    void accept(RinexHeaderVisitor visitor);
}
