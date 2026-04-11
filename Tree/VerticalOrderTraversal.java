import java.util.*;
class Tuple{
    int x;
    int y;
    Tree node;
    public Tuple(Tree node,int x,int y){
        this.node=node;
        this.x=x;
        this.y=y;
    }

}
public class VerticalOrderTraversal {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        Tree root=buildTree(arr);
        List<List<Integer>> n=verticalOrderTraversal(root);
        for(List i:n){
            System.out.println(i);
        }
        

    }


    public static Tree buildTree(int[] arr) {
        if (arr.length == 0) return null;
        Queue<Tree> q = new ArrayDeque<>();
        Tree root = new Tree(arr[0]);
        q.add(root);
        int i = 1;
        while (i < arr.length) {
            Tree curr = q.poll();
            if (i < arr.length) {
                curr.left = new Tree(arr[i++]);
                q.add(curr.left);
            }
            if (i < arr.length) {
                curr.right = new Tree(arr[i++]);
                q.add(curr.right);
            }
        }
        return root;
    }

    public static List<List<Integer>> verticalOrderTraversal(Tree root){
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));
        while(!q.isEmpty()){
            Tuple t=q.poll();
            Tree node=t.node;
            int x=t.x;
            int y=t.y;
            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.data);
            if(node.left!=null) q.offer(new Tuple(node.left, x-1, y+1));
            if(node.right!=null) q.offer(new Tuple(node.right, x+1, y+1));
        }
        List<List<Integer>> list=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> ys:map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes:ys.values()){
                while(!nodes.isEmpty()){
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}