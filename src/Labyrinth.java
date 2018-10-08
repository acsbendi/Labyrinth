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
}
