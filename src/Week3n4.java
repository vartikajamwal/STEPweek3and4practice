import java.util.*;

class Client {
    String name;
    int risk;
    int balance;
    Client(String name,int risk,int balance){
        this.name=name;
        this.risk=risk;
        this.balance=balance;
    }
}

public class Week3n4 {
    static void bubbleSort(Client[] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j].risk>arr[j+1].risk){
                    Client t=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                }
            }
        }
    }

    static void insertionSort(Client[] arr){
        for(int i=1;i<arr.length;i++){
            Client key=arr[i];
            int j=i-1;
            while(j>=0 && (arr[j].risk<key.risk ||
                    (arr[j].risk==key.risk && arr[j].balance<key.balance))){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }

    public static void main(String[] args){
        Client[] arr={
                new Client("C",80,1000),
                new Client("A",20,2000),
                new Client("B",50,1500)
        };

        bubbleSort(arr);
        for(Client c:arr) System.out.print(c.name+":"+c.risk+" ");
        System.out.println();

        insertionSort(arr);
        for(Client c:arr) System.out.print(c.name+":"+c.risk+" ");
        System.out.println();

        for(int i=0;i<Math.min(10,arr.length);i++)
            System.out.print(arr[i].name+" ");
    }
}