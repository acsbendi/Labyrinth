import java.util.ArrayList;
import java.util.List;

class MoveController {
    private Node rootNode;
    private Node currentNode;

    MoveController(LabyrinthCell rootCell){
        this.rootNode = new Node(rootCell, null);
        this.currentNode = rootNode;
    }

    LabyrinthCell getNextMove(DistanceComparator distanceComparator){
        List<Node> children = currentNode.generateChildren();


        List<LabyrinthCell> leaves = new ArrayList<>();
        rootNode.insertLeavesInto(leaves);
        leaves.sort(distanceComparator);
    }

    void refresh(LabyrinthCell newRoot){
        rootNode = new Node(newRoot, null);
    }
}
