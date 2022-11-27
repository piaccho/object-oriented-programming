package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {
    private MoveDirection[] moves;
    public final List<Animal> animals;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] initialPositions) {
        this.moves = moves;
        this.animals = new ArrayList<>();
        for (Vector2d pos : initialPositions) {
            Animal animalToAdd = new Animal(map, pos);
            if (map.place(animalToAdd))
                animals.add(animalToAdd);
        }
    }

    public List<Animal> getAnimals() {
        return animals;
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

    @Override
    public void run() {
        int i = 0;
        for (MoveDirection move : moves) {
            animals.get(i).move(move);
//            System.out.println(String.format("Ruch %d, Zwierze %d: %s %s %s",counter, i, x, move, animals.get(i).getPosition()));
            i++;
            if (i == animals.size())
                i = 0;
        }
    }

}
