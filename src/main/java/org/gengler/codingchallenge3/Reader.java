package org.gengler.codingchallenge3;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * A simple wrapper class around the CSVReader that allows the the lines read/parsed by
 * CSVReader to be returned as a stream. Its a very simple way to create a stream that,
 * were the input file large, would likely use too much memory. It would need to be re-written
 * to provide a stream implementation that reads each line incrementally.
 *
 * The class is auto-closeable for use with the newer try/catch mechanism.
 */
public class Reader implements AutoCloseable {
    private static final String DEFAULT_INPUT_FILENAME = "input.csv";

    private CSVReader csvReader;

    public Reader() {
        this(DEFAULT_INPUT_FILENAME);
    }

    public Reader(final String fileName) {
        if (! (new File(fileName)).exists())
            throw new RuntimeException("Input file does not exist: " + fileName);

        try {
            csvReader = new CSVReader(new BufferedReader(new FileReader(fileName)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Stream<String[]> stream() {
        try {
            return csvReader.readAll().stream();
        } catch (IOException e) {
            e.printStackTrace();
            return Stream.empty();
        }
    }

    @Override
    public void close() {
        try {
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
