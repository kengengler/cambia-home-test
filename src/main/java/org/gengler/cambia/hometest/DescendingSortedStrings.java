package org.gengler.cambia.hometest;


import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Puts a very simple class wrapper around a stream that both sorts the string array and removes blank strings.
 */
public class DescendingSortedStrings {
    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    final String[] stringArray;

    public DescendingSortedStrings(final String[] in) {
        stringArray = in;
    }

    public String[] asArray() {
        return Arrays
            .stream(stringArray)
            .filter(StringUtils::isNotBlank)
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList())
            .toArray(EMPTY_STRING_ARRAY);
    }
}
