package agh.ics.oop;

import agh.ics.oop.gui.IObserver;
import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable {
    private MoveDirection[] moves;
    public final List<Animal> animals;
    private int moveDelay = 0;
    private List<IObserver> observers = new ArrayList<IObserver>();

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] initialPositions) {
        this.moves = moves;
        this.animals = new ArrayList<>();
        for (Vector2d pos : initialPositions) {
            Animal animalToAdd = new Animal(map, pos);
            if (map.place(animalToAdd))
                animals.add(animalToAdd);
        }
    }

    public SimulationEngine(IWorldMap map, Vector2d[] animalsPositions) {
        this.moves = new MoveDirection[0];
        this.animals = new ArrayList<>();
        for (Vector2d pos : animalsPositions) {
            Animal animalToAdd = new Animal(map, pos);
            if (map.place(animalToAdd))
                animals.add(animalToAdd);
        }

    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setMoves(MoveDirection[] moves) {
        this.moves = moves;
    }

    public void setMoveDelay(int moveDelay) {
        this.moveDelay = moveDelay;
    }

    public void addObserver(IObserver app) {
        this.observers.add(app);
    }

    @Override
    public void run() {
        int i = 0;
        for (MoveDirection move : this.moves) {
            animals.get(i).move(move);
            i++;
            if (i == animals.size())
                i = 0;
            for (IObserver observer : observers) {
                observer.elementMoved();
            }
            try {
                System.out.println("Sleeping..");
                Thread.sleep(this.moveDelay);
            } catch (InterruptedException ex) {
                System.out.println("Interrupted -> " + ex);
            }
        }
    }
}
