import AoC2020.Day1.ReportRepair;
import AoC2020.Day2.PasswordPhilosophy;
import AoC2020.Day3.TobogganTrajectory;
import AoC2020.Day4.PassportProcessing;
import AoC2020.Day5.BinaryBoarding;

import java.io.IOException;

public class Main {

    public static void main(String [ ] args) throws IOException {
        long start = System.nanoTime();

        ReportRepair.runDay(); //2020 - Day 1
        PasswordPhilosophy.runDay(); //2020 - Day 2
        TobogganTrajectory.runDay(); //2020 - Day 3
        PassportProcessing.runDay(); //2020 - Day 4
        BinaryBoarding.runDay(); //2020 - Day 5

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }
}
