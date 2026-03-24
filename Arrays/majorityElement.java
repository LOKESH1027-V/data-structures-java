import java.util.*;
public class majorityElement {
    public static void main(String[] args) {
        int[] arr={2,2,3,3,1,2,2};
        int element=arr[0];
        int count=1;
        // Dutch national algorithm
        for(int i=1;i<arr.length;i++){
            if(count==0)
                element=arr[i];
            else if(element==arr[i])
                count++;
            else 
                count--;

        }
        System.out.println("The element that occur n/2 times or greater is:  "+element);
    }
}
