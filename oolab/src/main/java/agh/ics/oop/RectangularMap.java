package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap  {
    public RectangularMap(int width, int height) {

        super(width - 1, height - 1, 0, 0);
    }

    public Vector2d drawBottomLeft() {
        return leftBottomCorner;
    }

    public Vector2d drawTopRight() {
        return rightTopCorner;
    }

}
