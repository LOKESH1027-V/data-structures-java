import java.util.*;
public class MaxDepth {
    public static void main(String[] args) {
        int[]  arr={1,2,3,4,5,6,7,8,9,10};
        Tree root=buildTree(arr);
        System.out.println("Maximun height of the tree is: "+maxDepth(root));
    }

    public static Tree buildTree(int[] arr){
        Queue<Tree> q=new LinkedList<>();
        Tree root=new Tree(arr[0]);
        int i=1;
        q.add(root);
        while(i<arr.length){
            Tree cureent=q.poll();
            if(i<arr.length){
                cureent.left=new Tree(arr[i++]);
                q.offer(cureent.left);
            }
            if(i<arr.length){
                cureent.right=new Tree(arr[i++]);
                q.offer(cureent.right);
            }
        }
        return root;
    }

    public static int maxDepth(Tree root){
        if(root==null) return 0;
        int lh=maxDepth(root.left);
        int rh=maxDepth(root.right);

        return 1+Math.max(lh, rh);
    }
}
