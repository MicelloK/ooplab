package agh.ics.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.Math;

public class GrassField extends AbstractWorldMap {

    public GrassField(int numOfGrasses) {
        List<Integer> positions_x = new ArrayList<>();
        List<Integer> positions_y = new ArrayList<>();
        for (int i = 0; i <= Math.sqrt(10 * numOfGrasses); i++) {
            positions_x.add(i);
            positions_y.add(i);
        }
        Collections.shuffle(positions_x);
        Collections.shuffle(positions_y);

        for (int i = 0; i < numOfGrasses; i++) {
            elements.add(new Grass(new Vector2d(positions_x.get(i), positions_y.get(i))));
        }
    }

    public Vector2d[] getEnds() {
        Vector2d upperRightCorner = new Vector2d(0, 0);
        Vector2d lowerLeftCorner = new Vector2d(0, 0);

        for (IMapElement element : elements) {
            upperRightCorner = element.getPosition().upperRight(upperRightCorner);
            lowerLeftCorner = element.getPosition().lowerLeft(lowerLeftCorner);
        }

        Vector2d[] ends = new Vector2d[2];
        ends[0] = lowerLeftCorner;
        ends[1] = upperRightCorner;
        return ends;
    }

    @Override
    public Object objectAt(Vector2d position) {
        IMapElement result = null;
        for (IMapElement element : elements) {
            if (element.isAt(position) && element instanceof Animal) return element;
            else if (element.isAt(position)) result = element; //display order
        }
        return result;
    }
}
