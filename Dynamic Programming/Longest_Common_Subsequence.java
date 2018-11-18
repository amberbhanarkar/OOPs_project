package hp1;

public class lcs {
    static void lcsc(char[] X,char[] Y,int m,int n){
        int[][] lis=new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            for(int j=0;j<=n;j++){
            if(i==0||j==0) lis[i][j]=0;
            else if(X[i-1]==Y[j-1]) lis[i][j]=lis[i-1][j-1]+1;
            else lis[i][j]=Math.max(lis[i][j-1],lis[i-1][j]);
        }
        System.out.println(lis[m][n]);
        int i=m,j=n;
        StringBuilder ss=new StringBuilder();
        while(i>0&&j>0)
            if(i!=0||j!=0)
                if(X[i-1]==Y[j-1]){
                    ss.append(X[i-1]);
                    i--;j--;
                }
                else if(lis[i-1][j]>lis[i][j-1]) i--;
                else j--;
        System.out.println(ss.reverse());
    }
    public static void main(String[] args) {
        String s1="ADFGMYFTMBH";
        String s2="ADXJNRTMGYMYKB";
        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m=X.length;
        int n=Y.length;
        lcsc(X,Y,m,n);
    }
}
