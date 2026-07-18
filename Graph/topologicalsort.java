import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class topologicalsort {
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
        int[] ans=topologicalsort(n, adj);
        for(int i=0;i<n;i++){
            System.out.print(ans[i]+" ");
        }
    }

    public static int[] topologicalsort(int v,ArrayList<ArrayList<Integer>> adj){
        int vis[]=new int[v];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<v;i++){
            if(vis[i]==0){
                dfs(i,vis,st,adj);
            }
        }
        int ans[]=new int[v];
        int i=0;
        while(!st.isEmpty()){
            ans[i]=st.pop();
            i++;
        }
        return ans;
    }

    public static void dfs(int node,int[] vis,Stack<Integer> st,ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        for(int it:adj.get(node)){
            if(vis[it]==0){
                dfs(it, vis, st, adj);
            }
        }
        st.push(node);

    }
}
