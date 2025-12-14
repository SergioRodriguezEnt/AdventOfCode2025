package software.aoc.day01;

import java.io.InputStream;
import java.util.function.ToIntBiFunction;

public class Runner01Builder {
    private InputStream file;
    private ToIntBiFunction<Lock, Order> counter;

    public Runner01Builder from(InputStream file) {
        this.file = file;
        return this;
    }

    public Runner01Builder use(ToIntBiFunction<Lock, Order> counter) {
        this.counter = counter;
        return this;
    }

    public Runner01 runner() {
        return new Runner01(file, counter);
    }
}
