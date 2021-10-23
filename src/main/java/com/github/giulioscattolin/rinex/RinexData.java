package com.github.giulioscattolin.rinex;

public interface RinexData {
    void accept(RinexDataVisitor visitor);
}
