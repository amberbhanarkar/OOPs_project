package any;
//Given a number n, count minimum steps to minimize it to 1 according to the following criteria:
//If n is divisible by 2 then we may reduce n to n/2.
//If n is divisible by 3 then you may reduce n to n/3.
//Decrement n by 1.
import java.util.*;

public class min {
    static int mini(int n,int[] rem){
        if(n==1) return 0;
        if(rem[n]!=-1) return rem[n];
        int x=mini(n-1,rem);
        if(n%2==0) x=Math.min(x,mini(n/2,rem));
        if(n%3==0) x=Math.min(x,mini(n/3,rem));

        rem[n]=1+x;
        return rem[n];
    }
    public static void main(String args[])
    {
        Scanner s1=new Scanner(System.in);
        System.out.println("Enter no. to minimize to 1: ");
        int n=s1.nextInt();
        int[] rem=new int[n+1];
        for(int i=0;i<=n;i++) rem[i]=-1;
        System.out.println("Minimum steps are: "+mini(n,rem));
    }
}
