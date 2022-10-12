package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {
        //given
        Vector2d v1 = new Vector2d(1, 0);
        Vector2d v2 = new Vector2d(1, -1);
        Vector2d v3 = new Vector2d(100, 10);
        Vector2d v4 = new Vector2d(-17, 23);
        Vector2d v5 = new Vector2d(67444, 165432);
        Vector2d v6 = new Vector2d(-6746444, -1654);

        //when
        String v1Result = v1.toString();
        String v2Result = v2.toString();
        String v3Result = v3.toString();
        String v4Result = v4.toString();
        String v5Result = v5.toString();
        String v6Result = v6.toString();

        //then
        assertEquals(v1Result, "(1,0)");
        assertEquals(v2Result, "(1,-1)");
        assertEquals(v3Result, "(100,10)");
        assertEquals(v4Result, "(-17,23)");
        assertEquals(v5Result, "(67444,165432)");
        assertEquals(v6Result, "(-6746444,-1654)");
    }

    @Test
    void precedes() {
        //given
        Vector2d v1 = new Vector2d(1, 0);
        Vector2d v2 = new Vector2d(1, -1);
        Vector2d v3 = new Vector2d(100, 10);
        Vector2d v4 = new Vector2d(1, 0);
        Vector2d v5 = new Vector2d(67444, 165432);
        Vector2d v6 = new Vector2d(-6746444, -1654);

        //when
        boolean v1v2Result = v1.precedes(v2);
        boolean v1v4Result = v1.precedes(v4);
        boolean v6v3Result = v6.precedes(v3);
        boolean v6v5Result = v6.precedes(v5);
        boolean v5v6Result = v5.precedes(v6);
        boolean v6v1Result = v6.precedes(v1);

        //then
        assertFalse(v1v2Result);
        assertTrue(v1v4Result);
        assertTrue(v6v3Result);
        assertTrue(v6v5Result);
        assertFalse(v5v6Result);
        assertTrue(v6v1Result);

    }

    @Test
    void follows() {
        //given
        Vector2d v1 = new Vector2d(1, 0);
        Vector2d v2 = new Vector2d(1, -1);
        Vector2d v3 = new Vector2d(100, 10);
        Vector2d v4 = new Vector2d(1, 0);
        Vector2d v5 = new Vector2d(67444, 165432);
        Vector2d v6 = new Vector2d(-6746444, -1654);

        //when
        boolean v1v2Result = v1.follows(v2);
        boolean v1v4Result = v1.follows(v4);
        boolean v6v3Result = v6.follows(v3);
        boolean v6v5Result = v6.follows(v5);
        boolean v5v6Result = v5.follows(v6);
        boolean v6v1Result = v6.follows(v1);

        //then
        assertTrue(v1v2Result);
        assertTrue(v1v4Result);
        assertFalse(v6v3Result);
        assertFalse(v6v5Result);
        assertTrue(v5v6Result);
        assertFalse(v6v1Result);
    }

    @Test
    void upperRight() {
        //given
        Vector2d v1 = new Vector2d(1, 0);
        Vector2d v2 = new Vector2d(1, -1);
        Vector2d v3 = new Vector2d(100, 10);
        Vector2d v4 = new Vector2d(1, 0);
        Vector2d v5 = new Vector2d(67444, 165432);
        Vector2d v6 = new Vector2d(-6746444, -1654);

        //when
        Vector2d v1v2Result = v1.upperRight(v2);
        Vector2d v1v4Result = v1.upperRight(v4);
        Vector2d v6v3Result = v6.upperRight(v3);
        Vector2d v6v5Result = v6.upperRight(v5);
        Vector2d v5v6Result = v5.upperRight(v6);
        Vector2d v6v1Result = v6.upperRight(v1);

        //then
        assertEquals(v1v2Result, new Vector2d(1, 0));
        assertEquals(v1v4Result, new Vector2d(1, 0));
        assertEquals(v6v3Result, new Vector2d(100, 10));
        assertEquals(v6v5Result, new Vector2d(67444, 165432));
        assertEquals(v5v6Result, new Vector2d(67444, 165432));
        assertEquals(v6v1Result, new Vector2d(1, 0));
    }

    @Test
    void lowerLeft() {
        //given
        Vector2d v1 = new Vector2d(1, 0);
        Vector2d v2 = new Vector2d(1, -1);
        Vector2d v3 = new Vector2d(100, 10);
        Vector2d v4 = new Vector2d(1, 0);
        Vector2d v5 = new Vector2d(67444, 165432);
        Vector2d v6 = new Vector2d(-6746444, -1654);

        //when
        Vector2d v1v2Result = v1.lowerLeft(v2);
        Vector2d v1v4Result = v1.lowerLeft(v4);
        Vector2d v6v3Result = v6.lowerLeft(v3);
        Vector2d v6v5Result = v6.lowerLeft(v5);
        Vector2d v5v6Result = v5.lowerLeft(v6);
        Vector2d v6v1Result = v6.lowerLeft(v1);

        //then
        assertEquals(v1v2Result, new Vector2d(1, -1));
        assertEquals(v1v4Result, new Vector2d(1, 0));
        assertEquals(v6v3Result, new Vector2d(-6746444, -1654));
        assertEquals(v6v5Result, new Vector2d(-6746444, -1654));
        assertEquals(v5v6Result, new Vector2d(-6746444, -1654));
        assertEquals(v6v1Result, new Vector2d(-6746444, -1654));
    }

    @Test
    void add() {
        //given
        Vector2d v1 = new Vector2d(1, 0);
        Vector2d v2 = new Vector2d(1, -1);
        Vector2d v3 = new Vector2d(100, 10);
        Vector2d v4 = new Vector2d(1, 0);
        Vector2d v5 = new Vector2d(67444, 165432);
        Vector2d v6 = new Vector2d(-6746444, -1654);

        //when
        Vector2d v1v2Result = v1.add(v2);
        Vector2d v1v4Result = v1.add(v4);
        Vector2d v6v3Result = v6.add(v3);
        Vector2d v6v5Result = v6.add(v5);
        Vector2d v5v6Result = v5.add(v6);
        Vector2d v6v1Result = v6.add(v1);

        //then
        assertEquals(v1v2Result, new Vector2d(2, -1));
        assertEquals(v1v4Result, new Vector2d(2, 0));
        assertEquals(v6v3Result, new Vector2d(-6746344, -1644));
        assertEquals(v6v5Result, new Vector2d(-6679000, 163778));
        assertEquals(v5v6Result, new Vector2d(-6679000, 163778));
        assertEquals(v6v1Result, new Vector2d(-6746443, -1654));
    }

    @Test
    void subtract() {
        //given
        Vector2d v1 = new Vector2d(1, 0);
        Vector2d v2 = new Vector2d(1, -1);
        Vector2d v3 = new Vector2d(100, 10);
        Vector2d v4 = new Vector2d(1, 0);
        Vector2d v5 = new Vector2d(67444, 165432);
        Vector2d v6 = new Vector2d(-6746444, -1654);

        //when
        Vector2d v1v2Result = v1.subtract(v2);
        Vector2d v1v4Result = v1.subtract(v4);
        Vector2d v6v3Result = v6.subtract(v3);
        Vector2d v6v5Result = v6.subtract(v5);
        Vector2d v5v6Result = v5.subtract(v6);
        Vector2d v6v1Result = v6.subtract(v1);

        //then
        assertEquals(v1v2Result, new Vector2d(0, 1));
        assertEquals(v1v4Result, new Vector2d(0, 0));
        assertEquals(v6v3Result, new Vector2d(-6746544, -1664));
        assertEquals(v6v5Result, new Vector2d(-6813888, -167086));
        assertEquals(v5v6Result, new Vector2d(6813888, 167086));
        assertEquals(v6v1Result, new Vector2d(-6746445, -1654));
    }

    @Test
    void testEquals() {
        //given
        Vector2d v1 = new Vector2d(1, 0);
        Vector2d v2 = new Vector2d(1, -1);
        Vector2d v3 = new Vector2d(100, 10);
        Vector2d v4 = new Vector2d(1, 0);

        //when
        boolean v1v4Result = v1.equals(v4);
        boolean v4v1Result = v4.equals(v1);
        boolean v2v3Result = v2.equals(v3);
        boolean v1v2Result = v1.equals(v2);
        boolean v1czResult = v1.equals("czekolada");

        //then
        assertTrue(v1v4Result);
        assertTrue(v4v1Result);
        assertFalse(v2v3Result);
        assertFalse(v1v2Result);
        assertFalse(v1czResult);
    }

    @Test
    void opposite() {
        //given
        Vector2d v1 = new Vector2d(1, 0);
        Vector2d v2 = new Vector2d(1, -1);
        Vector2d v3 = new Vector2d(100, 10);
        Vector2d v4 = new Vector2d(0, 0);
        Vector2d v5 = new Vector2d(67444, 165432);
        Vector2d v6 = new Vector2d(-6746444, -1654);

        //when
        Vector2d v1Result = v1.opposite();
        Vector2d v2Result = v2.opposite();
        Vector2d v3Result = v3.opposite();
        Vector2d v4Result = v4.opposite();
        Vector2d v5Result = v5.opposite();
        Vector2d v6Result = v6.opposite();

        //then
        assertEquals(v1Result, new Vector2d(-1, 0));
        assertEquals(v2Result, new Vector2d(-1, 1));
        assertEquals(v3Result, new Vector2d(-100, -10));
        assertEquals(v4Result, new Vector2d(0, 0));
        assertEquals(v5Result, new Vector2d(-67444, -165432));
        assertEquals(v6Result, new Vector2d(6746444, 1654));
    }
}