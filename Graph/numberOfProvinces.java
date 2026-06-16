import java.util.*;
public class numberOfProvinces {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        System.out.println("If your starting node number start form 1 the first node and it adj node =0");
        System.out.print("Enter the number of nodes:");
    
        int n=sc.nextInt();
        for(int i=0;i<=n;i++){
            System.out.print("Node:");
            int node=sc.nextInt();
            System.out.print("Enter number of adjacent nodes:");
            int m=sc.nextInt();
            ArrayList<Integer> cur=new ArrayList<>();
            for(int j=0;j<m;j++){
                cur.add(sc.nextInt());
            }
            while(adj.size()<=node)
                adj.add(new ArrayList<>());
            adj.set(node, cur);

        }
        sc.close();
        boolean[] visited=new boolean[adj.size()];
        visited[0]=true;
        int count=0;
        for(int i=1;i<visited.length;i++){
            if(visited[i]==false){
                dfsOfGraph(i, adj, visited);
                count++;
            }
        }
        System.out.println(count);


    }
    public static void dfsOfGraph(int i,ArrayList<ArrayList<Integer>> adj, boolean[] vistied){
        vistied[i]=true;
        for(int it:adj.get(i)){
            if(vistied[it]==false){
                dfsOfGraph(it,adj,vistied);
            }
        }
    }
}
