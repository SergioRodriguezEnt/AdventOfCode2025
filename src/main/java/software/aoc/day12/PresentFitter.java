package software.aoc.day12;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record PresentFitter(Map<Integer, List<Present>> presents) {
    public static PresentFitter from(List<Present> presents) {
        Map<Integer, List<Present>> allPresents = new HashMap<>();
        for (int i = 0; i < presents.size(); i++) {
            List<Present> variations = new ArrayList<>();
            variations.add(presents.get(i));
            IntStream.range(0, 3).forEach(_ -> variations.add(variations.getLast().rotateLeft()));
            IntStream.range(0, 4).forEach(x -> variations.add(variations.get(x).flippedHorizontal()));
            allPresents.put(i, variations.stream().toList());
        }
        return new PresentFitter(Map.copyOf(allPresents));
    }

    public boolean canFit(Region region) {
        if (region.area() >= region.totalPresents() * 9) return true;
        if (region.area() < areaOfPresents(region.requiredPresents())) return false;
        return tryFitInRegion(region);
    }

    private boolean tryFitInRegion(Region region) {
        return presentCoordCombinations(region).anyMatch(coords -> canFitWith(coords, region));
    }

    private boolean canFitWith(List<Coordinate> coords, Region region) {
        return presentVariationCombinations(region).anyMatch(variation -> containsAllUnique(movePresentsTo(coords, region, variation)));
    }

    private Stream<List<Integer>> presentVariationCombinations(Region region) {
        return Combinator.combinations(IntStream.range(0, 8).boxed().toList(), region.totalPresents());
    }

    private List<Coordinate> movePresentsTo(List<Coordinate> coords, Region region, List<Integer> variations) {
        List<Present> presentList = presentStateFor(region, variations);
        return IntStream.range(0, coords.size())
                .mapToObj(i -> presentList.get(i).move(coords.get(i)))
                .map(Present::coordinates)
                .flatMap(Collection::stream)
                .toList();
    }

    private List<Present> presentStateFor(Region region, List<Integer> variations) {
        List<Integer> requiredPresentList = region.requiredPresentList();
        return IntStream.range(0, requiredPresentList.size())
                .mapToObj(i -> presents.get(requiredPresentList.get(i)).get(variations.get(i)))
                .toList();
    }

    private static boolean containsAllUnique(List<Coordinate> x) {
        return Set.copyOf(x).size() == x.size();
    }

    private Stream<List<Coordinate>> presentCoordCombinations(Region region) {
        return Combinator.combinations(region.coordinates(), region.totalPresents());
    }

    private int areaOfPresents(Map<Integer, Integer> requiredPresents) {
        return requiredPresents.keySet().stream()
                .mapToInt(i -> presents.get(i).getFirst().area() * requiredPresents.get(i))
                .sum();
    }
}
