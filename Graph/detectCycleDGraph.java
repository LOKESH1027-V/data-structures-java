import java.util.*;
public class detectCycleDGraph {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of nodes in the graph :");
        int n=sc.nextInt();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            System.out.print("Node :");
            int node=sc.nextInt();
            System.out.print("Enter the number of adj nodes :");
            int m=sc.nextInt();
            ArrayList<Integer> cur=new ArrayList<>();
            for(int j=0;j<m;j++){
                cur.add(sc.nextInt());
            }
            while (adj.size()<=node) {
                adj.add(new ArrayList<>());
                
            }
            adj.set(node,cur);

        }
        System.out.println(isCycle(n, adj));
    }

    public static boolean isCycle(int v,ArrayList<ArrayList<Integer>> adj){
        int[] vis=new int[v+1];
        int[] pathvis=new int[v+1];
        for(int i=1;i<=v;i++){
            if(vis[i]==0)
                if(dfs(i,adj,vis,pathvis)==true) return true;
        }
        return false;
    }

    public static boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] vis,int[] pathvis){
        vis[node]=1;
        pathvis[node]=1;
        for(int it:adj.get(node)){
            if(vis[it]==0){
                if(dfs(it,adj,vis,pathvis)==true) return true;
            }else if(pathvis[it]==1) return true;
        }
        pathvis[node]=0;
        vis[node]=0;
        return false;
    }
}
