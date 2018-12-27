package org.gengler.cambia.hometest;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Main entry point for the app. There's two methods:
 * * One (direct()) is a straight-foward procedural implementation
 * * The other (oofunctional()) is a more object-oriented / functional implementation that uses streams
 * The oofunctional() will be used from this point forward. The procedural remains for reference.
 */
public class Main {

    public static void main(final String args[]) {
        new Main().oofunctional();
    }

    protected void oofunctional() {
        try (
            final Reader reader = new Reader();
            final Writer writer = new Writer()) {
            reader
                .stream()
                .map(DescendingSortedStrings::new)
                .forEach(writer::write);
        }
    }

    protected void direct() {
        try (
            final CSVReader csvReader = new CSVReader(new FileReader("input.csv"));
            final CSVWriter csvWriter = new CSVWriter(new FileWriter("output.csv"));
        ) {
            for (String[] tokens = csvReader.readNext(); tokens != null; tokens = csvReader.readNext()) {
                Arrays.parallelSort(tokens, Comparator.reverseOrder());
                csvWriter.writeNext(tokens);
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
