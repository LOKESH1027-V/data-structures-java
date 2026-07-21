import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DAGbyTopologicalsort {
        public static void main(String[] args) {
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
        boolean ans=isCycle(n, adj);
        if(ans){
            System.out.println("Graph contains Cycle");
        }else{
            System.out.println("Graph does not have Cycle");
        }
    }


    public static boolean isCycle(int v,ArrayList<ArrayList<Integer>> adj){
        int indegree[]=new int[v];
        for(int i=0;i<v;i++){
            for(int it:adj.get(i)){
                indegree[i]++;
            }
        }
        int count=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int top[]=new int[v];
        int i=0;
        while(!q.isEmpty()){
            int node=q.poll();
            top[i++]=node;
            count++;
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                    
                }
            }
        }
        if(count<v) return true;
        return false;
    }
}
