package org.gengler.cambia.hometest;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(final String args[]) {
        new Main().direct();
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
