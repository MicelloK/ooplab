package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable {
    private final AbstractWorldMap map;
    private MoveDirection[] moveDirections;
    private final List<IStepObserver> observers = new ArrayList<>();

    public SimulationEngine(MoveDirection[] moveDirections, AbstractWorldMap map, Vector2d[] positions) {
        this.moveDirections = moveDirections;
        this.map = map;

        for (Vector2d position : positions) {
            Animal animal = new Animal(map, position);
            map.place(animal);
            animal.addObserver(map);
        }
    }

    public SimulationEngine(AbstractWorldMap map, Vector2d[] positions) {
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
            updateObservers();
        }
    }

    public void updateObservers() {
        for (IStepObserver observer : observers) {
            observer.stepTaken();
        }
    }

    public void addObserver(IStepObserver observer) {
        observers.add(observer);
    }

    public void updateDirections(MoveDirection[] directions) {
        moveDirections = directions;
    }
}
