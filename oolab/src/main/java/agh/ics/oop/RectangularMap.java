package agh.ics.oop;

public class RectangularMap implements agh.ics.oop.IWorldMap {
    private int width;
    private int height;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return null;
    }


    public String toString() {
        agh.ics.oop.MapVisualizer vis = new agh.ics.oop.MapVisualizer(map);
        return vis.draw(new Vector2d(0, 0), new Vector2d(width, height));

    }
}
