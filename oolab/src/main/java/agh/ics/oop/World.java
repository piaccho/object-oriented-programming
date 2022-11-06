package agh.ics.oop;


import static java.lang.System.out;

public class World {

    public static void main(String[] args) {
        MoveDirection[] directions = new OptionsParser().parse(args);
<<<<<<< HEAD
        GrassField map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        out.println(map.toString());
=======
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
>>>>>>> 01f523e0798ec096e21babf692a538a70cd8747e

    }

    public static void run(Direction[] dirs) {
        for (Direction d : dirs) {
            String ans = switch (d) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak skręca w prawo";
                case LEFT -> "Zwierzak skręca w lewo";
            };
            out.println(ans);
        }
    }

    public static Direction[] convert(String[] array) {
        int counter = 0;
        for (String s : array) {
            if (s.equals("f") || s.equals("b") || s.equals("r") || s.equals("l")) {
                counter++;
            }
        }
        Direction[] dirs = new Direction[counter];
        counter = 0;
        for (String s : array) {
            switch (s) {
                case "f":
                    dirs[counter] = Direction.FORWARD;
                    counter++;
                    break;
                case "b":
                    dirs[counter] = Direction.BACKWARD;
                    counter++;
                    break;
                case "r":
                    dirs[counter] = Direction.RIGHT;
                    counter++;
                    break;
                case "l":
                    dirs[counter] = Direction.LEFT;
                    counter++;
                    break;
                default:
                    break;
            }

        }
        return dirs;
    }
}
