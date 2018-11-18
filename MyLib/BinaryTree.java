package MyLib;
import java.util.*;
public class BinaryTree{
    class Node {
        int key;
        Node left, right;
        Node(int key){
            this.key = key;
            left = null;
            right = null;
        }
    }
    Node root;
    Node temp = root;
    void inorder(Node temp)
    {
        if (temp == null)
            return;
        inorder(temp.left);
        System.out.print(temp.key+" ");
        inorder(temp.right);
    }
    void insert(Node temp, int key)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            } else q.add(temp.left);
            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            } else
                q.add(temp.right);
        }
    }
} 