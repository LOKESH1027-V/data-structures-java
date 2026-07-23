    import java.util.*;
    public class safeNode {
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter number of nodes in the graph :");
            int n=sc.nextInt();
            ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
            for(int i=0;i<n;i++){
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
            ArrayList<Integer> ans=safNode(n, adj);
            for(int it:ans){
                System.out.print(it+" ");
            }
        }
        public static ArrayList<Integer> safNode(int v,ArrayList<ArrayList<Integer>> adj){
            ArrayList<ArrayList<Integer>> adjRev=new ArrayList<>();
            for(int i=0;i<v;i++){
                adjRev.add(new ArrayList<>());
            }
            int[] indegree=new int[v];
            for(int i=0;i<v;i++){
                for(int it:adj.get(i)){
                    adjRev.get(it).add(i);
                    indegree[i]++;
                }
            }
            Queue<Integer> q=new LinkedList<>();
            ArrayList<Integer> safenode=new ArrayList<>();
            for(int i=0;i<v;i++){
                if(indegree[i]==0)
                    q.add(i);
            }
            while(!q.isEmpty()){
                int node=q.peek();
                q.remove();
                safenode.add(node);
                for(int it:adjRev.get(node)){
                    indegree[it]--;
                    if(indegree[it]==0) q.add(it);
                }
            }
            Collections.sort(safenode);
            return safenode;
        }
    }
