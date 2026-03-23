import java.util.*;

class Asset {
    String name;
    double ret;
    double vol;
    Asset(String n,double r,double v){
        name=n; ret=r; vol=v;
    }
}

public class Week3n4 {
    static void merge(ArrayList<Asset> arr,int l,int m,int r){
        ArrayList<Asset> temp=new ArrayList<>();
        int i=l,j=m+1;
        while(i<=m && j<=r){
            if(arr.get(i).ret<=arr.get(j).ret) temp.add(arr.get(i++));
            else temp.add(arr.get(j++));
        }
        while(i<=m) temp.add(arr.get(i++));
        while(j<=r) temp.add(arr.get(j++));
        for(int k=0;k<temp.size();k++) arr.set(l+k,temp.get(k));
    }

    static void mergeSort(ArrayList<Asset> arr,int l,int r){
        if(l<r){
            int m=(l+r)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }

    static int partition(ArrayList<Asset> arr,int low,int high){
        Asset pivot=arr.get(high);
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr.get(j).ret>pivot.ret ||
                    (arr.get(j).ret==pivot.ret && arr.get(j).vol<pivot.vol)){
                i++;
                Asset t=arr.get(i);
                arr.set(i,arr.get(j));
                arr.set(j,t);
            }
        }
        Asset t=arr.get(i+1);
        arr.set(i+1,arr.get(high));
        arr.set(high,t);
        return i+1;
    }

    static void quickSort(ArrayList<Asset> arr,int low,int high){
        if(low<high){
            int pi=partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }

    public static void main(String[] args){
        ArrayList<Asset> arr=new ArrayList<>();
        arr.add(new Asset("AAPL",12,5));
        arr.add(new Asset("TSLA",8,7));
        arr.add(new Asset("GOOG",15,4));

        mergeSort(arr,0,arr.size()-1);
        for(Asset a:arr) System.out.print(a.name+":"+a.ret+" ");
        System.out.println();

        quickSort(arr,0,arr.size()-1);
        for(Asset a:arr) System.out.print(a.name+":"+a.ret+" ");
    }
}