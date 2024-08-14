package math.n860LemonadeChange;

class Solution {

  public boolean lemonadeChange(int[] bills) {
    int fives = 0;
    int tens = 0;


    for (int cash : bills) {
      if (cash == 5) {
        fives++;
        continue;
      }
      if (cash == 10) {
        if (fives > 0) {
          fives--;
          tens++;
        } else {
          return false;
        }
      }
      if (cash == 20) {
        if (tens > 0) {
          tens--;
          if (fives > 0) {
            fives--;
          } else {
            return false;
          }
        } else if (fives > 2) {
          fives -= 3;
        } else {
          return false;
        }
      }
    }
    return true;
  }
}
