package AoC2020.Day04;

import Utils.LoadFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PassportProcessing {
    public static void runDay() throws IOException {
        System.out.println("2020 - Day 4 *********************");
        List<String> words = LoadFile.LoadWords("src/main/java/AoC2020/Day04/passports.txt", " ");

        List<PassportInformation> info = createPassports(words);

        Part1(info);//Part 1
        Part2(info);//Part 2
    }

    public static void Part1(List<PassportInformation> passports) {
        System.out.println("Part 1:");
        long start = System.nanoTime();

        int validCount = 0;

        for (PassportInformation pi : passports) {
            if (pi.isValid()) {
                validCount++;
            }
        }

        System.out.println("Valid Passports: " + validCount);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    public static void Part2(List<PassportInformation> passports) {
        System.out.println("Part 2:");
        long start = System.nanoTime();

        int validCount = 0;

        for (PassportInformation pi : passports) {
            if (pi.isValid() && pi.isValidContent()) {
                validCount++;
            }
        }

        System.out.println("Valid Passports: " + validCount);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    private static List<PassportInformation> createPassports(List<String> passports) {
        List<PassportInformation> passportInformations = new ArrayList<>();

        PassportInformation pi = new PassportInformation();
        for (String line : passports) {

            String key = "";
            String value = "";

            if (line.length() > 0) {
                key = line.substring(0, line.indexOf(":"));
                value = line.substring(line.indexOf(":") + 1);
            }

            switch (key) {
                case "byr" -> pi.setBirthYear(value);
                case "iyr" -> pi.setIssueYear(value);
                case "eyr" -> pi.setExpirationYear(value);
                case "hgt" -> pi.setHeight(value);
                case "hcl" -> pi.setHairColor(value);
                case "ecl" -> pi.setEyeColor(value);
                case "pid" -> pi.setPassportId(value);
                case "cid" -> pi.setCountryId(value);
                default -> {
                    passportInformations.add(pi);
                    pi = new PassportInformation();
                }
            }
        }
        passportInformations.add(pi);
        return passportInformations;
    }

}
