package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangularMapTest {

    @Test
    public void canMoveToTest() {
        IWorldMap map = new RectangularMap(3, 3);
        Assertions.assertTrue(map.canMoveTo(new Vector2d(1, 0)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(1, 1)));
        Assertions.assertFalse(map.canMoveTo(new Vector2d(1, 3)));
    }

    @Test
    public void placeTest() {
        IWorldMap map = new RectangularMap(4, 4);
        Assertions.assertTrue(map.place(new Animal(map, new Vector2d(1, 1))));
        Assertions.assertFalse(map.place(new Animal(map, new Vector2d(1, 1))));
        Assertions.assertFalse(map.place(new Animal(map, new Vector2d(4, 1))));
    }

    @Test
    public void isOccupiedTest() {
        IWorldMap map = new RectangularMap(5, 5);
        Assertions.assertFalse(map.isOccupied(new Vector2d(1, 1)));
        map.place(new Animal(map, new Vector2d(3, 3)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(3, 3)));
    }

    @Test
    public void objectAtTest() {
        IWorldMap map = new RectangularMap(6, 6);
        map.place(new Animal(map, new Vector2d(5, 5)));
        Assertions.assertTrue(map.objectAt(new Vector2d(5, 5)) instanceof Animal);
    }
}
