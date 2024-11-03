package array.n838PushDominoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
 public String pushDominoes(String dominoes) {
  List<Entry<Character, Integer>> nodes = new ArrayList<>();
  char[] chars =  dominoes.toCharArray();
  for(int i = 0; i < chars.length; i++){
   char c = chars[i];
   if(c != '.' ){
    nodes.add(Map.entry(c, i));
   }
  }

  int begin = 0;
  int i =0;
  while(i < nodes.size()){
   Map.Entry<Character, Integer> leftEntry = nodes.get(i);
   char leftC = leftEntry.getKey();
   Integer leftIdx =  leftEntry.getValue();

   //Handle new interval

   if(leftC == 'L'){
    fillWith(chars, 'L', begin, leftIdx);
    begin=leftIdx+1;
    i++;
    continue;
   } else {

    // Last R
    if(i +1 >= nodes.size()){
     fillWith(chars, 'R', leftIdx, chars.length);
     i++;
     continue;
    }

    // Not last R
    Map.Entry<Character, Integer> rightEntry = nodes.get(i+1);
    char rightC = rightEntry.getKey();
    Integer rightIdx =  rightEntry.getValue();
    if(rightC == 'R'){
     // R.R
     fillWith(chars, 'R', leftIdx, rightIdx);
     begin=rightIdx+1;
     i++;
    } else {
     // R.L

     int rightDomino = leftIdx;
     int leftDomino = rightIdx;
     while(rightDomino < leftDomino){
      chars[rightDomino] ='R';
      chars[leftDomino] ='L';
      rightDomino++;
      leftDomino--;
     }
     begin=rightIdx+1;
     i++;
    }
   }

  }
  return new String(chars);
 }

 private void fillWith(char[] chars, char c, int from, int to){
  for(int j = from; j <to; j++){
   chars[j] = c;
  }
 }





}
