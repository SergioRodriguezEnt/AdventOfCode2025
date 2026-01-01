package software.aoc.day07.b;

import software.aoc.day07.Runner07;

public class Main07B {
    static void main() {
        long result = Runner07.with(Main07B.class.getClassLoader().getResourceAsStream("Day07Input.txt"))
                .getPaths();
        System.out.println(result);
    }
}
