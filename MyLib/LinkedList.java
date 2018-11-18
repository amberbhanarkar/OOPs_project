package MyLib;
import java.util.*;
public class LinkedList{
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){data=d;next=null;}
    }
    public void insert(int x){
        Node nnode=new Node(x);
        if(head==null) {
            head=new Node(x);
        }
        else {
            Node nnde = head;
            while (nnde.next != null) nnde = nnde.next;
            nnde.next = nnode;
        }
    }
    public void inbet(Node nnde,int x,int p){
        Node nnode;
        Node r=new Node(x);
        if(p==1){nnode=head;head=new Node(x);head.next=nnode;}
        else{
            for(int i=0;i<p-2;i++){
                nnde=nnde.next;
            }
            r.next=nnde.next;
            nnde.next=r;
        }
    }
    public void del(Node nnde,int x){
        Node r=head;
        while(nnde.data!=x){
            r=nnde;
            nnde=nnde.next;
        }
        if(nnde==head){
            head=nnde.next;
        }
        else {
            r.next = nnde.next;
        }
    }
    public void delbynum(Node nnde,int x){
        Node r=head;
        if(x==1){
            head=nnde.next;
        }
        else {
            for(int i=0;i<x-1;i++){
                r=nnde;
                nnde=nnde.next;
            }
            r.next=nnde.next;
        }
    }
    void display(Node nnde)
    {
        while (nnde != null)
        {
            System.out.print(nnde.data + " ");
            nnde = nnde.next;
        }
    }
}