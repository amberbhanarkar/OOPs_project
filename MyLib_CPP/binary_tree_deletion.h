#include <bits/stdc++.h> 
using namespace std; 
struct Node 
{ 
    int key; 
    struct Node* left, *right; 
}; 
struct Node* newNode(int key) 
{ 
    struct Node* temp = new Node; 
    temp->key = key; 
    temp->left = temp->right = NULL; 
    return temp; 
}; 
void inorder(struct Node* temp) 
{ 
    if (!temp) 
        return; 
    inorder(temp->left); 
    cout << temp->key << " "; 
    inorder(temp->right); 
} 
void deletDeepest(struct Node *root, 
                  struct Node *d_node) 
{ 
    queue<struct Node*> q; 
    q.push(root); 

    struct Node* temp; 
    while(!q.empty()) 
    { 
        temp = q.front(); 
        q.pop(); 
  
        if (temp->right) 
        { 
            if (temp->right == d_node) 
            { 
                temp->right = NULL; 
                delete(d_node); 
                return; 
            } 
            else
                q.push(temp->right); 
        } 
  
        if (temp->left) 
        { 
            if (temp->left == d_node) 
            { 
                temp->left=NULL; 
                delete(d_node); 
                return; 
            } 
            else
                q.push(temp->left); 
        } 
    } 
} 

void deletion(struct Node* root, int key) 
{ 
    queue<struct Node*> q; 
    q.push(root); 
  
    struct Node *temp; 
    struct Node *key_node = NULL; 
    while (!q.empty()) 
    { 
        temp = q.front(); 
        q.pop(); 
  
        if (temp->key == key) 
            key_node = temp; 
  
        if (temp->left) 
            q.push(temp->left); 
  
        if (temp->right) 
            q.push(temp->right); 
    } 
  
    int x = temp->key; 
    deletDeepest(root, temp); 
    key_node->key = x; 
} 
  
