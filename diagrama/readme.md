## Descrição do Diagrama

O diagrama mostrará uma letra sendo encriptada pela máquina Enigma. Usaremos a letra 'A' como exemplo, e a configuração inicial dos rotores será a seguinte:

- **Rotor I**: "EKMFLGDQVZNTOWYHXUSPAIBRCJ"
- **Rotor II**: "AJDKSIRUXBLHWTMCQGZNPYFVOE"
- **Rotor III**: "BDFHJLCPRTXVZNYEIWGAKMUSQO"
- **Refletor**: "YRUHQSLDPXNGOKMIEBFZCWVJAT" (Exemplo de configuração do refletor)
- **Posição Inicial dos Rotores**: Rotor I - A, Rotor II - A, Rotor III - A

### Diagrama (em Texto)

```plaintext
Entrada: 'A'

            +-------+      +-------+      +-------+      +---------+      +-------+      +-------+      +-------+
            | Rotor |      | Rotor |      | Rotor |      | Reflector|      | Rotor |      | Rotor |      | Rotor |
            |   I   |      |  II   |      |  III  |      |         |      |  III  |      |  II   |      |   I   |
            +-------+      +-------+      +-------+      +---------+      +-------+      +-------+      +-------+
               |              |              |              |               |              |              |
               E              J              B              Y               X              U              A
               |              |              |              |               |              |              |
            +-------+      +-------+      +-------+      +---------+      +-------+      +-------+      +-------+
            |       |      |       |      |       |      |         |      |       |      |       |      |       |
            |  E -> Q|      |  J -> Z|      |  B -> D|      |  Y -> I|      |  X -> T|      |  U -> K|      |  A -> E|
            |       |      |       |      |       |      |         |      |       |      |       |      |       |
            +-------+      +-------+      +-------+      +---------+      +-------+      +-------+      +-------+
               |              |              |              |               |              |              |
               Q              Z              D              I               T              K              E
               |              |              |              |               |              |              |
            +-------+      +-------+      +-------+      +---------+      +-------+      +-------+      +-------+
            | Rotor |      | Rotor |      | Rotor |      | Reflector|      | Rotor |      | Rotor |      | Rotor |
            |   I   |      |  II   |      |  III  |      |         |      |  III  |      |  II   |      |   I   |
            +-------+      +-------+      +-------+      +---------+      +-------+      +-------+      +-------+
             (Primeira Passagem)                  |             (Refletido)                  |               (Segunda Passagem)
```

### Explicação do Diagrama

1. **Entrada**: A letra 'A' é digitada na máquina.
2. **Primeiro Rotor (Rotor I)**:
    - A letra 'A' entra no Rotor I.
    - De acordo com a configuração do Rotor I, 'A' é mapeada para 'E'.
3. **Segundo Rotor (Rotor II)**:
    - A letra 'E' sai do Rotor I e entra no Rotor II.
    - De acordo com a configuração do Rotor II, 'E' é mapeada para 'J'.
4. **Terceiro Rotor (Rotor III)**:
    - A letra 'J' sai do Rotor II e entra no Rotor III.
    - De acordo com a configuração do Rotor III, 'J' é mapeada para 'B'.
5. **Refletor**:
    - A letra 'B' sai do Rotor III e entra no Refletor.
    - De acordo com a configuração do Refletor, 'B' é mapeada para 'Y'.
6. **Segunda Passagem pelos Rotores**:
    - A letra 'Y' sai do Refletor e volta pelo Rotor III.
    - De acordo com a configuração inversa do Rotor III, 'Y' é mapeada para 'I'.
    - A letra 'I' sai do Rotor III e volta pelo Rotor II.
    - De acordo com a configuração inversa do Rotor II, 'I' é mapeada para 'U'.
    - A letra 'U' sai do Rotor II e volta pelo Rotor I.
    - De acordo com a configuração inversa do Rotor I, 'U' é mapeada para 'A'.
7. **Saída**: A letra final é 'A'.

---
