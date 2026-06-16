import java.util.*;

public class IntersectionAndUnionOfTwoUnsortedArrays {
    void intersection(int a[], int b[]) {
        HashSet<Integer> m = new HashSet<>();
        HashSet<Integer> n = new HashSet<>();
        for (int x : a) {
            m.add(x);
        }
        for (int x : b) {
            n.add(x);
        }
        for (int x : n) {
            if (m.contains(x)) {
                System.out.print(x + " ");
            }
        }
    }

    void union(int a[], int b[]) {
        HashSet<Integer> m = new HashSet<>();
        for (int x : a) {
            m.add(x);
        }
        for (int x : b) {
            m.add(x);
        }
        for (int x : m) {
            System.out.print(x + " ");
        }
    }

    public static void main(String args[]) {
        int a[] = { 10, 15, 20, 15, 30, 30, 5 };
        int b[] = { 30, 5, 30, 80 };
        IntersectionAndUnionOfTwoUnsortedArrays i = new IntersectionAndUnionOfTwoUnsortedArrays();
        System.out.println("Intersection of two arrays is: ");
        i.intersection(a, b);
        System.out.println("\nUnion of two arrays is: ");
        i.union(a, b);
    }

}
