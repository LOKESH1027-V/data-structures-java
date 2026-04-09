import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class IterativePostorder {
        public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        Tree root=buildTree(arr);
        List<Integer> preorder=iterativePostorder(root);
        for(int k:preorder){
            System.out.print(k+"-> ");

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

    public static List<Integer> iterativePostorder(Tree root){
        Stack<Tree> st=new Stack<>();
        List<Integer> postorder=new ArrayList<>();
        Tree current=root;
        while(current!=null || !st.isEmpty()){
            if(current!=null){
                st.push(current);
                current=current.left;
            }else{
                Tree temp=st.pop().right;
                if(temp==null) {
                    temp=st.peek();
                    postorder.add(temp.data);
                    st.pop();
                    while(!st.isEmpty() && st.peek().right==null){
                    postorder.add(st.pop().data);

                }}else 
                    current=temp;
            
        }
    }
        return postorder;


    }
}



