import java.util.*;
public class LevelorderTraversal {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        Tree root=buildTree(arr);
        List<List<Integer>> list=levelorderTraversal(root);
        for(List k:list){
            System.out.println(k);

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

    public static List<List<Integer>> levelorderTraversal(Tree root){
        Queue<Tree> q=new LinkedList<>();
        List<List<Integer>> list=new LinkedList<>();
        if(root==null) return null;
        q.offer(root);
        while(!q.isEmpty()){
            int levelNum=q.size();
            List<Integer> sublist=new LinkedList<>();
            for(int i=0;i<levelNum;i++){
                if(q.peek().left!=null) q.offer(q.peek().left);
                if(q.peek().right!=null) q.offer(q.peek().right);
                sublist.add(q.poll().data);
            }
            list.add(sublist);

        }
        return list;

    }
}
