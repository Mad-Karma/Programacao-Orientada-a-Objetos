package src;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner;
    private MenuAdministrador menuAdministrador;
    private Store store;

    public MenuPrincipal(Store store) {
        this.scanner = new Scanner(System.in);
        this.menuAdministrador = new MenuAdministrador(store);
        this.store = store;
    }

    public void exibirMenuPrincipal() {
        int opcao;
        Utilizador utilizador;
        do {
            System.out.println("====== Menu Principal ======");
            System.out.println("1. Registar a execução de uma atividade");
            System.out.println("2. Criar um plano de treino");
            System.out.println("3. Listar as atividades realizadas");
            System.out.println("4. Listar os planos de treino registados\n");
            System.out.print("Escolha uma opção (0 para sair): ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Insira o nome da atividade: ");
                    String nome = scanner.nextLine();
                    System.out.print("Indique a duração (em minutos): ");
                    int duracao = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Indique a frequência cardiaca média: ");
                    int frequenciaCardiaca = scanner.nextInt();
                    scanner.nextLine();

                    double distancia;
                    int altimetria;
                    int pesos;
                    int repeticoes;
                    Atividade atividade;
                    if(store.getAtividade(nome) == null) {
                        System.out.println("A atividade inserida não existe!");
                        break;
                    }
                    else {
                        Atividade activ = store.getAtividade(nome);
                        boolean isHard = activ.isHard();
                        if(activ instanceof AtividadeDistanciaAltimetria) {
                            System.out.print("Insira a distância percorrida: ");
                            distancia = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Indique a altimetria: ");
                            altimetria = scanner.nextInt();
                            scanner.nextLine();

                            atividade = new AtividadeDistanciaAltimetria(nome, duracao, frequenciaCardiaca, isHard, distancia, altimetria);
                            utilizador = store.getUtilizador(store.getUser());
                            atividade.setConsumoCalorias(utilizador);
                        }
                        else if(activ instanceof AtividadeDistancia) {
                            System.out.print("Insira a distância percorrida: ");
                            distancia = scanner.nextDouble();
                            scanner.nextLine();

                            atividade = new AtividadeDistancia(nome, duracao, frequenciaCardiaca, isHard, distancia);
                            utilizador = store.getUtilizador(store.getUser());
                            atividade.setConsumoCalorias(utilizador);
                        }
                        else if(activ instanceof AtividadeRepeticoesPesos) {
                            System.out.print("Indique o número de repetições realizadas: ");
                            repeticoes = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Insira o peso utilizado: ");
                            pesos = scanner.nextInt();
                            scanner.nextLine();

                            atividade = new AtividadeRepeticoesPesos(nome, duracao, frequenciaCardiaca, isHard, repeticoes, pesos);
                            utilizador = store.getUtilizador(store.getUser());
                            atividade.setConsumoCalorias(utilizador);
                        }
                        else if(activ instanceof AtividadeRepeticoes) {
                            System.out.print("Indique o número de repetições realizadas: ");
                            repeticoes = scanner.nextInt();
                            scanner.nextLine();

                            atividade = new AtividadeRepeticoes(nome, duracao, frequenciaCardiaca, isHard, repeticoes);
                            utilizador = store.getUtilizador(store.getUser());
                            atividade.setConsumoCalorias(utilizador);
                        }
                        else{
                            break;
                        }
                    }

                    utilizador = store.getUtilizador(store.getUser());
                    utilizador.addAtividades(atividade);
                    store.setUtilizador(store.getUser(), utilizador);

                    System.out.println("A execução da atividade foi registada com sucesso.\n");

                    break;
                case 2:
                    System.out.print("Indique a data para a realização: ");
                    String inputDate = scanner.nextLine();
                    LocalDate data = LocalDate.parse(inputDate);

                    String activ;
                    PlanoDeTreino plano = new PlanoDeTreino(data);
                    do {
                        System.out.print("\nIndique as atividades a realizar (0 para terminar): ");
                        activ = scanner.nextLine();

                        if(!activ.equals("0")) {
                            System.out.print("\nIndique a duração (em minutos): ");
                            int duracaoo = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Indique a frequência cardiaca média: ");
                            int frequenciaCardiacaa = scanner.nextInt();
                            scanner.nextLine();

                            if(store.getAtividade(activ) == null) {
                                System.out.println("A atividade inserida não existe!");
                                break;
                            }
                            else {
                                Atividade act = store.getAtividade(activ);
                                boolean isHard = act.isHard();
                                if(act instanceof AtividadeDistanciaAltimetria) {
                                    System.out.print("Insira a distância percorrida: ");
                                    distancia = scanner.nextDouble();
                                    scanner.nextLine();
                                    System.out.print("Indique a altimetria: ");
                                    altimetria = scanner.nextInt();
                                    scanner.nextLine();

                                    atividade = new AtividadeDistanciaAltimetria(activ, duracaoo, frequenciaCardiacaa, isHard, distancia, altimetria);
                                    utilizador = store.getUtilizador(store.getUser());
                                    atividade.setConsumoCalorias(utilizador);
                                }
                                else if(act instanceof AtividadeDistancia) {
                                    System.out.print("Insira a distância percorrida: ");
                                    distancia = scanner.nextDouble();
                                    scanner.nextLine();

                                    atividade = new AtividadeDistancia(activ, duracaoo, frequenciaCardiacaa, isHard, distancia);
                                    utilizador = store.getUtilizador(store.getUser());
                                    atividade.setConsumoCalorias(utilizador);
                                }
                                else if(act instanceof AtividadeRepeticoesPesos) {
                                    System.out.print("Indique o número de repetições realizadas: ");
                                    repeticoes = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.print("Insira o peso utilizado: ");
                                    pesos = scanner.nextInt();
                                    scanner.nextLine();

                                    atividade = new AtividadeRepeticoesPesos(activ, duracaoo, frequenciaCardiacaa, isHard, repeticoes, pesos);
                                    utilizador = store.getUtilizador(store.getUser());
                                    atividade.setConsumoCalorias(utilizador);
                                }
                                else if(act instanceof AtividadeRepeticoes) {
                                    System.out.print("Indique o número de repetições realizadas: ");
                                    repeticoes = scanner.nextInt();
                                    scanner.nextLine();

                                    atividade = new AtividadeRepeticoes(activ, duracaoo, frequenciaCardiacaa, isHard, repeticoes);
                                    utilizador = store.getUtilizador(store.getUser());
                                    atividade.setConsumoCalorias(utilizador);
                                }
                                else{
                                    break;
                                }

                                plano.addAtividades(atividade);
                            }
                        }
                    }while(!activ.equals("0"));

                    Utilizador user = store.getUtilizador(store.getUser());
                    user.addPlanoDeTreino(plano);

                    break;
                case 3:
                    utilizador = store.getUtilizador(store.getUser());
                    ArrayList<Atividade> atividades = utilizador.getAtividades();

                    System.out.println("Atividades realizadas:\n");
                    for (Atividade elemento : atividades) {
                        System.out.println(elemento.toString());
                    }

                    break;
                case 4:
                    utilizador = store.getUtilizador(store.getUser());
                    ArrayList<PlanoDeTreino> planosDeTreino = utilizador.getPlanosDeTreino();

                    System.out.println("Planos de Treino:\n");
                    for (PlanoDeTreino elemento : planosDeTreino) {
                        System.out.println("Plano:\n");
                        System.out.println("Data: " + elemento.getData().toString());
                        ArrayList<Atividade> listaAtividades = elemento.getAtividades();
                        for (Atividade a : listaAtividades) {
                            System.out.println(a.toString());
                        }
                    }

                    break;
                case 0:
                    System.out.println("Saindo do programa...\n\n\n");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (opcao != 0);
    }
}
