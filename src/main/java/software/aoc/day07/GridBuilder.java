package software.aoc.day07;

import java.util.ArrayList;
import java.util.List;

public class GridBuilder {
    private final List<String> grid;

    public GridBuilder() {
        grid = new ArrayList<>();
    }

    public GridBuilder add(String str) {
        grid.add(str);
        return this;
    }

    public List<List<Cell>> build() {
        return grid.stream().map(Cell::parse).toList();
    }
}
