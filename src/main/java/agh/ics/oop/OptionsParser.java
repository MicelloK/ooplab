package agh.ics.oop;

public class OptionsParser {
    //methods
    public static MoveDirection[] parse(String[] args) {
        // converting strings to MoveDirection[]
        MoveDirection[] directionsTemp = new MoveDirection[args.length];
        int wrongDirectionCounter = 0;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "f", "forward" -> directionsTemp[i] = MoveDirection.FORWARD;
                case "b", "backward" -> directionsTemp[i] = MoveDirection.BACKWARD;
                case "l", "left" -> directionsTemp[i] = MoveDirection.LEFT;
                case "r", "right" -> directionsTemp[i] = MoveDirection.RIGHT;
                default -> wrongDirectionCounter += 1;
            }
        }

        // creating array without null value
        MoveDirection[] directions = new MoveDirection[args.length - wrongDirectionCounter];
        int i = 0;
        for (MoveDirection dir : directionsTemp) {
            if (dir != null) {
                directions[i] = dir;
                i += 1;
            }
        }
        return directions;
    }
}
