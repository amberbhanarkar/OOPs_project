#include<iostream> 
#include<cstdlib> 
using namespace std;
struct node 
{ 
    int key; 
    struct node *left, *right; 
}; 
   
struct node *newNode(int item) 
{ 
    struct node *temp =  (struct node *)malloc(sizeof(struct node)); 
    temp->key = item; 
    temp->left = temp->right = NULL; 
    return temp; 
} 
   
void inorder(struct node *root) 
{ 
    if (root != NULL) 
    { 
        inorder(root->left); 
        cout<<"\n"<<root->key; 
        inorder(root->right); 
    } 
} 

struct node* insert(struct node* node, int key) 
{ 
    if (node == NULL) return newNode(key); 
  
    if (key < node->key) 
        node->left  = insert(node->left, key); 
    else if (key > node->key) 
        node->right = insert(node->right, key);    
  
    return node; 
} 

