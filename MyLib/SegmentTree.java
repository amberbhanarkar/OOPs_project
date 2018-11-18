package MyLib;
public class SegmentTree {
    int st[];
    public SegmentTree(int n,int[] a){
        int x=(int)Math.ceil(Math.log(n)/Math.log(2));
        int size=2*(int)Math.pow(2,x)-1;
        st=new int[size];
        construct(a,0,n-1,0);
    }
    public int getMid(int s,int e){
        return s+(e-s)/2;
    }
    public int construct(int[] a,int s,int e,int i){
        if(s==e){
            st[i]=a[s];
            return st[i];
        }
        int mid=getMid(s,e);
        st[i]=construct(a,s,mid,i*2+1)+construct(a,mid+1,e,i*2+2);
        return st[i];
    }
    public int getSum(int cs,int ce,int s,int e,int i){
        if (s <= cs && e >= ce)
            return st[i];
        if (ce < s || cs > e)
            return 0;
        int mid = getMid(cs, ce);
        return getSum(cs, mid, s, e, 2 * i + 1) + getSum(mid + 1, ce, s, e, 2 * i + 2);
    }
    public int getSum(int s,int e,int n){
        if(s<0||e>n-1||s>e){
            System.out.println("Invalid Input");
            return -1;
        }
        return getSum(0,n-1,s,e,0);
    }
    public void update(int s,int e,int i,int diff,int ci){
        if (i < s || i > e)
            return;
        st[ci] = st[ci] + diff;
        if (e != s) {
            int mid = getMid(s,e);
            update(s, mid, i, diff, 2 * ci + 1);
            update(mid + 1, e, i, diff, 2 * ci + 2);
        }
    }
    public void update(int new_val,int i,int n,int[] a){
        if (i < 0 || i > n - 1) {
            System.out.println("Invalid Input");
            return;
        }
        int diff = new_val - a[i];
        a[i] = new_val;
        update(0, n - 1, i, diff, 0);
    }
}