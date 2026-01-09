package software.aoc.day04;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record Wall(List<List<Space>> grid) {
    public Space spaceAt(Position position) {
        return grid.get(position.row()+1).get(position.col()+1);
    }

    public static Wall from(List<String> wallData) {
        int rowSize = wallData.getFirst().length();
        return new Wall(addSpacerRowsTo(wallData.stream(), rowSize)
                .map(Wall::addRowSpacing)
                .map(Wall::spaceListFrom).toList());
    }

    public Stream<Stream<Position>> positionRowStream() {
        return IntStream.range(0, grid.size()-2)
                .mapToObj(row -> IntStream.range(0, colAmount())
                        .mapToObj(col -> new Position(row, col)));
    }

    public Stream<Position> getPositions() {
        return positionRowStream().flatMap(s -> s);
    }

    private int colAmount() {
        return grid.getFirst().size()-2;
    }

    private static List<Space> spaceListFrom(String s) {
        return s.chars().mapToObj(c -> (char)c).map(Space::from).toList();
    }

    private static Stream<String> addSpacerRowsTo(Stream<String> wallData, int rowSize) {
        return getConcat(wallData, emptyRowOf(rowSize));
    }

    private static Stream<String> getConcat(Stream<String> wallData, String row) {
        return Stream.concat(Stream.of(row), Stream.concat(wallData, Stream.of(row)));
    }

    private static String emptyRowOf(int rowSize) {
        return new StringBuilder().repeat('.', rowSize).toString();
    }

    private static String addRowSpacing(String row) {
        return ".".concat(row.concat("."));
    }
}
