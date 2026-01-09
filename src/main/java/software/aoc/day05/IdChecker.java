package software.aoc.day05;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public record IdChecker(List<IdRange> ranges) {
    public IdChecker() {
        this(List.of());
    }

    public IdChecker add(String str) {
        return addAndTryCombine(new IdRange(str));
    }

    public boolean contains(long id) {
        return ranges.stream().anyMatch(range -> range.contains(id));
    }

    private IdChecker addAndTryCombine(IdRange newRange) {
        ArrayList<IdRange> newRanges = new ArrayList<>();
        ListIterator<IdRange> iterator = this.ranges.listIterator();

        newRange = tryCombineInto(newRange, iterator, newRanges);

        newRanges.add(newRange);
        iterator.forEachRemaining(newRanges::add);

        return new IdChecker(List.copyOf(newRanges));
    }

    private static IdRange tryCombineInto(IdRange newRange, ListIterator<IdRange> iterator, ArrayList<IdRange> newRanges) {
        while (iterator.hasNext()) {
            IdRange current = iterator.next();
            if (newRange.isSmallerThan(current)) {
                if (iterator.hasPrevious()) iterator.previous();
                break;
            }
            if (newRange.overlapsWith(current)) {
                newRange = newRange.combineWith(current);
                continue;
            }
            newRanges.add(current);
        }
        return newRange;
    }
}
