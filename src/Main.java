import AoC2020.Day1.ReportRepair;
import AoC2020.Day2.PasswordPhilosophy;
import AoC2020.Day3.TobogganTrajectory;
import AoC2020.Day4.PassportProcessing;

import java.io.IOException;

public class Main {

    public static void main(String [ ] args) throws IOException {
        long start = System.nanoTime();

        ReportRepair.runDay(); //2020 - Day 1
        PasswordPhilosophy.runDay(); //2020 - Day 2
        TobogganTrajectory.runDay(); //2020 - Day 3
        PassportProcessing.runDay(); //2020 - Day 4

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }
}
