public class Main {

    public static void main(String[] args) {
        InputParser inputParser = new InputParser();
        inputParser.parseInput();
        LabyrinthBuilder labyrinthBuilder = new LabyrinthBuilder();
        Labyrinth labyrinth = labyrinthBuilder.buildLabyrinth(inputParser.getCells());
        Agent agent = labyrinth.createNewAgent(inputParser.getNumberOfThings());
        agent.solve();
    }
}
