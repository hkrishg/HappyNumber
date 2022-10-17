class Main {

//   Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits, leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not include ‘1’.

// Example 1:

// Input: 23   
// Output: true (23 is a happy number)  
// Explanations: Here are the steps to find out that 23 is a happy number:
// 2
// 2
// +
// 3
// 2
// 2
// ​2
// ​​ +3
// ​2
// ​​  = 4 + 9 = 13
// 1
// 2
// +
// 3
// 2
// 1
// ​2
// ​​ +3
// ​2
// ​​  = 1 + 9 = 10
// 1
// 2
// +
// 0
// 2
// 1
// ​2
// ​​ +0
// ​2
// ​​  = 1 + 0 = 1

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