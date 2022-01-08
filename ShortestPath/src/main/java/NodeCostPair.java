public class NodeCostPair {
    public Node node;
    public Arc arc;
    public int cost;

    public NodeCostPair(Node node, Arc arc) {
        this.node = node;
        this.arc = arc;
        this.cost = arc.getLength();
    }

    public NodeCostPair(Node node, Integer cost) {
        this.node = node;
        this.cost = cost;
    }

    public Node getNode() {
        return node;
    }

    public int getCost() {
        return cost;
    }

    public void setNode(Node newNode) {
        node = newNode;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Arc getArc() {
        return this.arc;
    }
}
