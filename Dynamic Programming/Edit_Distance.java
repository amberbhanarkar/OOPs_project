package hp1;

public class edit {
    static void editdis(String str1,String str2,int m,int n){
        int[][] mat=new int[m+1][n+1];
        for(int i=0;i<=m;i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) mat[i][j] = j;
                else if (j == 0) mat[i][j] = i;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) mat[i][j] = mat[i - 1][j - 1];
                else mat[i][j] = 1 + Math.min(mat[i - 1][j], Math.min(mat[i][j - 1], mat[i - 1][j - 1]));
            }
        }
        System.out.println(mat[m][n]);
    }
    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";
        editdis(str1,str2,str1.length(),str2.length());
    }
}
