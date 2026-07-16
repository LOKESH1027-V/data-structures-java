import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bipartedgraphDfs {
        public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of nodes in the graph :");
        int n=sc.nextInt();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        System.out.println("For Study enter 0 and 0 for first node and its adj");
        for(int i=0;i<=n;i++){
            System.out.print("Node :");
            int node=sc.nextInt();
            System.out.print("Enter number of adj nodes :");
            int m=sc.nextInt();
            ArrayList<Integer> cur=new ArrayList<>();
            for(int j=0;j<m;j++){
                int adjnode=sc.nextInt();
                cur.add(adjnode);
            }
            if(adj.size()<=n){
                adj.add(new ArrayList<>());
            }
            adj.set(node, cur);

        }
        System.out.println(bipart(n, adj));
    }

    public static boolean bipart(int v,ArrayList<ArrayList<Integer>> adj){
        int color[]=new int[v+1];
        for(int i=0;i<=v;i++) color[i]=-1;
        for(int i=0;i<=v;i++) {
            if(color[i]==-1){
                if(dfs(i,0,adj,color)==false){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean dfs(int start, int col,ArrayList<ArrayList<Integer>> adj,int[] color){
        color[start]=col;
        for(int it:adj.get(start)){
            if(color[it]==-1){
                if(dfs(it,1-col,adj,color)==false)
                    return false;
            }else if(color[it]==color[start]) return false; 
        }
        return true;
    }
}

