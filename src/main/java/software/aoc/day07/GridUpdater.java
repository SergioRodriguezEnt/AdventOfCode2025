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
                        (updater, _) -> updater.update(),
                        (_, b) -> b
                );
    }

    private GridUpdater update() {
        ArrayList<Cell> updatedLayer = new ArrayList<>();

        int counter = updateAndCountSplits(grid.get(currentLayer), grid.get(currentLayer - 1), updatedLayer);

        List<List<Cell>> newGrid = new ArrayList<>(grid);
        newGrid.set(currentLayer, updatedLayer);

        return new GridUpdater(newGrid, count+counter, currentLayer+1);
    }

    private static int updateAndCountSplits(List<Cell> layer, List<Cell> previousLayer, ArrayList<Cell> updatedLayer) {
        return (int) IntStream.range(0, layer.size())
                .filter(i -> updateAndCheckIfSplits(updatedLayer, previousLayer.get(i), i, layer.get(i)))
                .count();
    }

    private static boolean updateAndCheckIfSplits(ArrayList<Cell> updatedLayer, Cell previous, int i, Cell current) {
        if (!previous.isBeam()) {
            addOrReplace(updatedLayer, i, current);
            return false;
        }

        if (!current.isSplitter()) {
            addBeamPath(updatedLayer, i, previous.paths());
            return false;
        }

        addBeamPath(updatedLayer, i -1, previous.paths());
        updatedLayer.add(Cell.splitter());
        addBeamPath(updatedLayer, i +1, previous.paths());
        return true;
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