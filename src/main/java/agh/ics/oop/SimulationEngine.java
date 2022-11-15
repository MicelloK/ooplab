package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {
    private final IWorldMap map;
    private final MoveDirection[] moveDirections;
    private final List<Animal> animals = new ArrayList<>();

    public SimulationEngine(MoveDirection[] moveDirections, IWorldMap map, Vector2d[] positions) {
        this.moveDirections = moveDirections;
        this.map = map;

        for (Vector2d position : positions) {
            Animal animal = new Animal(map, position);

            animals.add(animal);
            map.place(animal);
        }
    }

    @Override
    public void run() {
        System.out.println(map.toString());
        int animalNum = 0;
        for (MoveDirection direction : moveDirections) {

            animals.get(animalNum).move(direction);
            System.out.println(map.toString());
            animalNum = (animalNum + 1) % animals.size();
        }
    }
}
