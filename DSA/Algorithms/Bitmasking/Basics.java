import java.util.*;

class Basics {

  public static int add(int subset, int bitno) {
    return subset | (1 << (bitno - 1));
  }

  public static int remove(int subset, int bitno) {
    return subset & ~(1 << (bitno - 1));
  }

  public static void display(int subset) {
    for (int bitno = 1; bitno <= 9; bitno++) {
      // Whether the bitno is set or not
      if ((subset & (1 << (bitno - 1))) != 0) {
        System.out.print(bitno + " ");
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int subset = 27; // Binary: 11011, which means bits 1, 2, 4, and 5 are set
    System.out.print("Initial subset: ");
    display(subset);

    subset = add(subset, 3); // Adding bit 3
    System.out.print("After adding bit 3: ");
    display(subset);

    subset = remove(subset, 2); // Removing bit 2
    System.out.print("After removing bit 2: ");
    display(subset);
  }
}
