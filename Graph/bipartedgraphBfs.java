import java.util.*;
public class bipartedgraphBfs {
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
                if(check(i,v,adj,color)==false){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean check(int start, int v,ArrayList<ArrayList<Integer>> adj,int[] color){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        color[start]=0;
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            for(int it:adj.get(node)){
                if(color[it]==-1){
                    color[it]=1-color[node];
                    q.add(it);
                }else if(color[it]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}
