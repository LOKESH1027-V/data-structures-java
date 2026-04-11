import java.util.ArrayDeque;
import java.util.Queue;
public class DiameterofTree {
    static int maxi=0;

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        Tree root=buildTree(arr);
        diameterOfTree(root);
        System.out.println(maxi);

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

    public static int diameterOfTree(Tree root){
        if(root==null) return 0;
        int lh=diameterOfTree(root.left);
        int rh=diameterOfTree(root.right);
        maxi=Math.max(maxi, rh+lh);
        return 1+Math.max(lh,rh);

    }

}
