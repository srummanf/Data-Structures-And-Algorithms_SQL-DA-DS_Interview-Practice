// Find the least number of coins required that can make any desired amount. The coins can only be pennies(1), nickels(5), dimes(10) and quarters(25).

public class Denomination {

  int p = 0, n = 0, d = 0, q = 0;

  int checkQuarter(int val) {
    if ((val - 25) >= 0) {
      val = val - 25;
      q++;
      checkQuarter(val);
    }
    return q;
  }

  int checkDimes(int val) {
    if ((val - 10) >= 0) {
      val = val - 10;
      d++;
      checkDimes(val);
    }
    return d;
  }

  int checkNickels(int val) {
    if ((val - 5) >= 0) {
      val = val - 5;
      n++;
      checkNickels(val);
    }
    return n;
  }

  int checkPennies(int val) {
    if ((val - 1) >= 0) {
      val = val - 1;
      p++;
      checkPennies(val);
    }
    return p;
  }

  void showCoins(int val) {
    int quarter = checkQuarter(val);
    // int p = (val - (quarter * 25));
    int dimes = checkDimes((val - (quarter * 25)));
    int nickels = checkNickels((val - (quarter * 25) - (dimes * 10)));
    int pennies = checkPennies((val - (quarter * 25) - (dimes * 10) - (nickels * 1)));

    System.out.println(
      "Quarters: " +
      quarter +
      "\nDimes: " +
      dimes +
      "\nNickels: " +
      nickels +
      "\nPennies: " +
      pennies
    );
  }

  public static void main(String[] args) {
    int val = 50;
    Denomination d = new Denomination();
    d.showCoins(val);
  }
}
