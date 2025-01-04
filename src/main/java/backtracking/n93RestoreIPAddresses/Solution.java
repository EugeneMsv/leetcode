package backtracking.n93RestoreIPAddresses;

import java.util.LinkedList;
import java.util.List;

class Solution {
 public List<String> restoreIpAddresses(String s) {
  List<String> strings =  new LinkedList<>();
  backtrack(strings, new StringBuilder(s), 1, 3);

  return strings;
 }

 private void backtrack(List<String> result, StringBuilder candidate, int start, int dotsLeft){
  if(dotsLeft == 0 ){

   for(String num : candidate.toString().split("\\.")){
    Long parseNum =  Long.parseLong(num);

    if((num.length()>1L && num.startsWith("0") )
        || parseNum > 255L){
     return;
    }
   }
   result.add(candidate.toString());
   return;
  }


  for(int i = start; i< Math.min(start+3, candidate.length()); i++){

   candidate.insert(i,".");
   backtrack(result, candidate, i+2, dotsLeft-1);
   candidate.deleteCharAt(i);
  }

 }
}