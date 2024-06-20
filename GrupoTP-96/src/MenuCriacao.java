package src;

import java.util.Scanner;

public class MenuCriacao {
    private Scanner scanner;
    private Store store;

    public MenuCriacao(Store store) {
        this.scanner = new Scanner(System.in);
        this.store = store;
    }

    public void exibirMenuCriacao() {
        int opcao;
        do {
            System.out.println("\n\n====== Menu Criação ======");
            System.out.println("1. Criar utilizador");
            System.out.println("2. Criar atividade");
            System.out.println("3. Criar plano de treino\n");
            System.out.print("Escolha uma opção (0 para voltar): ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Insira o nome do utilizador: ");
                    String nome = scanner.nextLine();
                    System.out.print("Insira a morada do utilizador: ");
                    String morada = scanner.nextLine();
                    System.out.print("Insira o email do utilizador: ");
                    String email = scanner.nextLine();
                    System.out.print("Insira a peso do utilizador: ");
                    int peso = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Insira a altura do utilizador (cm): ");
                    int altura = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Insira a idade do utilizador: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();

                    int codigo = this.store.getStoreUtilizadores().size() + 1;
                    Utilizador utilizador = new Utilizador(codigo, nome, morada, email, peso, altura, idade);
                    this.store.addUtilizadores(codigo, utilizador);

                    System.out.print("\nO utilizador foi adicionado com sucesso!");

                    break;

                case 2:
                    System.out.print("Insira o nome da atividade: ");
                    nome = scanner.nextLine();
                    System.out.print("O nivel de dificuldade é Hard (true ou false): ");
                    boolean isHard = scanner.nextBoolean();
                    scanner.nextLine();
                    System.out.print("Insira o tipo da atividade: ");
                    String tipo = scanner.nextLine();

                    switch (tipo) {
                        case "distancia":
                            AtividadeDistancia atividadeDistancia = new AtividadeDistancia(nome, isHard);
                            this.store.addAtividade(nome, atividadeDistancia);
                            break;
                        case "distanca e altimetria":
                            AtividadeDistanciaAltimetria atividadeDistanciaAltimetria = new AtividadeDistanciaAltimetria(nome, isHard);
                            this.store.addAtividade(nome, atividadeDistanciaAltimetria);
                            break;
                        case "repeticoes":
                            AtividadeRepeticoes atividadeRepeticoes = new AtividadeRepeticoes(nome, isHard);
                            this.store.addAtividade(nome, atividadeRepeticoes);
                            break;
                        case "repeticoes e pesos":
                            AtividadeRepeticoesPesos atividadeRepeticoesPesos = new AtividadeRepeticoesPesos(nome, isHard);
                            this.store.addAtividade(nome, atividadeRepeticoesPesos);
                        default:
                            System.out.println("Tipo inválido. Por favor, indique novamente.");
                    }

                    System.out.print("\nO utilizador foi adicionado com sucesso!");

                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (opcao != 0);
    }
}