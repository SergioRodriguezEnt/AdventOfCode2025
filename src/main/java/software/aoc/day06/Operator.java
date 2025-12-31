package software.aoc.day06;

import java.util.function.BinaryOperator;

public enum Operator implements BinaryOperator<Long> {
    ADD, MULTIPLY;
    public static boolean isOperator(char c) {
        return c == '+' || c == '*';
    }

    public static Operator from(String str) {
        return str.strip().equals("+") ? ADD : MULTIPLY;
    }

    public long identity() {
        return this.equals(ADD) ? 0 : 1;
    }

    @Override
    public Long apply(Long long1, Long long2) {
        return this.equals(ADD) ? long1 + long2 : long1 * long2;
    }
}
