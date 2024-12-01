package dynamic2d.n1335MinimumDifficultyOfAJobSchedule;

class Solution {

 static final int MAX = 9_999_999;

 public int minDifficulty(int[] jobs, int d) {
  int n = jobs.length;
  if(d == 1){
   return n >=1? max(jobs, 0,n-1) : -1;
  }

  int[][][] dp = new int[n][n][d];

  for(int start = 0; start < dp.length; start++){
   for(int end = 0; end < dp[start].length; end++){
    for(int day = 0; day < dp[start][end].length; day++){
     dp[start][end][day] =  MAX;
    }
   }
  }


  for(int i = 0; i < n; i++){
   int difficulty = max(jobs, 0, i);
   if(difficulty >=0){
    dp[0][i][0] = difficulty;
   }
  }

  int result = MAX;
  for(int day = 1; day < d; day++){


   for(int start = day; start < n; start++){

    int prevMin = min(dp, start, day-1);
    for(int end = start; end < n; end++){
     dp[start][end][day] = prevMin+ max(jobs, start, end);


     if(day == d-1 && end == n-1){
      result =  Math.min(result, dp[start][end][day]);
     }
    }

   }
  }
  return result >= MAX ? -1 : result;
 }




 private int max(int[] jobs, int startInclusive, int end){
  int max =  -1;
  for(int i = startInclusive; i <= end; i++){
   max = Math.max(jobs[i], max);
  }

  return max <0 ? MAX : max;
 }

 private int min(int[][][] dp, int end, int day){
  int min =  MAX;
  for(int start = 0; start < end ; start++){
   min = Math.min(min, dp[start][end-1][day]);
  }
  return min;
 }
}
