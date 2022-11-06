package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals = new ArrayList<>();
    protected MapVisualizer visualizer = new MapVisualizer(this);
    protected Vector2d leftBottomCorner;
    protected Vector2d rightTopCorner;


    public AbstractWorldMap(int xLB, int yLB, int xRT, int yRT) {
        this.leftBottomCorner = new Vector2d(xLB, yLB);
        this.rightTopCorner = new Vector2d(xRT, yRT);
    }

    abstract Vector2d drawBottomLeft();

    abstract Vector2d drawTopRight();

    public String toString() {
        System.out.println(drawBottomLeft());
        System.out.println(drawTopRight());
        return visualizer.draw(drawBottomLeft(), drawTopRight());
    }

    public boolean canMoveTo(Vector2d position) {
        return position.precedes(rightTopCorner) && position.follows(leftBottomCorner) && !(objectAt(position) instanceof Animal);
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position) instanceof Animal;
    }

    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) {
                return animal;
            }
        }
        return null;
    }

}
