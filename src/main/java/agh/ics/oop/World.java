package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");
        Direction[] directions = conv(args);
        run(directions);
        System.out.println("Stop");
    }
    private static void run(Direction[] directions) {
        for(Direction direction : directions) {
            switch(direction) {
                case LEFT -> System.out.println("Zwierzak idzie w lewo");
                case RIGHT -> System.out.println("Zwierzak idzie w prawo");
                case FORWARD -> System.out.println("Zwierzak idzie w przod");
                case BACKWARD -> System.out.println("Zwierzak idzie w tyl");
            }
        }
    }
    private static Direction[] conv(String[] args) {
        Direction[] dir = new Direction[args.length];
        for(int i=0; i<args.length; i++) {
            switch(args[i]) {
                case "l" -> dir[i] = Direction.LEFT;
                case "r" -> dir[i] = Direction.RIGHT;
                case "f" -> dir[i] = Direction.FORWARD;
                case "b" -> dir[i] = Direction.BACKWARD;
            }
        }
        return dir;
    }
}
