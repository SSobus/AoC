import AoC2020.Day01.ReportRepair;
import AoC2020.Day02.PasswordPhilosophy;
import AoC2020.Day03.TobogganTrajectory;
import AoC2020.Day04.PassportProcessing;
import AoC2020.Day05.BinaryBoarding;
import AoC2020.Day06.CustomCustoms;
import AoC2020.Day07.HandyHaversacks;

import java.io.IOException;

public class Main {

    public static void main(String [ ] args) throws IOException {
        long start = System.nanoTime();

        ReportRepair.runDay(); //2020 - Day 1
        PasswordPhilosophy.runDay(); //2020 - Day 2
        TobogganTrajectory.runDay(); //2020 - Day 3
        PassportProcessing.runDay(); //2020 - Day 4
        BinaryBoarding.runDay(); //2020 - Day 5
        CustomCustoms.runDay(); //2020 - Day 6
        HandyHaversacks.runDay(); //2020 - Day 7

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }
}
