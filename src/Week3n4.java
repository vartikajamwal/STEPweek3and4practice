import java.util.*;

public class Week3n4 {
    static int linear(int[] arr,int key){
        for(int i=0;i<arr.length;i++) if(arr[i]==key) return i;
        return -1;
    }

    static int floor(int[] arr,int key){
        int l=0,r=arr.length-1,ans=-1;
        while(l<=r){
            int m=(l+r)/2;
            if(arr[m]<=key){
                ans=arr[m];
                l=m+1;
            } else r=m-1;
        }
        return ans;
    }

    static int ceil(int[] arr,int key){
        int l=0,r=arr.length-1,ans=-1;
        while(l<=r){
            int m=(l+r)/2;
            if(arr[m]>=key){
                ans=arr[m];
                r=m-1;
            } else l=m+1;
        }
        return ans;
    }

    public static void main(String[] args){
        int[] arr={10,25,50,100};

        System.out.println(linear(arr,30));
        System.out.println(floor(arr,30));
        System.out.println(ceil(arr,30));
    }
}