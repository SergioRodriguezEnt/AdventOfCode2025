package software.aoc.day01;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.ToIntBiFunction;
import java.util.stream.Stream;

public record Runner01(Stream<Order> orders, ToIntBiFunction<Lock, Order> counterFn) {
    public Runner01(InputStream fileStream, ToIntBiFunction<Lock, Order> counterFn) {
        this(instructionsFrom(fileStream), counterFn);
    }

    private static Stream<Order> instructionsFrom(InputStream fileStream) {
        try (InputStreamReader isr = new InputStreamReader(fileStream)) {
            return isr.readAllLines().stream().map(Order::new);
        } catch (IOException e) {
            System.err.println("Error while reading from file: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public int run() {
        return orders
                .reduce(new Lock(new Dial(), 0, counterFn),
                        Lock::nextWith,
                        (_, b) -> b)
                .count();
    }
}