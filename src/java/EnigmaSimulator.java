package src.java;

import java.util.HashMap;
import java.util.Map;

public class EnigmaSimulator {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Map<Character, Character> rotor = new HashMap<>();

    static {
        String shuffledAlphabet = "EKMFLGDQVZNTOWYHXUSPAIBRCJ"; // Rotor I configuration
        for (int i = 0; i < ALPHABET.length(); i++) {
            rotor.put(ALPHABET.charAt(i), shuffledAlphabet.charAt(i));
        }
    }

    public static String encrypt(String input) {
        return transform(input, rotor);
    }

    public static String decrypt(String input) {
        Map<Character, Character> reverseRotor = new HashMap<>();
        for (Map.Entry<Character, Character> entry : rotor.entrySet()) {
            reverseRotor.put(entry.getValue(), entry.getKey());
        }
        return transform(input, reverseRotor);
    }

    private static String transform(String input, Map<Character, Character> mapping) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toUpperCase().toCharArray()) {
            if (ALPHABET.indexOf(c) != -1) {
                result.append(mapping.get(c));
            } else {
                result.append(c); // Non-alphabetic characters are not transformed
            }
        }
        return result.toString();
    }
}
