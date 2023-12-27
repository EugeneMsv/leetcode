package graph.n417PacificAtlanticWaterFlow;

import java.util.LinkedList;
import java.util.List;

public class Solution {

  private static final int EMPTY = 0;
  private static final int PACIFIC = 1;
  private static final int ATLANTIC = 2;
  private static final int BOTH = 3;

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    int[][] flows = new int[heights.length][heights[0].length];

    // Rows
    for (int column = 0; column < heights[0].length; column++) {
      // System.out.println("First row PACIFIC");
      markOcean(flows, heights, 0, column, PACIFIC, Integer.MIN_VALUE);
      //  System.out.println("Last row ATLANTIC");
      markOcean(flows, heights, heights.length - 1, column, ATLANTIC, Integer.MIN_VALUE);
    }

    // Columns
    for (int row = 0; row < heights.length; row++) {
      // System.out.println("First column PACIFIC");
      markOcean(flows, heights, row, 0, PACIFIC, Integer.MIN_VALUE);
      // System.out.println("Last column ATLANTIC");
      markOcean(flows, heights, row, heights[row].length - 1, ATLANTIC, Integer.MIN_VALUE);
    }
    List<List<Integer>> result = new LinkedList<>();

    // for(int i = 0; i < heights.length; i++){
    //     for(int j = 0; j < heights[i].length; j++){
    //         String row = heights[i][j]+" ";
    //         System.out.print(row.length() ==3 ? row : row+" ");
    //     }
    //     System.out.println();
    // }

    System.out.println();
    for (int i = 0; i < flows.length; i++) {
      for (int j = 0; j < flows[i].length; j++) {
        // System.out.print(flows[i][j]+"  ");
        if (flows[i][j] == BOTH) {
          result.add(List.of(i, j));
        }
      }
      // System.out.println();
    }
    return result;
  }

  private void markOcean(int[][] flows, int[][] heights, int x, int y, int ocean,
      int parentHeight) {
    // System.out.println("Calculating "+ x+" "+y);
    if (x < 0 || y < 0
        || x >= heights.length || y >= heights[x].length) {
      //  System.out.println("Out of borders for "+ x+" "+y);
      return;
    }

    int height = heights[x][y];
    if (parentHeight > height) {
      return;
    }
    if (flows[x][y] == ocean || flows[x][y] == BOTH) {
      // System.out.println("Prevents recursion for "+ x+" "+y);
      return;
    }

    if (flows[x][y] == EMPTY) {
      flows[x][y] = ocean;
    } else if (flows[x][y] != ocean) {
      flows[x][y] = BOTH;
    }

    // for(int i = 0; i < flows.length; i++){
    //     for(int j = 0; j < flows[i].length; j++){
    //         System.out.print(flows[i][j]+" ");
    //     }
    //     System.out.println();
    // }

    markOcean(flows, heights, x - 1, y, ocean, height);
    markOcean(flows, heights, x + 1, y, ocean, height);
    markOcean(flows, heights, x, y - 1, ocean, height);
    markOcean(flows, heights, x, y + 1, ocean, height);
  }

}
