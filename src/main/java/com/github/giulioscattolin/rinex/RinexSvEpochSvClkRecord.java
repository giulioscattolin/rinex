package com.github.giulioscattolin.rinex;

public abstract class RinexSvEpochSvClkRecord implements RinexToken{
    public void accept(RinexTokenVisitor visitor) {
        visitor.visit(this);
    }

    public abstract boolean hasSatelliteSystem();

    public abstract char getSatelliteSystem();

    public abstract int getSatelliteNumber();

    public abstract int getYear();

    public abstract int getMonth();

    public abstract int getDay();

    public abstract int getHour();

    public abstract int getMinute();

    public abstract int getSecond();

    public abstract double[] getParameters();

    public abstract double getParameter(int index);
}
