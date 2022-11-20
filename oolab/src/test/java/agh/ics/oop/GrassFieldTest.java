package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrassFieldTest {


    @Test
    public void canMoveToTest() {
        GrassField map = new GrassField(10);
        Assertions.assertTrue(map.canMoveTo(new Vector2d(1, 1)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1)));
    }

    @Test
    public void placeTest() {
        GrassField map = new GrassField(10);
        Assertions.assertTrue(map.place(new Animal(map, new Vector2d(-10, -10))));
        // cant place at map border
        try{
            map.place(new Animal(map, new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE)));
            Assertions.fail("Can't place at borders");
        }catch(IllegalArgumentException ex){
            Assertions.assertTrue(true);
        }

        // cant place if position is taken
        Assertions.assertTrue(map.place(new Animal(map, new Vector2d(5, 5))));
        try{
            map.place(new Animal(map, new Vector2d(5, 5)));
            Assertions.fail("Can't place on (5, 5) if it's taken");
        }catch(IllegalArgumentException ex){
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void isOccupiedTest() {
        GrassField map = new GrassField(10);
        map.place(new Animal(map, new Vector2d(3, 3)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(3, 3)));
    }

    @Test
    public void objectAtTest() {
        GrassField map = new GrassField(10);
        map.place(new Animal(map, new Vector2d(1, 1)));
        Assertions.assertTrue(map.objectAt(new Vector2d(1, 1)) instanceof Animal);
    }

    @Test
    public void spawnGrassTest() {
        GrassField map = new GrassField(0);
        Assertions.assertTrue(map.objectAt(new Vector2d(4, 3)) instanceof Grass);
    }

}
