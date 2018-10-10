import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class MoveController {
    private Node rootNode;
    private Node currentNode;

    MoveController(LabyrinthCell rootCell){
        this.rootNode = new Node(rootCell, null);
        this.currentNode = rootNode;
    }

    LabyrinthCell getNextMove(DistanceComparator distanceComparator){
        List<LabyrinthCell> children = currentNode.generateUnvisitedChildren();
        rootNode.removeContained(children);

        if(children.size() > 0){
            List<LabyrinthCell> childrenList = new ArrayList<>(children);
            childrenList.sort(distanceComparator);
            LabyrinthCell nextCell = childrenList.get(0);
            currentNode = new Node(nextCell, currentNode);
            return nextCell;
        }

        currentNode = currentNode.getParent();
        return currentNode.getCell();
    }

    void refresh(LabyrinthCell newRoot){
        rootNode = new Node(newRoot, null);
        currentNode = rootNode;
    }
}
