import AoC2020.Day01.ReportRepair;
import AoC2020.Day02.PasswordPhilosophy;
import AoC2020.Day03.TobogganTrajectory;
import AoC2020.Day04.PassportProcessing;
import AoC2020.Day05.BinaryBoarding;
import AoC2020.Day06.CustomCustoms;
import AoC2020.Day07.HandyHaversacks;
import AoC2020.Day08.HandheldHalting;
import AoC2020.Day09.EncodingError;
import AoC2020.Day10.AdapterArray;
import AoC2020.Day11.SeatingSystem;
import AoC2020.Day12.RainRisk;
import AoC2020.Day13.ShuttleSearch;
import AoC2020.Day14.DockingData;
import AoC2020.Day15.RambunctiousRecitation;
import AoC2021.Day01.SonarSweep;
import AoC2021.Day02.Dive;
import AoC2021.Day03.BinaryDiagnostic;
import AoC2022.Day01.Day01;
import AoC2022.Day02.Day02;
import AoC2022.Day03.Day03;
import AoC2022.Day04.Day04;

import java.io.IOException;

public class Main {

    public static void main(String [ ] args) throws IOException {
        run2022();
    }

    public static void run2020() throws IOException {
        long start = System.nanoTime();

        ReportRepair.runDay(); //2020 - Day 1
        PasswordPhilosophy.runDay(); //2020 - Day 2
        TobogganTrajectory.runDay(); //2020 - Day 3
        PassportProcessing.runDay(); //2020 - Day 4
        BinaryBoarding.runDay(); //2020 - Day 5
        CustomCustoms.runDay(); //2020 - Day 6
        HandyHaversacks.runDay(); //2020 - Day 7
        HandheldHalting.runDay(); //2020 - Day 8
        EncodingError.runDay(); //2020 - Day 9
        AdapterArray.runDay(); //2020 - Day 10
        SeatingSystem.runDay(); //2020 - Day 11
        RainRisk.runDay(); //2020 - Day 12
        ShuttleSearch.runDay(); //2020 - Day 13
        DockingData.runDay(); //2020 - Day 14
        RambunctiousRecitation.runDay(); //2020 - Day 15

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    public static void run2021() throws IOException {
        long start = System.nanoTime();

        SonarSweep.runDay(); //Day 1
        Dive.runDay(); // Day 2
        BinaryDiagnostic.runDay(); //Day 3

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    public static void run2022() throws IOException {
        long start = System.nanoTime();

        Day01.runDay(); //Day 1
        Day02.runDay(); //Day 2
        Day03.runDay(); //Day 3
        Day04.runDay(); //Day 4


        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }
}
