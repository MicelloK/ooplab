package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal implements IMapElement {
    //fields
    private MapDirection animalDirection;
    private Vector2d animalPosition;
    private IWorldMap map;
    private final List<IPositionChangeObserver> observerList = new ArrayList<>();

    public Animal(IWorldMap map) {
        this.animalDirection = MapDirection.NORTH;
        this.animalPosition = new Vector2d(2, 2);
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.animalDirection = MapDirection.NORTH;
        this.animalPosition = initialPosition;
        this.map = map;
    }

    public String toString() {
        return animalDirection.toString();
    }

    public void addObserver(IPositionChangeObserver observer) {
        observerList.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        observerList.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : observerList) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    public MapDirection getDirection() {
        return animalDirection;
    }

    @Override
    public Vector2d getPosition() {
        return animalPosition;
    }

    public boolean isAt(Vector2d position) {
        return animalPosition.equals(position);
    }

    public void move(MoveDirection direction) {
        Vector2d newPosition = animalPosition;

        switch (direction) {
            case RIGHT -> animalDirection = animalDirection.next();
            case LEFT -> animalDirection = animalDirection.previous();
            case FORWARD -> newPosition = animalPosition.add(animalDirection.toUnitVector());
            case BACKWARD -> newPosition = animalPosition.subtract(animalDirection.toUnitVector());
        }
        if (map.canMoveTo(newPosition)) {
            Vector2d oldPosition = animalPosition;
            animalPosition = newPosition;
            positionChanged(oldPosition, newPosition);
        }
    }
}
