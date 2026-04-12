import java.util.*;

class NodeIndex{
    Tree node;
    int num;
    public NodeIndex(Tree node,int num){
        this.node=node;
        this.num=num;
    }
}
public class WidthOfTree {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        Tree root=buildTree(arr);
        System.out.println(withOfTree(root));

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


    public static int withOfTree(Tree node){
        if(node==null) return 0;
        int ans=0;
        Queue<NodeIndex> q=new LinkedList<>();
        q.offer(new NodeIndex(node, 0));
        while (!q.isEmpty()) {
            int size=q.size();
            int min=q.peek().num;
            int first=0;
            int last=0;
            for(int i=0;i<size;i++){
                int cur_id=q.peek().num-min;
                Tree cur_node=q.peek().node;
                q.poll();
                if(i==0) first=cur_id;
                if(i==size-1) last=cur_id;
                if(cur_node.left!=null) q.offer(new NodeIndex(cur_node.left, cur_id*2+1));
                if(cur_node.right!=null) q.offer(new NodeIndex(cur_node.right, cur_id*2+2));

            }
            ans=Math.max(ans,last-first+1);
            
        }
        return ans;
    }
}
