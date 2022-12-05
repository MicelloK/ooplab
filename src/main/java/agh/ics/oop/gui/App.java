package agh.ics.oop.gui;
import agh.ics.oop.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class App extends Application implements IStepObserver {
    private AbstractWorldMap map;
    private GridPane grid;
    private SimulationEngine engine;
    private Stage stage;
    private Scene scene;
    private HBox hBox;

    public void start(Stage primaryStage) throws FileNotFoundException {
        stage = primaryStage;
        hBox = new HBox();
        Button button = new Button("Start");
        TextField textField = new TextField();

        button.setOnAction(action -> {
            if (textField.getText().length() > 0) {
                MoveDirection[] directions = OptionsParser.parse(Arrays.asList(textField.getText().split(" ")));
                engine.updateDirections(directions);
            }
            Thread engineThread = new Thread(engine);
            engineThread.start();
        });

        hBox.getChildren().addAll(button, textField);

        updateGrid();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() {
        grid = new GridPane();

        try {
            MoveDirection[] directions = OptionsParser.parse(getParameters().getRaw());
            map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(1, 5)};
            engine = new SimulationEngine(directions, map, positions);
            engine.addObserver(this);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateGrid() throws FileNotFoundException {
        Vector2d[] size = map.getSize();
        int WIDTH = 40;
        int HEIGHT = 40;

        initGrid(size, WIDTH, HEIGHT);

        int idX = 1;
        for (int i = size[0].x(); i <= size[1].x(); ++i) {
            int idY = 1;
            for (int j = size[1].y(); j >= size[0].y(); --j) {
                Vector2d position = new Vector2d(i, j);
                if (map.isOccupied(position)) {
                    IMapElement object = (IMapElement) map.objectAt(position);

                    GuiElementBox box = new GuiElementBox(object);
                    VBox vbox = box.getVbox();

                    grid.add(vbox, idX, idY);
                    GridPane.setHalignment(vbox, HPos.CENTER);
                }
                idY += 1;
            }
            idX += 1;
        }

        VBox vBox = new VBox();
        vBox.getChildren().addAll(grid, hBox);

        scene = new Scene(vBox, 800, 800);
        stage.setScene(scene);
        stage.show();
    }

    private void initGrid(Vector2d[] size, int WIDTH, int HEIGHT) {
        grid.getColumnConstraints().clear();
        grid.getRowConstraints().clear();
        grid.getChildren().clear();

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
    }

    @Override
    public void stepTaken() {
        try {
            Platform.runLater(() -> {
                try{
                    updateGrid();
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            });
            Thread.sleep(300);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
