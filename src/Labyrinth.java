import java.util.List;

class Labyrinth {

    private List<List<LabyrinthCell>> cells;
    private int rowCount;
    private int columnCount;

    Labyrinth(List<List<LabyrinthCell>> cells){
        this.cells = cells;
        this.rowCount = cells.size();
        this.columnCount = cells.get(0).size();
    }

    Agent createNewAgent(int numberOfThings){
        return new Agent(cells.get(0).get(0), numberOfThings, this);
    }

    boolean isExit(LabyrinthCell cell){
        return cells.get(rowCount - 1).get(columnCount - 1) == cell;
    }

    Thing getNearestThingTo(LabyrinthCell relativeCell) {

    }

    int getDistanceBetween(LabyrinthCell cell1, LabyrinthCell cell2){
        Coordinate coordinate1 = getCoordinateOf(cell1);
        Coordinate coordinate2 = getCoordinateOf(cell2);

        return coordinate1.distanceFrom(coordinate2);
    }

    private Coordinate getCoordinateOf(LabyrinthCell cell){
        for(int i = 0; i < rowCount; ++i)
            for(int j = 0; j < columnCount; ++j)
                if(cells.get(i).get(j) == cell)
                    return new Coordinate(j, i);
        throw new RuntimeException("No such cell exists in labyrinth");
    }
}
