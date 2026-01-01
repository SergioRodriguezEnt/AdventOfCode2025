package software.aoc.day08.b;

public class Main08B {
    static void main() {
        long result = Runner08B.with(Main08B.class.getClassLoader().getResourceAsStream("Day08Input.txt"))
                .run();
        System.out.println(result);
    }
}
