package string.n929UniqueEmailAddresses;

import java.util.HashSet;
import java.util.Set;

class Solution {
 public int numUniqueEmails(String[] emails) {

  Set<String> emailsSet = new HashSet<>();

  for(String rawEmail : emails){
   String[] separated =  rawEmail.split("@");
   String rawLocalName = separated[0];
   String domainName = separated[1];
   StringBuilder localName = new StringBuilder();
   for(char c: rawLocalName.toCharArray()){
    if(c == '.'){
     continue;
    }
    if(c == '+'){
     break;
    }
    localName.append(String.valueOf(c));
   }
   emailsSet.add(localName.toString()+"@"+domainName);
  }

  return emailsSet.size();
 }
}
