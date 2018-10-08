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
            collectThing();
        }
    }

    private void collectThing(){
        if(currentCell.hasThing()){
            things.add(currentCell.removeThing());
            remainingNumberOfThings--;
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
}