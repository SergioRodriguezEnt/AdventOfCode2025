package software.aoc.day03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public record DigitSequenceSelector(List<Integer> digits, List<Map.Entry<Integer, Integer>> reservedDigits, int maxDigits) {
    public DigitSequenceSelector(int maxBatteriesActivePerBank) {
        this(new ArrayList<>(), new ArrayList<>(), maxBatteriesActivePerBank);
    }

    public DigitSequenceSelector continueWith(int newDigit) {
        if (digits.isEmpty()) {
            digits.add(newDigit);
            return this;
        }

        tryToAdd(newDigit);

        if (digits.size() < maxDigits) {
            digits.add(newDigit);
        }

        return this;
    }

    private void tryToAdd(int newDigit) {
        IntStream.iterate(digits.size()-1, i -> i >= 0, i -> i - 1)
                .sequential()
                .filter(i->digits.get(i) < newDigit)
                .forEach( i -> {
                    reservedDigits.add(Map.entry(i, digits.get(i)));
                    digits.remove(i);
                });
    }

    public long number() {
        rebuildNumber();
        return IntStream.iterate(digits.size() - 1, i -> i >= 0, i -> i - 1)
                .mapToLong(i -> (long) digits.get(i) * Math.powExact(10L, digits.size() - i - 1))
                .sum();
    }

    private void rebuildNumber() {
        while (digits.size() < maxDigits) {
            Map.Entry<Integer, Integer> pair = reservedDigits.removeLast();
            digits.add(pair.getKey(), pair.getValue());
        }
    }
}
