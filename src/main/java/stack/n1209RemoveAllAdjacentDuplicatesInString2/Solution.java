package stack.n1209RemoveAllAdjacentDuplicatesInString2;

class Solution {
 public String removeDuplicates(String s, int k) {
  Node dummy =  new Node('-');

  Node prevNode = new Node(s.charAt(0));
  dummy.next = prevNode;
  prevNode.prev=  dummy;

  for(int i =1; i < s.length(); i++){
   char c = s.charAt(i);
   if(prevNode.c == c){
    prevNode.increment();
   } else{
    Node newNode =  new Node(c);
    prevNode.next = newNode;
    newNode.prev=prevNode;
    prevNode = newNode;
   }
  }


  int changed =0;
  do{
   changed =0;
   Node node =  dummy.next;
   while(node != null){
    if(node.count % k !=0){
     changed+= node.count > k ? 1 :0;
     node.count= node.count % k;
     node = node.next;
    }else {
     changed++;
     Node prev=  node.prev;
     Node next = node.next;
     if(next==null){
      prev.next =null;
      node =null;
     }else{
      if(prev.merge(next)){
       next = next.next;
       prev.next = next;
       if(next !=null){
        next.prev= prev;
       }
       node = prev;
      }else{
       prev.next= next;
       next.prev=prev;
       node = next;
      }
     }
    }

   }


  } while(changed >0);

  return makeResult(dummy);

 }

 String makeResult(Node dummy){
  Node node = dummy.next;
  StringBuilder sb=  new StringBuilder();
  while(node != null){
   sb.append(node.toFlat());
   node = node.next;
  }

  return sb.toString();
 }

 static class Node{
  final char c;
  int count;
  Node prev;
  Node next;


  Node(char c){
   this.c = c;
   this.count = 1;
  }

  void increment(){
   this.count+=1;
  }

  boolean merge(final Node node){
   if(node.c == c){
    count+=node.count;
    return true;
   }
   return false;
  }


  public String toFlat(){
   StringBuilder sb = new StringBuilder();
   for(int i =0; i < count; i++){
    sb.append(c);
   }
   return sb.toString();
  }

 }
}
