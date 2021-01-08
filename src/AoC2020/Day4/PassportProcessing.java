package AoC2020.Day4;

import Utils.LoadFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PassportProcessing {
    public static void runDay() throws IOException {
        System.out.println("2020 - Day 4 *********************");
        List<String> words = LoadFile.LoadWords("src/AoC2020/Day4/passports.txt", " ");

        List<PassportInformation> info = createPassports(words);

        Part1(info);//Part 1
        Part2();//Part 2
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

    public static void Part2() {
        System.out.println("Part 2:");
        long start = System.nanoTime();

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    //TODO: Refactor, Make this better, maybe a tool can help
    private static List<PassportInformation> createPassports(List<String> passports) {
        List<PassportInformation> passportInformations = new ArrayList<>();

        PassportInformation pi = new PassportInformation();
        for (String line : passports) {

            String key = "";
            String value = "";
            Integer intValue = null;

            if (line.length() > 0) {
                key = line.substring(0, line.indexOf(":"));
                value = line.substring(line.indexOf(":") + 1);

                try {
                    value = value.replace("cm", "");
                    value = value.replace("in", "");
                    intValue = Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    intValue = null;
                }

            }

            switch (key) {
                case "byr":
                    pi.setBirthYear(intValue);
                    break;
                case "iyr":
                    pi.setIssueYear(intValue);
                    break;
                case "eyr":
                    pi.setExpirationYear(Integer.parseInt(value));
                    break;
                case "hgt":
                    value = value.replace("cm", "");
                    value = value.replace("in", "");
                    pi.setHeight(Integer.parseInt(value));
                    break;
                case "hcl":
                    pi.setHairColor(value);
                    break;
                case "ecl":
                    pi.setEyeColor(value);
                    break;
                case "pid":
                    pi.setPassportId(value);
                    break;
                case "cid":
                    pi.setCountryId(intValue);
                    break;
                default: {
                    passportInformations.add(pi);
                    pi = new PassportInformation();

                    break;
                }

            }
        }
        passportInformations.add(pi);
        return passportInformations;
    }

}
