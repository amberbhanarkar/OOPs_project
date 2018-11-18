package MyLib;
public class BinarySearch{
 int search(int a[],int f,int l,int val){
     int mid=f+(l-f)/2;
     if(a[mid]==val) return mid;
     if(a[mid]>val) return search(a,f,mid-1,val);
     else
         return search(a,mid+1,l,val);
 }
}
