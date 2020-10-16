/*
 * Author: Jack Keller
 * Section: CS 1180L-05
 * Instructor: Dr. Richard Volkers
 * Project 1
 */
package project1_keller;

import java.util.Scanner;

/**
 *
 * @author Jack
 */
public class Project1_Keller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Initialize all of the varaibales being used
        
        int choice = 0;
        double counter = 0;
        double correct = 0;
        double percent = 0;
        
        // Start the loop that doesn't end until the user selects option 6
        
        do {
            System.out.println("Please choose one of the following options for your math quiz:");
            System.out.println("1. Addition with numbers 1-10");
            System.out.println("2. Addition with numbers 1-100");
            System.out.println("3. Subtraction with numbers 1-10");
            System.out.println("4. Subtraction with numbers 1-100");
            System.out.println("5. Multiplication with numbers 1-10");
            System.out.println("6. Exit the program\n");
            choice = input.nextInt();
            
            // Check to make sure the user entered a number 1-6
            
            while (choice < 1 || choice > 6) {
                System.out.println("\nValid choices are 1-6; Please re-enter ");
                choice = input.nextInt();
            }
            
            // Initilialize the array for the random numbers used in the problems
            
            int[] problemNumbers = new int[10];
            int answer = 0;
           
            switch (choice) {
                // If the user chooses 1, give them 5 addition problems
                
                case 1:
                    for(int i = 0; i < problemNumbers.length; i++) {
                        problemNumbers[i] = (int)(1 + Math.random() * 10);
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d + %d\n", problemNumbers[0],problemNumbers[1]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[0]+ problemNumbers[1]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[0] + problemNumbers[1]);
                        counter += 1;
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d + %d\n", problemNumbers[2],problemNumbers[3]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[2]+ problemNumbers[3]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[2] + problemNumbers[3]);
                        counter += 1;
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d + %d\n", problemNumbers[4],problemNumbers[5]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[4]+ problemNumbers[5]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[4] + problemNumbers[5]);
                        counter += 1;
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d + %d\n", problemNumbers[6],problemNumbers[7]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[6]+ problemNumbers[7]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[6] + problemNumbers[7]);
                        counter += 1;
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d + %d\n", problemNumbers[8],problemNumbers[9]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[8]+ problemNumbers[9]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[8] + problemNumbers[9]);
                        counter += 1;
                    }
                    
                    System.out.println("");
                    
                    break;
                // If the user chooses 2, give them 5 addition problems
                    
                case 2:
                    for(int i = 0; i < problemNumbers.length; i++) {
                        problemNumbers[i] = (int)(1 + Math.random() * 100);
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d + %d\n", problemNumbers[0],problemNumbers[1]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[0]+ problemNumbers[1]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[0] + problemNumbers[1]);
                        counter += 1;
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d + %d\n", problemNumbers[2],problemNumbers[3]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[2]+ problemNumbers[3]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[2] + problemNumbers[3]);
                        counter += 1;
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d + %d\n", problemNumbers[4],problemNumbers[5]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[4]+ problemNumbers[5]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[4] + problemNumbers[5]);
                        counter += 1;
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d + %d\n", problemNumbers[6],problemNumbers[7]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[6]+ problemNumbers[7]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[6] + problemNumbers[7]);
                        counter += 1;
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d + %d\n", problemNumbers[8],problemNumbers[9]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[8]+ problemNumbers[9]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[8] + problemNumbers[9]);
                        counter += 1;
                    }
                    
                    System.out.println("");
                    
                    break;
                // If the user chooses 3, give them 5 subtraction problems    
                
                case 3:
                    for(int i = 0; i < problemNumbers.length; i++) {
                        problemNumbers[i] = (int)(1 + Math.random() * 10);
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d - %d\n", problemNumbers[0],problemNumbers[1]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[0]- problemNumbers[1]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[0] - problemNumbers[1]);
                        counter += 1;
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d - %d\n", problemNumbers[2],problemNumbers[3]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[2]- problemNumbers[3]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[2] - problemNumbers[3]);
                        counter += 1;
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d - %d\n", problemNumbers[4],problemNumbers[5]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[4]- problemNumbers[5]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[4] - problemNumbers[5]);
                        counter += 1;
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d - %d\n", problemNumbers[6],problemNumbers[7]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[6]- problemNumbers[7]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[6] - problemNumbers[7]);
                        counter += 1;
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d - %d\n", problemNumbers[8],problemNumbers[9]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[8]- problemNumbers[9]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[8] - problemNumbers[9]);
                        counter += 1;
                    }
                    
                    System.out.println("");
                    
                    break;
                // If the user chooses 4, give them 5 subtraction problems
                    
                case 4:
                    for(int i = 0; i < problemNumbers.length; i++) {
                        problemNumbers[i] = (int)(1 + Math.random() * 100);
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d - %d\n", problemNumbers[0],problemNumbers[1]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[0]- problemNumbers[1]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[0] - problemNumbers[1]);
                        counter += 1;
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d - %d\n", problemNumbers[2],problemNumbers[3]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[2]- problemNumbers[3]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[2] - problemNumbers[3]);
                        counter += 1;
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d - %d\n", problemNumbers[4],problemNumbers[5]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[4]- problemNumbers[5]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[4] - problemNumbers[5]);
                        counter += 1;
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d - %d\n", problemNumbers[6],problemNumbers[7]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[6]- problemNumbers[7]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[6] - problemNumbers[7]);
                        counter += 1;
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d - %d\n", problemNumbers[8],problemNumbers[9]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[8]- problemNumbers[9]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[8] - problemNumbers[9]);
                        counter += 1;
                    }
                    
                    System.out.println("");
                    
                    break;
                // If the user choose 5, give 5 multiplication problems
                    
                case 5:
                    for(int i = 0; i < problemNumbers.length; i++) {
                        problemNumbers[i] = (int)(1 + Math.random() * 10);
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d * %d\n", problemNumbers[0],problemNumbers[1]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[0] * problemNumbers[1]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[0] * problemNumbers[1]);
                        counter += 1;
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d * %d\n", problemNumbers[2],problemNumbers[3]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[2] * problemNumbers[3]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[2] * problemNumbers[3]);
                        counter += 1;
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d * %d\n", problemNumbers[4],problemNumbers[5]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[4] * problemNumbers[5]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[4] * problemNumbers[5]);
                        counter += 1;
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d * %d\n", problemNumbers[6],problemNumbers[7]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[6] * problemNumbers[7]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[6] * problemNumbers[7]);
                        counter += 1;
                    }
                    
                    System.out.printf("\nEnter the answer to the following problem: %d * %d\n", problemNumbers[8],problemNumbers[9]);
                    answer = input.nextInt();
                    
                    // Display whether the answer is correct or not and keep track of the progress
                    
                    if (answer == problemNumbers[8] * problemNumbers[9]) {
                        System.out.print("That is the correct answer!\n");
                        correct += 1;
                        counter += 1;
                    } else {
                        System.out.printf("Sorry, that is incorrect. The correct answer is %d\n",problemNumbers[8] * problemNumbers[9]);
                        counter += 1;
                    }
                    
                    System.out.println("");
                    
                    break;
                // If the user chooses 6, the program finishes running
                    
                case 6:
                    break;
            }

        } while(choice != 6);
        
        // Output the number correct out of the number attempted and the percentage
        
        percent = (correct / counter) * 100;
        
        System.out.printf("\nYou got %.0f problems correct out of %.0f problems attempted. That is %.2f percent correct. Goodbye!\n",correct,counter,percent);
    }
}
