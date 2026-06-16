import java.util.*;

public class dfs{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <=n; i++) {

            System.out.print("Node: ");
            int node = sc.nextInt();

            System.out.print("Enter number of adjacent nodes: ");
            int m = sc.nextInt();

            ArrayList<Integer> cur = new ArrayList<>();

            System.out.println("Enter adjacent nodes:");
            for (int j = 0; j <m; j++) {
                int adjNode = sc.nextInt();
                cur.add(adjNode);
            }

            while (adj.size() <= node) {
                adj.add(new ArrayList<>());
            }

            adj.set(node, cur);
        }

        System.out.println("Adjacency List:");
        for (int i = 0; i < adj.size(); i++) {
            System.out.println(i + " -> " + adj.get(i));
        }

        sc.close();
        System.out.println(dfsOfGraph(n, adj));
    }
    public static ArrayList<Integer> dfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj){
        boolean vis[]=new boolean[V+1];
        vis[0]=true;
        ArrayList<Integer> ls=new ArrayList<>();
        dfs(1,vis,adj,ls);
        return ls;

    }
    public static void dfs(int node,boolean vis[],ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ls){
        vis[node]=true;
        ls.add(node);
        for(int it:adj.get(node)){
            if(vis[it]==false){
                dfs(it, vis, adj, ls);
            }
        }
    }

}
