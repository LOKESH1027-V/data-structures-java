import java.util.ArrayDeque;
import java.util.Queue;

public class PostorderTraversal {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        Tree root=buildTree(arr);
        PostorderTraversal(root);

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

    public static void PostorderTraversal(Tree root){
        if(root==null) return;
        PostorderTraversal(root.left);
        PostorderTraversal(root.right);
        System.out.print(root.data+"->");
    }
}
