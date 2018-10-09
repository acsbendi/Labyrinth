import java.util.Comparator;

public class DistanceComparator implements Comparator<LabyrinthCell> {

    private Labyrinth labyrinth;
    private LabyrinthCell current;
    private LabyrinthCell destination;

    DistanceComparator(Labyrinth labyrinth, LabyrinthCell current, LabyrinthCell destination){
        this.current = current;
        this.destination = destination;
        this.labyrinth = labyrinth;
    }

    @Override
    public int compare(LabyrinthCell o1, LabyrinthCell o2) {
        int totalDistance1 = calculateDistanceThrough(o1);
        int totalDistance2 = calculateDistanceThrough(o2);

        return totalDistance1 - totalDistance2;
    }

    private int calculateDistanceThrough(LabyrinthCell cell){
        int distanceFromCurrentToCell = labyrinth.getDistanceBetween(current, cell);
        int distanceFromCellToDestination = labyrinth.getDistanceBetween(cell, destination);

        return distanceFromCurrentToCell + distanceFromCellToDestination;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
