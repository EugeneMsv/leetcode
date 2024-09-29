package hashing.n1436DestinationCity


class Solution {
 fun destCity(paths: List<List<String>>): String {
  val map =  hashMapOf<String,Int>()

  for( path in paths){
   map[path[0]]= (map[path[0]] ?: 0) +1
   map[path[1]]= (map[path[1]] ?: 0)
  }

  for((city, destinations) in map){
   if(destinations == 0){
    return city
   }
  }
  return ""
 }
}