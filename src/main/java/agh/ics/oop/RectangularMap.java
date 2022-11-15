package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private final Vector2d lowerLeftCorner;
    private final Vector2d upperRightCorner;
    private final List<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height) {
        this.lowerLeftCorner = new Vector2d(0,0);
        this.upperRightCorner = new Vector2d(width,height);
    }

    public String toString() {
        return new MapVisualiser(this).draw(lowerLeftCorner, upperRightCorner);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(upperRightCorner) && position.follows(lowerLeftCorner) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (!isOccupied(animal.getPosition())) {
            animals.add(animal);
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
        for (Animal animal : animals) {
            if (animal.isAt(position)) return animal;
        }
        return null;
    }


}
