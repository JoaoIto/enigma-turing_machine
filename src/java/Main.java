package src.java;

import static src.java.EnigmaSimulator.decrypt;
import static src.java.EnigmaSimulator.encrypt;

public class Main {
    public static void main(String[] args) {
        String message = "HELLO WORLD";
        String encryptedMessage = encrypt(message);
        String decryptedMessage = decrypt(encryptedMessage);

        System.out.println("Original Message: " + message);
        System.out.println("Encrypted Message: " + encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}
