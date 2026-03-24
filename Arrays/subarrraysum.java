import java.util.*;
public class subarrraysum {
    public static void main(String[] args) {
        int[] arr={1,1,2,3,-3,1,1,1,4,2,-3};
        HashMap<Integer,Integer> mapp=new HashMap<>();
        mapp.put(0,1);
        int k=3;
        int count=0;
        int presum=0;
        for(int i=0;i<arr.length;i++){
            presum+=arr[i];
            int remove=presum-k;
            if(mapp.containsKey(remove)){
                count+=mapp.get(remove);
            }
            mapp.put(presum, mapp.getOrDefault(presum,0)+1);
        }
        System.out.println(count);
    }
}
