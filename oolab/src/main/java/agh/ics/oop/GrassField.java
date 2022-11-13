package agh.ics.oop;

import java.util.ArrayList;
import java.util.Random;

public class GrassField extends AbstractWorldMap{
    private int grassNumber;
    private final int maxRange;
    private final int minRange = 0;

    private ArrayList<Grass> grasses;


    public GrassField(int grassNumber) {
        super(Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 1, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1);
        this.grassNumber = grassNumber;
        this.maxRange = (int) Math.sqrt(grassNumber * 10);
        this.setGrasses();
    }


    public void setGrasses() {
        this.grasses = new ArrayList<>();
        for(int i = 0; i < grassNumber; i++) {
            while (true) {
                if (spawnGrassRandomly())
                    break;
            }
        }
    }

    public boolean spawnGrassRandomly() {
        int randomX = (int) (Math.random() * maxRange) + minRange;
        int randomY = (int) (Math.random() * maxRange) + minRange;
        Vector2d randomPosition = new Vector2d(randomX, randomY);
        return spawnGrassAt(randomPosition);
    }

    public boolean spawnGrassAt(Vector2d position) {
        if (objectAt(position) == null) {
            grasses.add(new Grass(position));
            return true;
        }
        return false;
    }

    public Vector2d drawBottomLeft() {
        Vector2d drawLB = rightTopCorner;
        for (Animal animal: animals.values()) {
            drawLB = drawLB.lowerLeft(animal.getPosition());
        }
        for (Grass grass : grasses) {
            drawLB = drawLB.lowerLeft(grass.getPosition());
        }
        return drawLB;
    }

    public Vector2d drawTopRight() {
        Vector2d drawRT = leftBottomCorner;
//        for (Animal animal : animals) {
//            drawRT = drawRT.upperRight(animal.getPosition());
//        }
//        animals.forEach((pos, animal) -> {
//            drawRT = drawRT.lowerLeft(pos);
//        });
        for (Animal animal: animals.values()) {
            drawRT = drawRT.upperRight(animal.getPosition());
        }
        for (Grass grass : grasses) {
            drawRT = drawRT.upperRight(grass.getPosition());
        }
        return drawRT;
    }

    public boolean isOccupied(Vector2d position) {
        if (super.isOccupied(position))
            return true;
        for (Grass grass : grasses) {
            if (position.equals(grass.getPosition()))
                return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        if (super.objectAt(position) != null) {
            return super.objectAt(position);
        }
        for (Grass grass : grasses) {
            if (grass.isAt(position))
                return grass;
        }
        return null;
    }

    public boolean canMoveTo(Vector2d position) {
        if (position.precedes(leftBottomCorner) && position.follows(rightTopCorner) && !(objectAt(position) instanceof Animal)) {
            Object checkedPosition = objectAt(position);
            if (checkedPosition instanceof Grass) {
                grasses.remove(checkedPosition);
                spawnGrassRandomly();
            }
            return true;
        }
        return false;
    }

}
