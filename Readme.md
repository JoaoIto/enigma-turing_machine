# Enigma Machine Simulator 

<p align="center">
    <img width="150" height="150" src="https://upload.wikimedia.org/wikipedia/commons/7/79/Alan_Turing_az_1930-as_%C3%A9vekben.jpg">
    <img width="300" height="150" src="https://warren.com.br/magazine/wp-content/uploads/2022/02/alan-turing-2-1024x684.jpg">
</p>

## Introdução

A máquina Enigma foi uma máquina de criptografia utilizada pela Alemanha durante a Segunda Guerra Mundial para proteger as comunicações militares. A máquina utilizava uma série de rotores que substituíam letras do alfabeto para encriptar e desencriptar mensagens. Este projeto simula o funcionamento básico da máquina Enigma em Java e TypeScript.

## Funcionamento da Máquina Enigma

A máquina Enigma usava uma série de rotores intercambiáveis, cada um dos quais substituía uma letra do alfabeto por outra. A configuração dos rotores era alterada diariamente com base em um código pré-determinado. Quando uma letra era digitada na máquina, ela passava por cada rotor, um refletor e depois voltava pelos rotores, produzindo uma letra encriptada. Para desencriptar a mensagem, a máquina era configurada da mesma maneira, e a mensagem encriptada era digitada, revertendo o processo de substituição.

### Componentes Principais da Máquina Enigma

1. **Rotores**: Discos que giravam e substituíam uma letra por outra.
2. **Refletor**: Dispositivo que refletia a corrente elétrica de volta pelos rotores.
3. **Plugboard (ou Placa de Conexões)**: Permitia trocas adicionais de letras antes e depois dos rotores.

### Processo de Encriptação e Desencriptação

#### 1. Configuração Inicial

- **Configuração dos Rotores**: Cada dia, os rotores eram configurados em uma posição inicial específica, conhecida apenas pelos operadores das máquinas de ambos os lados da comunicação. A posição inicial dos rotores era definida por um código diário.
- **Seleção dos Rotores**: A máquina podia conter vários rotores, e a seleção dos rotores a serem usados também era parte da configuração diária.

#### 2. Substituição de Letras

Quando uma letra era digitada na máquina Enigma, o processo de substituição era o seguinte:

##### Encriptação

1. **Entrada de Letra**: A letra digitada pelo operador.
2. **Passagem pelos Rotores**:
   - A corrente elétrica passava pelo primeiro rotor, que substituía a letra por outra de acordo com a configuração interna do rotor.
   - Em seguida, a corrente passava pelo segundo rotor, que realizava outra substituição, e assim por diante, passando por todos os rotores configurados.
3. **Reflexão**:
   - A corrente chegava ao refletor, que redirecionava a corrente de volta pelos rotores.
4. **Passagem Inversa pelos Rotores**:
   - A corrente passava pelos rotores na ordem inversa, realizando substituições de letras de acordo com a configuração inversa dos rotores.
5. **Saída da Letra Encriptada**:
   - A letra final resultante era a letra encriptada, que acendia em um painel na máquina.

##### Desencriptação

O processo de desencriptação era essencialmente o mesmo que o de encriptação, mas ao contrário:

1. **Entrada da Letra Encriptada**: A letra encriptada era digitada na máquina.
2. **Passagem pelos Rotores e Refletor**:
   - A corrente passava pelos rotores, refletor e novamente pelos rotores na configuração inversa.
3. **Saída da Letra Original**:
   - A letra final resultante era a letra original da mensagem.

#### Exemplo Detalhado

1. **Configuração Inicial**:
   - Rotores selecionados: Rotor I, Rotor II, Rotor III
   - Posições iniciais: Rotor I - A, Rotor II - B, Rotor III - C
   - Plugboard: E-T, A-L (exemplos de pares trocados)

2. **Encriptação da Letra 'H'**:
   - **Entrada**: H
   - **Passagem pelo Plugboard**: Se houver uma troca configurada, por exemplo, H-P, a letra H seria substituída por P.
   - **Primeiro Rotor**: P → substituído pela configuração interna do Rotor I.
   - **Segundo Rotor**: Resultado do Rotor I → substituído pela configuração interna do Rotor II.
   - **Terceiro Rotor**: Resultado do Rotor II → substituído pela configuração interna do Rotor III.
   - **Refletor**: O resultado é refletido de volta.
   - **Passagem Inversa pelos Rotores**: O resultado do refletor passa novamente pelos rotores em ordem inversa (III, II, I).
   - **Plugboard (se aplicável)**: A letra final passa novamente pelo plugboard, se necessário.
   - **Saída**: Letra encriptada.

3. **Desencriptação da Letra Encriptada**:
   - **Entrada**: Letra encriptada
   - **Passagem pelo Plugboard e Rotores**: Mesma sequência de substituições, mas revertida.
   - **Saída**: Letra original 'H'.

### Exemplo Prático

Para ilustrar, considere a seguinte configuração:

- **Rotor I**: "EKMFLGDQVZNTOWYHXUSPAIBRCJ"
- **Rotor II**: "AJDKSIRUXBLHWTMCQGZNPYFVOE"
- **Rotor III**: "BDFHJLCPRTXVZNYEIWGAKMUSQO"

Mensagem: "HELLO"

1. **Configuração Inicial**: Rotor I - A, Rotor II - B, Rotor III - C
2. **Encriptação**:
   - Entrada: H
   - Passa pelos rotores e refletor.
   - Saída: Letra encriptada (por exemplo, 'X').

3. **Desencriptação**:
   - Entrada: X
   - Passa pelos rotores e refletor.
   - Saída: H (letra original).

### Projeto

Este projeto é uma simplificação do funcionamento da máquina Enigma, demonstrando os conceitos básicos de substituição de letras através de rotores. A máquina Enigma real era muito mais complexa, utilizando múltiplos rotores, refletores e configurações diárias para garantir a segurança das comunicações.


### Conclusão

A máquina Enigma era um dispositivo de criptografia avançado para seu tempo, utilizando a combinação de rotores intercambiáveis, refletores e plugboard para garantir a segurança das mensagens. A complexidade da Enigma residia na sua configuração diária e na substituição de letras em múltiplas etapas, tornando a quebra de suas mensagens uma tarefa extremamente desafiadora. A simulação apresentada em Java e TypeScript demonstra os princípios básicos deste mecanismo, proporcionando uma introdução aos conceitos de criptografia utilizados pela Enigma.

---
