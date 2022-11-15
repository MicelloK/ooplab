package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {
    protected final List<IMapElement> elements = new ArrayList<>();

    public abstract Vector2d[] getEnds();

    public String toString() {
        Vector2d[] ends = getEnds();
        return new MapVisualiser(this).draw(ends[0], ends[1]);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            elements.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (IMapElement element : elements) {
            if (element.isAt(position)) return element;
        }
        return null;
    }
}
