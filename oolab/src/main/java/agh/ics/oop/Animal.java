package agh.ics.oop;


public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    public String toString() {
        return "position: " + "(" + String.valueOf(this.position.x) + "," + String.valueOf(this.position.y) + ")" + " orientation: " + String.valueOf(orientation);
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public boolean isTurnedTo(MapDirection direction) {
        return this.orientation.equals(direction);
    }

    public void move(MoveDirection direction) {
        Vector2d moveAnimal = new Vector2d(0, 0);
        switch (direction) {
            case RIGHT:
                this.orientation = switch (this.orientation) {
                    case NORTH -> MapDirection.EAST;
                    case EAST -> MapDirection.SOUTH;
                    case SOUTH -> MapDirection.WEST;
                    case WEST -> MapDirection.NORTH;
                };
                break;
            case LEFT:
                this.orientation = switch (this.orientation) {
                    case NORTH -> MapDirection.WEST;
                    case WEST -> MapDirection.SOUTH;
                    case SOUTH -> MapDirection.EAST;
                    case EAST -> MapDirection.NORTH;
                };
                break;
            case FORWARD:
                moveAnimal = switch (this.orientation) {
                    case NORTH -> new Vector2d(0, 1);
                    case WEST -> new Vector2d(-1, 0);
                    case SOUTH -> new Vector2d(0, -1);
                    case EAST -> new Vector2d(1, 0);
                };
                break;
            case BACKWARD:
                moveAnimal = switch (this.orientation) {
                    case NORTH -> new Vector2d(0, -1);
                    case WEST -> new Vector2d(1, 0);
                    case SOUTH -> new Vector2d(0, 1);
                    case EAST -> new Vector2d(-1, 0);
                };
                break;
        }
        if (!moveAnimal.equals(new Vector2d(0, 0))) {
            int vectorX = this.position.x + moveAnimal.x;
            int vectorY = this.position.y + moveAnimal.y;
            if (vectorX >= 0 && vectorX <= 4 && vectorY >= 0 && vectorY <= 4) {
                this.position = new Vector2d(vectorX, vectorY);
            }
        }
    }
}
