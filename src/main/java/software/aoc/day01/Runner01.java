package software.aoc.day01;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.ToIntBiFunction;
import java.util.stream.Stream;

public record Runner01(Stream<Order> orders, ToIntBiFunction<Lock, Order> counter) {
    public Runner01(InputStream file, ToIntBiFunction<Lock, Order> counter) {
        this(instructionsFrom(file), counter);
    }

    private static Stream<Order> instructionsFrom(InputStream file) {
        try (InputStreamReader reader = new InputStreamReader(file)) {
            return reader.readAllLines().stream().map(Order::new);
        } catch (IOException exception) {
            System.err.println("Error while reading from file: " + exception.getMessage());
            throw new RuntimeException(exception);
        }
    }

    public int run() {
        return orders
                .reduce(new Lock(new Dial(), 0, counter),
                        Lock::nextFrom,
                        (_, nextLock) -> nextLock)
                .count();
    }
}