package com.github.giulioscattolin.rinex;

import java.util.List;

@Deprecated
public interface RinexFile {
    List<RinexHeader> getHeaders();

    List<RinexRecord> getRecords();
}
