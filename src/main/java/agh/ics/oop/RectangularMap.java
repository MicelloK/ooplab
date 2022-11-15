package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private final Vector2d lowerLeftCorner;
    private final Vector2d upperRightCorner;

    public RectangularMap(int width, int height) {
        this.lowerLeftCorner = new Vector2d(0,0);
        this.upperRightCorner = new Vector2d(width,height);
    }

    public Vector2d[] getEnds() {
        Vector2d[] ends = new Vector2d[2];
        ends[0] = lowerLeftCorner;
        ends[1] = upperRightCorner;
        return ends;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(upperRightCorner) && position.follows(lowerLeftCorner) && !isOccupied(position);
    }
}
