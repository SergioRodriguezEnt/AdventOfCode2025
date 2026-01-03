package software.aoc.day09;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record RectangleFinder(List<Coordinate> redTiles) {
    public Stream<Rectangle> rectangles() {
        return IntStream.range(0, redTiles.size() - 1)
                .mapToObj(i -> IntStream.range(i + 1, redTiles().size())
                        .mapToObj(j -> new Rectangle(redTiles.get(i), redTiles.get(j))))
                .flatMap(s -> s)
                .sorted(Comparator.comparingLong(Rectangle::area).reversed());
    }

    public Rectangle biggest() {
        return rectangles()
                .findFirst()
                .orElse(new Rectangle(new Coordinate(0, 0), new Coordinate(0, 0)));
    }

    public Rectangle biggestAllowed() {
        List<Rectangle> rectangles = rectangles().toList();
        List<Rectangle> edges = polygonEdges(rectangles.stream());
        return rectangles.stream()
                .filter(r -> isInsidePolygon(r, edges))
                .findFirst()
                .orElse(new Rectangle(new Coordinate(0, 0), new Coordinate(0, 0)));
    }

    private boolean isInsidePolygon(Rectangle r, List<Rectangle> edges) {
        return r.edges().allMatch(c -> checkProjection(c, edges));
    }

    private boolean checkProjection(Coordinate c, List<Rectangle> edges) {
        if(redTiles.contains(c)) return true;
        int projections = 0;
        Rectangle r = new Rectangle(c, new Coordinate(0, c.y()));

        for (Rectangle edge : edges) {
            if (edge.contains(c)) return true; //Doesnt work

            if (edge.overlaps(r)) projections++;
        }

        return projections%2 == 1;
    }

    private List<Rectangle> polygonEdges(Stream<Rectangle> rectangles) {
        return rectangles
                .filter(Rectangle::isLine)
                .filter(r->r.area()>2)
                .map(this::trim).toList();
    }

    private Rectangle trim(Rectangle r) {
        if (r.coord1().x() == r.coord2().x()) {
            if (r.coord1().y() < r.coord2().y()) {
                return new Rectangle(new Coordinate(r.coord1().x(), r.coord1().y()+1), new Coordinate(r.coord2().x(), r.coord2().y()-1));
            }
            return new Rectangle(new Coordinate(r.coord1().x(), r.coord1().y()-1), new Coordinate(r.coord2().x(), r.coord2().y()+1));
        }
        if (r.coord1().x() < r.coord2().x()) {
            return new Rectangle(new Coordinate(r.coord1().x()+1, r.coord1().y()), new Coordinate(r.coord2().x()-1, r.coord2().y()));
        }
        return new Rectangle(new Coordinate(r.coord1().x()-1, r.coord1().y()), new Coordinate(r.coord2().x()+1, r.coord2().y()));
    }
}
