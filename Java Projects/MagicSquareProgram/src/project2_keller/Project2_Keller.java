/*
* Project 2 for CS 1180.
* This program helps the user create a Magic Sqaure.
* This program asks the user for the size of the square and for the user to populate the sqaure.
* The program checks for a completed Magic Square after every number entered.
 */

 /*
 * Author: Jack Keller
 * Section: CS 1180L-05
 * Instructor: Dr. Richard Volkers
 * Project 2
 */
package project2_keller;

import java.util.Scanner;

/**
 *
 * @author Jack Keller
 */
public class Project2_Keller {

    /**
     * @param args the command line arguments
     */
    
    // This function tests to make sure the number entered by the user has not been used already.
    public static int testOptionValue(int[][] square, int option) {
        int test = 1;

        for (int r = 0; r < square.length; r++) {
            for (int c = 0; c < square[r].length; c++) {
                if (square[r][c] == option) {
                    test = 0;
                    return test;
                }
            }
        }

        return test;
    }

    // This function makes sure there are no longer any zeros in the square.
    // The square cannot be considered finished if there are still zeros.
    // This function also tests if the sums of the rows, columns, and diagonals are all equal.
    public static int testMagicSquare(int[][] square, int n, int[] sumr, int[] sumc, int sum) {
        int result = 0;

        for (int r = 0; r < square.length; r++) {
            for (int c = 0; c < square[r].length; c++) {
                if (square[r][c] == 0) {
                    result = 0;
                    return result;
                }
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (sumr[r] != sum) {
                    result = 0;
                    return result;
                } else if (sumc[c] != sum) {
                    result = 0;
                    return result;
                } else {
                    result = 1;
                    return result;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // This code gets the size of the square from the user and makes sure it is between 3 and 8.
        System.out.print("Let's make a Magic Sqaure! How big should it be? ");
        int n = input.nextInt();

        if (n <= 2 || n >= 9) {
            while (n <= 2) {
                System.out.print("That would violate the laws of mathematics!\n\n");

                System.out.print("Let's make a Magic Sqaure! How big should it be? ");
                n = input.nextInt();
            }

            while (n >= 9) {
                System.out.print("That's huge! Please enter a number less than 9.\n\n");

                System.out.print("Let's make a Magic Sqaure! How big should it be? ");
                n = input.nextInt();
            }
        }

        System.out.println("Great!\n");

        int[][] square = new int[n][n];

        // This code shows the current numbers in the sqaure.
        System.out.println("The square currently looks like this:");

        for (int r = 0; r < square.length; r++) {
            for (int c = 0; c < square[r].length; c++) {
                System.out.printf("%3d ", square[r][c]);
            }
            System.out.print("\n");
        }

        System.out.print("\n");

        int truth = 0;

        // This is the start of the loop that will continue until a MAgic Sqaure is made.
        do {

            // This code asks the user for the location of the new number they enter.
            System.out.println("Where do you want to put a new value?");
            System.out.print("Row: ");
            int row = input.nextInt();
            System.out.print("Column: ");
            int column = input.nextInt();
            System.out.print("What vlaue should go there? ");
            int option = input.nextInt();

            // This code makes sure the number as well as the location are valid.
            if (row >= n || row < 0 || column >= n || column < 0) {
                System.out.println("Error: Invalid row or column entry.");
                System.out.println("");
            } else {

                int test = testOptionValue(square, option);

                if (option > n * n || option < 1) {
                    System.out.printf("You can only use numbers between 1 and %d for this square.\n\n", n * n);
                } else if (test == 0) {
                    System.out.println("That number already occurs in the square.\n");
                } else {
                    square[row][column] = option;
                }

                System.out.println("");

                // This code shows what is currently in the square.
                System.out.println("The square currently looks like this:");

                for (int r = 0; r < square.length; r++) {
                    for (int c = 0; c < square[r].length; c++) {
                        System.out.printf("%3d ", square[r][c]);
                    }
                    System.out.print("\n");
                }

                System.out.print("\n");

                // This code sums up the rows, columns, and diagonals.
                int[] sumr = new int[n];

                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        sumr[r] += square[r][c];
                    }
                }

                int[] sumc = new int[n];

                for (int c = 0; c < n; c++) {
                    for (int r = 0; r < n; r++) {
                        sumc[c] += square[r][c];
                    }
                }

                int sumd = 0;

                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        if (r == c) {
                            sumd += square[r][c];
                        }
                    }
                }

                // This code calls the test function and finds out if the square is completed or not.
                truth = testMagicSquare(square, n, sumr, sumc, sumd);

            }
        } while (truth != 1);

        // The code let's the user know a Magic Square has been created and ends the program.
        System.out.println("Victory!\n");

    }
}
