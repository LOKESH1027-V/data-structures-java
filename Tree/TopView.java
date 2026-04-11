import java.util.*;
class Pair{
    int x;
    Tree node;
    public Pair(Tree node,int x){
        this.x=x;
        this.node=node;
    }
}
public class TopView {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        Tree root=buildTree(arr);
        List<Integer> ls=topView(root);
        for(int i:ls){
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

    public static List<Integer> topView(Tree  root){
        Queue<Pair> q=new LinkedList<>();
        Map<Integer,Tree> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        q.offer(new Pair(root, 0));
        map.put(0, root);
        while(!q.isEmpty()){
            Pair it=q.poll();
            Tree node=it.node;
            int x=it.x;
            if(!map.containsKey(x))
                map.put(x, node);
            if(node.left!=null) q.add(new Pair(node.left, x-1));
            if(node.right!=null) q.add(new Pair(node.right, x+1));
        }
        for(Map.Entry<Integer, Tree> entry :map.entrySet()){
             list.add(entry.getValue().data); 
    }
    return list;
    }
}
