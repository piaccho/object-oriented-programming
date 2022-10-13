package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    void equalsTest() {
        Vector2d v = new Vector2d(1, 2);
        Object o = new Object();
        Vector2d v2 = new Vector2d(1, 2);
        assertFalse(v.equals(o));
        assertTrue(v.equals(v2));
    }

    @Test
    void toStringTest() {
        Vector2d v1 = new Vector2d(2, 4);
        Vector2d v2 = new Vector2d(32, 4244);
        assertEquals(v1.toString(), "(2,4)");
        assertEquals(v2.toString(), "(32,4244)");
    }

    @Test
    void precedesTest() {
        Vector2d v = new Vector2d(3, 6);
        Vector2d t = new Vector2d(7, 8);
        Vector2d f = new Vector2d(2, 5);
        Vector2d f2 = new Vector2d(2, 7);
        assertTrue(v.precedes(t));
        assertFalse(v.precedes(f));
        assertFalse(v.precedes(f2));

    }

    @Test
    void followsTest() {
        Vector2d v = new Vector2d(3, 6);
        Vector2d f = new Vector2d(7, 8);
        Vector2d f2 = new Vector2d(2, 7);
        Vector2d t = new Vector2d(2, 5);

        assertTrue(v.follows(t));
        assertFalse(v.follows(f));
        assertFalse(v.follows(f2));
    }

    @Test
    void upperRightTest() {
        Vector2d v = new Vector2d(2, 3);
        Vector2d u = new Vector2d(1, 4);
        Vector2d t = new Vector2d(2, 4);
        assertEquals(v.upperRight(u), t);
    }

    @Test
    void lowerLeftTest() {
        Vector2d v = new Vector2d(2, 3);
        Vector2d u = new Vector2d(1, 4);
        Vector2d t = new Vector2d(1, 3);
        assertEquals(v.lowerLeft(u), t);

    }

    @Test
    void addTest() {
        Vector2d v = new Vector2d(2, 3);
        Vector2d u = new Vector2d(1, 4);
        Vector2d t = new Vector2d(3, 7);
        assertEquals(v.add(u), t);
    }

    @Test
    void subtractTest() {
        Vector2d v = new Vector2d(2, 3);
        Vector2d u = new Vector2d(1, 4);
        Vector2d t = new Vector2d(1, -1);
        assertEquals(v.subtract(u), t);
    }

    @Test
    void oppositeTest() {
        Vector2d v = new Vector2d(12, 31);
        Vector2d t = new Vector2d(31, 12);
        assertEquals(v.opposite(), t);
    }
}
