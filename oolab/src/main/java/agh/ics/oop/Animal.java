package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public class Animal extends AbstractWorldMapElement{
    private MapDirection direction = MapDirection.NORTH;
    private IWorldMap map;
    protected Map<IPositionChangeObserver, IPositionChangeObserver> observers = new HashMap<>();

    public Animal (IWorldMap map, Vector2d initialPosition){
        super(initialPosition);
        this.map = map;
    }

    public String toString() {
        return switch (this.direction) {
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };
    }

    public MapDirection getDirection() {
        return this.direction;
    }

    public boolean isTurnedTo(MapDirection direction) {
        return this.direction.equals(direction);
    }

    public void move(MoveDirection direction) {
        boolean oppositeFlag = false;
        switch (direction) {
            case RIGHT:
                this.direction = this.direction.next();
                break;
            case LEFT:
                this.direction = this.direction.previous();
                break;
            case BACKWARD:
                oppositeFlag = true;
            case FORWARD:
                Vector2d movementChange = this.direction.toUnitVector();
                if (oppositeFlag)
                    movementChange = movementChange.opposite();
                Vector2d updatePosition = this.position.add(movementChange);
                if (map.canMoveTo(updatePosition))
                    this.position = updatePosition;
                break;
        }
    }

    void addObserver(IPositionChangeObserver observer) {this.observers.put(observer, observer);
    }

    void removeObserver(IPositionChangeObserver observer) {this.observers.remove(observer);
    }

    void positionChanged(Vector2d newPosition) {
        for (IPositionChangeObserver observer: observers.values()) {
            observer.positionChanged(this.position, newPosition);
        }
        this.position = newPosition;
    }

    @Override
    public String getImageName() {
        return switch (this.direction) {
            case NORTH -> "up.png";
            case EAST -> "right.png";
            case SOUTH -> "down.png";
            case WEST -> "left.png";
        };
    }

}
