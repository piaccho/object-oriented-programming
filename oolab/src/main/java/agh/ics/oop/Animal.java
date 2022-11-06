package agh.ics.oop;


public class Animal extends AbstractWorldMapElement{
    private MapDirection direction = MapDirection.NORTH;
    private IWorldMap map;

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
}
