package agh.ics.oop;


public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position;
    private IWorldMap map;

    public Animal () {
        this.position = new Vector2d(2, 2);
    }

    public Animal (agh.ics.oop.IWorldMap map){
        this.map = map;
    }

    public Animal (agh.ics.oop.IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }

    public String toString() {
        return switch (this.direction) {
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public MapDirection getDirection() {
        return this.direction;
    }


    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
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
