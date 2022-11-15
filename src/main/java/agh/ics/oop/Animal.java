package agh.ics.oop;

public class Animal {
    //fields
    private MapDirection animalDirection;
    private Vector2d animalPosition;
    private IWorldMap map;

    public Animal() {
        this.animalDirection = MapDirection.NORTH;
        this.animalPosition = new Vector2d(2, 2);
    }

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

    public MapDirection getDirection() {
        return animalDirection;
    }

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
            animalPosition = newPosition;
        }
    }
}
