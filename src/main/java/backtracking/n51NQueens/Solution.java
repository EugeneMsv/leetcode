package backtracking.n51NQueens;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
 public List<List<String>> solveNQueens(int n) {
  List<List<String>> result = new LinkedList<>();

  backtrack(result, new int[n][n], 0, n);
  return result;
 }

 private void backtrack(List<List<String>> solutions, int[][] candidate, int queenNum, int n ){
  if(queenNum == n){
   solutions.add(buildSolution(candidate));
   return;
  }
  for(int column =0; column < candidate.length; column++){
   if(candidate[queenNum][column] ==0){
    candidate[queenNum][column] = 1;
    // left diagonal
    int dRow = queenNum +1;
    int dColumn = column -1;
    while(dRow < candidate.length && dColumn >=0){
     candidate[dRow][dColumn] -= 1;
     dRow++;
     dColumn--;
    }
    // right diagonal
    dRow = queenNum +1;
    dColumn = column + 1;
    while(dRow < candidate.length && dColumn < candidate[dRow].length){
     candidate[dRow][dColumn] -= 1;
     dRow++;
     dColumn++;
    }

    // column
    for(int row = queenNum + 1; row < candidate.length; row++){
     candidate[row][column] -= 1;
    }

    backtrack(solutions, candidate, queenNum+1, n);

    // erase left diagonal
    dRow = queenNum +1;
    dColumn = column -1;
    while(dRow < candidate.length && dColumn >=0){
     candidate[dRow][dColumn] += 1;
     dRow++;
     dColumn--;
    }

    // right diagonal
    dRow = queenNum +1;
    dColumn = column + 1;
    while(dRow < candidate.length && dColumn < candidate[dRow].length){
     candidate[dRow][dColumn] += 1;
     dRow++;
     dColumn++;
    }

    // erase column
    for(int row = queenNum + 1; row < candidate.length; row++){
     candidate[row][column] += 1;
    }
    candidate[queenNum][column] = 0;
   }
  }


 }


 private List<String> buildSolution(int[][] candidate){
  List<String> result =  new ArrayList<>(candidate.length);
  for(int i =0; i < candidate.length; i++){
   StringBuilder row = new StringBuilder();
   for(int j =0; j < candidate[i].length; j++){
    row.append(candidate[i][j] == 1 ? "Q" : ".");
   }
   result.add(row.toString());
  }
  return result;
 }

}