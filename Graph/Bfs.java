import java.util.*;

public class Bfs {
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
        System.out.println(bfsOfGrap(n, adj));
    }

    public static ArrayList<Integer> bfsOfGrap(int Vnodes,ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs=new ArrayList<>();
        boolean vis[]=new boolean[adj.size()];
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        vis[1]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            bfs.add(node);
            for(int it:adj.get(node)){
                if(vis[it]==false){
                    vis[it]=true;
                    q.add(it);
                }
            }
        }

        return bfs;
    }
}