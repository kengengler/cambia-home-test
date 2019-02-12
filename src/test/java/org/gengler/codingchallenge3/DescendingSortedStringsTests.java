package org.gengler.codingchallenge3;

import org.junit.Assert;
import org.junit.Test;

public class DescendingSortedStringsTests {
    @Test
    public void testHappyPath() {
        final String[] test1Strings = { "a", "c", "b", "d" };
        final DescendingSortedStrings dss = new DescendingSortedStrings(test1Strings);
        final String[] invSortedStrings = dss.asArray();
        Assert.assertEquals(
            "Sorted string array is not the same size as input",
            test1Strings.length,
            invSortedStrings.length);
        Assert.assertArrayEquals(
            "Sorted array is not what  is expected",
            new String[] { "d", "c", "b", "a" },
            invSortedStrings);
    }

    @Test
    public void testEmpty() {
        final String[] emptyStrings = { };
        final DescendingSortedStrings dss = new DescendingSortedStrings(emptyStrings);
        final String[] invSortedStrings = dss.asArray();
        Assert.assertEquals(
            "Empty string array input did not result in an empty array result",
            0,
            invSortedStrings.length);
    }

    @Test
    public void testEmptyStringRemoval() {
        final String[] arrayWithEmptyStrings = { "Chicago", "", "New York", "   ", "London" };
        final DescendingSortedStrings dss = new DescendingSortedStrings(arrayWithEmptyStrings);
        final String[] invSortedStrings = dss.asArray();
        Assert.assertEquals(
            "Sorted string array is not of the expected size with empties removed",
            3,
            invSortedStrings.length);
        Assert.assertArrayEquals(
            "Sorted array is not what  is expected",
            new String[] { "New York", "London", "Chicago" },
            invSortedStrings);
    }
}
