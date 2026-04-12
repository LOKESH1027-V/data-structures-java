import java.util.LinkedList;
import java.util.Queue;

public class ChildSum {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        Tree root=buildTree(arr);
        change(root);
        System.out.println(root.data);
        
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

    public static void change(Tree root){
        if(root==null) return ;
        int child=0;
        if(root.left!=null) child+=root.left.data;
        if(root.right!=null) child+=root.right.data;
        if(child>=root.data) root.data=child;
        else{
            if(root.left!=null) root.left.data=root.data;
            if(root.right!=null) root.right.data=root.data;

        }
        change(root.left);
        change(root.right);
        int tot=0;
        if(root.left!=null) tot+=root.left.data;
        if(root.right!=null) tot+=root.right.data;
        if(root.left!=null  || root.right!=null)
            root.data=tot;
    }

}
