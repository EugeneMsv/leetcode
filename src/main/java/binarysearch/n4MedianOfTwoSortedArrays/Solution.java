package binarysearch.n4MedianOfTwoSortedArrays;

class Solution {
 public double findMedianSortedArrays(int[] n, int[] m) {
  int l = n.length + m.length;

  // Calculate the indices for median
  int m1 = l % 2 == 1 ? l / 2 : (l / 2) - 1;
  int m2 = l % 2 == 1 ? m1 : m1 + 1;

  // Edge cases when one of the arrays is empty
  if (n.length == 0) {
   return (double) (m[m1] + m[m2]) / 2;
  }
  if (m.length == 0) {
   return (double) (n[m1] + n[m2]) / 2;
  }

  // Merge arrays to find the median
  int nIdx = 0;
  int mIdx = 0;
  int count = 0;
  int last = 0;
  int secondLast = 0;

  while (count <= m2) {
   secondLast = last;

   if (nIdx < n.length && (mIdx >= m.length || n[nIdx] <= m[mIdx])) {
    last = n[nIdx];
    nIdx++;
   } else {
    last = m[mIdx];
    mIdx++;
   }

   count++;
  }

  if (l % 2 == 1) {
   return (double) last;
  } else {
   return (double) (last + secondLast) / 2;
  }
 }
}

