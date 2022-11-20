package agh.ics.oop;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        MoveDirection[] directionsTemp = new MoveDirection[args.length];

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "f", "forward" -> directionsTemp[i] = MoveDirection.FORWARD;
                case "b", "backward" -> directionsTemp[i] = MoveDirection.BACKWARD;
                case "l", "left" -> directionsTemp[i] = MoveDirection.LEFT;
                case "r", "right" -> directionsTemp[i] = MoveDirection.RIGHT;
                default -> throw new IllegalArgumentException(args[i] + " is not legal move specification");
            }
        }
        return directionsTemp;
    }
}
