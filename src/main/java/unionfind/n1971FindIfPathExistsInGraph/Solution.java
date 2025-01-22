package unionfind.n1971FindIfPathExistsInGraph;

class Solution {
 public boolean validPath(int n, int[][] edges, int source, int destination) {
  UnionFind uf =  new UnionFind(n);
  for(int[] edge : edges){
   uf.union(edge[0], edge[1]);
  }
  return uf.find(source) == uf.find(destination);
 }

 static class UnionFind{
  int[] parent;

  UnionFind(int n){
   parent = new int[n];
   for(int i =0; i < n; i++){
    parent[i]=i;
   }
  }


  void union(int left, int right){
   int lParent = find(left);
   int rParent = find(right);

   if(lParent != rParent){
    parent[lParent] = rParent;
   }

  }

  int find(int node){
   if(node != parent[node]){
    parent[node]= find(parent[node]);
   }
   return parent[node];
  }

 }
}