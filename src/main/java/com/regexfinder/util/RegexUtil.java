package com.regexfinder.util;

import static com.regexfinder.util.Constants.EMPTY_STRING;
import static com.regexfinder.util.Constants.NEW_LINE;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

    public static void matchStringByRegex(String readFilePath, String writeFilePath, String regexPattern) throws IOException {
        List<String> lines = FileUtil.readAllLinesFromFile(readFilePath);
        List<String> results = new ArrayList<>();
        File file = new File(writeFilePath);
        FileUtil.writeFile(file, EMPTY_STRING);

        for (String line : lines) {
            Pattern pattern = Pattern.compile(regexPattern);
            Matcher matcher = pattern.matcher(line);

            if (matcher.matches()) {
                results.add(line);
                System.out.println(line);
            }
        }

        appendResultsToFile(file, results);
    }

    private static void appendResultsToFile(File file, List<String> results) throws IOException {
        for (String result : results) {
            FileUtil.appendToFile(file, result + NEW_LINE);
        }
    }
}
