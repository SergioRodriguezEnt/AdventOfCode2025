package software.aoc.day01.b;


import software.aoc.Runner;

public class Main01B {
    static void main() {
        Runner<Integer> runner = new Runner01B();
        System.out.println(runner.runFrom(Main01B.class.getClassLoader().getResourceAsStream("Day01Input.txt")));
    }
}
