## Estrutura do Código

O código é dividido em várias partes, cada uma desempenhando um papel específico na simulação da máquina Enigma. Vamos explorar cada parte do código detalhadamente.

### 1. Definição do Alfabeto e do Rotor

```java
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
```

- **ALPHABET**: Uma constante que contém todas as letras do alfabeto em ordem. Esta é a base para a substituição de letras.
- **rotor**: Um mapa (`HashMap`) que armazena a configuração do rotor. O rotor é configurado para mapear cada letra do alfabeto para uma letra diferente, de acordo com uma configuração pré-determinada.
- **static block**: Um bloco estático que inicializa o `rotor` mapeando cada letra do `ALPHABET` para a letra correspondente no `shuffledAlphabet`.
- **shuffledAlphabet**: Uma string que representa uma configuração específica do rotor. Neste caso, usamos a configuração do Rotor I da máquina Enigma real.
- **for loop**: Este loop inicializa o `rotor` mapeando cada letra do `ALPHABET` para a letra correspondente no `shuffledAlphabet`.

### 2. Função de Criptografia

```java
    public static String encrypt(String input) {
        return transform(input, rotor);
    }
```

- **encrypt**: Esta função recebe uma string de entrada e retorna a versão criptografada da string.
- **transform**: A função `transform` é chamada com a string de entrada e o `rotor` para realizar a transformação das letras.

### 3. Função de Descriptografia

```java
    public static String decrypt(String input) {
        Map<Character, Character> reverseRotor = new HashMap<>();
        for (Map.Entry<Character, Character> entry : rotor.entrySet()) {
            reverseRotor.put(entry.getValue(), entry.getKey());
        }
        return transform(input, reverseRotor);
    }
```

- **decrypt**: Esta função recebe uma string de entrada e retorna a versão descriptografada da string.
- **reverseRotor**: Um novo mapa é criado para armazenar a configuração inversa do `rotor`. Isso é necessário para reverter o processo de criptografia.
- **forEach**: Este loop percorre cada entrada no `rotor` para preencher o `reverseRotor` com o mapeamento inverso, onde cada valor original se torna a chave e cada chave original se torna o valor.
- **transform**: A função `transform` é chamada com a string de entrada e o `reverseRotor` para realizar a transformação das letras de volta à sua forma original.

### 4. Função de Transformação

```java
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
```

- **transform**: Esta função realiza a transformação das letras da string de entrada usando o mapeamento fornecido.
- **result**: Uma variável `StringBuilder` que acumula o resultado da transformação.
- **for loop**: Este loop percorre cada caractere da string de entrada, convertendo-a para maiúscula.
- **if statement**: Verifica se o caractere atual está no alfabeto. Se estiver, ele é transformado usando o mapeamento. Caso contrário, o caractere é adicionado ao resultado sem transformação (isso é útil para manter espaços e pontuações intactos).

### 5. Teste da Implementação (Adicionar no Método Main)

Para testar a implementação, adicione o seguinte método `main` na classe `EnigmaSimulator`:

```java
public static void main(String[] args) {
    String message = "HELLO WORLD";
    String encryptedMessage = encrypt(message);
    String decryptedMessage = decrypt(encryptedMessage);

    System.out.println("Original Message: " + message);
    System.out.println("Encrypted Message: " + encryptedMessage);
    System.out.println("Decrypted Message: " + decryptedMessage);
}
```

- **message**: A mensagem original a ser criptografada e descriptografada.
- **encryptedMessage**: A mensagem após ser criptografada pela função `encrypt`.
- **decryptedMessage**: A mensagem após ser descriptografada pela função `decrypt`.
- **System.out.println**: Exibe a mensagem original, a mensagem criptografada e a mensagem descriptografada no console para verificação.

### Conclusão

Este código simula o funcionamento básico da máquina Enigma, demonstrando os conceitos de substituição de letras através de rotores. A máquina Enigma real era muito mais complexa, utilizando múltiplos rotores, refletores e configurações diárias para garantir a segurança das comunicações. Esta simulação, no entanto, fornece uma introdução aos princípios de criptografia utilizados pela Enigma.

---
