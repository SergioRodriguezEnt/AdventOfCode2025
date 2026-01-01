package software.aoc.day07;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public record GridUpdater(List<List<Cell>> grid, int count, int currentLayer) {
    public GridUpdater resolve() {
        return IntStream.range(currentLayer, grid.size())
                .boxed()
                .sequential()
                .reduce(
                        this,
                        (x, _) -> x.update(),
                        (_, b) -> b
                );
    }

    private GridUpdater update() {
        int counter = 0;
        List<Cell> layer = grid.get(currentLayer);
        List<Cell> previousLayer = grid.get(currentLayer - 1);
        ArrayList<Cell> updatedLayer = new ArrayList<>();

        for (int i = 0; i < layer.size(); i++) {
            Cell current = layer.get(i);
            Cell previous = previousLayer.get(i);

            if (!previous.isBeam()) {
                addOrReplace(updatedLayer, i, current);
                continue;
            }

            if (!current.isSplitter()) {
                addBeamPath(updatedLayer, i, previous.paths());
                continue;
            }

            addBeamPath(updatedLayer, i-1, previous.paths());
            updatedLayer.add(Cell.splitter());
            addBeamPath(updatedLayer, i+1, previous.paths());
            counter++;
        }

        List<List<Cell>> newGrid = new ArrayList<>(grid);
        newGrid.set(currentLayer, updatedLayer);
        return new GridUpdater(newGrid, count+counter, currentLayer+1);
    }

    private static void addOrReplace(List<Cell> layer, int index, Cell cell) {
        if (layer.size() <= index) layer.add(cell);
        else if (!layer.get(index).isBeam() || cell.isBeam()) layer.set(index, cell);
    }

    private static void addBeamPath(List<Cell> layer, int index, long previousPaths) {
        long currentPaths = 0;
        if (layer.size() > index) currentPaths = layer.get(index).paths();
        addOrReplace(layer, index, Cell.beam(currentPaths + previousPaths));
    }
}

// .  .  .    ^  ^  ^    1  1    .1.  .1.    111  111
// .  ^  1    .  ^  1    .  1    .^.  1^1    .^.  1^1

// .  ^  1    .  ^  1    1  2    1^1  2^2    2^2  3^3