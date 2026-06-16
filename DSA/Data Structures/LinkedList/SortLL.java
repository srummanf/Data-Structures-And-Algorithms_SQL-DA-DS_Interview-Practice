import java.util.*;
import java.io.*;

public class SortLL {

    public static void main(String[] args)

    {
        Scanner sc = new Scanner(System.in);

        LinkedList<Integer> ll = new LinkedList<>();
        LinkedList<Integer> ll2 = new LinkedList<>();
        LinkedList<Integer> ll3 = new LinkedList<>();
        int a, b;
        System.out.println("Enter the number of elements in the first linked list");
        a = sc.nextInt();
        System.out.println("Enter the elements of the first linked list");
        for (int i = 0; i < a; i++) {
            ll.add(sc.nextInt());
        }
        System.out.println("Enter the number of elements in the second linked list");
        b = sc.nextInt();
        System.out.println("Enter the elements of the second linked list");
        for (int i = 0; i < b; i++) {
            ll2.add(sc.nextInt());
        }
        ll3.addAll(ll);
        ll3.addAll(ll2);
        int n =ll3.size();
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(ll3.get(j)>ll3.get(j+1)){
                    int temp=ll3.get(j);
                    ll3.set(j,ll3.get(j+1));
                    ll3.set(j+1,temp);
                }
            }
        }

        System.out.println("The sorted linked list is: "+ ll3);
    }
}
