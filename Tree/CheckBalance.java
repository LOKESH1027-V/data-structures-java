import java.util.*;
public class CheckBalance {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        Tree root=buildTree(arr);
        int height=checkbalance(root);
        if(height>1) System.out.println("Tree is balanced");
        else System.out.println("Tree is unbalanced");
        
    }

    public static Tree buildTree(int[] arr){
        Queue<Tree> q=new LinkedList<>();
        Tree root=new Tree(arr[0]);
        int i=1;
        q.offer(root);
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

    public static int checkbalance(Tree root){
        if(root==null) return 0;
        int lh=checkbalance(root.left);
        int rh=checkbalance(root.right);
        if(lh==-1 && rh==-1) return -1;
        if(Math.abs(lh-rh)>1) return  -1;
        return 1+Math.max(lh, rh);
    }
}
