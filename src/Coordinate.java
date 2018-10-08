public class Coordinate {
    int xCoordinate;
    int yCoordinate;

    Coordinate(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    int distanceFrom(Coordinate other){
        return Math.abs(this.xCoordinate - other.xCoordinate) +
                Math.abs(this.yCoordinate - other.yCoordinate);
    }
}
