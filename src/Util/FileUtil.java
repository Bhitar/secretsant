package Util;

import java.io.File;

public class FileUtil {

    public static boolean fileExists(String path) {
        File file = new File(path);
        return file.exists() && file.isFile();
    }

    public static void ensureFileExists(String path) throws IllegalArgumentException {
        if (!fileExists(path)) {
            throw new IllegalArgumentException("File not found at path: " + path);
        }
    }

    public static boolean isCsvFile(String path) {
        return path != null && path.toLowerCase().endsWith(".csv");
    }

    public static void validateCsvFile(String path) throws IllegalArgumentException {
        ensureFileExists(path);
        if (!isCsvFile(path)) {
            throw new IllegalArgumentException("File is not a CSV: " + path);
        }
    }
}
