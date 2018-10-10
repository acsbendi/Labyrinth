import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Node {
    private Node parent;
    private List<Node> children;
    private LabyrinthCell cell;

    Node(LabyrinthCell cell, Node parent){
        this.cell = cell;
        this.parent = parent;
        this.children = new ArrayList<>();
        if(parent != null)
            parent.addChild(this);
    }

    private void addChild(Node newChild){
        children.add(newChild);
    }

    void removeContained(Collection<LabyrinthCell> cells){
        cells.remove(cell);
        for (Node node: children
             ) {
            node.removeContained(cells);
        }
    }

    Collection<LabyrinthCell> generateUnvisitedChildren(){
        Collection<LabyrinthCell> possibleChildren = cell.getNeighbors();
        removeContained(possibleChildren);
        return possibleChildren;
    }

    LabyrinthCell getCell(){
        return cell;
    }

    Node getParent(){
        return parent;
    }
}
