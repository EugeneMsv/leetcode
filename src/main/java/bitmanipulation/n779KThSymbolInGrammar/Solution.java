package bitmanipulation.n779KThSymbolInGrammar;

class Solution {
 public int kthGrammar(int n, int k) {
  return getBit(k);
 }

 private int getBit(int position){
  if(position ==1){
   return 0;
  }
  if(position ==2){
   return 1;
  }

  int parentPosition =  position/2 + ((position % 2 == 0) ? 0 : 1);
  int parentBit = getBit(parentPosition);
  if(parentBit ==0){
   return position % 2 == 0 ? 1 : 0;
  }else {
   return position % 2 == 0 ? 0 : 1;
  }
 }
}
