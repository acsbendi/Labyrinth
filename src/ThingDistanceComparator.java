import java.util.Comparator;

public class ThingDistanceComparator implements Comparator<LabyrinthCell> {

    private Labyrinth labyrinth;
    private LabyrinthCell base;

    ThingDistanceComparator(Labyrinth labyrinth, LabyrinthCell base){
        this.base = base;
        this.labyrinth = labyrinth;
    }


    @Override
    public int compare(LabyrinthCell o1, LabyrinthCell o2) {
        int distanceFromBase1 = labyrinth.getDistanceBetween(base, o1);
        int distanceFromBase2 = labyrinth.getDistanceBetween(base, o2);

        return distanceFromBase1 - distanceFromBase2;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
