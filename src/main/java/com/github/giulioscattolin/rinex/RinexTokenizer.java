package com.github.giulioscattolin.rinex;

public interface RinexTokenizer {
    void setLineNumber(int lineNumber);
    void readLine(String line);
}
