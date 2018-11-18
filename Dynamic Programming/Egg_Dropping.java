class Egg {
    static int egg(int n,int k){
        int[][] T=new int[n+1][k+1];
        int c=0;
        for(int i=1;i<=n;i++){
            T[i][1]=1;
            T[i][0]=0;
        }
        for(int j=1;j<=k;j++){
            T[1][j]=j;
        }
        for(int i=2;i<=n;i++){
            for(int j=2;j<=k;j++){
                T[i][j]=Integer.MAX_VALUE;
                for(int x=1;x<=j;x++){
                c=1+Math.max(T[i-1][x-1],T[i][j-x]);
                if(c<T[i][j]) T[i][j]=c;
                }
            }
        }
        return T[n][k];
    }
    public static void main(String[] args) {
     int n=2;
     int k=36;
     System.out.println("Minimum number of trials in worst case: "+egg(n,k));
    }
}
