/**
 * Cipher.java
 * 
 * Program to decipher messages encoded using a Caesar cipher.
 * 
 * @author Ryan Regier
 * CSCI 235, Wheaton College, Fall 2019
 * Project 2
 * Date 09/25/2019
 */

import java.util.Scanner; //import scanner
import java.io.*;		//import input/output

public class Cipher {
	//main driver method that does everything for the Cipher.java program
    public static void main(String[] args) {

        // encrypted text
        String ciphertext;  

        // input from keyboard
        Scanner keyboard = new Scanner(System.in);

        // -----------------------------------------------------------------
        // this section contains stuff we haven't covered yet. 
        // -----------------------------------------------------------------
        if (args.length > 0) {
            ciphertext = "";
            try {
                Scanner inputFile = new Scanner(new File(args[0]));
                while(inputFile.hasNext()) 
                    ciphertext += inputFile.nextLine();
            } catch(IOException ioe) {
                System.out.println("File not found: " + args[0]);
                System.exit(-1);
            }
        }
        else {
            System.out.print("Please enter text--> ");
            ciphertext = keyboard.nextLine(); 
        }
        // -----------------------------------------------------------------

        int distance = 0;  // how far the ciphertext should be shifted
        String next = "";  // user input after viewing

        /*
         * Depending on how you solve the problem, you might need
         * to declare plaintext here instead of inside the while loop.
         */
        String plaintext = ""; // the (possibly) decrypted message
        char letters [] = new char[ciphertext.length()]; //array to hold each letter of input and update as the letters are shifted
        for(int i = 0; i < letters.length; i++){
            letters[i] = ciphertext.charAt(i);
        }
        while(!next.equals("quit")) {
            distance += 1;
            // Your code to shift the ciphertext goes here;
            // make plaintext ciphertext shifted by distance.
            // Do not change ciphertext
            plaintext = ""; // the (possibly) decrypted message
            for(int i = 0; i < letters.length; i++){   //loop through each letter of the array, shift it up one, and update the array letters at each element            
                if(letters[i] >= 65 && letters[i] <= 90 || letters[i] >= 97 && letters[i] <= 122){ //make sure that letters[i] is either a lowercase/uppercase letter and not a special character
                    if(letters[i] == 'Z'){
                        letters[i] = 'A';
                    } else if(letters[i] == 'z'){
                        letters[i] = 'a';
                    } else {
                        letters[i] = (char)(letters[i] + 1);
                    }
                }
            }
            for(int z = 0; z < letters.length; z++){ //add the decrypted message to the plaintext variable from the letters array
                plaintext += letters[z];
            }

            System.out.println ("Original input: " + ciphertext); //print original message
			
			System.out.println();

            // At this point, plaintext is the shifted ciphertext.
            // Nothing below this should need to change.
            System.out.println("distance " + distance);
            System.out.println("Shifted/decrypted text : " + plaintext);
			System.out.println();
            System.out.println("Press enter to see the next option,"
                + "type 'quit' to quit.");
            next = keyboard.nextLine().trim();
        }
        System.out.println("Final shift distance was " + distance + " places");
    }

}
