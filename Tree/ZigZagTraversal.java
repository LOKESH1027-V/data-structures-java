import java.util.*;

public class ZigZagTraversal {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        Tree root=buildTree(arr);
        List<List<Integer>> n=zigZagTraversal(root);
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

    public static List<List<Integer>> zigZagTraversal(Tree root){
        List<List<Integer>> zigZag=new ArrayList<>();
        Queue<Tree> q=new LinkedList<>();
        q.offer(root);
        boolean LeftToRight=true;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> zig=new ArrayList<>();
            for(int i=0;i<size;i++){
                Tree node=q.poll();
                int index=(LeftToRight)?i:size-1-i;
                if(LeftToRight) zig.add(node.data);
                else zig.add(0,node.data);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            LeftToRight=!LeftToRight;
            zigZag.add(zig);
        }
        return zigZag;
    }
}
