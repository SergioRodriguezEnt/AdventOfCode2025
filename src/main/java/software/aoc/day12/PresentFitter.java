package software.aoc.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

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
        System.out.println(region);
        System.out.println(region.area());
        System.out.println(region.totalPresents());
        if (region.area() >= region.totalPresents() * 9) return true;

        System.out.println(areaOfPresents(region.requiredPresents()));
        if (region.area() < areaOfPresents(region.requiredPresents())) return false;

        System.out.println("Non trivial solution: ");

        return true;
    }

    private int areaOfPresents(Map<Integer, Integer> requiredPresents) {
        return requiredPresents.keySet().stream()
                .mapToInt(i -> presents.get(i).getFirst().area() * requiredPresents.get(i))
                .sum();
    }
}
