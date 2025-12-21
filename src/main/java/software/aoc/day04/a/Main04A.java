package software.aoc.day04.a;

import software.aoc.day04.Runner04Factory;

public class Main04A {
    static void main() {
        long result = new Runner04Factory()
                .from(Main04A.class.getClassLoader().getResourceAsStream("Day04Input.txt"))
                .type(Runner04Factory.Runner04Type.A)
                .runner()
                .run();
        System.out.println(result);
    }
}
