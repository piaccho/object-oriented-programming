package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    Image elementImage;
    IMapElement mapElement;

    public GuiElementBox(IMapElement mapElement) throws FileNotFoundException {
        this.mapElement = mapElement;
        String URL = "src/main/resources/" + mapElement.getImageName();
        try {
            this.elementImage = new Image(new FileInputStream(URL));
        } catch (FileNotFoundException ex) {
            System.out.println("Files not found -> " + ex);
        }

    }

    public VBox mapElementVbox() {
        Label mapElementLabel;
        ImageView mapElementImage = new ImageView(elementImage);
        if (mapElement instanceof Animal) {
            mapElementLabel = new Label("Z " + mapElement.getPosition());
        }
        else {
            mapElementLabel = new Label("Trawa");
        }
        mapElementImage.setFitWidth(20);
        mapElementImage.setFitHeight(20);
//        mapElementLabel.setFont(new Font(10));
        VBox elementVBox = new VBox();
        elementVBox.getChildren().addAll(mapElementImage, mapElementLabel);
        elementVBox.setAlignment(Pos.CENTER);

        return elementVBox;

    }
}
