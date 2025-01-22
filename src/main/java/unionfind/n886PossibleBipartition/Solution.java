package unionfind.n886PossibleBipartition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

 class UnionFind {
  int[] parent;
  int[] rank;
  public UnionFind(int size){
   parent = new int[size];
   rank = new int[size];
   for(int i=0; i<size;i++){
    parent[i]=i;
   }
  }
  public int find(int x){
   if(parent[x] !=x){
    parent[x] = find(parent[x]);
   }
   return parent[x];
  }
  public void union(int x, int y){
   int parentX = find(x), parentY=find(y);
   if(parentX == parentY){
    return;
   }
   if (rank[parentX] > rank[parentY]) {
    parent[parentY] = parentX;
    rank[parentX] += rank[parentY];
   } else {
    parent[parentX] = parentY;
    rank[parentY] += rank[parentX];
   }
  }
 }
 public boolean possibleBipartition(int n, int[][] dislikes) {
  HashMap<Integer, List<Integer>> graph = new HashMap<>();
  for(int[] p : dislikes){
   graph.computeIfAbsent(p[0], value -> new ArrayList<Integer>()).add(p[1]);
   graph.computeIfAbsent(p[1], value -> new ArrayList<Integer>()).add(p[0]);
  }
  UnionFind dsu = new UnionFind(n+1);
  for(int i=1; i<=n; i++){
   if(!graph.containsKey(i)){
    continue;
   }
   for(int neighbour : graph.get(i)){

    if(dsu.find(i) == dsu.find(neighbour)){
     return false;
    }
    // All i dislikes should in the same union
    dsu.union(graph.get(i).get(0), neighbour);
   }
  }
  return true;
 }
}
