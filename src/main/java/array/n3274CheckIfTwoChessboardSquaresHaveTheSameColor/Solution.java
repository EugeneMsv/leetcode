package array.n3274CheckIfTwoChessboardSquaresHaveTheSameColor;

class Solution {
 public boolean checkTwoChessboards(String c1, String c2) {
  int x1 = c1.charAt(0) - 'a';
  int y1 = Integer.parseInt(c1.substring(1)) - 1;
  int x2 = c2.charAt(0) - 'a';
  int y2 = Integer.parseInt(c2.substring(1)) - 1;

  int r1 =  x1+y1;
  int r2 = x2+y2;

  return r1 % 2 ==0 ? r2 % 2 ==0 : r2 % 2 !=0;
 }
}
