import java.util.LinkedList;
import java.util.Queue;

public class MaxPathSum {
    static int maxi=Integer.MIN_VALUE;
    public static void main(String[] args) {
        int[]  arr={1,2,3,4,5,6,7,8,9,10};
        Tree root=buildTree(arr);
        maxPathSum(root);
        System.out.println(maxi);
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

    public static int maxPathSum(Tree root){
        if(root==null) return 0;
        int lh=Math.max(0,maxPathSum(root.left));
        int rh=Math.max(0,maxPathSum(root.right));
        maxi=Math.max(maxi, rh+lh+root.data);
        return root.data+Math.max(lh,rh);
    }
}
