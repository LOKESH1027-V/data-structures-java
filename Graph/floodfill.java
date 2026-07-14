import java.util.Scanner;

public class floodfill {
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
        int[][] ans=floodfill(graph, 1,1,2);
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void dfs(int ro,int col,int[][] ans,int[][] image,int newcolor,int[] delrow,int[] delcol,int incolor){
        ans[ro][col]=newcolor;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int nrow=ro+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==incolor && ans[nrow][ncol]!=newcolor){
                dfs(nrow,ncol,ans,image,newcolor,delrow,delcol,incolor);
            }

        }
    }

    public static int[][] floodfill(int[][] image,int sr,int sc,int newcolor){
        int incolor=image[sr][sc];
        int[][] ans=image;
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        dfs(sr,sc,ans,image,newcolor,delrow,delcol,incolor);
        return ans;
    }
}
