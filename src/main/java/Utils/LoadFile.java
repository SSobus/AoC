package Utils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LoadFile {

    public static Path getPath(String source){
        return Paths.get(source);
    }

    public static List<Integer> LoadIntegers(String source) throws IOException {
        Path filePath = getPath(source);

        Scanner scanner = new Scanner(filePath);

        List<Integer> integers = new ArrayList<>();
        while (scanner.hasNext()) {
            if (scanner.hasNext("")) {
                integers.add(0);
            }
            if (scanner.hasNextInt()) {
                integers.add(scanner.nextInt());
            } else {
                scanner.next();
            }
        }

        return integers;
    }

    public static List<String> LoadStrings(String source) throws IOException {
        Path filePath = getPath(source);

        Scanner scanner = new Scanner(filePath);

        List<String> strings = new ArrayList<>();
        while (scanner.hasNext()) {
            if (scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            } else {
                scanner.next();
            }
        }

        return strings;
    }

    public static List<String> LoadWords(String source, String delimiter) throws IOException {
        Path filePath = getPath(source);

        Scanner scanner = new Scanner(filePath);

        List<String> strings = new ArrayList<>();
        while (scanner.hasNext()) {
            if (scanner.hasNextLine()) {
                strings.addAll(Arrays.asList(scanner.nextLine().split(delimiter)));
            } else {
                scanner.next();
            }
        }

        return strings;
    }

}
