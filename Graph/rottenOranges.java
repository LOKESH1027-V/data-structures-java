import java.util.*;
class pair{
    int first;
    int second;
    int time;
    public pair(int first,int second,int time){
        this.first=first;
        this.second=second;
        this.time=time;
    }
}


public class rottenOranges {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of rows in the martix of graph: ");
        int rows=sc.nextInt();
        System.out.print("Enter number of columns in the matrix of graph: ");
        int columns=sc.nextInt();
        int[][] graph=new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print("Enter the elemnt for index ["+i+"] ["+j+"]: ");
                graph[i][j]=sc.nextInt();


            }
        }
        System.out.println("Time taken to rotte all the oranges is :"+rottenOranges(graph));
         
    }
    public static int rottenOranges(int[][] graph){
        int n=graph.length;
        int m=graph[0].length;
        int countFresh=0;
        Queue<pair> q=new LinkedList<>();
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(graph[i][j]==2){
                    q.add(new pair(i, j,0));
                    vis[i][j]=1;
                }else{
                    vis[i][j]=0;
                }if(graph[i][j]==1){
                    countFresh++;
                }
            }
        }
        int time=0;
        int count=0;
        int[] delrow={-1,0,1,0};
        int[] delcol={0,-1,0,1};
        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            int t=q.peek().time;
            time=Math.max(time, t);
            q.remove();
            for(int i=0;i<4;i++){
                int nrow=r+delrow[i];
                int ncol=c+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && graph[nrow][ncol]==1){
                    q.add(new pair(nrow, ncol, t+1));
                    vis[nrow][ncol]=1;
                    count++;
                }
            }
        }
        if(count!=countFresh) return -1;
        return time;



    }
}
