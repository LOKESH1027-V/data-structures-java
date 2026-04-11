import java.util.*;
public class IdenticalTrees {
    public static void main(String[] args) {
        int[]  arr={1,2,3,4,5,6,7,8,9,10};
        Tree root=buildTree(arr);
        Tree root2=buildTree(arr);
        System.out.println(isSame(root, root2));
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

    public static boolean isSame(Tree root1,Tree root2){
        if(root1==null && root2==null) return root1==root2;
        return (root1.data==root2.data) && isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }
}
