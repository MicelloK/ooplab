package agh.ics.oop;

public interface IMapElement {
    boolean isAt(Vector2d position);
    Vector2d getPosition();

    public String getImage();
}
