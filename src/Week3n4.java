import java.util.*;

public class Week3n4 {
    static int linearFirst(String[] arr,String key){
        for(int i=0;i<arr.length;i++) if(arr[i].equals(key)) return i;
        return -1;
    }

    static int binarySearch(String[] arr,String key){
        int l=0,r=arr.length-1;
        while(l<=r){
            int m=(l+r)/2;
            if(arr[m].equals(key)) return m;
            else if(arr[m].compareTo(key)<0) l=m+1;
            else r=m-1;
        }
        return -1;
    }

    static int count(String[] arr,String key){
        int c=0;
        for(String s:arr) if(s.equals(key)) c++;
        return c;
    }

    public static void main(String[] args){
        String[] arr={"accA","accB","accB","accC"};

        System.out.println(linearFirst(arr,"accB"));
        System.out.println(binarySearch(arr,"accB"));
        System.out.println(count(arr,"accB"));
    }
}