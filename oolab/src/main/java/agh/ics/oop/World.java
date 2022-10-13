package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class World {

    public static void main(String[] args) {
        out.println("Start");
        run(convert(args));
        out.println("Stop");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        out.println(MapDirection.NORTH.toString());
        out.println(MapDirection.SOUTH.toString());
        out.println(MapDirection.EAST.toString());
        out.println(MapDirection.WEST.toString());

        out.println(MapDirection.NORTH.previous().toString());
        out.println(MapDirection.SOUTH.toUnitVector().toString());

    }

    public static void run(Direction[] dirs) {
        for(Direction d: dirs) {
            String ans = switch (d) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak skręca w prawo";
                case LEFT  -> "Zwierzak skręca w lewo";
            };
            out.println(ans);
        }
    }

    public static Direction[] convert(String[] array){
        int counter = 0;
        for(String s: array) {
            if(s.equals("f") || s.equals("b") || s.equals("r") || s.equals("l")){
                counter++;
            }
        }
        Direction[] dirs = new Direction[counter];
        counter = 0;
        for(String s: array) {
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
            };
        }
        return dirs;
    }
}
