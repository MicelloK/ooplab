package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.Map;

public class App extends Application {
    private AbstractWorldMap map;
    private GridPane grid;

    public void start(Stage primaryStage) throws Exception {
        updateVisualisation();

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        grid = new GridPane();

        try {
            MoveDirection[] directions = OptionsParser.parse(getParameters().getRaw());
            map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(1, 5)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateVisualisation() {
        Vector2d[] size = map.getSize();

        grid.getColumnConstraints().clear();
        grid.getRowConstraints().clear();
        grid.getChildren().clear();

        int WIDTH = 40;
        int HEIGHT = 40;

        Label label = new Label("y\\x");
        GridPane.setHalignment(label, HPos.CENTER);
        grid.add(label, 0, 0);
        grid.getRowConstraints().add(new RowConstraints(HEIGHT));
        grid.getColumnConstraints().add(new ColumnConstraints(WIDTH));

        int idX = 1;
        for (int i = size[0].x(); i <= size[1].x(); ++i) {
            label = new Label(Integer.toString(i));
            grid.add(label, idX, 0);
            grid.getColumnConstraints().add(new ColumnConstraints(WIDTH));
            GridPane.setHalignment(label, HPos.CENTER);
            idX += 1;
        }

        int idY = 1;
        for (int i = size[1].y(); i >= size[0].y(); --i) {
            label = new Label(Integer.toString(i));
            grid.add(label, 0, idY);
            grid.getRowConstraints().add(new RowConstraints(HEIGHT));
            GridPane.setHalignment(label, HPos.CENTER);
            idY += 1;
        }

        idX = 1;
        for (int i = size[0].x(); i <= size[1].x(); ++i) {
            idY = 1;
            for (int j = size[1].y(); j >= size[0].y(); --j) {
                Vector2d position = new Vector2d(i, j);
                if (map.isOccupied(position)) {
                    IMapElement object = (IMapElement) map.objectAt(position);

                    if (object instanceof Animal) {
                        label = new Label(object.toString());
                    }
                    else if (object instanceof Grass) {
                        label = new Label("T");
                    }
                    else {
                        label = new Label("E"); // if other element types exist
                    }

                    grid.add(label, idX, idY);
                    grid.getColumnConstraints().add(new ColumnConstraints(WIDTH));
                    grid.getRowConstraints().add(new RowConstraints(HEIGHT));
                    GridPane.setHalignment(label, HPos.CENTER);
                }
                idY += 1;
            }
            idX += 1;
        }

    }
}
