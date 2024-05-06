package tree.n427ConstructQuadTree;

import java.util.function.Function;

class Solution {

  // Definition for a QuadTree node.
  class Node {

    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
      this.val = false;
      this.isLeaf = false;
      this.topLeft = null;
      this.topRight = null;
      this.bottomLeft = null;
      this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
      this.val = val;
      this.isLeaf = isLeaf;
      this.topLeft = null;
      this.topRight = null;
      this.bottomLeft = null;
      this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft,
        Node bottomRight) {
      this.val = val;
      this.isLeaf = isLeaf;
      this.topLeft = topLeft;
      this.topRight = topRight;
      this.bottomLeft = bottomLeft;
      this.bottomRight = bottomRight;
    }
  }

  public Node construct(int[][] grid) {
    return build(grid, 0, 0, grid.length);
  }

  private Node build(int[][] grid, int startX, int startY, int size) {

    if (size == 1) {
      return new Node(grid[startX][startY] == 1, true);
    }
    int newSize = size / 2;
    Node topL = build(grid, startX, startY, newSize);
    Node topR = build(grid, startX, startY + newSize, newSize);
    Node bottomL = build(grid, startX + newSize, startY, newSize);
    Node bottomR = build(grid, startX + newSize, startY + newSize, newSize);

    if (topL.isLeaf && topR.isLeaf && bottomL.isLeaf && bottomR.isLeaf) {
      Function<Node, Integer> counter = node -> node.val ? 1 : 0;
      int count = 0;
      count += counter.apply(topL);
      count += counter.apply(topR);
      count += counter.apply(bottomL);
      count += counter.apply(bottomR);

      if (count == 0 || count == 4) {
        return new Node(count == 4, true);
      }
    }

    return new Node(false, false, topL, topR, bottomL, bottomR);

  }
}
