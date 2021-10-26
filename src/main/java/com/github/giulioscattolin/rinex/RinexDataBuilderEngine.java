package com.github.giulioscattolin.rinex;
public abstract class RinexDataBuilderEngine {
public abstract void unhandledTransition(String state, String event);
private enum State {GPS_BROADCAST_ORBIT_1,GPS_BROADCAST_ORBIT_2,GPS_BROADCAST_ORBIT_3,GPS_BROADCAST_ORBIT_4,GPS_BROADCAST_ORBIT_5,GPS_BROADCAST_ORBIT_6,GPS_BROADCAST_ORBIT_7,READY}
private enum Event {notifyBroadcastOrbit,notifyGpsSvEpochSvClk}
private State state = State.READY;
private void setState(State s) {state = s;}
public void notifyBroadcastOrbit() {handleEvent(Event.notifyBroadcastOrbit);}
public void notifyGpsSvEpochSvClk() {handleEvent(Event.notifyGpsSvEpochSvClk);}
private void handleEvent(Event event) {
switch(state) {
case GPS_BROADCAST_ORBIT_1:
switch(event) {
case notifyBroadcastOrbit:
setState(State.GPS_BROADCAST_ORBIT_2);
readGpsBroadcastOrbit1();
break;
default: unhandledTransition(state.name(), event.name()); break;
}
break;
case GPS_BROADCAST_ORBIT_2:
switch(event) {
case notifyBroadcastOrbit:
setState(State.GPS_BROADCAST_ORBIT_3);
readGpsBroadcastOrbit2();
break;
default: unhandledTransition(state.name(), event.name()); break;
}
break;
case GPS_BROADCAST_ORBIT_3:
switch(event) {
case notifyBroadcastOrbit:
setState(State.GPS_BROADCAST_ORBIT_4);
readGpsBroadcastOrbit3();
break;
default: unhandledTransition(state.name(), event.name()); break;
}
break;
case GPS_BROADCAST_ORBIT_4:
switch(event) {
case notifyBroadcastOrbit:
setState(State.GPS_BROADCAST_ORBIT_5);
readGpsBroadcastOrbit4();
break;
default: unhandledTransition(state.name(), event.name()); break;
}
break;
case GPS_BROADCAST_ORBIT_5:
switch(event) {
case notifyBroadcastOrbit:
setState(State.GPS_BROADCAST_ORBIT_6);
readGpsBroadcastOrbit5();
break;
default: unhandledTransition(state.name(), event.name()); break;
}
break;
case GPS_BROADCAST_ORBIT_6:
switch(event) {
case notifyBroadcastOrbit:
setState(State.GPS_BROADCAST_ORBIT_7);
readGpsBroadcastOrbit6();
break;
default: unhandledTransition(state.name(), event.name()); break;
}
break;
case GPS_BROADCAST_ORBIT_7:
switch(event) {
case notifyBroadcastOrbit:
setState(State.READY);
readGpsBroadcastOrbit7();
break;
default: unhandledTransition(state.name(), event.name()); break;
}
break;
case READY:
switch(event) {
case notifyGpsSvEpochSvClk:
setState(State.GPS_BROADCAST_ORBIT_1);
readGpsSvEpochSvClk();
break;
default: unhandledTransition(state.name(), event.name()); break;
}
break;
}
}
protected abstract void readGpsSvEpochSvClk();
protected abstract void readGpsBroadcastOrbit1();
protected abstract void readGpsBroadcastOrbit2();
protected abstract void readGpsBroadcastOrbit3();
protected abstract void readGpsBroadcastOrbit4();
protected abstract void readGpsBroadcastOrbit5();
protected abstract void readGpsBroadcastOrbit6();
protected abstract void readGpsBroadcastOrbit7();
}
