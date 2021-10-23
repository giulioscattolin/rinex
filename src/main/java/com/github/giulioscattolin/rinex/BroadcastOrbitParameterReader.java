package com.github.giulioscattolin.rinex;

interface BroadcastOrbitParameterReader {
    double getParameterOrNaN(String line, int index);
}
