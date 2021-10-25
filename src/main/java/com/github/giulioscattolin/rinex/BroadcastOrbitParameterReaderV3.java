package com.github.giulioscattolin.rinex;

import static com.github.giulioscattolin.rinex.Utilities.toFloatingPointNumberOrNaN;

@Deprecated
class BroadcastOrbitParameterReaderV3 implements BroadcastOrbitParameterReader{
    public double getParameterOrNaN(String line, int index) {
        switch (index) {
            case 0:
                return toFloatingPointNumberOrNaN(line.substring(4, 23));
            case 1:
                return toFloatingPointNumberOrNaN(line.substring(23, 42));
            case 2:
                return toFloatingPointNumberOrNaN(line.substring(42, 61));
            case 3:
                return toFloatingPointNumberOrNaN(line.substring(61, 80));
            default:
                throw new IllegalStateException("Unexpected index = " + index);
        }
    }
}
