package src;

import java.io.Serializable;
import java.util.ArrayList;

public class Utilizador implements Serializable {
    private int codigoUtilizador;
    private String nome;
    private String morada;
    private String email;
    private int peso;
    private int altura;
    private int idade;
    private ArrayList<Atividade> atividades;
    private ArrayList<PlanoDeTreino> planosDeTreino;

    public Utilizador(int codigoUtilizador, String nome, String morada, String email,
                      int peso, int altura, int idade) {
        this.codigoUtilizador = codigoUtilizador;
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.atividades = new ArrayList<>();
        this.planosDeTreino = new ArrayList<>();
    }

    // Getters e setters

    public int getCodigoUtilizador() {
        return codigoUtilizador;
    }

    public void setCodigoUtilizador(int codigoUtilizador) {
        this.codigoUtilizador = codigoUtilizador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public void addAtividades(Atividade atividade) {
        this.atividades.add(atividade);
    }

    public ArrayList<PlanoDeTreino> getPlanosDeTreino() {
        return this.planosDeTreino;
    }

    public void addPlanoDeTreino(PlanoDeTreino planoDeTreino) {
        this.planosDeTreino.add(planoDeTreino);
    }

    public String toString() {
        return "Utilizador { " +
                "codigo: '" + this.codigoUtilizador + '\'' +
                ", nome: '" + this.nome + '\'' +
                ", morada: " + this.morada + '\'' +
                ", e-mail: " + this.email + '\'' +
                ", peso: '" + this.peso + " kg" + '\'' +
                ", altura: '" + this.altura + " cm" + '\'' +
                ", idade: '" + this.idade + " anos" + '\'' +
                '}';
    }
}
