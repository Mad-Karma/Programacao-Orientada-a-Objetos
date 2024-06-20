package src;

public class AtividadeRepeticoesPesos extends AtividadeRepeticoes {
    private int pesos;


    public AtividadeRepeticoesPesos(String nome, boolean isHard) {
        super(nome, isHard);
        this.pesos = 0;
    }

    public AtividadeRepeticoesPesos(String nome, double tempoDispendido, double frequenciaCardiacaMedia, boolean isHard, int repeticoes, int pesos) {
        super(nome, tempoDispendido, frequenciaCardiacaMedia, isHard, repeticoes);
        this.pesos = pesos;
    }

    public int getPesos() {
        return this.pesos;
    }

    public void setPesos(int pesos) {
        this.pesos = pesos;
    }

    @Override
    public void setConsumoCalorias(Utilizador utilizador) {
        if(this.isHard) {
            this.consumoCalorias = 2*((utilizador.getPeso()*0.0175 + utilizador.getAltura()*0.025 +
                    utilizador.getIdade()*0.005 + this.frequenciaCardiacaMedia*0.0005)
                    +(this.repeticoes*this.pesos*0.5));
        }
        else {
            this.consumoCalorias = (utilizador.getPeso()*0.0175 + utilizador.getAltura()*0.025 +
                    utilizador.getIdade()*0.005 + this.frequenciaCardiacaMedia*0.0005)
                    +(this.repeticoes*this.pesos*0.5);
        }
    }

    public String toString() {
        return "--- Atividade de Repetições e Pesos ---" + '\n' +
                "nome: " + this.nome + '\n' +
                "tempo dispendido: " + this.tempoDispendido + " minutos" + '\n' +
                "frequencia cardíaca média: " + this.frequenciaCardiacaMedia + " bpm" + '\n' +
                "é Hard: " + this.isHard + '\n' +
                "consumo de calorias: " + this.consumoCalorias + " kcal" + '\n' +
                "repetições: " + this.repeticoes + '\n' +
                "pesos: " + this.pesos + " kg" + '\n';
    }
}