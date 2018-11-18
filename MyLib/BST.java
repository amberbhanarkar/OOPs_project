package MyLib;
import java.util.*;
public class BST {
    class Node{
        int key;
        Node left,right;
        public Node(int item){
            key=item;
            left=right=null;
        }
    }
    Node root;
    void insert(int key)
    {
        root = insertRec(root, key);
    }
    Node insertRec(Node root, int key)
    {
        if (root == null)
        {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    void del(int key){
        root=delRec(root,key);
    }
    Node delRec(Node root,int key){
        if(root==null) return root;
        if(key<root.key) root.left=delRec(root.left,key);
        else if(key>root.key) root.right=delRec(root.right,key);
        else {
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;
            root.key=min(root.right);
            root.right=delRec(root.right,root.key);
        }
        return root;
    }
    int min(Node root){
        int min=root.key;
        while(root.left!=null){
            min=root.left.key;
            root=root.left;
        }
        return min;
    }

    void print()
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            Node tempNode = queue.poll();
            System.out.print(tempNode.key + " ");
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
}
