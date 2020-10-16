package com.regexfinder.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileUtil {

    public static List<String> readAllLinesFromFile(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }

    public static void writeFile(File file, String content) throws IOException {
        Files.write(file.toPath(), content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
    }

    public static void appendToFile(File file, String content) throws IOException {
        Files.write(file.toPath(), content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
    }
}
