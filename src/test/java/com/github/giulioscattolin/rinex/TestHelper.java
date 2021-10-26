package com.github.giulioscattolin.rinex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URI;
import java.net.URISyntaxException;

public class TestHelper {
    public static BufferedReader toBufferedReader(String path) throws FileNotFoundException, URISyntaxException {
        return new BufferedReader(new FileReader(new File(toURI(path))));
    }

    public static URI toURI(String path) throws URISyntaxException {
        return TestHelper.class.getResource(path).toURI();
    }
}
