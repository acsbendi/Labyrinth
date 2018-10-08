import java.util.ArrayList;
import java.util.List;

class LabyrinthBuilder {

    private List<List<LabyrinthCell>> labyrinthCells;
    private List<List<Cell>> cells;
    private int rowCount;
    private int columnCount;

    Labyrinth buildLabyrinth(List<List<Cell>> cells){
        this.cells = cells;
        rowCount = cells.size();
        columnCount = cells.get(0).size();

        createLabyrinthCells();
        initializeLabyrinthCells();

        return new Labyrinth(labyrinthCells);
    }
    
    private void createLabyrinthCells(){
        labyrinthCells = new ArrayList<>();
        for (int i = 0; i < rowCount; ++i){
            labyrinthCells.add(new ArrayList<>());
            for(int j = 0; j < columnCount; ++j){
                labyrinthCells.get(i).add(new LabyrinthCell());
            }
        }
    }

    private void initializeLabyrinthCells(){
        for (int i = 0; i < rowCount; ++i){
            for(int j = 0; j < columnCount; ++j) {
                initializeLabyrinthCell(i, j);
            }
        }
    }

    private void initializeLabyrinthCell(int row, int column){
        LabyrinthCell labyrinthCell = labyrinthCells.get(row).get(column);
        Cell cell = cells.get(row).get(column);

        if(cell.hasThing){
            labyrinthCell.setThing(new Thing());
        }

        if(!cell.hasNorthWall && row > 0){
            labyrinthCell.setNeighbor(Direction.NORTH, labyrinthCells.get(row - 1).get(column));
        }

        if(!cell.hasEastWall && column < columnCount - 1){
            labyrinthCell.setNeighbor(Direction.EAST, labyrinthCells.get(row).get(column + 1));
        }

        if(!cell.hasSouthWall && row < rowCount - 1){
            labyrinthCell.setNeighbor(Direction.SOUTH, labyrinthCells.get(row + 1).get(column));
        }

        if(!cell.hasWestWall && column > 0){
            labyrinthCell.setNeighbor(Direction.WEST, labyrinthCells.get(row).get(column - 1));
        }
    }
}
