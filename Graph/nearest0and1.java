import java.util.*;

import javax.management.QueryEval;
class node{
    int row;
    int col;
    int dis;
    public node(int row,int col,int dis){
        this.row=row;
        this.col=col;
        this.dis=dis;
    }
}
public class nearest0and1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of row :");
        int n=sc.nextInt();
        System.out.print("Enter number of columns :");
        int m=sc.nextInt();
        int[][] grid=new int[n][m];
        System.out.println("Enter the values of the grid :");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        System.out.print("Enter the value that has to near to the node :");
        int value=sc.nextInt();
        int[][] dis=nearestcellContainTheValue(grid, value);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(dis[i][j]+" ");
            }
            System.out.println();
        }
    
    }

    public static int[][] nearestcellContainTheValue(int[][] grid,int value){
        int n=grid.length;
        int m=grid[0].length;
        int[][] newgrid=new int[n][m];
        int[][] vis=new int[n][m];
        Queue<node> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==value){
                    q.add(new node(i, j, 0));
                    grid[i][j]=q.peek().dis;
                    vis[i][j]=1;
                }
            }
        }

        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int dis=q.peek().dis;
            q.remove();
            newgrid[row][col]=dis;
            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]!=1){
                    vis[nrow][ncol]=1;
                    q.add(new node(nrow, ncol, dis+1));
                }


            }
        }
        return newgrid;

    }
    
}
