package queue.n1700NumberOfStudentsUnableToEatLunch;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
 public int countStudents(int[] students, int[] sandwiches) {
  Queue<Integer> q= new LinkedList<>();
  for(int student : students){
   q.offer(student);
  }

  Queue<Integer> s= new LinkedList<>();
  for(int sandwich : sandwiches){
   s.offer(sandwich);
  }

  int cycleN= q.size();
  int matches =0;
  while(!q.isEmpty()){
   if(cycleN == 0){
    if (matches ==0){
     return q.size();
    } else {
     matches =0;
     cycleN = q.size();
    }
   }
   Integer student = q.poll();
   Integer sandwich = s.peek();

   if(student == sandwich){
    matches++;
    s.poll();
   }else{
    q.offer(student);
   }
   cycleN--;
  }

  return 0;
 }
}
