package agh.ics.oop;

public class Grass implements IMapElement {
    private final Vector2d grassPosition;

    public Grass(Vector2d position) {
        grassPosition = position;
    }

    public String toString() {
        return "*";
    }

    public String getImage() {
        return "src/main/resources/grass.png";
    }

    @Override
    public boolean isAt(Vector2d position) {
        return grassPosition.equals(position);
    }

    @Override
    public Vector2d getPosition() {
        return grassPosition;
    }
}
