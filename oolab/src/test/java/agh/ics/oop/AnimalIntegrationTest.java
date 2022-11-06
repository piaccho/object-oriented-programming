package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

<<<<<<< HEAD
=======
import java.util.Arrays;
import java.util.List;
>>>>>>> 01f523e0798ec096e21babf692a538a70cd8747e

public class AnimalIntegrationTest {
    @Test
    void worldTest(){
        String[] testArgs = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(testArgs);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

<<<<<<< HEAD
        System.out.println(map);
=======
        System.out.println(map.toString());
>>>>>>> 01f523e0798ec096e21babf692a538a70cd8747e

        Vector2d[] expected = new Vector2d[]{
                new Vector2d(2, 0),
                new Vector2d(3, 4)
        };
        Assertions.assertEquals(expected[0], engine.animals.get(0).getPosition());
        Assertions.assertEquals(expected[1], engine.animals.get(1).getPosition());
    }
}
