package software.aoc.day12;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Combinator {
    public static <T> Stream<List<T>> combinations(List<T> elementsToCombine, int amountPerCombination) {
        if (amountPerCombination < 0 || amountPerCombination > elementsToCombine.size()) return Stream.empty();

        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(
                        iteratorFor(elementsToCombine, amountPerCombination),
                        Spliterator.ORDERED
                ),
                false
        );
    }

    private static <T> Iterator<List<T>> iteratorFor(List<T> elementsToCombine, int amountPerCombination) {
        return new Iterator<>() {
            private final int[] indices = IntStream.range(0, amountPerCombination).toArray();
            private boolean hasNext = true;

            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public List<T> next() {
                if (!hasNext) {
                    throw new NoSuchElementException();
                }

                List<T> result = new ArrayList<>(amountPerCombination);
                for (int i : indices) {
                    result.add(elementsToCombine.get(i));
                }

                hasNext = advanceIndices(indices, elementsToCombine.size(), amountPerCombination);
                return result;
            }
        };
    }

    private static boolean advanceIndices(int[] indices, int elementsAmount, int elementsPerCombination) {
        for (int i = elementsPerCombination - 1; i >= 0; i--) {
            if (indices[i] < elementsAmount - elementsPerCombination + i) {
                indices[i]++;
                for (int j = i + 1; j < elementsPerCombination; j++) {
                    indices[j] = indices[j - 1] + 1;
                }
                return true;
            }
        }
        return false; // no more combinations
    }
}
