package com.github.giulioscattolin.rinex;

interface RinexTokenizerProvider {
    RinexTokenizer provideTokenizer(TokenizerName name);

    enum TokenizerName {
        RINEX_VERSION_TYPE,
        NAVIGATION_FILE_HEADER_V302,
        NAVIGATION_FILE_HEADER_V304,
        SV_EPOCH_SV_CLK_V302,
        SV_EPOCH_SV_CLK_V304,
        BROADCAST_ORBIT_V302,
        BROADCAST_ORBIT_V304
    }
}
