package AoC2020.Day2;

import Utils.LoadFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PasswordPhilosophy {

    public static void runDay() throws IOException {
        System.out.println("2020 - Day 2 *********************");
        List<String> strings = LoadFile.LoadStrings("src/AoC2020/Day2/passwords.txt");

        List<PasswordInformation> passwords = parsePasswords(strings);

        Part1(passwords);//Part 1
        Part2(passwords);//Part 2
    }

    /**
     * Part 1 - Password must contain the letter between the min and max
     *
     * @param passwords list of PasswordInformation to search for valid passwords
     */
    private static void Part1(List<PasswordInformation> passwords) {
        System.out.println("Part 1:");
        long start = System.nanoTime();

        int validCount = 0;
        for (PasswordInformation password : passwords) {
            long count = password.getPassword().chars().filter(ch -> ch == password.getCharacter()).count();
            if (password.getMin() <= count && password.getMax() >= count) {
                validCount++;
            }
        }

        System.out.println("Valid Count: " + validCount);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    /**
     * 1-3 a: abcde is valid: position 1 contains a and position 3 does not.
     * 1-3 b: cdefg is invalid: neither position 1 nor position 3 contains b.
     * 2-9 c: ccccccccc is invalid: both position 2 and position 9 contain c.
     *
     * @param passwords list of PasswordInformation to search for valid passwords
     */
    private static void Part2(List<PasswordInformation> passwords) {
        System.out.println("Part 2:");
        long start = System.nanoTime();

        int validCount = 0;

        for (PasswordInformation password : passwords) {
            if (password.getPassword().charAt(password.getMin() - 1) == password.getCharacter() ^ password.getPassword().charAt(password.getMax() - 1) == password.getCharacter()) {
                validCount++;
            }
        }

        System.out.println("Valid Count: " + validCount);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    private static List<PasswordInformation> parsePasswords(List<String> passwords) {
        List<PasswordInformation> info = new ArrayList<>();
        for (String password : passwords) {
            PasswordInformation pi = new PasswordInformation(
                    Integer.parseInt(password.substring(0, password.indexOf("-"))),
                    Integer.parseInt(password.substring(password.indexOf("-") + 1, password.indexOf(" "))),
                    password.substring(password.indexOf(":") - 1, password.indexOf(":")).charAt(0),
                    password.substring(password.indexOf(":") + 2)
            );
            info.add(pi);
        }

        return info;
    }
}
