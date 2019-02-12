package org.gengler.codingchallenge3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderTests {
    private static final String INPUT_FILE_NAME = "input.csv";
    @After
    public void cleanup() {
        final File inputCsv = new File(INPUT_FILE_NAME);
        if (inputCsv.exists())
            inputCsv.delete();
    }

    @Test
    public void testHappyPath() throws Exception {
        final String csvInputLine = "Chicago,New York,Portland,Seattle,Los Angeles";
        try (final FileWriter inputWriter = new FileWriter(INPUT_FILE_NAME)) {
            inputWriter.write(csvInputLine);
        }
        final Reader r = new Reader();
        final List<String[]> lines = r.stream().collect(Collectors.toList());
        Assert.assertEquals("Incorrect number of lines seen", 1, lines.size());
        Assert.assertArrayEquals(
            "Array input does not match file content",
            csvInputLine.split(","),
            lines.get(0));
    }
}
