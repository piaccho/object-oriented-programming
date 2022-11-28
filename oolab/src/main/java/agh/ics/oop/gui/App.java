package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


public class App extends Application implements IObserver{
    private SimulationEngine engine;
    private GrassField map;
    private GridPane grid;


    public void init() {
        this.map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(-3, -6)};
        this.engine = new SimulationEngine(map, positions);
        this.engine.addObserver(this);
        engine.setMoveDelay(300);
        grid = new GridPane();
    }

    public void drawMap() {

        grid.setGridLinesVisible(true);

        double boxSize = 40; // bok kwadratu w px
        for (int i = 0; i < map.drawTopRight().y - map.drawBottomLeft().y + 2; i++) {
            for (int j = 0; j < map.drawTopRight().x - map.drawBottomLeft().x + 2; j++) {
                Label label;
                if (i == 0 && j == 0) {
                    label = new Label("y/x");
                } else if (i == 0) {
                    label = new Label(Integer.toString(map.drawBottomLeft().x + j - 1));
                } else if (j == 0) {
                    label = new Label(Integer.toString(map.drawBottomLeft().y + i - 1));
                } else {
                    label = new Label("");
                }

                Rectangle r = new Rectangle(boxSize, boxSize, boxSize, boxSize);
                r.setFill(Color.WHITE);
                grid.add(r, j, i);
                grid.add(label, j, i);
                GridPane.setHalignment(label, HPos.CENTER);
            }
        }

        try {
            for (Animal animal : engine.getAnimals()) {
                GuiElementBox box = new GuiElementBox(animal);
                Vector2d pos = animal.getPosition();
                grid.add(box.mapElementVbox(), pos.x + 1 + Math.abs(map.drawBottomLeft().x), pos.y + 1 + Math.abs(map.drawBottomLeft().y));
            }

            for (Grass grass : map.getGrasses()) {
                GuiElementBox box = new GuiElementBox(grass);
                Vector2d pos = grass.getPosition();
                grid.add(box.mapElementVbox(), pos.x + 1 + Math.abs(map.drawBottomLeft().x), pos.y + 1 + Math.abs(map.drawBottomLeft().y));
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Couldnt load files");
        }
    }

    public void start(Stage primaryStage) throws Exception {
        TextField movesInput = new TextField();
        Button startButton = new Button("Run");
        VBox inputBox = new VBox(movesInput, startButton);
        VBox appBox = new VBox(this.grid, inputBox);
        grid.setAlignment(Pos.CENTER);
        inputBox.setAlignment(Pos.CENTER);
        appBox.setAlignment(Pos.CENTER);
        movesInput.setMaxWidth(100);

        startButton.setOnAction(ev -> {
            String[] args = movesInput.getText().split("");
            MoveDirection[] directions = new OptionsParser().parse(args);
            engine.setMoves(directions);
            Thread engineThread = new Thread(engine);
            engineThread.start();
        });


        drawMap();
        Scene scene = new Scene(appBox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void elementMoved() {
        Platform.runLater(() -> {
            grid.getChildren().clear();
            drawMap();
        });
    }
}
