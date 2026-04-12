import java.util.ArrayDeque;
import java.util.Queue;

public class LowestAncestors {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        Tree root=buildTree(arr);
        Tree p=root.right;
        Tree q=root.left;
        System.out.println(lowestAncestors(root,p,q).data);
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

    public static Tree lowestAncestors(Tree root,Tree p,Tree q){
        if(root==null|| root==p || root==q) return root;
        Tree left=lowestAncestors(root.left, p, q);
        Tree right=lowestAncestors(root.right, p, q);
        if(left==null) return right;
        else if(right==null) return left;
        else return root;
    }
}
