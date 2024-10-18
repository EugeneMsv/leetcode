package array.n1422MaximumScoreAfterSplittingAString


class Solution {
    fun maxScore(s: String): Int {

        var right = 0

        for (c in s) {
            right += if (c == '1') 1 else 0
        }


        var left = 0;
        var max = Int.MIN_VALUE

        var i = 0
        for (c in s) {
            if (i == s.length - 1) {
                break
            }
            left += if (c == '0') 1 else 0
            right -= if (c == '1') 1 else 0
            max = maxOf(left + right, max)
            i++
        }

        return max
    }
}