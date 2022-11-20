package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected MapVisualizer visualizer = new MapVisualizer(this);
    protected Vector2d leftBottomCorner;
    protected Vector2d rightTopCorner;

    public Vector2d getLeftBottomCorner() {
        return leftBottomCorner;
    }

    public Vector2d getRightTopCorner() {
        return rightTopCorner;
    }

    public AbstractWorldMap(int xLB, int yLB, int xRT, int yRT) {
        this.leftBottomCorner = new Vector2d(xLB, yLB);
        this.rightTopCorner = new Vector2d(xRT, yRT);
    }

    abstract Vector2d drawBottomLeft();

    abstract Vector2d drawTopRight();

    public String toString() {
        return visualizer.draw(drawBottomLeft(), drawTopRight());
    }

    public boolean canMoveTo(Vector2d position) {
        return position.precedes(rightTopCorner) && position.follows(leftBottomCorner);
//        return position.precedes(rightTopCorner) && position.follows(leftBottomCorner) && !(objectAt(position) instanceof Animal);
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            return true;
        }
        throw new IllegalArgumentException("Animal can't be palced at " + animal.getPosition() + " position");
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position) instanceof Animal;
    }

    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animalToChange = this.animals.get(oldPosition);
        this.animals.remove(oldPosition);
        this.animals.put(newPosition, animalToChange);
    }


}
