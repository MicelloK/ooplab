package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimulationEngine implements IEngine {
    private final AbstractWorldMap map;
    private final MoveDirection[] moveDirections;

    public SimulationEngine(MoveDirection[] moveDirections, AbstractWorldMap map, Vector2d[] positions) {
        this.moveDirections = moveDirections;
        this.map = map;

        for (Vector2d position : positions) {
            Animal animal = new Animal(map, position);
            map.place(animal);
            animal.addObserver(map);
        }
    }

    @Override
    public void run() {
        System.out.println(map.toString());
        int animalNum = 0;
        List<Animal> animals = new ArrayList<>();
        for (IMapElement element : map.getAnimals().values()) {
            animals.add((Animal) element);
        }

        for (MoveDirection direction : moveDirections) {
            Animal animal = animals.get(animalNum);
            animal.move(direction);
            animalNum = (animalNum + 1) % animals.size();
            System.out.println(map);
        }
    }
}
