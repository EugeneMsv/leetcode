package math.n1491AverageSalaryExcludingTheMinimumAndMaximumSalary;

class Solution {

  public double average(int[] salary) {
    int count = salary.length - 2;
    int sum = 0;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int num : salary) {
      min = Math.min(min, num);
      max = Math.max(max, num);
      sum += num;
    }
    sum -= min;
    sum -= max;
    return (double) sum / count;
  }
}
