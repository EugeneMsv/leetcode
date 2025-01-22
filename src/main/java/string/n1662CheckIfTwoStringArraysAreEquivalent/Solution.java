package string.n1662CheckIfTwoStringArraysAreEquivalent;

class Solution {
 public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
  StringBuilder one = new StringBuilder();
  for(String word: word1){
   one.append(word);
  }

  StringBuilder two = new StringBuilder();
  for(String word: word2){
   two.append(word);
  }
  return one.toString().equals(two.toString());
 }
}