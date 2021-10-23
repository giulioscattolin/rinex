package com.github.giulioscattolin.rinex;

abstract class LineReader {
    protected String itsLine;

    void readLine(String line) {
        itsLine = line;
        execute();
    }

    protected abstract void execute();

    protected boolean isHeader(String header) {
        return itsLine.length() >= 60 && isHeaderLabelEqualTo(header);
    }

    protected boolean isHeaderLabelEqualTo(String expected) {
        return expected.equals(getHeaderLabel());
    }

    protected String getHeaderLabel() {
        return itsLine.substring(60).trim();
    }
}
