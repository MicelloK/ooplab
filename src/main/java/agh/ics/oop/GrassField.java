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
            boundary.addElement(position);
        }
    }

    @Override
    public Object objectAt(Vector2d position) {
        IMapElement element = animals.get(position);
        if (element != null) return element;
        return grassList.get(position);
    }
}
