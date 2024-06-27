const ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
const rotor: Map<string, string> = new Map<string, string>();

const shuffledAlphabet = "EKMFLGDQVZNTOWYHXUSPAIBRCJ"; // Rotor I configuration
for (let i = 0; i < ALPHABET.length; i++) {
    rotor.set(ALPHABET[i], shuffledAlphabet[i]);
}

function encrypt(input: string): string {
    return transform(input, rotor);
}

function decrypt(input: string): string {
    const reverseRotor: Map<string, string> = new Map<string, string>();
    rotor.forEach((value, key) => {
        reverseRotor.set(value, key);
    });
    return transform(input, reverseRotor);
}

function transform(input: string, mapping: Map<string, string>): string {
    let result = "";
    for (let char of input.toUpperCase()) {
        if (ALPHABET.includes(char)) {
            result += mapping.get(char);
        } else {
            result += char; // Non-alphabetic characters are not transformed
        }
    }
    return result;
}

// Test the implementation
const message = "HELLO WORLD";
const encryptedMessage = encrypt(message);
const decryptedMessage = decrypt(encryptedMessage);

console.log("Original Message: " + message);
console.log("Encrypted Message: " + encryptedMessage);
console.log("Decrypted Message: " + decryptedMessage);
