package software.aoc.day04.b;

import software.aoc.day04.Runner04Factory;

public class Main04B {
    static void main() {
        long result = new Runner04Factory()
                .from(Main04B.class.getClassLoader().getResourceAsStream("Day04Input.txt"))
                .type(Runner04Factory.Runner04Type.B)
                .runner()
                .run();
        System.out.println(result);
    }
}
