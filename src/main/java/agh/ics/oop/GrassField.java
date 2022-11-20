package agh.ics.oop;

import java.util.*;
import java.lang.Math;

public class GrassField extends AbstractWorldMap {
    protected final Map<Vector2d, IMapElement> grassList = new HashMap<>();

    public GrassField(int numOfGrasses) {
        List<Vector2d> positions = new ArrayList<>();
        for (int i = 0; i <= Math.sqrt(10 * numOfGrasses); i++) {
            for (int j = 0; j <= Math.sqrt(10 * numOfGrasses); j++) {
                positions.add(new Vector2d(i, j));
            }
        }
        Collections.shuffle(positions);

        for (int i = 0; i < numOfGrasses; i++) {
            Vector2d position = positions.get(i);
            grassList.put(position, new Grass(position));
        }
    }

    public Vector2d[] getEnds() {
        Vector2d upperRightCorner = new Vector2d(0, 0);
        Vector2d lowerLeftCorner = new Vector2d(0, 0);

        for (Vector2d position : animals.keySet()) {
            upperRightCorner = position.upperRight(upperRightCorner);
            lowerLeftCorner = position.lowerLeft(lowerLeftCorner);
        }
        for (Vector2d position : grassList.keySet()) {
            upperRightCorner = position.upperRight(upperRightCorner);
            lowerLeftCorner = position.lowerLeft(lowerLeftCorner);
        }

        Vector2d[] ends = new Vector2d[2];
        ends[0] = lowerLeftCorner;
        ends[1] = upperRightCorner;
        return ends;
    }

    @Override
    public Object objectAt(Vector2d position) {
        IMapElement element = animals.get(position);
        if (element != null) return element;
        return grassList.get(position);
    }
}
