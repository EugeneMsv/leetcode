package array.n238ProductOfArrayExceptSelf;

public class Solution2 {

  public int[] productExceptSelf(int[] nums) {
    int[] frequency = new int[61];

    for (int num : nums) {
      frequency[num + 30] += 1;
    }
    //print(frequency);
    int[] products = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      products[i] = calcProduct(num, frequency);
    }
    return products;
  }

  private void print(int[] frequency) {
    for (int i = 0; i < frequency.length; i++) {
      if (frequency[i] != 0) {
        System.out.print(i - 30 + "->[" + frequency[i] + "], ");
      }
    }
  }

  private int calcProduct(int num, int[] frequency) {
    int product = 1;
    for (int j = 0; j < frequency.length; j++) {
      int count = frequency[j];
      int realNum = j - 30;
      if (num == realNum) {
        if (count == 1) {
          continue;
        }
        product *= (int) Math.pow(realNum, count - 1);
      } else if (count >= 1) {
        product *= (int) Math.pow(realNum, count);
      }
    }
    return product;
  }
}
