package agh.ics.oop;

public class OptionsParser {
    public MoveDirection[] parse(String[] array) {
        int counter = 0;
        for (String s : array) {
            if (s.equals("f") || s.equals("b") || s.equals("r") || s.equals("l") || s.equals("forward") || s.equals("backward") || s.equals("right") || s.equals("left")) {
                counter++;
            }
        }
        MoveDirection[] moveArray = new MoveDirection[counter];
        int index = 0;
        for (String s: array) {
             MoveDirection add = switch (s) {
                 case "f", "forward" -> MoveDirection.FORWARD;
                 case "b", "backward" -> MoveDirection.BACKWARD;
                 case "r", "right" -> MoveDirection.RIGHT;
                 case "l", "left" -> MoveDirection.LEFT;
                 default -> null;
             };
             if (add != null) {
                 moveArray[index] = add;
                 index++;
             }
        }
        return moveArray;
    }
}
