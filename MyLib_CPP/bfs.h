#include <bits/stdc++.h>
using namespace std;
vector <int> adj[100000];                                            //vector to implement graph using adjacency lists (size can vary a/c to need)
bool mark[100000];                                                   //array to keep record of visited nodes
void bfs(int s)
{
    queue <int> q;                                                   // Create a queue for BFS
    mark[s] = true;                                                  // Mark the current node as visited and enqueue it
    q.push(s);
                              
    while(!q.empty())
    {
        s = q.front();                                               // Dequeue a vertex from queue and print it
        cout << s+1 << " ";
        q.pop();
        // Get all adjacent vertices of the dequeued vertex s
        // If a adjacent has not been visited, then mark it visited
        // and enqueue it
        for(int i = 0; i < adj[s].size(); ++i)
        {
            if(!mark[adj[s][i]])
            {
                mark[adj[s][i]] = true;
                q.push(adj[s][i]);
            }
        }
    }
}

