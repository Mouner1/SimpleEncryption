/*
 * Mouner Dabjan 
 * 24/02/2020
 * This program will encrypt a plain text message using the simple encryption algorithim to create the ciphertext
 */
package simpleencryption;

import javax.swing.*;

/**
 *
 * @author User
 */
public class SimpleEncryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //asking the user for their input
        String input = JOptionPane.showInputDialog(" Enter the phrase you want to encrypt or decrypt");
        String number = JOptionPane.showInputDialog(" Enter the number of rotations ");
        String choice = JOptionPane.showInputDialog(" 1- Encryption " + "\n 2- Decryption");
        String output = "";
        // changng the string values to integers
        int rotation = Integer.parseInt(number);
        int operation = Integer.parseInt(choice);
        // testing to see if the input value is a valid answer
        if (rotation < 1 && rotation > 25) {
            JOptionPane.showMessageDialog(null, " Please enter a valid rotation number");
        }
        // changing everything to uppercase letters
        input = input.toUpperCase();
        // doing the encryption scnario 
        if (operation == 1) {
            for (int i = 0; i < input.length(); i++) {
                int letter = (int) input.charAt(i);

                if (letter + rotation > 90) {
                    letter = letter + rotation - 26;
                } else if (letter != 32) {
                    letter = letter + rotation;

                }
                output = output + Character.toString((char) letter);
            }

            System.out.println(" The phrase at the start " + input);
            System.out.println(" The ciphertext phrase is " + output);
           // doing the decryption scenario  
        } else if (operation == 2) {
            for (int i = 0; i < input.length(); i++) {
                int letter = (int) input.charAt(i);
                if (letter - rotation < 65) {
                    letter = letter - rotation + 26;
                } else if (letter != 32) {
                    letter = letter - rotation;
                }
                output = output + Character.toString((char) letter);
            }
            System.out.println(" The original phrase is " + input);
            System.out.println(" The decrypted ciphertext " + output);
        }
    }

}
