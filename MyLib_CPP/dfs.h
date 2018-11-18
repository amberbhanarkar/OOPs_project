#include<bits/stdc++.h>
using namespace std;
#define N 100
int visited[N];
void dfs(vector<int> graph[], int node) {
  if(visited[node] == 1)
    return;
  // Else
  visited[node]=1;
  cout<<node<<" ";
  for(int i=0;i<graph[node].size();i++) {
    dfs(graph, graph[node][i]);
  }
}
void initialize() {
  for(int i=1;i<=5;i++)
    visited[i]=0;
}
void dfs_iterative(vector<int> graph[], int node){
  stack<int> stack_dfs;
  stack_dfs.push(node);
  visited[node] = 1;
  int cur_node;
  while(!stack_dfs.empty()){
    cur_node = stack_dfs.top();
    stack_dfs.pop();
    cout<<cur_node<<" ";
    for(int i = 0; i<graph[cur_node].size(); i++){
      if(visited[graph[cur_node][i]] == 0){
        visited[graph[cur_node][i]] = 1;
        stack_dfs.push(graph[cur_node][i]);
      }
    }
  } 
}

