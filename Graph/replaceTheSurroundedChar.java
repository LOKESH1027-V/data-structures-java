import java.util.*;

public class replaceTheSurroundedChar{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of rows :");
        int n=sc.nextInt();
        System.out.print("Enter the number of colums :");
        int m=sc.nextInt();
        System.out.println("Enter the characters of the graph : ");
        System.out.println("Note:");
        System.out.println("Use capital X and O");
        char[][] graph=new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                graph[i][j]=sc.next().charAt(0);
            }
            System.out.println();
        }
        char[][]  result=fill(n,m,graph);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static char[][] fill(int n,int m,char[][] mat){
        int[][] vis=new int[n][m];
        int[] delrow={1,0,-1,0};
        int[] delcol={0,-1,0,1};
        for(int i=0;i<m;i++){
            if(vis[0][i]==0 && mat[0][i]=='O')
                dfs(0,i,vis,delrow,delcol,mat);
            if(vis[n-1][i]==0 && mat[n-1][i]=='O')
                dfs(n-1,i,vis,delrow,delcol,mat);
        }
        for(int i=0;i<n;i++){
            if(vis[i][0]==0 && mat[i][0]=='O')
                dfs(i,0,vis,delrow,delcol,mat);
            if(vis[i][m-1]==0 &&  mat[i][m-1]=='O')
                dfs(i,m-1,vis,delrow,delcol,mat);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0)
                    mat[i][j]='X';
            }
        }
        return mat;

    }

    public static void dfs(int row,int col,int[][] vis,int[] delrow,int[] delcol,char[][] mat){
        vis[row][col]=1;
        int n=vis.length;
        int m=vis[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && mat[nrow][ncol]=='O')
                dfs(nrow,ncol,vis,delrow,delcol,mat);
        }
    }
}
