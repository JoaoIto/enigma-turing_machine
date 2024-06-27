## Estrutura do Código

O código é dividido em várias partes, cada uma desempenhando um papel específico na simulação da máquina Enigma. Vamos explorar cada parte do código detalhadamente.

### 1. Definição do Alfabeto e do Rotor

```typescript
const ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
const rotor: Map<string, string> = new Map<string, string>();

const shuffledAlphabet = "EKMFLGDQVZNTOWYHXUSPAIBRCJ"; // Rotor I configuration
for (let i = 0; i < ALPHABET.length; i++) {
    rotor.set(ALPHABET[i], shuffledAlphabet[i]);
}
```

- **ALPHABET**: Uma constante que contém todas as letras do alfabeto em ordem. Esta é a base para a substituição de letras.
- **rotor**: Um mapa (`Map`) que armazena a configuração do rotor. O rotor é configurado para mapear cada letra do alfabeto para uma letra diferente, de acordo com uma configuração pré-determinada.
- **shuffledAlphabet**: Uma string que representa uma configuração específica do rotor. Neste caso, usamos a configuração do Rotor I da máquina Enigma real.
- **for loop**: Este loop inicializa o `rotor` mapeando cada letra do `ALPHABET` para a letra correspondente no `shuffledAlphabet`.

### 2. Função de Criptografia

```typescript
function encrypt(input: string): string {
    return transform(input, rotor);
}
```

- **encrypt**: Esta função recebe uma string de entrada e retorna a versão criptografada da string.
- **transform**: A função `transform` é chamada com a string de entrada e o `rotor` para realizar a transformação das letras.

### 3. Função de Descriptografia

```typescript
function decrypt(input: string): string {
    const reverseRotor: Map<string, string> = new Map<string, string>();
    rotor.forEach((value, key) => {
        reverseRotor.set(value, key);
    });
    return transform(input, reverseRotor);
}
```

- **decrypt**: Esta função recebe uma string de entrada e retorna a versão descriptografada da string.
- **reverseRotor**: Um novo mapa é criado para armazenar a configuração inversa do `rotor`. Isso é necessário para reverter o processo de criptografia.
- **forEach**: Este método é usado para preencher o `reverseRotor` com o mapeamento inverso, onde cada valor original se torna a chave e cada chave original se torna o valor.
- **transform**: A função `transform` é chamada com a string de entrada e o `reverseRotor` para realizar a transformação das letras de volta à sua forma original.

### 4. Função de Transformação

```typescript
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
```

- **transform**: Esta função realiza a transformação das letras da string de entrada usando o mapeamento fornecido.
- **result**: Uma variável string que acumula o resultado da transformação.
- **for loop**: Este loop percorre cada caractere da string de entrada, convertendo-a para maiúscula.
- **if statement**: Verifica se o caractere atual está no alfabeto. Se estiver, ele é transformado usando o mapeamento. Caso contrário, o caractere é adicionado ao resultado sem transformação (isso é útil para manter espaços e pontuações intactos).

### 5. Teste da Implementação

```typescript
const message = "HELLO WORLD";
const encryptedMessage = encrypt(message);
const decryptedMessage = decrypt(encryptedMessage);

console.log("Original Message: " + message);
console.log("Encrypted Message: " + encryptedMessage);
console.log("Decrypted Message: " + decryptedMessage);
```

- **message**: A mensagem original a ser criptografada e descriptografada.
- **encryptedMessage**: A mensagem após ser criptografada pela função `encrypt`.
- **decryptedMessage**: A mensagem após ser descriptografada pela função `decrypt`.
- **console.log**: Exibe a mensagem original, a mensagem criptografada e a mensagem descriptografada no console para verificação.

### Conclusão

Este código simula o funcionamento básico da máquina Enigma, demonstrando os conceitos de substituição de letras através de rotores. A máquina Enigma real era muito mais complexa, utilizando múltiplos rotores, refletores e configurações diárias para garantir a segurança das comunicações. Esta simulação, no entanto, fornece uma introdução aos princípios de criptografia utilizados pela Enigma.

---
