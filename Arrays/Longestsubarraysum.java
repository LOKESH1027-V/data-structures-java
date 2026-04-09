import java.util.*;
public class Longestsubarraysum {
    public static void main(String[] args) {
        int[] arr={-2,-3,4,-1,-2,1,5,-3};
        int k=7;
        int longest=0;
        int sum=0;
        int start=0;
        int right=0;
        for(int i=0;i<arr.length-1;i++){
            sum+=arr[right];
            if(sum==0 || arr[start]<arr.length-1 && right<arr.length-1){
                start++;
            }
            if(sum==k){
                longest=right+1-start;
            }else if(sum>k){
                sum-=arr[start];
                start++;
            }
            right++;
        }
        System.out.println(sum);
    }
}
