package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    AbstractWorldMap testingMap = new RectangularMap(4, 4);

    @Test
    void creatingNewAnimal() {
        //given
        Animal animal1 = new Animal(testingMap);

        //when, then
        assertEquals(animal1.getDirection(), MapDirection.NORTH);
        assertEquals(animal1.getPosition(), new Vector2d(2, 2));
    }

    @Test
    void correctOrientation() {
        //given
        Animal animal1 = new Animal(testingMap);
        MoveDirection[] testMovements = new MoveDirection[]{
                MoveDirection.RIGHT,
                MoveDirection.RIGHT,
                MoveDirection.RIGHT,
                MoveDirection.RIGHT,
                MoveDirection.LEFT,
                MoveDirection.LEFT,
                MoveDirection.RIGHT
        };

        //when, then
        for (MoveDirection movement : testMovements) {
            MapDirection firstDirection = animal1.getDirection();
            animal1.move(movement);

            switch (movement) {
                case LEFT -> assertEquals(animal1.getDirection(), firstDirection.previous());
                case RIGHT -> assertEquals(animal1.getDirection(), firstDirection.next());
            }
        }
    }

    @Test
    void changeOfPosition() {
        //given
        Animal animal1 = new Animal(testingMap);

        //when, then
        // Dir: NORTH
        animal1.move(MoveDirection.FORWARD);
        assertTrue(animal1.isAt(new Vector2d(2, 3)));
        animal1.move(MoveDirection.BACKWARD);
        assertTrue(animal1.isAt(new Vector2d(2, 2)));

        // Dir: EAST
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.FORWARD);
        assertTrue(animal1.isAt(new Vector2d(3, 2)));
        animal1.move(MoveDirection.BACKWARD);
        assertTrue(animal1.isAt(new Vector2d(2, 2)));

        // Dir: SOUTH
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.FORWARD);
        assertTrue(animal1.isAt(new Vector2d(2, 1)));
        animal1.move(MoveDirection.BACKWARD);
        assertTrue(animal1.isAt(new Vector2d(2, 2)));

        // Dir: WEST
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.FORWARD);
        assertTrue(animal1.isAt(new Vector2d(1, 2)));
        animal1.move(MoveDirection.BACKWARD);
        assertTrue(animal1.isAt(new Vector2d(2, 2)));
    }

    @Test
    void mapEdgeControl() {
        //given
        Animal animal1 = new Animal(testingMap);
        Animal animal2 = new Animal(testingMap);
        Animal animal3 = new Animal(testingMap);
        Animal animal4 = new Animal(testingMap);

        //when
        for (int i = 0; i < 20; i++) animal1.move(MoveDirection.FORWARD);

        animal2.move(MoveDirection.RIGHT);
        for (int i = 0; i < 10; i++) animal2.move(MoveDirection.FORWARD);

        animal3.move(MoveDirection.RIGHT);
        animal3.move(MoveDirection.RIGHT);
        for (int i = 0; i < 10; i++) animal3.move(MoveDirection.FORWARD);

        animal4.move(MoveDirection.LEFT);
        for (int i = 0; i < 10; i++) animal4.move(MoveDirection.FORWARD);

        //then
        assertTrue(animal1.isAt(new Vector2d(2, 4)));
        assertTrue(animal2.isAt(new Vector2d(4, 2)));
        assertTrue(animal3.isAt(new Vector2d(2, 0)));
        assertTrue(animal4.isAt(new Vector2d(0, 2)));
    }
}
