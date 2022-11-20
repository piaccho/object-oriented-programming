package agh.ics.oop.gui;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class App extends Application{
    private SimulationEngine engine;
    private GrassField map;

    public void init() {
        this.map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(-3, -6)};
        this.engine = new SimulationEngine(map, positions);

    }

    public void start(Stage primaryStage) throws Exception {
        GridPane grid = new GridPane();
        double boxSize = 30; // bok kwadratu w px
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

        for(Grass grass: map.getGrasses()) {
            Vector2d pos = grass.getPosition();
            Label label = new Label("*");
            grid.add(label, pos.x + 1 + Math.abs(map.drawBottomLeft().x), pos.y + 1 + Math.abs(map.drawBottomLeft().y));
            GridPane.setHalignment(label, HPos.CENTER);
        }

        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        grid.setGridLinesVisible(true);
        primaryStage.show();
    }
}
