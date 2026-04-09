import java.util.*;
public class preinpost{
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        Tree root=buildTree(arr);
        preInPostOrderTraversal(root);
    }

    public static Tree buildTree(int[] arr){
        if(arr.length==0) return null;
        Queue<Tree> q=new LinkedList<>();
        Tree root=new Tree(arr[0]);
        q.offer(root);
        int i=1;
        while(i<arr.length){
            Tree current=q.poll();
            if(i<arr.length){
                current.left=new Tree(arr[i++]);
                q.offer(current.left);
            }
            if(i<arr.length){
                current.right=new Tree(arr[i++]);
                q.offer(current.right);
            }
        }
        return root;
    }

    public static void preInPostOrderTraversal(Tree root){
        Stack<Pair> st=new Stack<Pair>();
        List<Tree> pre=new ArrayList<>();
        List<Tree> in=new ArrayList<>();
        List<Tree> post=new ArrayList<>();
        st.push(new Pair(root, 1));
        while(!st.isEmpty()){
            Pair current=st.pop();
            if(current.number==1){
                pre.add(current.node);
                current.number++;
                st.push(current);
                if(current.node.left!=null) st.push(new Pair(current.node.left, 1));
            }
            else if(current.number==2){
                in.add(current.node);
                current.number++;
                st.push(current);
                if(current.node.right!=null) st.push(new Pair(current.node.right,1));
            }else{
                post.add(current.node);
            }
        }
        System.out.print("PreOrder: \t");
        for(Tree i:pre){
            System.out.print(i.data+"->");
        }
        System.out.print("\nInorder: \t");
         for(Tree i:in){
            System.out.print(i.data+"->");
        }
        System.out.print("\nPostOrder: \t");
         for(Tree i:post){
            System.out.print(i.data+"->");
        }

    }

    public  static class Pair{
        public Tree node;
        public int number;

        public Pair(Tree node, int number){
            this.node=node;
            this.number=number;
        }
    }
}