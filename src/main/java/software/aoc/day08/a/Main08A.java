package software.aoc.day08.a;

public class Main08A {
    static void main() {
        long result = Runner08A.with(Main08A.class.getClassLoader().getResourceAsStream("Day08Input.txt"))
                .run(1000);
        System.out.println(result);
    }
}
