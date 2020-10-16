/*
 * Author: Jack Keller
 * Section: CS 1181L-06
 * Date: 9/30/2017
 * Project 1
 */
package keller_project1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.Collections;
import java.util.InputMismatchException;

/**
 *
 * @author Jack Keller
 */
public class Keller_Project1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // The library ArrayList is created and looks to see if there is a file
        // to load in and fill library.
        
        ArrayList<Media> library = new ArrayList<>();

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("library.bin")));
            library = (ArrayList<Media>) ois.readObject();
        } catch (IOException e) {
            // System.err.println("Caught IOException: " + e.getMessage());
        } catch (ClassNotFoundException e1) {
            // System.err.println("Caught ClassNotFoundException: " + e1.getMessage());
        }

        int choice = 0;

        System.out.println("Hello! Welcome to your media library!");

        loop:
        do {
            // The menu of options is displayed and the user's input is taken.
            // There is a try-catch block to see if the user enters anything 
            // that isn't an int. This do-while loop will run until the user
            // choose "6" to quit.
            
            try {
                System.out.println("");
                System.out.println("\t1. Insert a New Media Item");
                System.out.println("\t2. Mark Item as a Loan");
                System.out.println("\t3. Mark an Item as Returned");
                System.out.println("\t4. List Items Currently in Inventory");
                System.out.println("\t5. Remove an Item");
                System.out.println("\t6. Quit");
                System.out.print("\nPlease choose an option from the menu: ");
                choice = input.nextInt();
                input.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("\nError. Invalid entry. Please enter a number.\n");
                input.nextLine();
                continue loop;
            }

            // This while loop makes sure the user entered an int that is one of
            // the options from the menu.
            
            while (choice < 1 || choice > 6) {
                System.out.println("\nError. Choice not listed.\n");
                System.out.println("\t1. Insert a New Media Item");
                System.out.println("\t2. Mark Item as a Loan");
                System.out.println("\t3. Mark an Item as Returned");
                System.out.println("\t4. List Items Currently in Inventory");
                System.out.println("\t5. Remove an Item");
                System.out.println("\t6. Quit");
                System.out.print("Please enter a valid choice from the menu: ");
                choice = input.nextInt();
                input.nextLine();
            }
            
            // The switch is the different options the user can choose.

            switch (choice) {
                case 1:
                    // The program asks the user for a title and format, creates
                    // a media item, then calls the ediLibrary function.
                    
                    System.out.print("\nWhat is the title of the media? ");
                    String title = input.nextLine();
                    System.out.print("What is the format (Xbox, PlayStation, Blu-Ray, DVD) of the media? ");
                    String format = input.nextLine();
                    Media m1 = new Media(title, format);
                    
                    library = m1.editLibrary(library,choice);

                    break;
                case 2:
                    // The program asks the user for a title of a media to loan
                    // out.  If the library has that media, the user enters
                    // the name of the person being loaned to and the date
                    // it was loaned out then calls the loan function.
                    
                    System.out.print("\nWhat media would you like to loan out? ");
                    title = input.nextLine();
                    for (Media m : library) {
                        if (title.compareTo(m.getTitle()) == 0) {
                            System.out.print("Who would you like to loan it to? ");
                            String loanee = input.nextLine();
                            System.out.print("What day is it being loaned out?(mm/dd/YYYY) ");
                            String date = input.nextLine();
                            m.loan(date, loanee);
                            System.out.println("\nThe media was marked as loaned out.");

                            continue loop;
                        }
                    }

                    System.out.println("\nThat media was not found in the library.");

                    break;
                case 3:
                    // The program asks for the title of the media being
                    // returned.  If the library has that media, the program
                    // calls the return function.
                    
                    System.out.print("\nWhat media is being returned? ");
                    title = input.nextLine();
                    for (Media m : library) {
                        if (title.compareTo(m.getTitle()) == 0) {
                            m.loanReturn();
                            System.out.println("\nThe media was marked as returned.");
                            continue loop;
                        }
                    }

                    System.out.println("\nThat media was not found in the library.");

                    break;
                case 4:
                    // The program puts the media items in the library in 
                    // alphabetical order by title.  The program then prints out
                    // the library.
                    
                    Collections.sort(library, Media.MediaTitleComparator);

                    if (library.isEmpty()) {
                        System.out.println("\nThere is nothing in your library.");
                    } else {
                        for (Media m : library) {
                            System.out.println(m);
                        }
                    }

                    break;
                case 5:
                    // The program asks the user for the title of the media to
                    // be removed then creates a media object to call the 
                    // editLibrary function.
                    
                    System.out.print("What media would you like to remove? ");
                    title = input.nextLine();
                    Media m2 = new Media(title, "");
                    
                    library = m2.editLibrary(library, choice);

                    break;
                case 6:
                    // The program saves the library to a file named
                    // "library.bin" to be used the next time the program is
                    // ran.
                    
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("library.bin")));
                        oos.writeObject(library);
                        oos.close();
                    } catch (IOException e) {
                        System.err.println("Caught IOException: " + e.getMessage());
                    }

            }

        } while (choice != 6);
    }

}
