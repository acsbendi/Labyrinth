import java.util.EnumMap;
import java.util.List;

class LabyrinthCell {

    private EnumMap<Direction, LabyrinthCell> neighbors = new EnumMap<Direction, LabyrinthCell>(Direction.class);
    private Thing thing = null;

    void setThing(Thing thing){
        this.thing = thing;
    }

    void setNeighbor(Direction direction, LabyrinthCell neighbor){
        neighbors.put(direction, neighbor);
    }

    Thing removeThing(){
        Thing thingToRemove = thing;
        thing = null;
        return thingToRemove;
    }

    boolean hasThing(){
        return thing == null;
    }

    List<LabyrinthCell> getNeighbors()
}
