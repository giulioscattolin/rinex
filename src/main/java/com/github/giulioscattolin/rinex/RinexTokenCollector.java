package com.github.giulioscattolin.rinex;

public interface RinexTokenCollector {
    void token(RinexToken token);

    void error(String error);
}
