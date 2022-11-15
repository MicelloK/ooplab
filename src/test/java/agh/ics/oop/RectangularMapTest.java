package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void canMoveTo() {
        RectangularMap map = new RectangularMap(3, 3);
        map.place(new Animal(map, new Vector2d(2, 2)));

        assertTrue(map.canMoveTo(new Vector2d(1, 1)));
        assertFalse(map.canMoveTo(new Vector2d(2, 2)));
        assertFalse(map.canMoveTo(new Vector2d(4, 2)));
        assertFalse(map.canMoveTo(new Vector2d(1, -1)));
    }

    @Test
    void place() {
        RectangularMap map = new RectangularMap(3, 3);

        assertTrue(map.place(new Animal(map, new Vector2d(2, 2))));
        assertTrue(map.objectAt(new Vector2d(2, 2)) instanceof Animal);
        assertFalse(map.place(new Animal(map, new Vector2d(2, 2))));
        assertFalse(map.place(new Animal(map, new Vector2d(100, -5))));
    }

    @Test
    void isOccupied() {
        RectangularMap map = new RectangularMap(10, 10);

        assertFalse(map.isOccupied(new Vector2d(100, 100)));
        map.place(new Animal(map, new Vector2d(1, 1)));
        assertTrue(map.isOccupied(new Vector2d(1, 1)));
    }

    @Test
    void objectAt() {
        RectangularMap map = new RectangularMap(10, 10);

        assertNull(map.objectAt(new Vector2d(1, 1)));
        assertNull(map.objectAt(new Vector2d(100, 1100)));
        for (IMapElement element : map.elements) {
            assertEquals(element, map.objectAt(element.getPosition()));
        }
    }
}