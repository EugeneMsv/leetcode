package string.n2264Largest3SameDigitNumberInString



class Solution {
 companion object {
  private val options = LinkedHashSet(listOf("000","111","222","333","444","555","666","777","888","999"))
 }
 fun largestGoodInteger(num: String): String {


  var result: String = ""
  for (element in options.reversed()) {
   if(num.contains(element)){
    result =  element
    break
   }
  }

  return result

 }
}