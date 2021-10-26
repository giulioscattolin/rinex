package com.github.giulioscattolin.rinex;

class RinexDataBuilder extends RinexDataBuilderEngine implements RinexTokenCollector, RinexTokenVisitor {
    private final RinexDataCollector itsDataCollector;
    private RinexSvEpochSvClkRecord itsSvEpochSvClk;
    private RinexBroadcastOrbitRecord itsBroadcastOrbit;
    private MutableRinexGpsNavigationMessage itsGpsNavigationMessage;

    public RinexDataBuilder(RinexDataCollector itsDataCollector) {
        this.itsDataCollector = itsDataCollector;
    }

    public void token(RinexToken token) {
        token.accept(this);
    }

    public void visit(RinexSvEpochSvClkRecord svEpochSvClk) {
        switch (svEpochSvClk.getSatelliteSystem()) {
            case 'G':
                visitGpsSvEpochSvClk(svEpochSvClk);
                return;
        }
    }

    private void visitGpsSvEpochSvClk(RinexSvEpochSvClkRecord svEpochSvClk) {
        itsSvEpochSvClk = svEpochSvClk;
        notifyGpsSvEpochSvClk();
    }

    public void visit(RinexBroadcastOrbitRecord broadcastOrbit) {
        itsBroadcastOrbit = broadcastOrbit;
        notifyBroadcastOrbit();
    }

    protected void readGpsSvEpochSvClk() {
        itsGpsNavigationMessage = new MutableRinexGpsNavigationMessage();
        itsGpsNavigationMessage.setSatelliteNumber(itsSvEpochSvClk.getSatelliteNumber());
        itsGpsNavigationMessage.setTocYear(itsSvEpochSvClk.getYear());
        itsGpsNavigationMessage.setTocMonth(itsSvEpochSvClk.getMonth());
        itsGpsNavigationMessage.setTocDay(itsSvEpochSvClk.getDay());
        itsGpsNavigationMessage.setTocHour(itsSvEpochSvClk.getHour());
        itsGpsNavigationMessage.setTocMinute(itsSvEpochSvClk.getMinute());
        itsGpsNavigationMessage.setTocSecond(itsSvEpochSvClk.getSecond());
        itsGpsNavigationMessage.setSvClockBias(itsSvEpochSvClk.getParameter(0));
        itsGpsNavigationMessage.setSvClockDrift(itsSvEpochSvClk.getParameter(1));
        itsGpsNavigationMessage.setSvClockDriftRate(itsSvEpochSvClk.getParameter(2));
    }

    protected void readGpsBroadcastOrbit1() {
        itsGpsNavigationMessage.setIODE((int) itsBroadcastOrbit.getParameter(0));
        itsGpsNavigationMessage.setCrs(itsBroadcastOrbit.getParameter(1));
        itsGpsNavigationMessage.setDeltaN(itsBroadcastOrbit.getParameter(2));
        itsGpsNavigationMessage.setM0(itsBroadcastOrbit.getParameter(3));
    }

    protected void readGpsBroadcastOrbit2() {
        itsGpsNavigationMessage.setCuc(itsBroadcastOrbit.getParameter(0));
        itsGpsNavigationMessage.setE(itsBroadcastOrbit.getParameter(1));
        itsGpsNavigationMessage.setCus(itsBroadcastOrbit.getParameter(2));
        itsGpsNavigationMessage.setSqrtA(itsBroadcastOrbit.getParameter(3));
    }

    protected void readGpsBroadcastOrbit3() {
        itsGpsNavigationMessage.setToe((int) itsBroadcastOrbit.getParameter(0));
        itsGpsNavigationMessage.setCic(itsBroadcastOrbit.getParameter(1));
        itsGpsNavigationMessage.setOmega0(itsBroadcastOrbit.getParameter(2));
        itsGpsNavigationMessage.setCis(itsBroadcastOrbit.getParameter(3));
    }

    protected void readGpsBroadcastOrbit4() {
        itsGpsNavigationMessage.setI0(itsBroadcastOrbit.getParameter(0));
        itsGpsNavigationMessage.setCrc(itsBroadcastOrbit.getParameter(1));
        itsGpsNavigationMessage.setOmega(itsBroadcastOrbit.getParameter(2));
        itsGpsNavigationMessage.setOmegaDot(itsBroadcastOrbit.getParameter(3));
    }

    protected void readGpsBroadcastOrbit5() {
        itsGpsNavigationMessage.setIDOT(itsBroadcastOrbit.getParameter(0));
        itsGpsNavigationMessage.setCodesOnL2Channel((int) itsBroadcastOrbit.getParameter(1));
        itsGpsNavigationMessage.setGpsWeekNumber((int) itsBroadcastOrbit.getParameter(2));
        itsGpsNavigationMessage.setL2PDataFlag((int) itsBroadcastOrbit.getParameter(3));
    }

    protected void readGpsBroadcastOrbit6() {
        itsGpsNavigationMessage.setSvAccuracy((int) itsBroadcastOrbit.getParameter(0));
        itsGpsNavigationMessage.setSvHealth((int) itsBroadcastOrbit.getParameter(1));
        itsGpsNavigationMessage.setTGD(itsBroadcastOrbit.getParameter(2));
        itsGpsNavigationMessage.setIODC((int) itsBroadcastOrbit.getParameter(3));
    }

    protected void readGpsBroadcastOrbit7() {
        switch (itsBroadcastOrbit.getParameters().length) {
            case 2:
                itsGpsNavigationMessage.setSvHealth((int) itsBroadcastOrbit.getParameter(1));
            case 1:
                itsGpsNavigationMessage.setTransimissionTimeOfMessage((int) itsBroadcastOrbit.getParameter(0));
        }
        itsDataCollector.data(itsGpsNavigationMessage);
    }

    public void error(String error) {

    }

    public void unhandledTransition(String state, String event) {
        String error = "Unhandled transition (" + state + ", " + event + ")";
        itsDataCollector.error(error);
    }
}
