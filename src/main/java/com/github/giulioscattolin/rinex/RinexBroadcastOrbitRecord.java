package com.github.giulioscattolin.rinex;

public abstract class RinexBroadcastOrbitRecord implements RinexToken {
    public abstract double getParameter(int index);

    public abstract double[] getParameters();

    public void accept(RinexTokenVisitor visitor) {
        visitor.visit(this);
    }
}
