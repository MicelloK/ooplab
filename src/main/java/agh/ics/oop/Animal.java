package agh.ics.oop;

public class Animal {
    //fields
    private MapDirection animalDirection;
    private Vector2d animalPosition;
    private static final Vector2d upperRightCorner = new Vector2d(4, 4);
    private static final Vector2d lowerLeftCorner = new Vector2d(0, 0);

    //methods
    public Animal() {
        this.animalDirection = MapDirection.NORTH;
        this.animalPosition = new Vector2d(2, 2);
    }

    public String toString() {
        return "Position: " + animalPosition.toString() + "\nDirection: " + animalDirection.toString();
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
        if (newPosition.precedes(upperRightCorner) && newPosition.follows(lowerLeftCorner)) {
            animalPosition = newPosition;
        }
    }


}
