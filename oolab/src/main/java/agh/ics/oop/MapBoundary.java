package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver{
    SortedSet<Vector2d> objectsX = new TreeSet<>(new _Comparator(true));
    SortedSet<Vector2d> objectsY = new TreeSet<>(new _Comparator(false));
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        removeElement(oldPosition);
        addElement(newPosition);
    }

    public void addElement(Vector2d element){
        objectsX.add(element);
        objectsY.add(element);
    }

    public void removeElement(Vector2d element){
        objectsX.remove(element);
        objectsY.remove(element);
    }
}
