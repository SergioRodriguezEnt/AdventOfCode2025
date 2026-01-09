package software.aoc.day03;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public record Runner03(Stream<Bank> banks, int maxBatteriesActivePerBank) {
    public Runner03(InputStream file, int maxBatteriesActivePerBank) {
        this(banksFrom(file), maxBatteriesActivePerBank);
    }

    public long run() {
        return banks.mapToLong(this::bestDigitsFrom).sum();
    }

    private static Stream<Bank> banksFrom(InputStream file) {
        try (InputStreamReader reader = new InputStreamReader(file)) {
            return reader.readAllLines().stream().map(Bank::new);
        } catch (IOException exception) {
            System.err.println("Error while reading from file: " + exception.getMessage());
            throw new RuntimeException(exception);
        }
    }

    private long bestDigitsFrom(Bank bank) {
        return bank.batteryStream()
                .boxed()
                .reduce(new DigitSequenceSelector(maxBatteriesActivePerBank),
                        DigitSequenceSelector::continueWith,
                        (_, selector) -> selector)
                .number();
    }
}