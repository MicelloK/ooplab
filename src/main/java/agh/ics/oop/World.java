package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        try {
            MoveDirection[] directions = OptionsParser.parse(args);
            AbstractWorldMap map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(0,0), new Vector2d(0,1) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
