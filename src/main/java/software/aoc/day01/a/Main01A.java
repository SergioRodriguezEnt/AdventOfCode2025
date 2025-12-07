package software.aoc.day01.a;

public class Main01A {
    static void main() {
        Day01ARunner runner = new Day01ARunner();
        System.out.println(runner.runFrom(Main01A.class.getClassLoader().getResourceAsStream("Day01AInput.txt")));
    }
}