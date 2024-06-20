package src;

import java.io.Serializable;

public abstract class Atividade implements Serializable {
    protected String nome;
    protected double tempoDispendido;
    protected double frequenciaCardiacaMedia;
    protected boolean isHard;
    protected double consumoCalorias;

    public Atividade(String nome, boolean isHard) {
        this.nome = nome;
        this.tempoDispendido = 0.0;
        this.frequenciaCardiacaMedia = 0;
        this.isHard = isHard;
        this.consumoCalorias = 0;
    }

    public Atividade(String nome, double tempoDispendido, double frequenciaCardiacaMedia, boolean isHard) {
        this.nome = nome;
        this.tempoDispendido = tempoDispendido;
        this.frequenciaCardiacaMedia = frequenciaCardiacaMedia;
        this.isHard = isHard;
        this.consumoCalorias = 0;
    }

    // Getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTempoDispendido() {
        return tempoDispendido;
    }

    public void setTempoDispendido(double tempoDispendido) {
        this.tempoDispendido = tempoDispendido;
    }

    public double getFrequenciaCardiacaMedia() {
        return frequenciaCardiacaMedia;
    }

    public void setFrequenciaCardiacaMedia(double altimetria) {
        this.frequenciaCardiacaMedia = altimetria;
    }

    public boolean isHard() {
        return isHard;
    }

    public void setHard(boolean hard) {
        isHard = hard;
    }

    public double getConsumoCalorias() {
        return consumoCalorias;
    }

    public abstract void setConsumoCalorias(Utilizador utilizador);

    public String toString() {
        return "Atividade{" +
                "nome: '" + this.nome + '\'' +
                ", tempo dispendido: '" + this.tempoDispendido + " minutos" + '\'' +
                ", frequencia cardíaca média: " + this.frequenciaCardiacaMedia + " bpm" + '\'' +
                ", é Hard: " + this.isHard + '\'' +
                ", consumo de calorias: '" + this.consumoCalorias + " kcal" + '\'' +
                '}';
    }
}