package slidingwindow.n3258CountSubstringsThatSatisfyKConstraint1;

class Solution {
  public int countKConstraintSubstrings(String s, int k) {

    int length = 1;
    int result =0;
    int[] counter = new int[2];

    while(length <=s.length()){
      counter[0]=0;
      counter[1]=0;
      int zeros = 0;
      int ones = 0;
      for(int i =0; i < length; i++){
        counter[s.charAt(i) == '0' ? 0 :1] += 1;
      }

      if(counter[0] <=k ||  counter[1] <= k){
        result++;
      }

      for(int begin = 1; begin + length -1 < s.length(); begin++){
        counter[s.charAt(begin-1) == '0' ? 0 :1] -= 1;
        counter[s.charAt(begin + length-1) == '0' ? 0 :1] += 1;

        if(counter[0] <=k ||  counter[1] <= k){
          result++;
        }
      }

      length++;

    }

    return result;
  }
}