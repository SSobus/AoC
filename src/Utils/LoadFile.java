package Utils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
            if (scanner.hasNextInt()) {
                integers.add(scanner.nextInt());
            } else {
                scanner.next();
            }
        }

        return integers;
    }
}
