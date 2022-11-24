package agh.ics.oop;

import java.util.List;

public class OptionsParser {
    public static MoveDirection[] parse(List<String> args) {
        MoveDirection[] directionsTemp = new MoveDirection[args.size()];

        for (int i = 0; i < args.size(); i++) {
            switch (args.get(i)) {
                case "f", "forward" -> directionsTemp[i] = MoveDirection.FORWARD;
                case "b", "backward" -> directionsTemp[i] = MoveDirection.BACKWARD;
                case "l", "left" -> directionsTemp[i] = MoveDirection.LEFT;
                case "r", "right" -> directionsTemp[i] = MoveDirection.RIGHT;
                default -> throw new IllegalArgumentException(args.get(i) + " is not legal move specification");
            }
        }
        return directionsTemp;
    }
}
