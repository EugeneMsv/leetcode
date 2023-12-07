package graph.n733FloodFill;

public class Solution {

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int colorToChange = image[sr][sc];
    dfs(image, sr, sc, colorToChange, newColor);
    return image;
  }

  void dfs(int[][] image, int i, int j, int colorToChange, int newColor) {

    if (i < 0 || j < 0 || i >= image.length || j >= image[i].length
        || image[i][j] != colorToChange
        || image[i][j] == newColor) {
      return;
    }
    image[i][j] = newColor;
    dfs(image, i + 1, j, colorToChange, newColor);
    dfs(image, i - 1, j, colorToChange, newColor);
    dfs(image, i, j + 1, colorToChange, newColor);
    dfs(image, i, j - 1, colorToChange, newColor);
  }
}
