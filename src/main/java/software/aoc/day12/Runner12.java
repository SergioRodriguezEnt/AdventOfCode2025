package software.aoc.day12;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public record Runner12(List<Present> presents, List<Region> regions) {
    public static Runner12 with(InputStream file) {
        try (InputStreamReader reader = new InputStreamReader(file)) {
            ListIterator<String> iterator = reader.readAllLines().listIterator();
            List<Present> presents = new ArrayList<>();
            List<Region> regions = new ArrayList<>();
            while(iterator.hasNext()) {
                String current = iterator.next();
                if (current.isEmpty()) continue;
                if (!current.contains("x")) {
                    presents.add(Present.from(List.of(current, iterator.next(), iterator.next(), iterator.next())));
                } else {
                    regions.add(Region.from(current));
                }
            }
            return new Runner12(presents, regions);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long run() {
        PresentFitter fitter = PresentFitter.from(presents);
        return regions.stream().filter(fitter::canFit).count();
    }
}
