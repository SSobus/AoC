package AoC2020.Day13;

import Utils.LoadFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShuttleSearch {

    public static void runDay() throws IOException {
        System.out.println("2020 - Day 12 *********************");
        List<String> busStrings = LoadFile.LoadStrings("src/main/java/AoC2020/Day13/buses.txt");

        Integer timestamp = Integer.parseInt(busStrings.get(0));
        List<Integer> buses = Arrays.stream(busStrings.get(1).split(",")).filter(bus -> !bus.equals("x")).map(Integer::valueOf).collect(Collectors.toList());

        Part1(timestamp, buses);//Part 1
        Part2(busStrings.get(1));//Part 2
    }

    public static void Part1(Integer timestamp, List<Integer> buses) {
        System.out.println("Part 1:");
        long start = System.nanoTime();

        int answer;
        int lowest = Integer.MAX_VALUE;
        int busNo = 0;

        for (Integer bus : buses) {
            int difference = Math.abs(bus - (timestamp % bus));

            if (difference < lowest) {
                lowest = difference;
                busNo = bus;
            }
        }

        answer = busNo * lowest;

        System.out.println("Answer: " + answer);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    public static void Part2(String busString) {
        System.out.println("Part 2:");
        long start = System.nanoTime();

        List<String> buses = Arrays.stream(busString.split(",")).collect(Collectors.toList());

        long answer;

        //Use Chinese Remainder Theorem https://www.youtube.com/watch?v=zIFehsBHB8o
        List<Bus> busList = new ArrayList<>();
        long N = 1;

        for (int i = 0; i < buses.size(); i++) {
            if (buses.get(i).equals("x")) {
                continue;
            }

            Bus bus = new Bus();
            bus.setModulo(Integer.parseInt(buses.get(i))); //modulo = bus number(timing)
            bus.setBi(bus.getModulo() - i);// gives you the Bi to put all buses on a common X
            busList.add(bus);

            //Help find N for later
            N *= bus.getModulo();
        }

        long sum = 0;
        for (Bus bus : busList) {
            int mod = bus.getModulo();

            //get Ni
            bus.setNi(N / mod); //Ni is all others except itself

            //find (NiXi === 1 (% modulo)
            // as Xi = 1 / (Ni % modulo),  (Xi = Inverse Ni)
            long inverse = bus.getNi() % mod;
            long factor = 1;
            while ((inverse * factor) % mod != 1) {
                factor++;
            }

            bus.setXi(factor);
            sum += bus.getBiNiXi();
        }

        answer = sum % N;

        System.out.println("Answer: " + answer);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }
}
