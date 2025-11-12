# Array List

## Exercício Prático: Lista de Tarefas (To-Do List)

**Objetivo:** Criar um programa `main` simples que gerencia uma lista de tarefas (Strings) usando um `ArrayList` e aplica todas as operações comuns da lousa.

**Requisitos:**

1.  **Crie a Instância:** Crie um `ArrayList` para guardar `String`s chamado `tarefas`.
2.  **Adicione** três tarefas: "Estudar Java", "Fazer exercício de ArrayList", "Comprar pão".
3.  **Imprima** o tamanho da lista.
4.  **Leia** e imprima a segunda tarefa da lista (lembre-se dos índices!).
5.  **Altere** a tarefa "Comprar pão" para "Comprar leite".
6.  **Remova** a primeira tarefa ("Estudar Java").
7.  **Imprima** o novo tamanho da lista.
8.  **Itere** sobre a lista restante e imprima cada tarefa precedida por "Tarefa: ".

**Saída Esperada:**
    ```text
    Tamanho da lista: 3
    A segunda tarefa é: Fazer exercício de ArrayList
    Tamanho da lista após remoção: 2
    Tarefa: Fazer exercício de ArrayList
    Tarefa: Comprar leite
    ````

````java
    import java.util.ArrayList;

public class ListaDeTarefas {
    public static void main(String[] args) {
        // 1. Criar a instância
        ArrayList<String> tarefas = new ArrayList<>();

        // 2. Adicionar três tarefas
        tarefas.add("Estudar Java");
        tarefas.add("Fazer exercício de ArrayList");
        tarefas.add("Comprar pão");

        // 3. Imprimir o tamanho da lista
        System.out.println("Tamanho da lista: " + tarefas.size());

        // 4. Ler e imprimir a segunda tarefa
        System.out.println("A segunda tarefa é: " + tarefas.get(1));

        // 5. Alterar a tarefa "Comprar pão" para "Comprar leite"
        tarefas.set(tarefas.indexOf("Comprar pão"), "Comprar leite");

        // 6. Remover a primeira tarefa ("Estudar Java")
        tarefas.remove(0);

        // 7. Imprimir o novo tamanho da lista
        System.out.println("Tamanho da lista após remoção: " + tarefas.size());

        // 8. Iterar sobre a lista restante e imprimir cada tarefa
        for (String tarefa : tarefas) {
            System.out.println("Tarefa: " + tarefa);
        }
    }
}
````

# Queue

## Simulador de Fila de Atendimento (usando Queue)

Crie um programa que simule o funcionamento de uma fila de atendimento em um banco.
O programa deve permitir:
* Adicionar um cliente à fila.
* Atender (remover) o próximo cliente da fila.
* Visualizar a fila atual.
* Sair do programa.

**Requisitos:**
* Utilize a interface `Queue` com a implementação `LinkedList`.
* Use os métodos `add()`, `poll()` e `peek()`.
* Mostrar mensagens no console a cada ação (por exemplo: "Cliente João adicionado à fila" , "Atendendo cliente Maria" , etc.).

**Exemplo de interação esperada:**

1. Adicionar cliente
2. Atender cliente
3. Mostrar fila
4. Sair
- Escolha: 1
- Digite o nome do cliente: Ana
- Cliente Ana adicionado à fila.

- Fila atual: [Ana, Pedro, Lucas]
- Atendendo: Ana
- Fila atual: [Pedro, Lucas]

````java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FilaAtendimentoBanco {

    private Queue<String> fila;

    public FilaAtendimentoBanco() {
        fila = new LinkedList<>();
    }

    public void adicionarCliente(String nome) {
        fila.add(nome);
        System.out.println("Cliente " + nome + " adicionado à fila.");
    }

    public void atenderCliente() {
        String cliente = fila.poll();
        if (cliente == null) {
            System.out.println("Não há clientes na fila para atender.");
        } else {
            System.out.println("Atendendo cliente " + cliente);
        }
    }

    public void mostrarFila() {
        if (fila.isEmpty()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("Fila atual: " + fila);
        }
    }

    public static void main(String[] args) {
        FilaAtendimentoBanco banco = new FilaAtendimentoBanco();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n1. Adicionar cliente");
            System.out.println("2. Atender cliente");
            System.out.println("3. Mostrar fila");
            System.out.println("4. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    banco.adicionarCliente(nome);
                    break;
                case 2:
                    banco.atenderCliente();
                    break;
                case 3:
                    banco.mostrarFila();
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
````


---

# Stack

**Objetivo:** Crie um programa que simule o funcionamento de uma pilha para gerenciamento de histórico de páginas visitadas em um navegador.

**Requisitos**:
1. Use a classe `Stack` do Java para armazenar as URLs visitadas (Strings).
2. Implemente as seguintes funcionalidades:
  - Adicionar uma página visitada no topo da pilha.
  - Voltar para a página anterior (remover a última página visitada e mostrar a nova do topo).
  - Mostrar a página atual (topo da pilha).
  - Mostrar todo o histórico de páginas visitadas (todos os elementos da pilha).
3. No programa principal, simule estas operações adicionando páginas e realizando "voltar", exibindo os resultados em cada etapa.

````java
   import java.util.Stack;

public class NavegadorHistorico {
    private Stack<String> historico;

    public NavegadorHistorico() {
        historico = new Stack<>();
    }

    // Adiciona uma página visitada no topo da pilha
    public void visitarPagina(String url) {
        historico.push(url);
        System.out.println("Página visitada: " + url);
    }

    // Volta para a página anterior, removendo a atual
    public void voltarPagina() {
        if (historico.size() > 1) {
            String removida = historico.pop();
            System.out.println("Voltando da página: " + removida);
            System.out.println("Página atual: " + historico.peek());
        } else {
            System.out.println("Não há página anterior para voltar.");
        }
    }

    // Mostra a página atual (topo da pilha)
    public void mostrarPaginaAtual() {
        if (!historico.isEmpty()) {
            System.out.println("Página atual: " + historico.peek());
        } else {
            System.out.println("Nenhuma página visitada ainda.");
        }
    }

    // Mostra todo o histórico
    public void mostrarHistorico() {
        if (historico.isEmpty()) {
            System.out.println("Nenhuma página visitada.");
        } else {
            System.out.println("Histórico de páginas visitadas:");
            for (String url : historico) {
                System.out.println(url);
            }
        }
    }

    public static void main(String[] args) {
        NavegadorHistorico navegador = new NavegadorHistorico();

        navegador.visitarPagina("https://www.google.com");
        navegador.visitarPagina("https://www.wikipedia.org");
        navegador.visitarPagina("https://www.openai.com");

        navegador.mostrarPaginaAtual();

        navegador.voltarPagina();
        navegador.voltarPagina();
        navegador.voltarPagina();

        navegador.mostrarHistorico();
    }
}
````

# Map

**Objetivo:** Criar um programa simples que simule uma agenda telefônica usando `Map`. A agenda deve permitir adicionar, remover, buscar e listar contatos.

**Requisitos:**

1.  Crie uma classe `AgendaTelefonica` que contenha um `Map<String, String>` chamado `contatos`. A chave será o nome do contato (String) e o valor será o telefone (String).
2.  Use um `HashMap` para instanciar o mapa.
3.  Crie os seguintes métodos na sua classe:
    * `public void adicionarContato(String nome, String telefone)`: Adiciona ou atualiza um contato.
    * `public void removerContato(String nome)`: Remove um contato pelo nome.
    * `public String buscarTelefone(String nome)`: Retorna o telefone de um contato. Se não encontrar, deve retornar uma mensagem "Contato não encontrado."
    * `public void listarContatos()`: Itera sobre o mapa e imprime todos os nomes e telefones no formato "Nome: [Nome], Telefone: [Telefone]".
4.  No seu método `main`, crie uma instância da `AgendaTelefonica` e teste todos os métodos: adicione alguns contatos, busque um, remova um e, por fim, liste os contatos restantes.

````java
   import java.util.HashMap;
import java.util.Map;

public class AgendaTelefonica {
    private Map<String, String> contatos;

    public AgendaTelefonica() {
        contatos = new HashMap<>();
    }

    public void adicionarContato(String nome, String telefone) {
        contatos.put(nome, telefone);
        System.out.println("Contato adicionado/atualizado: " + nome + " - " + telefone);
    }

    public void removerContato(String nome) {
        if (contatos.containsKey(nome)) {
            contatos.remove(nome);
            System.out.println("Contato removido: " + nome);
        } else
 
````

# Set

**Crie um programa Java que gerencie um conjunto de usuários únicos para um sistema de cadastro.**

**Requisitos**

1. Use HashSet para armazenar os emails.

2. Implemente métodos:
 - adicionarEmail(String email): adiciona um email se ainda não existir;
 - removerEmail(String email): remove um email;
 - existeEmail(String email): verifica se o email está cadastrado;
 - listarEmails(): imprime todos os emails armazenados.

3. No método main, demonstre a adição, remoção, busca e listagem.

````java
import java.util.HashSet;

public class RegistroDeEmails {
    private HashSet<String> emails;

    public RegistroDeEmails() {
        emails = new HashSet<>();
    }

    public boolean adicionarEmail(String email) {
        boolean adicionado = emails.add(email);
        if (adicionado) {
            System.out.println("Email '" + email + "' adicionado com sucesso.");
        } else {
            System.out.println("Email '" + email + "' já existe no cadastro.");
        }
        return adicionado;
    }

    public boolean removerEmail(String email) {
        boolean removido = emails.remove(email);
        if (removido) {
            System.out.println("Email '" + email + "' removido com sucesso.");
        } else {
            System.out.println("Email '" + email + "' não encontrado no cadastro.");
        }
        return removido;
    }

    public boolean existeEmail(String email) {
        return emails.contains(email);
    }

    public void listarEmails() {
        System.out.println("Emails cadastrados:");
        for (String email : emails) {
            System.out.println(email);
        }
    }

    public static void main(String[] args) {
        RegistroDeEmails registro = new RegistroDeEmails();

        // Adicionando emails
        registro.adicionarEmail("usuario1@example.com");
        registro.adicionarEmail("usuario2@example.com");
        registro.adicionarEmail("usuario1@example.com"); // Não será adicionado (duplicado)

        // Verificando existência
        System.out.println("Existe usuario2@example.com? " + registro.existeEmail("usuario2@example.com"));
        System.out.println("Existe usuario3@example.com? " + registro.existeEmail("usuario3@example.com"));

        // Removendo email
        registro.removerEmail("usuario2@example.com");
        registro.removerEmail("usuario3@example.com"); // Não encontrado

        // Listando todos os emails restantes
        registro.listarEmails();
    }
}
````

------------------------------------------------------------------------------------------