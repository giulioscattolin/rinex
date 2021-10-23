package com.github.giulioscattolin.rinex;

import java.util.LinkedList;
import java.util.List;

class MutableRinexFile implements RinexFile{
    private final List<RinexHeader> itsHeaders = new LinkedList<>();
    private final List<RinexRecord> itsRecords = new LinkedList<>();

    public List<RinexHeader> getHeaders() {
        return itsHeaders;
    }

    public List<RinexRecord> getRecords() {
        return itsRecords;
    }

    void addHeader(RinexHeader header) {
        itsHeaders.add(header);
    }

    void addRecord(RinexRecord record) {
        itsRecords.add(record);
    }
}
