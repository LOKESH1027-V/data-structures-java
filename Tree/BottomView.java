import java.util.*;
class Pair{
    int x;
    Tree node;
    int y;
    public Pair(Tree node,int x,int y){
        this.x=x;
        this.node=node;
        this.y=y;
    }
}
public class BottomView{
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        Tree root=buildTree(arr);
        List<Integer> ls=bottomView(root);
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

    public static List<Integer> bottomView(Tree  root){
        Queue<Pair> q=new LinkedList<>();
        TreeMap<Integer,Pair> map=new TreeMap<>();
        List<Integer> list=new ArrayList<>();
        q.offer(new Pair(root, 0,0));
        while(!q.isEmpty()){
            Pair it=q.poll();
            Tree node=it.node;
            int x=it.x;       
            int y=it.y;         
            if(!map.containsKey(x) || map.get(x).y<=y){
                map.put(x, it);
            }

            if(node.left!=null) q.add(new Pair(node.left, x-1,y+1));
            if(node.right!=null) q.add(new Pair(node.right, x+1,y+1));
        }
        for(Map.Entry<Integer, Pair> entry :map.entrySet()){
             list.add(entry.getValue().node.data); 
    }
    return list;
    }
}
