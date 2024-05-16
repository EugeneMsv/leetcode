package bitmanipulation.n393UTF8Validation;

class Solution {

  enum UTFCase {
    BYTE_1(7, 0, 0),
    BYTE_2(5, 6, 1),
    BYTE_3(4, 14, 2),
    BYTE_4(3, 30, 3),
    FOLLOWER(6, 2, -1);

    final int shift;
    final int expected;
    final int bytesLeft;

    UTFCase(int shift, int expected, int bytesLeft){
      this.shift = shift;
      this.expected = expected;
      this.bytesLeft= bytesLeft;
    }

  }

  public boolean validUtf8(int[] data) {


    UTFCase activeCase = getCase(data[0]);
    if(activeCase == null || activeCase == UTFCase.FOLLOWER){
      return false;
    }

    int bytesLeft = activeCase.bytesLeft;

    for(int i = 1; i < data.length; i++){
      UTFCase newCase = getCase(data[i]);
      if(newCase == null){
        return false;
      }
      if(bytesLeft == 0){
        if(newCase==UTFCase.FOLLOWER){
          return false;
        }
        activeCase = newCase;
        bytesLeft = newCase.bytesLeft;
      } else {
        if(newCase!=UTFCase.FOLLOWER){
          return false;
        }
        bytesLeft--;
      }
    }

    return bytesLeft == 0;
  }


  private UTFCase getCase(int value){

    for(UTFCase c: UTFCase.values()){
      if((value >> c.shift) == c.expected){
        return c;
      }
    }

    return null;
  }


}