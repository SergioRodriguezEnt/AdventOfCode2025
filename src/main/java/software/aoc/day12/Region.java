package software.aoc.day12;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public record Region(int width, int length, Map<Integer, Integer> requiredPresents) {
    public static Region from(String str) {
        List<String> data = Arrays.asList(str.split(": "));

        List<Integer> size = Arrays.stream(data.getFirst().split("x")).map(Integer::parseInt).toList();
        List<Integer> presents = Arrays.stream(data.getLast().split(" ")).map(Integer::parseInt).toList();

        return new Region(size.getFirst(),
                size.getLast(),
                IntStream.range(0, presents.size())
                        .filter(x -> presents.get(x) != 0)
                        .boxed()
                        .collect(Collectors.toMap(i -> i, presents::get)));
    }

    public int totalPresents() {
        return requiredPresents.values().stream().mapToInt(i -> i).sum();
    }

    public int area() {
        return width * length;
    }

    public List<Integer> requiredPresentList() {
        return requiredPresents.entrySet()
                .stream()
                .flatMap(e->IntStream.range(0, e.getValue()).mapToObj(_ -> e.getKey()))
                .toList();
    }

    public List<Coordinate> coordinates() {
        return IntStream.range(1, width-1)
                .mapToObj(x -> IntStream.range(1, length-1)
                        .mapToObj(y -> new Coordinate(x, y))
                )
                .flatMap(s->s)
                .toList();
    }
}
