import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class InputParser {

    private List<List<Cell>> cells = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int numberOfThings;

    void parseInput(){
        while(scanner.hasNext()){
            readLine();
        }
        scanner.close();
    }

    private void readLine(){
        String[] stringRowData = scanner.nextLine().split(" ");

        int[] intRowData = Arrays.stream(stringRowData).mapToInt(Integer::parseInt).toArray();
        if(intRowData.length == 1)
            numberOfThings = intRowData[0];
        else
            fillRow(intRowData);
    }

    private void fillRow(int[] rowData){
        List<Cell> row = new ArrayList<>();
        for (int cellDescription: rowData) {
            row.add(createCell(cellDescription));
        }
        cells.add(row);
    }

    private Cell createCell(int description){
        Cell cell = new Cell();
        cell.hasNorthWall = description % 2 == 1;
        cell.hasEastWall = description % 4 >= 2;
        cell.hasSouthWall = description % 8 >= 4;
        cell.hasWestWall = description % 16 >= 8;
        cell.hasThing = description % 32 >= 16;
        return cell;
    }

    int getNumberOfThings(){
        return numberOfThings;
    }

    List<List<Cell>> getCells(){
        return cells;
    }
}
