/*
* Project 4 for CS 1180.
* This program simulates an bat in baseball.
* This program asks the user for the names and averages of a pitcher and a 
* batter.
* The program then determines whether the pitcher throws a strike or a ball.
* If it is a strike, the program determines if the batter hits it.
 */

 /*
 * Author: Jack Keller
 * Section: CS 1180L-05
 * Instructor: Dr. Richard Volkers
 * Project 4
 */
package project4_keller;

import java.util.Scanner;

/**
 *
 * @author Jack Keller
 */
public class Project4_Keller {

    /**
     * @param args the command line arguments
     */
    
    // This method first asks the user for the names and averages of the 
    // pitcher and batter.  The method calls the pitcher's pitch function
    // and if true, it calls the batter's bat function, and if
    // not the method says its a ball.  If the bat function is false, the method
    // says its a ball.  If true, the method calls it a hit.  The method keeps
    // track of balls and strikes to determine a walk or a strike out.
    
    public static void atBat() {
        Scanner input = new Scanner(System.in);
        
        // This set of code gets the pitcher and batter's info from the user and
        // instantiates the batter and pitcher.
        
        System.out.print("What's the pitcher's name? ");
        String pname = input.nextLine();
        System.out.print("What is their pitching average? ");
        double paver = input.nextDouble();
        input.nextLine();
        System.out.print("What's the batter's name? ");
        String bname = input.nextLine();
        System.out.print("What is their batting average? ");
        double baver = input.nextDouble();
        
        Batter batter = new Batter(bname,baver);
        Pitcher pitcher = new Pitcher(pname,paver);
        
        int balls = 0;
        int strikes = 0;
        int ho = 0;
        
        System.out.printf("%s is pitching to %s.\n",pitcher.getName(),batter.getName());
        
        // This loop calls the pitch function and if true, calls the hit 
        // function.  If false, it says the pitch was a ball.  If the hit 
        // funciton is true, the method says its a hit.  If it is false, the
        // method says it is a strike.  The method keeps track of the balls 
        // and strikes for a walk or a strike out.
        
        do {
            if(pitcher.pitch()) {
                if(batter.hit()) {
                    System.out.printf("%s got a hit!\n",batter.getName());
                    break;
                } else {
                    System.out.printf("\t%s swung and missed.\n",batter.getName());
                    strikes += 1;
                }
            } else {
                System.out.printf("\t%s threw a ball.\n", pitcher.getName());
                balls += 1;
            }
            
            if(strikes == 3) {
                System.out.printf("%s struck out.\n",batter.getName());
                ho = 1;
            } else if (balls  == 4) {
                System.out.printf("%s walked.\n",batter.getName());
                ho = 1;
            } else {
                System.out.printf("\tThe count is %d balls and %d strikes.\n", balls, strikes);
            }            
            
        } while(ho == 0);
        
        
    }
    
    // All main does is call the method that gets info from the user and
    // simulates the at bat.
    
    public static void main(String[] args) {
        atBat();
    }
    
}
