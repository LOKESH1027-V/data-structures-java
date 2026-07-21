import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class courseSchedule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <n; i++) {

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
        int count=0;
        for(int i:topologicalsort(n, adj)){
            if(i==0) count++;
        }
        if(count<1){
            for(int i:topologicalsort(n, adj)){
                System.out.println(i+" ");
            }
        }else{
            System.out.println("Graph has a Cycle");
        }

    }

    public static int[] topologicalsort(int v,ArrayList<ArrayList<Integer>> adj){
        int indegree[]=new int[v];
        for(int i=0;i<v;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
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
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        return top;
    }
}
