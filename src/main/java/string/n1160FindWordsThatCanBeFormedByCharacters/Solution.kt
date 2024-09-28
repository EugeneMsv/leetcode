package string.n1160FindWordsThatCanBeFormedByCharacters


class Solution {
 fun countCharacters(words: Array<String>, str: String): Int {
  val chars =  mutableMapOf<Char, Int>()

  for(char in str){
   chars[char] = (chars[char] ?: 0) + 1
  }

  var sum : Int = 0
  for(word in words){
   val freq = chars.toMutableMap()
   var length: Int = word.length
   for(char in word){
    if(freq[char] == null || freq[char] == 0){
     length =0
     break
    }
    freq[char] = freq[char]!!-1
   }
   sum+=length
  }

  return sum
 }
}