package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected final Map<Vector2d, IMapElement> animals = new HashMap<>();

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement element = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition, element);
    }

    public abstract Vector2d[] getEnds();

    public Map<Vector2d, IMapElement> getAnimals() {
        return animals;
    }

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
        Vector2d position = animal.getPosition();
        if (canMoveTo(position)) {
            animals.put(position, animal);
            animal.addObserver(this);
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
