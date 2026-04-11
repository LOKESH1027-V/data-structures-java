import java.util.*;

public class BoundaryTraversal {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        Tree root=buildTree(arr);
        List<Integer> n=boundaryTraversal(root);
        for(int i:n){
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

   public static boolean isLeaf(Tree node){
    if(node== null) return false;
    return node.left==null && node.right==null;
   }

   public static List<Integer> boundaryTraversal(Tree root){
        if(root==null ) return  null;
        List<Integer> ans=new ArrayList<>();
        ans.add(root.data);
        addLeftBoundary(root, ans);
        addLeaf(root, ans);
        addRightBoundary(root, ans);
        return ans;

   }

    public static List<Integer> addLeftBoundary(Tree root,List<Integer> ans){
            Tree node=root.left;
            while (node!=null){
                if(isLeaf(node)==false) ans.add(node.data);
                if(node.left!=null) node=node.left;
                else node=node.right;
                
            }
            return ans;

    }
    public static List<Integer> addLeaf(Tree node, List<Integer> ans){
        if(node == null) return ans;

        if(isLeaf(node)){
            ans.add(node.data);
            return ans;
        }

        addLeaf(node.left, ans);
        addLeaf(node.right, ans);

        return ans;
    }

    public static void addRightBoundary(Tree root, List<Integer> ans){
        Tree node = root.right;
        List<Integer> temp = new ArrayList<>();

        while(node != null){
            if(!isLeaf(node)) temp.add(node.data);

            if(node.right != null) node = node.right;
            else node = node.left;
        }

        for(int i = temp.size() - 1; i >= 0; i--){
            ans.add(temp.get(i));
        }
    }
}
