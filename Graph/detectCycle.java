import java.util.*;
public class detectCycle {
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
        System.out.println(isCycle(n, adj,"Bfs"));
    }

    public static boolean isCycle(int v,ArrayList<ArrayList<Integer>> adj,String method){
        boolean[] vis=new boolean[v+1];
        for(int i=0;i<v;i++)
            vis[i]=false;
        for(int i=0;i<v;i++){
            if(vis[i]==false){
            if(method.equals("Bfs")){
                if(bfs(i,v,adj,vis))
                    return true;
            }
            }
        }
        return false;
    }
    public static boolean bfs(int src,int v,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        vis[src+1]=true;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src, -1));
        while(!q.isEmpty()){
            int node=q.peek().first;
            int parent=q.peek().second;
            q.remove();
            for(int adjNode:adj.get(node)){
                if(vis[adjNode]==false){
                    vis[adjNode]=true;
                    q.add(new Pair(adjNode, node));
                }
                else if(parent!=adjNode){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(int src,int parent,boolean[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[src]=true;
        for(int adjNode:adj.get(src)){
            if(vis[adjNode]==false){
                if(dfs(adjNode, src, vis, adj))
                    return true;
            }else if(adjNode!=src){
                return true;
            }
        }
        return false;
    }
}
