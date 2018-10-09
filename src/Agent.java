import java.util.List;

class Agent {

    private List<Thing> things;
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
        collectAllThings();
        escape();
    }

    private void collectAllThings(){
        while(remainingNumberOfThings > 0){
            tryCollectThing();
        }
    }

    private void tryCollectThing(){
        if(currentCell.hasThing()){
           collectThing();
        } else{
            move();
        }
    }

    private void escape(){
        while (labyrinth.isExit(currentCell)){
            move();
        }
    }

    private void move(){

    }

    private void collectThing(){
        things.add(currentCell.removeThing());
        remainingNumberOfThings--;
        findNewDestination();
    }

    private void findNewDestination(){
        currentDestination = labyrinth.getNearestThingTo(currentCell);
        moveController.refresh(currentDestination);
    }
}
