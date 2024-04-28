package graph.n133CloneGraph;

import java.util.ArrayList;
import java.util.List;

class Solution {

  class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }

  public Node cloneGraph(Node node) {

    if (node == null) {
      return null;
    }
    Node[] cloned = new Node[101];
    Node root = new Node(node.val);

    dfs(cloned, root, node);

    return root;
  }

  private void dfs(Node[] cloned, Node clone, Node node) {
    if (node == null) {
      return;
    }
    clone.val = node.val;
    cloned[node.val] = clone;

    for (Node n : node.neighbors) {
      Node childClone = cloned[n.val];
      if (childClone == null) {
        childClone = new Node();
        dfs(cloned, childClone, n);
      }

      clone.neighbors.add(childClone);
    }
  }
}
