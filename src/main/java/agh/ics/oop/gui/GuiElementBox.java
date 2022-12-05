package agh.ics.oop.gui;
import agh.ics.oop.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class GuiElementBox {
    VBox vbox;

    private Label createLabel(IMapElement element) {
        Label label;
        if (element instanceof Animal) {
            label = new Label("A" + element.getPosition().toString());
        }
        else if (element instanceof Grass) {
            label = new Label("G");
        }
        else {
            label = new Label("unknown");
        }
        return label;
    }

    private ImageView createImageView(IMapElement element) throws FileNotFoundException {
        Image image = new Image(new FileInputStream(element.getImage()));
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        return imageView;
    }

    public GuiElementBox(IMapElement element) throws FileNotFoundException {
        vbox = new VBox();
        ImageView imageView = createImageView(element);
        Label label = createLabel(element);

        vbox.getChildren().addAll(imageView, label);
        vbox.setAlignment(Pos.CENTER);
    }

    public VBox getVbox() {
        return vbox;
    }
}
