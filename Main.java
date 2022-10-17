class Main {

  public static int getNext(int n) {
    int totalSum = 0;
    while (n > 0) {
      int d = n % 10;
      n = n / 10;
      totalSum += d * d;
    }
    return totalSum;
  }

  public static boolean isHappy(int n) {
    int slowRunner = n;
    int fastRunner = n;
    do {
      slowRunner = Main.getNext(slowRunner);
      fastRunner = Main.getNext(Main.getNext(fastRunner));
    } while (fastRunner != 1 && slowRunner != fastRunner);
    
    return fastRunner == 1;
  }

  public static void main(String[] args) {
    System.out.println(Main.isHappy(23));
    System.out.println(Main.isHappy(12));

  }
}