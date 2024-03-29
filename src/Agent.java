import java.util.ArrayList;
import java.util.List;

class Agent {

    private List<Thing> things = new ArrayList<>();
    private LabyrinthCell currentCell;
    private int remainingNumberOfThings;
    private Labyrinth labyrinth;
    private MoveController moveController;
    private LabyrinthCell currentDestination;

    Agent(LabyrinthCell startingCell, int startingNumberOfThings, Labyrinth labyrinth){
        this.currentCell = startingCell;
        this.remainingNumberOfThings = startingNumberOfThings;
        this.labyrinth = labyrinth;
        this.moveController = new MoveController(startingCell);
    }

    void solve(){
        findNewDestination();
        collectAllThings();
        escape();
    }

    private void collectAllThings(){
        while(remainingNumberOfThings > 0){
            move();
        }
    }

    private void escape(){
        currentDestination = labyrinth.getExit();
        while (!labyrinth.isExit(currentCell)){
            move();
        }
    }

    private void move(){
        LabyrinthCell newCell =
                moveController.getNextMove(new DistanceComparator(labyrinth, currentCell, currentDestination));
        newCell.accept(this);
    }

    private void findNewDestination(){
        Thing thing = labyrinth.getNearestThingTo(currentCell);
        currentDestination = thing.getLocation();
        moveController.refresh(currentCell);
    }

    void receive(Thing thing){
        things.add(thing);
        thing.onPickedUp();
        System.out.println("felvesz");
        remainingNumberOfThings--;
        findNewDestination();
    }

    void arriveAt(LabyrinthCell cell){
        currentCell = cell;
    }
}
