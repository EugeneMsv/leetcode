package array.n28FindTheIndexOfTheFirstOccurrenceInAString;

class Solution {
 public int strStr(String haystack, String needle) {

  for(int i =0; i <= haystack.length()- needle.length() ;i++){
   if(hasMatch(needle, haystack, i)){
    return i;
   }
  }


  return -1;
 }


 private boolean hasMatch(String source, String target, int targetOffset){
  int idx = 0;

  while(idx < source.length() && idx + targetOffset < target.length()){
   if(source.charAt(idx) != target.charAt(idx+ targetOffset)){
    return false;
   }
   idx++;
  }

  return idx == source.length();
 }
}
