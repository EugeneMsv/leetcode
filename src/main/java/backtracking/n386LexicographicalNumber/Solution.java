package backtracking.n386LexicographicalNumber;

import java.util.LinkedList;
import java.util.List;

class Solution {
 private static int max ;
 public List<Integer> lexicalOrder(int n) {
  max =n;
  List<Integer> result =  new LinkedList<>();
  dfs(result, 0);

  return result;
 }

 private void dfs(List<Integer> result, int num){
  if(num > max){
   return;
  }

  for(int i = num; i <= num + 9; i++){
   if(i > max){
    return;
   }
   if(i ==0){
    continue;
   }
   result.add(i);
   dfs(result, i*10);
  }
 }
}
