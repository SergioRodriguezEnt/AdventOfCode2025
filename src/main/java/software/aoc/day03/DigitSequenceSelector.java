package software.aoc.day03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public record DigitSequenceSelector(List<Integer> digits, List<Map.Entry<Integer, Integer>> reservedDigits, int maxDigits) {
    public DigitSequenceSelector(int maxBatteriesActivePerBank) {
        this(new ArrayList<>(), new ArrayList<>(), maxBatteriesActivePerBank);
    }

    public DigitSequenceSelector continueWith(int newDigit) {
        if (digits.isEmpty()) {
            digits.add(newDigit);
            return this;
        }

        for (int i = digits.size() - 1; i >= 0; i--) {
            if (digits.get(i) < newDigit) {
                reservedDigits.add(Map.entry(i, digits.get(i)));
                digits.remove(i);
            }
        }
        if (digits.size() < maxDigits) {
            digits.add(newDigit);
        }

        return this;
    }

    public long number() {
        rebuildNumber();
        long number = 0;
        for (int i = digits.size() - 1; i >= 0; i--) {
            number += (long) digits.get(i) * Math.powExact(10L, digits.size() - i - 1);
        }
        return number;
    }

    private void rebuildNumber() {
        while (digits.size() < maxDigits) {
            Map.Entry<Integer, Integer> pair = reservedDigits.removeLast();
            digits.add(pair.getKey(), pair.getValue());
        }
    }
}
