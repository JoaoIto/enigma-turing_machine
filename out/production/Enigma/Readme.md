# Enigma Machine Simulator

## Introdução

A máquina Enigma foi uma máquina de criptografia utilizada pela Alemanha durante a Segunda Guerra Mundial para proteger as comunicações militares. A máquina utilizava uma série de rotores que substituíam letras do alfabeto para encriptar e desencriptar mensagens. Este projeto simula o funcionamento básico da máquina Enigma em Java e TypeScript.

## Funcionamento da Máquina Enigma

A máquina Enigma usava uma série de rotores intercambiáveis, cada um dos quais substituía uma letra do alfabeto por outra. A configuração dos rotores era alterada diariamente com base em um código pré-determinado. Quando uma letra era digitada na máquina, ela passava por cada rotor, um refletor e depois voltava pelos rotores, produzindo uma letra encriptada. Para desencriptar a mensagem, a máquina era configurada da mesma maneira, e a mensagem encriptada era digitada, revertendo o processo de substituição.

## Implementação do Simulador

### Estrutura do Projeto

O projeto contém dois arquivos principais:

- `src.java.EnigmaSimulator.java`: Implementação em Java.
- `enigmaSimulator.ts`: Implementação em TypeScript.

### Código Java

```java
import java.util.HashMap;
import java.util.Map;

public class src.java.EnigmaSimulator {
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
    
    public static void main(String[] args) {
        String message = "HELLO WORLD";
        String encryptedMessage = encrypt(message);
        String decryptedMessage = decrypt(encryptedMessage);
        
        System.out.println("Original Message: " + message);
        System.out.println("Encrypted Message: " + encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}
```

### Código TypeScript

```typescript
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
```

### Explicação Detalhada

1. **Rotor**: Utilizamos um rotor que mapeia cada letra do alfabeto para outra letra. No exemplo, usamos a configuração do Rotor I da máquina Enigma. O rotor é representado por um `HashMap` em Java e um `Map` em TypeScript.

2. **Encrypt**: Para criptografar, transformamos cada letra da mensagem original usando o mapeamento do rotor.

3. **Decrypt**: Para descriptografar, invertemos o mapeamento do rotor e transformamos cada letra da mensagem criptografada usando esse mapeamento reverso.

4. **Transform**: A função `transform` aplica o mapeamento a cada letra da mensagem, ignorando caracteres que não são letras (como espaços).

## Como Rodar o Código

### Java

1. Compile o arquivo `src.java.EnigmaSimulator.java`:
   ```bash
   javac src.java.EnigmaSimulator.java
   ```
2. Execute o programa:
   ```bash
   java src.java.EnigmaSimulator
   ```

### TypeScript

1. Certifique-se de ter o Node.js e o TypeScript instalados.
2. Compile o arquivo `enigmaSimulator.ts`:
   ```bash
   tsc enigmaSimulator.ts
   ```
3. Execute o programa:
   ```bash
   node enigmaSimulator.js
   ```

## Conclusão

Este projeto é uma simplificação do funcionamento da máquina Enigma, demonstrando os conceitos básicos de substituição de letras através de rotores. A máquina Enigma real era muito mais complexa, utilizando múltiplos rotores, refletores e configurações diárias para garantir a segurança das comunicações.

---

Você pode salvar o conteúdo acima em um arquivo chamado `README.md` no seu projeto.