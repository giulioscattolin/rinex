package com.github.giulioscattolin.rinex.demo;

import com.github.giulioscattolin.rinex.RinexData;
import com.github.giulioscattolin.rinex.RinexDataVisitor;
import com.github.giulioscattolin.rinex.RinexGpsNavigationMessage;
import com.github.giulioscattolin.rinex.RinexParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

class AnalyzeRinexFileUseCase implements RinexParser.User {
    private final File itsFile;
    private final User itsUser;
    private final RinexParser itsRinexParser;
    private final List<RinexData> itsRinexData = new LinkedList<>();
    private final List<String> itsLexicalErrors = new LinkedList<>();
    private final List<String> itsSemanticErrors = new LinkedList<>();

    AnalyzeRinexFileUseCase(File file, User user) {
        itsFile = file;
        itsUser = user;
        itsRinexParser = new RinexParser(this);
    }

    void execute() {
        if (isFileValid()) {
            read();
            report();
        }
    }

    private boolean isFileValid() {
        if (!itsFile.isFile()) {
            itsUser.error(itsFile + " is not a file, aborting..");
            return false;
        }
        if (!itsFile.canRead()) {
            itsUser.error(itsFile + " is not readable, aborting..");
            return false;
        }
        return true;
    }

    private void read() {
        try {
            tryRead();
        } catch (Exception exception) {
            itsUser.error(exception.toString());
        }
    }

    private void tryRead() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(itsFile))) {
            read(bufferedReader);
        }
    }

    private void read(BufferedReader bufferedReader) throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null)
            readLine(line);
    }

    private void readLine(String line) {
        itsRinexParser.readLine(line);
    }

    public void data(RinexData data) {
        itsRinexData.add(data);
    }

    public void tokenizerError(String error) {
        itsLexicalErrors.add(error);
    }

    public void semanticError(String error) {
        itsSemanticErrors.add(error);
    }

    private void report() {
        tellDataReport();
        tellSemanticReport();
        tellLexicalReport();
    }

    private void tellLexicalReport() {
        int lexicalErrorCount = itsLexicalErrors.size();
        if (lexicalErrorCount == 0)
            info("Found no lexical errors!");
        else
            reportLexicalErrors();
    }

    private void reportLexicalErrors() {
        info("Found " + itsLexicalErrors.size() + " lexical errors:");
        for (String error : itsLexicalErrors)
            info(" - " + error);
    }

    private void tellSemanticReport() {
        int lexicalSemanticCount = itsSemanticErrors.size();
        if (lexicalSemanticCount == 0)
            info("Found no semantic errors!");
        else
            reportSemanticErrors();
    }

    private void reportSemanticErrors() {
        info("Found " + itsSemanticErrors.size() + " semantic errors:");
        for (String error : itsSemanticErrors)
            info(" - " + error);
    }

    private void tellDataReport() {
        new ReportData();
    }

    private void info(String info) {
        itsUser.info(info);
    }

    interface User {
        void error(String error);

        void info(String info);
    }

    private class ReportData implements RinexDataVisitor {
        private int itsGpsNavigationMessageCount;

        ReportData() {
            collect();
            reportData();
        }

        private void collect() {
            for (RinexData data : itsRinexData)
                data.accept(this);
        }

        public void visit(RinexGpsNavigationMessage rinexGpsNavigationMessage) {
            itsGpsNavigationMessageCount += 1;
        }

        private void reportData() {
            int count = itsRinexData.size();
            if (count == 0)
                info("Found no RINEX data!");
            else {
                info("Found " + count + " RINEX data:");
                reportDataPerType();
            }
        }

        private void reportDataPerType() {
            info(" - GPS navigation message: " + itsGpsNavigationMessageCount);
        }
    }
}
