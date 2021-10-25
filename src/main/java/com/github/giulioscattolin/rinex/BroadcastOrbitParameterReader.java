package com.github.giulioscattolin.rinex;

@Deprecated
interface BroadcastOrbitParameterReader {
    double getParameterOrNaN(String line, int index);
}
