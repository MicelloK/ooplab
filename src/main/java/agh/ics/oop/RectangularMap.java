package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap {
    public RectangularMap(int width, int height) {
        boundary.setEnds(new Vector2d(0, 0), new Vector2d(width, height));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Vector2d[] ends = boundary.getEnds();
        return position.precedes(ends[1]) && position.follows(ends[0]) && !isOccupied(position);
    }
}
