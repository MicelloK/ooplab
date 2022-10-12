package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        //lab1
//        System.out.println("Start");
//        Direction[] directions = conv(args);
//        run(directions);
//        System.out.println("Stop");

        //lab2
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        System.out.println(MapDirection.NORTH.next());
        System.out.println(MapDirection.NORTH.previous());
        System.out.println(MapDirection.NORTH.toString());
        System.out.println(MapDirection.EAST.toString());
        System.out.println(MapDirection.WEST.toUnitVector());
        System.out.println(MapDirection.NORTH.toUnitVector());
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
