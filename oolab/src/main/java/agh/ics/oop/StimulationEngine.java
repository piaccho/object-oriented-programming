package agh.ics.oop;

import java.util.Vector;

public class StimulationEngine implements agh.ics.oop.IEngine {
    private MoveDirection[] moves;
    private agh.ics.oop.IWorldMap map;
    private Vector2d[] initialPositions;
    @Override
    public void run() {

    }

    public StimulationEngine(MoveDirection[] moves, agh.ics.oop.IWorldMap map, Vector2d[] initialPositions) {
        this.moves = moves;
        this.map = map;
        this.initialPositions = initialPositions;
    }

}
