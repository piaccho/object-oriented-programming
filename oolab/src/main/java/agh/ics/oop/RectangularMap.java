package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
=======

public class RectangularMap implements agh.ics.oop.IWorldMap {
    private final Vector2d leftBottomCorner;
    private final Vector2d rightTopCorner;
    private MapVisualizer visualizer;
    private List<Animal> animals;
>>>>>>> 01f523e0798ec096e21babf692a538a70cd8747e

public class RectangularMap extends AbstractWorldMap  {
    public RectangularMap(int width, int height) {
<<<<<<< HEAD

        super(width - 1, height - 1, 0, 0);
    }

    public Vector2d drawBottomLeft() {
        return leftBottomCorner;
    }

    public Vector2d drawTopRight() {
        return rightTopCorner;
    }

=======
        this.leftBottomCorner = new Vector2d(0, 0);
        this.rightTopCorner = new Vector2d(width - 1, height - 1);
        this.visualizer = new MapVisualizer(this);
        this.animals = new ArrayList<>();
    }

    public String toString() {
        return visualizer.draw(leftBottomCorner, rightTopCorner);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(leftBottomCorner) && position.follows(rightTopCorner) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (!isOccupied(animal.getPosition())) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal a : animals) {
            if (position.equals(a.getPosition()))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) {
                return animal;
            }
        }
        return null;
    }
>>>>>>> 01f523e0798ec096e21babf692a538a70cd8747e
}
