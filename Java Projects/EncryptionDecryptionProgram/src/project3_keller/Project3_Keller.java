/*
* Project 3 for CS 1180.
* This program serves a encryption/decryption tool for a Caesar Cipher.
* This program asks the user if they would like to encrypt or decrypt a file.
* The program then accesses the text file, encrypts/decrypts it, then creates a 
* new file for the text.
 */

 /*
 * Author: Jack Keller
 * Section: CS 1180L-05
 * Instructor: Dr. Richard Volkers
 * Project 3
 */
package project3_keller;

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

/**
 *
 * @author Ecslogon2
 */
public class Project3_Keller {

    /**
     * @param args the command line arguments
     */
    
    // This method gets the user's input whether they want to encrypt or decrpyt
    // a file or end the program. 
    // The method returns the user's option to Main.
    public static int getMenuOption() {
        Scanner input = new Scanner(System.in);

        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        System.out.println("3. Quit");
        System.out.print("What would you like to do? ");
        int option = input.nextInt();

        while (option < 1 || option > 3) {
            System.out.println("Error: Invalid option.");
            System.out.print("What would you like to do? ");
            option = input.nextInt();
        }

        return option;
    }

    // This method takes a text file and a key for the cipher and encrpyts the 
    // text inside the text file. 
    // After it is encrypted, the method creates a new file for the encrypted 
    // text.
    public static void encrypt(File inputFile, int key) throws Exception {
        String filename = inputFile.toString();
        
        if(filename.contains(".txt")) {
            String encryptedFilename = filename.replaceAll(".txt",".enc");
            
            File encryptedFile = new File(encryptedFilename);
            
            Scanner fin = new Scanner(inputFile);
            String text = "";
            
            while(fin.hasNext()) {
                text += fin.next();
            }
            
            PrintWriter pw = new PrintWriter(encryptedFile);
            String entext = "";
            
            for(int i = 0; i < text.length(); i++) {
                int c = text.charAt(i);
                
                if(Character.isUpperCase(c)) {
                    c = c + (key % 26);
                    if (c > 'Z') {
                        c = c - 26;
                    }
                } else if (Character.isLowerCase(c)) {
                    c = c + (key % 26);
                    if (c > 'z') {
                        c = c - 26;
                    }
                }
                
                entext += (char) c;
            }
            
            pw.printf("%s", entext);
            pw.close();
            
        } else {
            return;
        }
        
    }

    // This method takes a text file and a key for the cipher and decrpyts the 
    // text inside the text file. 
    // After it is decrypted, the method creates a new file for the decrypted 
    // text.
    public static void decrypt(File inputFile, int key) throws Exception {
        String filename = inputFile.toString();
        
        if(filename.contains(".enc")) {
            String decryptedFilename = filename.replaceAll(".enc",".txt");
            
            File decryptedFile = new File(decryptedFilename);
            Scanner fin = new Scanner(inputFile);
            String text = "";
            
            while(fin.hasNext()) {
                text += fin.next();
            }
            
            PrintWriter pw = new PrintWriter(decryptedFile);
            String detext = "";
            
            for(int i = 0; i < text.length(); i++) {
                int c = text.charAt(i);
                
                if(Character.isUpperCase(c)) {
                    c = c + (key % 26);
                    if (c > 'Z') {
                        c = c - 26;
                    }
                } else if (Character.isLowerCase(c)) {
                    c = c + (key % 26);
                    if (c > 'z') {
                        c = c - 26;
                    }
                }
                
                detext += (char) c;
            }
            
            pw.printf("%s", detext);
            pw.close();
        } else {
            return;
        }
    }

    // Main calls the getMenuOption to determine what the user wants to do.
    // While the user wants to encrypt or decrpyt a file, the program keeps 
    // running and main calls the corresponding method. 
    // For encryption or decrption, main gets the name of the text file and the
    // key for the cipher then sends them to the right methods.
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int option = 0;

        do {
            option = getMenuOption();

            if (option == 1) {

                System.out.print("Enter the name of the file: ");
                String filename = input.next();
                System.out.print("Enter the key: ");
                int key = input.nextInt();

                File inputFile = new File(filename);

                encrypt(inputFile, key);

            } else if (option == 2) {

                System.out.print("Enter the name of the file: ");
                String filename = input.next();
                System.out.print("Enter the key: ");
                int key = input.nextInt();

                File inputFile = new File(filename);

                decrypt(inputFile, key);
            }

        } while (option != 3);

    }

}