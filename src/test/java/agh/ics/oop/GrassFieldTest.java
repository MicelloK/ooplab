package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void canMoveTo() {
        GrassField map = new GrassField(10);
        map.place(new Animal(map, new Vector2d(2, 2)));

        assertTrue(map.canMoveTo(new Vector2d(3, 2)));
        assertTrue(map.canMoveTo(new Vector2d(1, 2)));
        assertTrue(map.canMoveTo(new Vector2d(2, 1)));
        assertTrue(map.canMoveTo(new Vector2d(2, 3)));

        map.place(new Animal(map, new Vector2d(2, 3)));
        assertFalse(map.canMoveTo(new Vector2d(2, 3)));
    }

    @Test
    void place() {
        GrassField map = new GrassField(10);

        assertTrue(map.place(new Animal(map, new Vector2d(2, 2))));
        assertTrue(map.objectAt(new Vector2d(2, 2)) instanceof Animal);
        assertFalse(map.place(new Animal(map, new Vector2d(2, 2))));
        assertTrue(map.place(new Animal(map, new Vector2d(100, -5))));
    }

    @Test
    void isOccupied() {
        GrassField map = new GrassField(1);

        assertFalse(map.isOccupied(new Vector2d(100, 100)));
        map.place(new Animal(map, new Vector2d(100, 100)));
        assertTrue(map.isOccupied(new Vector2d(100, 100)));

        for (IMapElement element : map.elements) {
            assertTrue(map.isOccupied(element.getPosition()));
        }
    }

    @Test
    void objectAt() {
        GrassField map = new GrassField(10);

        assertNull(map.objectAt(new Vector2d(100, 1100)));
        for (IMapElement element : map.elements) {
            assertEquals(element, map.objectAt(element.getPosition()));
        }
    }
}