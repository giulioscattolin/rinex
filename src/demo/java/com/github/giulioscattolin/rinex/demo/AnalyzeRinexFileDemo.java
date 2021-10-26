package com.github.giulioscattolin.rinex.demo;

import java.io.File;

public class AnalyzeRinexFileDemo {
    public static void main(String[] args) {
        String filePath = args[0];
        File file = new File(filePath);
        new AnalyzeRinexFileUseCase(file, new CLIUser()).execute();
    }

    private static class CLIUser implements AnalyzeRinexFileUseCase.User {
        public void error(String error) {
            System.err.println(error);
        }

        public void info(String info) {
            System.out.println(info);
        }
    }
}
