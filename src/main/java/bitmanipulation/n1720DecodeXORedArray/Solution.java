package bitmanipulation.n1720DecodeXORedArray;

public class Solution {

  public int[] decode(int[] encoded, int first) {
    int[] decoded = new int[encoded.length + 1];
    decoded[0] = first;

    for (int i = 0; i < encoded.length; i++) {
      decoded[i + 1] = encoded[i] ^ decoded[i];
    }
    return decoded;
  }
}
