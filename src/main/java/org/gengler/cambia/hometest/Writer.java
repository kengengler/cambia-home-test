package org.gengler.cambia.hometest;

import com.opencsv.CSVWriter;
import org.apache.commons.io.output.TeeOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * A wrapper around CSVWriter that takes a string array and writes out a CSV file. I've "tee-d" the
 * output so that the CSV is written both to output.csv and to standard output. This is simply so that
 * its easier for me to review the result - especially when in a docker container.
 *
 * The class is auto-closeable for use with the newer try/catch mechanism.
 */
public class Writer implements AutoCloseable {
    private static final String DEFAULT_OUTPUT_FILENAME = "output.csv";

    protected CSVWriter csvWriter;

    public Writer() {
        this(DEFAULT_OUTPUT_FILENAME);
    }

    public Writer(final String outputFileName) {
        try {
            final TeeOutputStream teedOutputStream = new TeeOutputStream(
                System.out,
                new FileOutputStream(outputFileName));
            csvWriter = new CSVWriter(new OutputStreamWriter(teedOutputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(final DescendingSortedStrings line) {
        csvWriter.writeNext(line.asArray());
    }

    @Override
    public void close() {
        try {
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
