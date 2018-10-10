import java.util.Collection;
import java.util.EnumMap;

class LabyrinthCell {

    private EnumMap<Direction, LabyrinthCell> neighbors = new EnumMap<>(Direction.class);
    private Thing thing = null;

    void setThing(Thing thing){
        this.thing = thing;
    }

    void setNeighbor(Direction direction, LabyrinthCell neighbor){
        neighbors.put(direction, neighbor);
    }

    void accept(Agent agent){
        if(thing != null){
            agent.receive(thing);
            thing = null;
        }
        agent.arriveAt(this);
    }

    Collection<LabyrinthCell> getNeighbors(){
        return neighbors.values();
    }
}
