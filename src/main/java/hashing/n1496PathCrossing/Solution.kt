package hashing.n1496PathCrossing


class Solution {
 fun isPathCrossing(path: String): Boolean {
  var points = mutableSetOf<String>("0;0")

  var x = 0
  var y = 0

  for ( direction in path){
   y+= if (direction == 'N') 1 else if (direction == 'S') -1 else 0
   x+= if (direction == 'E') 1 else if (direction == 'W') -1 else 0
   var point = "$x;$y"
   if(points.contains(point)){
    return true
   } else {
    points.add(point)
   }
  }
  return false;
 }
}