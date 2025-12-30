package software.aoc.day05;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.LongStream;

public record Runner05(IdChecker checker, LongStream ids) {
    public static Runner05 from(InputStream file) {
        try (InputStreamReader reader = new InputStreamReader(file)) {
            ListIterator<String> iterator = reader.readAllLines().listIterator();
            return new Runner05(checkerFrom(iterator), idsFrom(iterator));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static LongStream idsFrom(ListIterator<String> iterator) {
        List<Long> ids = new ArrayList<>();
        iterator.forEachRemaining(str -> ids.add(Long.parseLong(str)));
        return ids.stream().mapToLong(Long::longValue);
    }

    private static IdChecker checkerFrom(ListIterator<String> iterator) {
        IdChecker checker = new IdChecker();
        while (iterator.hasNext()) {
            String current = iterator.next();
            if (current.isEmpty()) {
                return checker;
            }
            checker = checker.add(current);
        }
        return checker;
    }

    public long filter_ingredients() {
        return ids.filter(checker::contains).count();
    }

    public long count_possible_ingredients() {
        return checker.ranges().stream().mapToLong(range -> range.max() + 1 - range.min()).sum();
    }
}
