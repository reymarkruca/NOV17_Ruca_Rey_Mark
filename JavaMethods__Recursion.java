/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package methods_recursion;

/**
 *
 * @author Rey Mark S. Ruca
 */
public class JavaMethods__Recursion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("PROBLEM 1");
        System.out.println(computeAverage(5, 2));
        System.out.println(computeAverage(10, 0));
        System.out.println(computeAverage(100, 8));

        System.out.println("\nPROBLEM 2");
        int[] grades = {60, 75, 88, 74, 91};
        System.out.println("Loop: " + countPassing(grades, 75));
        System.out.println("Recursive: " + countPassingRecursive(grades, 75, 0));

        System.out.println("\nPROBLEM 3");
        System.out.println(factorial(0));
        System.out.println(factorial(1));
        System.out.println(factorial(4));
    }
     // PROBLEM-1
    public static double computeAverage(int total, int count) {

        if (count <= 0) {
            return 0.0;
        }

        return (double) total / count;
    }
      // PROBLEM-2
    public static int countPassing(int[] grades, int passingMark) {

        int count = 0;

        for (int i = 0; i < grades.length; i++) {

            if (grades[i] >= passingMark) {
                count++;
            }
        }

        return count;
    }
       
    public static int countPassingRecursive(int[] grades, int passingMark, int index) {

        if (index == grades.length) {
            return 0;
        }

        int count = 0;

        if (grades[index] >= passingMark) {
            count = 1;
        }

        return count + countPassingRecursive(grades, passingMark, index + 1);
    }
       // PROBLEM-3
    public static int factorial(int n) {

        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

}

        //PROBLEM 1:
       // 1. Why does the method need the word double (or a cast) in the return?
       //   It needs double because the answer can have decimal numbers. It helps give the correct average.
      
       //2. What would go wrong without the count <= 0 guard?
       //If we don't put the guard, the program might divide by zero and give an error. That's why we need to check the count first.

      //PROBLEM 2:
      // 1. What does each recursive call do to index, and why must it change?
       //   Each time the method calls itself, the index increases by 1 to check the next grade.
       //   It must change so the program can stop at the end.

      // 2. What happens if you delete the base case entirely?
       //The program will continue calling itself and will not stop. It can cause a StackOverflowError.

       //PROBLEM 3:
     //   1. Why did one wrong return make every result wrong?
        //  Because the base case is important in recursion. If it returns 0 instead of 1, all the calculations will become wrong.

     //2. What happens for factorial(-2) with your corrected code, and why?
        //  It will return 1 because the condition is n