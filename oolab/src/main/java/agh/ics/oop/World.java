package agh.ics.oop;


import static java.lang.System.out;

public class World {

    public static void main(String[] args) {
//        out.println("Start");
//        run(convert(args));
//        out.println("Stop");
//
//        Vector2d position1 = new Vector2d(1, 2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2, 1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));

        animalTest(args);

        // aby wykluczyć pojawienie się dwóch zwierząt w jednym miejscu można zaimplementować klase Map która posiada dla każdych koordynatów wartość boolean, która będzie oznaczać czy dane pole jest zajęte


    }
    public static void animalTest(String[] array) {
        Animal pies = new Animal();
        out.println(pies.toString());

        OptionsParser p = new OptionsParser();
        for (MoveDirection m: p.parse(array)) {
            pies.move(m);
            out.println(pies.toString());
        }
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
