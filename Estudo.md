# ArrayList

## O que é e para que serve?

O `ArrayList` (parte do pacote `java.util`) é uma das implementações mais populares da interface `List` em Java. Pense nele como um **vetor (array) dinâmico** ou "redimensionável".

Enquanto um array normal em Java (`String[] meuArray`) tem um tamanho fixo que você define na criação, um `ArrayList` **cresce e encolhe automaticamente** à medida que você adiciona ou remove elements.

Seu principal objetivo é armazenar uma **coleção ordenada de elementos**.

## Principais Características

* **Baseado em Índices (Indexado):** Assim como um vetor, você acessa os elementos do `ArrayList` através de um índice numérico (uma posição). O primeiro elemento está no índice 0, o segundo no índice 1, e assim por diante.
* **Mantém a Ordem de Inserção:** Os elementos são armazenados e recuperados exatamente na mesma ordem em que foram adicionados.
* **Permite Duplicatas:** Você pode adicionar o mesmo objeto (ex: a string "Olá") várias vezes na lista.
* **Acesso Rápido (Leitura):** Acessar um elemento pelo seu índice (com o método `get(indice)`) é uma operação muito rápida (tempo constante, ou $O(1)$).
* **Adição/Remoção Lenta (no Meio):** Adicionar ou remover elementos do meio da lista é mais lento (tempo $O(n)$), pois o `ArrayList` precisa "empurrar" ou "puxar" todos os elementos subsequentes para preencher o espaço. Adicionar no final da lista é rápido.
* **Permite `null`:** Você pode adicionar elementos nulos à lista.

## `ArrayList` vs. `LinkedList`

Uma confusão comum é quando usar `ArrayList` vs. `LinkedList` (outra implementação de `List`):

* Use `ArrayList` (a escolha padrão) quando sua principal necessidade for **ler dados e iterar** pela lista.
* Use `LinkedList` quando sua principal necessidade for **adicionar e remover elementos frequentemente no meio** da lista.

## Operações Comuns do `ArrayList` (Seguindo a Lousa)

Aqui está a correspondência direta entre as "Operações Comuns" da lousa e os métodos reais da classe `ArrayList` em Java.

Vamos usar o exemplo de uma `ArrayList` que armazena uma lista de compras:
`List<String> listaDeCompras = new ArrayList<>();`
*(Note que é uma boa prática programar para a interface `List` e instanciar a classe `ArrayList`.)*

* **Criar Instância:**
    * É o ato de usar a palavra-chave `new`.
    * `List<String> minhaLista = new ArrayList<>();`
    * `ArrayList<Integer> listaDeNumeros = new ArrayList<>();`

* **Adicionar:**
    * Usa-se o método `add(Elemento)`. Ele adiciona o elemento **ao final** da lista.
    * `listaDeCompras.add("Maçã");`
    * `listaDeCompras.add("Leite");`
    * (Também existe o `add(indice, Elemento)` para adicionar em uma posição específica.)

* **Ler:**
    * Usa-se o método `get(indice)`. Ele retorna o elemento naquela posição.
    * `String primeiroItem = listaDeCompras.get(0);` // `primeiroItem` agora vale "Maçã"
    * `String segundoItem = listaDeCompras.get(1);` // `segundoItem` agora vale "Leite"

* **Alterar:**
    * Usa-se o método `set(indice, novoElemento)`. Ele substitui o elemento na posição indicada.
    * `listaDeCompras.set(0, "Pêra");` // A lista agora é ["Pêra", "Leite"]

* **Remover:**
    * Usa-se o método `remove(indice)` para remover pela posição.
    * `listaDeCompras.remove(1);` // Remove o item no índice 1. A lista agora é ["Pêra"]
    * Ou `remove(Objeto)` para remover a primeira ocorrência daquele objeto.
    * `listaDeCompras.remove("Pêra");` // Remove o objeto "Pêra". A lista agora está vazia.

* **Ver Tamanho:**
    * Usa-se o método `size()`.
    * `int quantosItens = listaDeCompras.size();` // Retorna o nº de elementos na lista.

* **Iterar (Percorrer):**
    * A forma mais fácil é com um "for-each loop", que percorre a lista na ordem correta.

    Exemplo:
    ```java
    for (String item : listaDeCompras) {
        System.out.println(item);
    }
    ```
    * Você também pode usar um `for` loop clássico com o índice:
    ```java
    for (int i = 0; i < listaDeCompras.size(); i++) {
        System.out.println(listaDeCompras.get(i));
    }
    ```


# Queue 

# Queue

## 1. Conceito Geral de Queue em Java

### Definição
A **Queue (Fila)** é uma estrutura de dados linear que segue o princípio **FIFO (First In, First Out)** — ou seja, o primeiro elemento inserido é o primeiro a ser removido.

**Exemplo da vida real:**
Uma fila de pessoas em um banco: o primeiro a chegar é o primeiro a ser atendido.

### Características
* É uma interface do **Java Collection Framework** (`java.util.Queue`);
* Estende `Collection` e `Iterable`, herdando métodos de manipulação (como `add()`, `remove()`, `clear()`, etc.);
* Permite iteração com o loop `for-each`.

O `Queue` é amplamente utilizado em situações que **demandam o processamento ordenado de elementos**, como buffers, filas de mensagens e sistemas de tarefas.

## 2. Métodos Principais da Interface Queue

A interface `Queue` declara diversos métodos que são implementados pelas classes que a estendem. Os principais são:

| Método | Retorno | Descrição |
| :--- | :--- | :--- |
| `boolean offer(E e)` | `boolean` | Insere um novo elemento na fila se possível, retornando `true` ou `false`. (Uso otimizado: retorna valor especial) |
| `boolean add(E e)` | `boolean` | Insere um novo elemento na fila; lança exceção se não houver espaço. (Uso clássico: lança exceção) |
| `E poll()` | `E` | Recupera e remove o elemento da cabeça da fila; retorna `null` se estiver vazio. (Uso otimizado: retorna valor especial) |
| `E remove()` | `E` | Recupera e remove o primeiro elemento; lança exceção se estiver vazia. (Uso clássico: lança exceção) |
| `E peek()` | `E` | Recupera, mas não remove, o elemento do início da fila; retorna `null` se vazio. (Uso otimizado: retorna valor especial) |
| `E element()` | `E` | Recupera, mas não remove, o elemento do início; lança exceção se vazia. (Uso clássico: lança exceção) |

Esses métodos permitem **adicionar**, **ler**, **remover** e **verificar** elementos da fila.

## 3. Operações Comuns e o Encaixe do Queue

| Operação | Encaixe | Observação |
| :--- | :--- | :--- |
| **Criar instância** | Encaixa | É possível criar instâncias a partir de implementações concretas como `LinkedList`, `PriorityQueue` e `ArrayBlockingQueue`. |
| **Adicionar (Criar/Adicionar)** | Totalmente | Oferece métodos como `add()` e `offer()` para inserir novos elementos no final da fila, respeitando o princípio **FIFO**. |
| **Ler (Leia)** | Parcialmente | É possível apenas ler o primeiro elemento com `peek()` ou `element()`. O `Queue` **não permite leitura por índice**, pois não é uma lista — apenas o primeiro elemento é acessível. |
| **Alterar (Atualizar)** | Não se encaixa | Não possui método para modificar diretamente um elemento específico, pois sua estrutura é orientada à ordem de chegada. Para alterar algo, é necessário remover e reinserir o elemento. |
| **Remover (Excluir/Remover)** | Perfeitamente | É possível remover o primeiro elemento com `poll()` ou `remove()`. Também é possível tentar remover um elemento específico com `remove(Object o)`, mas isso não é comum em filas. |
| **Ver tamanho** | Encaixa | O método `size()` (herdado de `Collection`) retorna a quantidade de elementos na fila. |
| **Iterar** | Encaixa | Por implementar `Iterable`, é possível percorrer o `Queue` com `for-each` sem removê-los. |

**Exemplo de criação:**
```java
Queue<Integer> fila = new LinkedList<>();
````

**Exemplo de Iteração:**

```java
for (Integer n : fila) {
    System.out.println(n);
}
```

## 4. Subinterfaces Queue

### Deque (Fila Dupla)

`Deque` significa “fila dupla” e suporta a adição e remoção de elementos em **ambas as extremidades**.
Pode funcionar tanto como uma fila (**FIFO**) quanto como uma pilha (**LIFO**).

**Principais classes que implementam Deque:**

  * `ArrayDeque`      
  * `ConcurrentLinkedDeque`
  * `LinkedBlockingDeque`
  * `LinkedList`

### Fila de Bloqueio (BlockingQueue)

É uma fila especial que **bloqueia a thread** em duas situações:

1.  Quando tenta obter elementos de uma fila vazia;
2.  Quando tenta inserir em uma fila cheia.

Essa estrutura é muito usada em aplicações **multithread**, permitindo sincronização entre produtores e consumidores.

## 5\. Implementações de Queue

### 5.1. Fila Abstrata (`AbstractQueue`)

Classe abstrata que fornece implementações básicas de algumas operações de fila.

  * Não permite elementos `null`.
  * Implementa métodos como `add`, `remove` e `element` baseados em `offer`, `poll` e `peek`, porém **lançando exceções** em vez de retornar `false` ou `null`.

### 5.2. Lista Encadeada (`LinkedList`)

`LinkedList` implementa tanto `List` quanto `Deque`, funcionando também como fila.

**Construtores:**

  * `LinkedList()`: cria uma lista vazia;
  * `LinkedList(Collection<? extends E> c)`: cria uma lista contendo os elementos de outra coleção.

**Principais métodos relacionados ao comportamento de fila:**

  * `add(E e)`: adicionar ao final da lista;
  * `addFirst(E e)` / `addLast(E e)`: adiciona no início ou fim;
  * `remove()` / `poll()`: remove o primeiro elemento;
  * `peek()` / `element()`: acessa o primeiro elemento sem removê-lo;
  * `size()`: retorna o número de elementos.

**Exemplo:**

```java
import java.util.*;

public class LinkedListExample {
    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<>();

        fila.add(1);
        fila.add(2);
        fila.add(3);
        System.out.println("Fila inicial: " + fila);

        fila.remove(); // remove o primeiro (1)
        System.out.println("Após remover o primeiro: " + fila);

        fila.offer(4); // adiciona ao final
        System.out.println("Após adicionar 4: " + fila);

        System.out.println("Próximo da fila (peek): " + fila.peek());
    }
}
```

### 5.3. Fila de Prioridade (`PriorityQueue`)

Os elementos são **ordenados** segundo sua ordem natural ou por um `Comparator` definido.
Internamente, é representado como um **heap mínimo**.

**Principais métodos:**

  * `add()` / `offer()`: inserir elemento;
  * `poll()` / `remove()`: remover o primeiro (de maior prioridade);
  * `peek()` / `element()`: lê o primeiro sem removê-lo;
  * `size()` / `clear()`: controle de tamanho e limpeza.

**Exemplo:**

```java
import java.util.*;

public class PriorityQueueExample {
    public static void main(String[] args) {
        Queue<Integer> fila = new PriorityQueue<>();

        fila.offer(5);
        fila.offer(2);
        fila.offer(4);
        fila.offer(1);

        System.out.println("Fila (ordem interna de prioridade): " + fila);

        while (!fila.isEmpty()) {
            System.out.println("Removendo: " + fila.poll());
        }
    }
}
```

### 5.4. Fila de Bloqueio de Matriz (`ArrayBlockingQueue`)

Baseada em uma **matriz circular**, possui **tamanho fixo** e comportamento FIFO.
Suporta um modo **justo (fair)** opcional, garantindo que os fios sejam atendidos na ordem de chegada.

**Construtores:**

  * `ArrayBlockingQueue(int capacity)`
  * `ArrayBlockingQueue(int capacity, boolean fair)`
  * `ArrayBlockingQueue(int capacity, boolean fair, Collection<? extends E> c)`

Uso típico: linhas de comunicação entre threads (**produtor e consumidor**).

**Exemplo:**

```java
import java.util.concurrent.*;

public class ArrayBlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> fila = new ArrayBlockingQueue<>(2);

        // Produtor
        new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    fila.put(i);
                    System.out.println("Produzido: " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // Consumidor
        new Thread(() -> {
            try {
                while (true) {
                    int valor = fila.take();
                    System.out.println("Consumido: " + valor);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
```

# Stack

## Significado
O stack tem o significado pilha pelo motivo de empilhar os itens que voce deseja, ele funciona no sistema LIFO que significa:
Last In → First Out que significa o ultimo que entrara no vetor é o primeiro que irá sair.

exemplo:
Imagine uma pilha de pratos que voce acabou de secar;
você coloca um prato em cima do outro e na hora de guardar voce começa a guardar o ultimo prato que voce secou.

## Para o que serve?
O Stack é usado quando você precisa controlar a ordem dos dados, de modo que o último adicionado seja o primeiro a ser retirado.

exemplos:
Desfazer ações (CTRL + Z)
Cada ação que você faz é empilhada e quando da o ctrl+z a ultima açao que você será a 1 a ser voltada.

Histórico de navegação do navegador
Cada página visitada é empilhada.

## Como usar?
Para usarmos o stack 1° devemos importar ele dentro do seu arquivo pois ele é uma pacote de coleção dentro do java e para chamarmos ele devemos:
> import java.util.Stack; - "Assim chamamos o pacote para ser usado no seu projeto".

Para criar o Stack devemos usar esse codigo:
> Stack<(tipo da sua stack)> (Nome da sua stack) = new Stack<>(); - "Assim podemos criar um stack para ser chamado no seus codigos para ser usados".

Agora para mexer com o stack temos varias operações que podemos usar como:
### push:
> (nome da sua stack).push("item"); - "Adiciona um elemento no topo da pilha".

### pop:
> (nome da sua stack).pop(); - "Remove e retorna o elemento do topo".

### peek:
> (nome da sua stack).peek(); - "Retorna o topo sem remover".

### isEmpty:
> (nome da sua stack).isEmpty(); - "Retorna true se a pilha estiver vazia".

### size:
> (nome da sua stack).size(); - "Retorna o número de elementos".

### search:
> (nome da sua stack).search("item"); - "Retorna a posição (1 = topo) ou -1 se não existir".

# quando devemos usar?
1 - Você precisa reverter uma ordem (ex: desfazer ações).
2 - Precisa guardar estados anteriores temporariamente.
3 - Precisa verificar estrutura de abertura e fechamento (como parênteses, chaves, tags HTML).
4 - Ou quando algo funciona naturalmente de trás pra frente.


<!-------------------------------------------------------------------------------------------->


# Map

## O que é e para que serve?

Na programação Java, a interface `Map` (parte do pacote `java.util`) não é tecnicamente uma "Coleção" no sentido de estender a interface `Collection`, mas é um pilar fundamental do "Java Collections Framework".

A sua principal função é armazenar dados em **pares de chave-valor** (key-value pairs).

Pense em um `Map` como um dicionário do mundo real:

* **Chave (Key):** É a "palavra" que você procura. Deve ser **única**.
* **Valor (Value):** É a "definição" associada àquela palavra. Pode se **repetir**.

O objetivo principal de um `Map` é a **busca rápida de dados**. Se você tem a chave (por exemplo, o CPF de um usuário), você pode recuperar o valor (o objeto `Usuario` completo) de forma quase instantânea.

## Principais Características

1.  **Chaves Únicas:** Um `Map` não permite chaves duplicadas. Se você tentar adicionar um novo par com uma chave que já existe, o `Map` simplesmente **substituirá** o valor antigo pelo novo.
2.  **Valores Duplicados:** Você pode ter valores idênticos associados a chaves diferentes. (Ex: Chave "Aluno A" -> Valor "Nota 10" e Chave "Aluno B" -> Valor "Nota 10").
3.  **Não é Ordenado (Geralmente):** A implementação mais comum, `HashMap`, não garante nenhuma ordem específica dos elementos. Se você precisar de ordem, usará outras implementações.

## Implementações Comuns

Como `Map` é uma interface, você precisa usar uma de suas classes concretas para "Criar a instância":

* **`HashMap`:** É a mais rápida e mais usada. Não garante nenhuma ordem de iteração. É a escolha padrão se você não se importa com a ordem.
* **`LinkedHashMap`:** Quase tão rápida quanto o `HashMap`, mas **garante a ordem de inserção**. Os elementos são iterados na mesma ordem em que foram adicionados.
* **`TreeMap`:** Armazena as chaves de forma ordenada (ordem alfabética, numérica, etc.). É mais lenta que as outras, mas é ótima se você precisa exibir os dados ordenados pela chave.

## Operações Comuns do Map (Seguindo a Lousa)

Aqui está a correspondência direta entre as "Operações Comuns" da lousa e os métodos reais da interface `Map` em Java.

Vamos usar o exemplo de um `Map` que armazena as notas de alunos:
`Map<String, Integer> notasAlunos = new HashMap<>();`

* **Criar Instância:**
    * É o ato de usar a palavra-chave `new` com uma das implementações.
    * `Map<String, Integer> meuMapa = new HashMap<>();`
    * `Map<String, Integer> meuMapaOrdenado = new TreeMap<>();`
    * `Map<String, Integer> meuMapaNaOrdemDeInsercao = new LinkedHashMap<>();`

* **Adicionar:**
    * Usa-se o método `put(Chave, Valor)`.
    * `notasAlunos.put("Alice", 9);`
    * `notasAlunos.put("Bob", 7);`

* **Ler:**
    * Usa-se o método `get(Chave)`. Ele retorna o valor associado àquela chave.
    * `Integer notaDoBob = notasAlunos.get("Bob");` // `notaDoBob` agora vale 7
    * Se a chave não existir, `get()` retorna `null`.

* **Alterar:**
    * É feito usando o mesmo método `put(Chave, Valor)`. Se a chave já existir, o `Map` automaticamente sobrescreve o valor antigo.
    * `notasAlunos.put("Alice", 10);` // O valor da Alice foi de 9 para 10

* **Remover:**
    * Usa-se o método `remove(Chave)`.
    * `notasAlunos.remove("Bob");` // O par chave-valor "Bob"=7 é removido do mapa.

* **Ver Tamanho:**
    * Usa-se o método `size()`.
    * `int quantosAlunos = notasAlunos.size();` // Retorna o nº de pares no mapa.

* **Iterar (Percorrer):**
    * Esta é a operação mais complexa. A forma mais comum e eficiente é usar o `entrySet()`, que retorna um conjunto de "entradas" (o par chave-valor).

    Exemplo:
    ```java
    for ( Map.Entry<String, Integer> entrada : notasAlunos.entrySet() ) {
        String aluno = entrada.getKey();
        Integer nota = entrada.getValue();
        System.out.println("O aluno " + aluno + " tirou nota " + nota);
    }
    ```

<!------------------------------------------------------------------------------------------>

# Set
## Interface Set

<p>A interface Set cria uma coleção para valores únicos, ou seja, sem duplicidade e a busca não é baseada em índice e sim no próprio valor do elemento.
    Os comandos para essa Interface são: 
        .Add - Adiciona um elemento do tipo condizente caso não haja um igual na coleção
        .Remove - Remove um item selecionado
        .Contains - Informa se um item está na coleção
        .Size - Informa o numero de itens na coleção
        .Clear - Limpa a coleção 
    Porém, nesse formato, além de não conseguir instanciar, essa interface não aprsenta uma ordenação para os elementos adicionados. Para isso usamos as implementações, que são o core para a performance dessa interface.</p>

> Import java.util.Set

## Implementações

### HashSet

<p> HashSet é uma instancia do Set, mas que ainda não mantém a ordem dos elementos

````java
import java.util.HashSet;
import java.util.Set;

Set<String> = new HashSet<String>();
````

### LinkedHashSet

<p> O linked tem as mesmas funções, porém mantem a ordem de inserção dos elementos

````java
import java.util.LinkedHashSet;
import java.util.Set;

Set<String> = new TreeSet<String>();
````

### TreeSet

<p> O TreeSet é o mais sofisticado, ordenando os elementos assim que são adicionados na coleção



````java
import java.util.TreeSet;
import java.util.Set;

TreeSet<String> cars = new TreeSet<>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("BMW");  
    cars.add("Mazda");

    System.out.println(cars);
````

<p>Nesse exemplo, além da segunda BMW não entrar na lista, ao consultar, a ordem será:
    1. BMW
    2. Ford
    3. Mazda 
    4. Volvo </p>


