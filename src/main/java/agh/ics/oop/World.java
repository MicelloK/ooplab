package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        Animal krowa1 = new Animal();
        MoveDirection[] movements = OptionsParser.parse(args);

        for (MoveDirection move : movements) {
            krowa1.move(move);
        }

        System.out.println(krowa1);
    }

    private void run(MoveDirection[] directions) {
        for (MoveDirection direction : directions) {
            switch (direction) {
                case LEFT -> System.out.println("Zwierzak idzie w lewo");
                case RIGHT -> System.out.println("Zwierzak idzie w prawo");
                case FORWARD -> System.out.println("Zwierzak idzie w przod");
                case BACKWARD -> System.out.println("Zwierzak idzie w tyl");
            }
        }
    }
}
