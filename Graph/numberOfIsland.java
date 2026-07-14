import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
}
public class numberOfIsland {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the numbere of rows in the matrix or graph:");
        int numrow=sc.nextInt();
        System.out.println();
        System.out.print("Enter the number of columns in the matrix or graph:");
        int numcol=sc.nextInt();
        System.out.println();
        int[][] graph=new int[numrow][numcol];
        for(int i=0;i<numrow;i++){
            for(int j=0;j<numcol;j++){
                System.out.print("Enter the element of index"+"["+i+"]"+"["+j+"]:");
                graph[i][j]=sc.nextInt();
            System.out.println();

            }
        }
        System.out.println("The number of island in the given graph is "+numberOfIsland(graph));
    }


    public static void bfs(int ro,int col,int[][] vis,int[][] grid){
        vis[ro][col]=1;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(ro, col));
        int n=grid.length;
        int m=grid[0].length;
        while(!q.isEmpty()){
            int row=q.peek().first;
            int colu=q.peek().second;
            q.remove();
            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                    int nrow=row+delcol;
                    int ncol=colu+delcol;
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                        vis[nrow][ncol]=1;
                        q.add(new Pair(ncol, col));
                    }
                }
            }
        }
    }

    public static int numberOfIsland(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1)
                    count++;
                    bfs(i, j, vis, grid);
            }
        }
        return count;
    }


}
