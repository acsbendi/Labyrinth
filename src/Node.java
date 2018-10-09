import java.util.ArrayList;
import java.util.List;

class Node {
    private Node parent;
    private List<Node> children;
    private LabyrinthCell representedCell;

    Node(LabyrinthCell cell, Node parent){
        this.representedCell = cell;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    void addChild(Node newChild){
        children.add(newChild);
    }

    void insertLeavesInto(List<LabyrinthCell> leaves){
        if(children.size() > 0) {
            for (Node child: children
                 ) {
                child.insertLeavesInto(leaves);
            }
        } else
            leaves.add(representedCell);
    }
}
