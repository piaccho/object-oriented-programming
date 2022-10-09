package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        out.println("Start");
        int counter = 0;
        for(String s: args) {
            if(s.equals("f") || s.equals("b") || s.equals("r") || s.equals("l")){
                counter++;
            }
        }
        Direction[] dirs = new Direction[counter];
        counter = 0;
        for(String s: args) {
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
        run(dirs);
        out.println("Stop");
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
}
