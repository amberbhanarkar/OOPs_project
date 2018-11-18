package MyLib;
class Node{
    int key;
    Node left,right;
    public Node(int item){
        key=item;
        left=right=null;
    }
}
public class Traversal{
    static Node root;

    void Inorder(Node node){
        if(node==null) return;
        Inorder(node.left);
        System.out.println(node.key+" ");
        Inorder(node.right);
    }
    void Preorder(Node node){
        if(node==null) return;
        System.out.println(node.key+" ");
        Preorder(node.left);
        Preorder(node.right);
    }
    void Postorder(Node node){
        if(node==null) return;
        Postorder(node.left);
        Postorder(node.right);
        System.out.println(node.key+" ");
    }
}