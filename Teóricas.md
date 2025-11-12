# ArrayList

1. 

Em um `ArrayList`, os elementos são acessados por um índice que começa em 0. Se você tem uma lista `ArrayList<String> nomes` com os elementos `["Ana", "Bruno", "Carla"]`, qual código você usaria para **ler** o nome "Bruno"?

A) `nomes.get(2)`
B) `nomes.get(1)`
C) `nomes.get("Bruno")`
D) `nomes.read(1)`

2. 

Qual é a principal **diferença** de comportamento entre os métodos `set(int index, E element)` e `add(int index, E element)` em um `ArrayList`?

A) `set` remove o elemento no índice, e `add` o substitui.
B) `set` altera o elemento no índice, mantendo o tamanho da lista; `add` insere um novo elemento, "empurrando" os demais e aumentando o tamanho da lista.
C) `set` só funciona se a lista estiver vazia, e `add` funciona a qualquer momento.
D) Ambos fazem exatamente a mesma coisa: adicionam um elemento no índice.

### Gabarito
 1. B
 2. B
  
<!------------------------------------------------------------------------------------------------->

# Queue

1. 

A estrutura de dados **Queue (fila)** em Java segue qual princípio de organização?

A) LIFO – Último a entrar, primeiro a sair
B) FIFO – Primeiro a entrar, primeiro a sair
C) FILO – Primeiro a entrar, último a sair
D) LILO – Último a entrar, último a sair
E) MIMO – Muitos a entrar, muitos a sair

---

2. 

Qual das opções representa corretamente o uso dos principais métodos da interface `Queue` em Java (visando evitar exceções)?

A) `push()`, `pop()`, `peek()`
B) `add()`, `remove()`, `get()`
C) `offer()`, `poll()`, `peek()`
D) `insert()`, `delete()`, `update()`
E) `enqueue()`, `dequeue()`, `front()`

## Gabarito

1. B
2. C

<!------------------------------------------------------------------------------------------------->

# Stack

1) 
A estrutura de dados Stack (pilha) em Java segue um princípio de organização conhecido como:

A) FIFO – First In, First Out
B) LIFO – Last In, First Out
C) FILO – First In, Last Out
D) MIMO – Many In, Many Out
E) RIFO – Random In, First Out.

2) 
qual das opções representa corretamente o uso dos principais métodos da classe Stack em Java?

A) add(), remove(), get()
B) insert(), delete(), update()
C) push(), pop(), peek()
D) offer(), poll(), element()
E) enqueue(), dequeue(), front()

## Gabarito

1. B
2. C

<!------------------------------------------------------------------------------------------------->

# Map

1. Você está criando um sistema de cache para armazenar resultados de buscas de usuários. A chave é o termo da busca (uma `String`) e o valor é o resultado (um objeto `ResultadoDaBusca`). Você não se importa com a ordem, mas o sistema precisa ser **o mais rápido possível** para adicionar e ler dados do cache.

Qual implementação de `Map` oferece a melhor performance (em média, $O(1)$) para operações `put` e `get`?

A) `TreeMap`
B) `LinkedHashMap`
C) `HashMap`
D) `Hashtable`

2. Observe o código abaixo:

```java
Map<String, Integer> inventario = new HashMap<>();
inventario.put("Maçã", 10);
inventario.put("Banana", 20);
inventario.put("Maçã", 15); // Linha 4
System.out.println(inventario.get("Maçã"));
System.out.println(inventario.size());
````

Quais serão os valores impressos no console?

A)
```text
10
2
```

B)
```text
15
2
```

C)
```text
10
3
```

D)
```text
15
3
```

## Gabarito 
1. C
2. B

<!------------------------------------------------------------------------------------------------->

# Set

1. Considere as implementações `HashSet`, `LinkedHashSet` e `TreeSet`. Qual das seguintes afirmativas é verdadeira?

- a) `HashSet` mantém a ordem de inserção dos elementos e `TreeSet` mantém a ordem de inserção também.  
- b) `LinkedHashSet` mantém a ordem de inserção, enquanto `TreeSet` mantém os elementos ordenados segundo a ordem natural ou um `Comparator`.  
- c) `TreeSet` permite elementos duplicados para manter a ordenação correta.  
- d) `HashSet` é sempre mais lento que `TreeSet` em operações básicas como add e remove.

---

2. Sobre a implementação do método `equals()` e `hashCode()` para objetos que serão armazenados em um `HashSet`, assinale a alternativa correta:

- a) Não é necessário implementar `equals()` nem `hashCode()` para usar objetos em `HashSet`, pois ele usa somente referência de memória.  
- b) É recomendado implementar ambos `equals()` e `hashCode()` para garantir que objetos iguais não sejam adicionados duplicadamente no `HashSet`.  
- c) Apenas o método `equals()` é suficiente para o funcionamento correto do `HashSet`.  
- d) O método `hashCode()` pode retornar valores fixos sem impacto no desempenho do `HashSet`.

## Gabarito 
1. B
2. B