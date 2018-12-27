package org.gengler.cambia.hometest;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Puts a very simple class wrapper around the behavior provided by Arrays::parallelSort. This class wrapper allows
 * the Arrays::parallelSort to be used in a stream which isn't possible directly since the method doesn't return
 * anything.
 */
public class DescendingSortedStrings {
    final String[] stringArray;

    public DescendingSortedStrings(final String[] in) {
        stringArray = in;
        Arrays.parallelSort(stringArray, Comparator.reverseOrder());
    }

    public String[] asArray() {
        return stringArray;
    }
}
