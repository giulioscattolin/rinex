package com.github.giulioscattolin.rinex;

public class RinexTokenizerProviderFacade implements RinexTokenizerProvider {
    private RinexTokenCollector itsTokenCollector;
    private RinexTokenizerDriver itsTokenizerDriver;

    public void setTokenCollector(RinexTokenCollector itsTokenCollector) {
        this.itsTokenCollector = itsTokenCollector;
    }

    public void setTokenizerDriver(RinexTokenizerDriver itsTokenizerDriver) {
        this.itsTokenizerDriver = itsTokenizerDriver;
    }

    public RinexTokenizer provideTokenizer(TokenizerName name) {
        switch (name) {
            case RINEX_VERSION_TYPE:
                return new RinexVersionTypeHeaderTokenizer(itsTokenCollector, this, itsTokenizerDriver);
            case NAVIGATION_FILE_HEADER_V304:
                return new NavigationMessageFileHeaderV304Tokenizer(itsTokenCollector, this, itsTokenizerDriver);
            case SV_EPOCH_SV_CLK_V304:
                return new SvEpochSvClockRecordV304Tokenizer(itsTokenCollector, this, itsTokenizerDriver);
            case BROADCAST_ORBIT_V304:
                return new BroadcastOrbitRecordV304Tokenizer(itsTokenCollector, this, itsTokenizerDriver);
        }
        throw new UnsupportedOperationException("Got unexpected tokenizer named " + name);
    }
}
