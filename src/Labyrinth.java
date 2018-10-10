import java.util.List;
import java.util.stream.Collectors;

class Labyrinth {

    private List<List<LabyrinthCell>> cells;
    private List<Thing> things;
    private int rowCount;
    private int columnCount;

    Labyrinth(List<List<LabyrinthCell>> cells, List<Thing> things){
        this.cells = cells;
        this.rowCount = cells.size();
        this.columnCount = cells.get(0).size();
        this.things = things;
    }

    Agent createNewAgent(int numberOfThings){
        return new Agent(cells.get(0).get(0), numberOfThings, this);
    }

    boolean isExit(LabyrinthCell cell){
        return cells.get(rowCount - 1).get(columnCount - 1) == cell;
    }

    Thing getNearestThingTo(LabyrinthCell base) {
        List<Thing> sortedThings = things.stream()
                .sorted(new ThingDistanceComparator(this, base))
                .collect(Collectors.toList());

        return sortedThings.get(0);
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
