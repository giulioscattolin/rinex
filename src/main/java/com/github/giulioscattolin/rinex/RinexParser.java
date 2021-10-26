package com.github.giulioscattolin.rinex;

public class RinexParser {
    private final User itsUser;
    private final RinexDataBuilder itsBuilder;
    private final RinexTokenEmitter itsTokenizer;

    public RinexParser(User user) {
        itsUser = user;
        itsBuilder = new RinexDataBuilder(new DataCollectorImpl());
        itsTokenizer = new RinexTokenEmitter(new TokenCollectorImpl());
    }

    public void readLine(String line) {
        itsTokenizer.readLine(line);
    }

    public interface User {
        void data(RinexData data);

        void tokenizerError(String error);

        void semanticError(String error);
    }

    private class DataCollectorImpl implements RinexDataCollector {
        public void data(RinexData data) {
            itsUser.data(data);
        }

        public void error(String error) {
            itsUser.semanticError(error);
        }
    }

    private class TokenCollectorImpl implements RinexTokenCollector {
        public void token(RinexToken token) {
            itsBuilder.token(token);
        }

        public void error(String error) {
            itsBuilder.error(error);
            itsUser.tokenizerError(error);
        }
    }
}
