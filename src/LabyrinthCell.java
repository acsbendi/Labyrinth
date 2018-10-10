import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;

class LabyrinthCell {

    private Coordinate location;
    private EnumMap<Direction, LabyrinthCell> neighbors = new EnumMap<>(Direction.class);
    private Thing thing = null;

    LabyrinthCell(Coordinate location){
        this.location = location;
    }

    void setThing(Thing thing){
        this.thing = thing;
    }

    void setNeighbor(Direction direction, LabyrinthCell neighbor){
        neighbors.put(direction, neighbor);
    }

    void accept(Agent agent){
        System.out.println(location.yCoordinate + " " + location.xCoordinate);
        agent.arriveAt(this);
        if(thing != null){
            agent.receive(thing);
            thing = null;
        }
    }

    List<LabyrinthCell> getNeighbors(){
        return new ArrayList<>(neighbors.values());
    }
}
