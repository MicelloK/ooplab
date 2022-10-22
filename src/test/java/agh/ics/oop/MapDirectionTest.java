package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class MapDirectionTest {
    @Test
    void testNext() {
        //given
        MapDirection dir1 = MapDirection.NORTH;
        MapDirection dir2 = MapDirection.EAST;
        MapDirection dir3 = MapDirection.SOUTH;
        MapDirection dir4 = MapDirection.WEST;

        //when
        MapDirection dir1NextResult = dir1.next();
        MapDirection dir2NextResult = dir2.next();
        MapDirection dir3NextResult = dir3.next();
        MapDirection dir4NextResult = dir4.next();

        //then
        Assertions.assertEquals(dir1NextResult, MapDirection.EAST);
        Assertions.assertEquals(dir2NextResult, MapDirection.SOUTH);
        Assertions.assertEquals(dir3NextResult, MapDirection.WEST);
        Assertions.assertEquals(dir4NextResult, MapDirection.NORTH);
    }

    @Test
    void testPrevious() {
        //given
        MapDirection dir1 = MapDirection.NORTH;
        MapDirection dir2 = MapDirection.EAST;
        MapDirection dir3 = MapDirection.SOUTH;
        MapDirection dir4 = MapDirection.WEST;

        //when
        MapDirection dir1PrevResult = dir1.previous();
        MapDirection dir2PrevResult = dir2.previous();
        MapDirection dir3PrevResult = dir3.previous();
        MapDirection dir4PrevResult = dir4.previous();

        //then
        Assertions.assertEquals(dir1PrevResult, MapDirection.WEST);
        Assertions.assertEquals(dir2PrevResult, MapDirection.NORTH);
        Assertions.assertEquals(dir3PrevResult, MapDirection.EAST);
        Assertions.assertEquals(dir4PrevResult, MapDirection.SOUTH);
    }
}
