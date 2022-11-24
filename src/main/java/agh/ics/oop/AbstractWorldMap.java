package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

abstract public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected final Map<Vector2d, IMapElement> animals = new HashMap<>();
    protected final MapBoundary boundary = new MapBoundary();

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement element = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition, element);
        boundary.positionChanged(oldPosition, newPosition);
    }

    public Map<Vector2d, IMapElement> getAnimals() {
        return animals;
    }

    public Vector2d[] getSize() {
        return boundary.getEnds();
    }

    public String toString() {
        Vector2d[] ends = getSize();
        return new MapVisualiser(this).draw(ends[0], ends[1]);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
        if (canMoveTo(position)) {
            animals.put(position, animal);
            boundary.addElement(position);
            return true;
        }
        throw new IllegalArgumentException(position + " is occupied");
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }
}
