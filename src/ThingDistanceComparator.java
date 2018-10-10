import java.util.Comparator;

public class ThingDistanceComparator implements Comparator<Thing> {

    private Labyrinth labyrinth;
    private LabyrinthCell base;

    ThingDistanceComparator(Labyrinth labyrinth, LabyrinthCell base){
        this.base = base;
        this.labyrinth = labyrinth;
    }

    @Override
    public int compare(Thing o1, Thing o2) {
        int distance1 = o1.getDistanceFrom(base, labyrinth);
        int distance2 = o2.getDistanceFrom(base, labyrinth);

        return distance1 - distance2;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
