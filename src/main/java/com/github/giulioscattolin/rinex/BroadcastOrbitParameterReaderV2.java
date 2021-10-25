package com.github.giulioscattolin.rinex;

import static com.github.giulioscattolin.rinex.Utilities.toFloatingPointNumberOrNaN;

@Deprecated
class BroadcastOrbitParameterReaderV2 implements BroadcastOrbitParameterReader{
    public double getParameterOrNaN(String line, int index) {
        switch (index) {
            case 0:
                return toFloatingPointNumberOrNaN(line.substring(3, 22));
            case 1:
                return toFloatingPointNumberOrNaN(line.substring(22, 41));
            case 2:
                return toFloatingPointNumberOrNaN(line.substring(41, 60));
            case 3:
                return toFloatingPointNumberOrNaN(line.substring(60, 79));
            default:
                throw new IllegalStateException("Unexpected index = " + index);
        }
    }
}
