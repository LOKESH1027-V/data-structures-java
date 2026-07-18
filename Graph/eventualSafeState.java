import java.lang.reflect.Array;
import java.util.*;

public class eventualSafeState {

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
        ArrayList<Integer> safeNode=eventualSafeState(n, adj);
        for(int i:safeNode){
            System.out.print(i+" ");
        }
    }

    public static ArrayList<Integer> eventualSafeState(int v,ArrayList<ArrayList<Integer>> adj){
        int vis[]=new int[v+1];
        int pathvis[]=new  int[v+1];
        int check[]=new int[v+1];
        for(int i=0;i<=v;i++){
            if(vis[i]==0)
                dfs(i,adj,vis,pathvis,check);
            
        }
        ArrayList<Integer> safeNode=new ArrayList<>();
        for(int i=0;i<=v;i++){
            if(check[i]==1)
                safeNode.add(i);
        }
        return safeNode;

    }

    public static boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,int vis[],int[] pathvis,int check[]){
        vis[node]=1;
        pathvis[node]=1;
        check[node]=0;
        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                if (dfs(it, adj, vis, pathvis, check)) {
                    return true;
                }
            } else if (pathvis[it] == 1) {
                return true;
            }
        }
        check[node]=1;
        pathvis[node]=0;
        return false;
    }

}
