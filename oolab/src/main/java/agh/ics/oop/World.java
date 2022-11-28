package agh.ics.oop;

import agh.ics.oop.gui.*;
import javafx.application.Application;

import static java.lang.System.out;


public class World {

    public static void main(String[] args) {Application.launch(App.class, args);}

//        try {
//            MoveDirection[] directions = new OptionsParser().parse(args);
////            String[] testArgs = {"f", "b", "r"};
////            MoveDirection[] directions = new OptionsParser().parse(testArgs);
//            GrassField map = new GrassField(10);
//            Vector2d[] positions = {new Vector2d(2,2), new Vector2d(3,4) };
//            IEngine engine = new SimulationEngine(directions, map, positions);
//            engine.run();
//            out.println(map);
//        }
//        catch(IllegalArgumentException exception) {
//
//            out.println("Exception:" + exception);
//        }


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
