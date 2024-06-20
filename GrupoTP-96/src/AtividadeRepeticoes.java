package src;

public class AtividadeRepeticoes extends Atividade {
    protected int repeticoes;


    public AtividadeRepeticoes(String nome, boolean isHard) {
        super(nome, isHard);
        this.repeticoes = 0;
    }

    public AtividadeRepeticoes(String nome, double tempoDispendido, double frequenciaCardiacaMedia, boolean isHard, int repeticoes) {
        super(nome, tempoDispendido, frequenciaCardiacaMedia, isHard);
        this.repeticoes = repeticoes;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    @Override
    public void setConsumoCalorias(Utilizador utilizador) {
        if(this.isHard) {
            consumoCalorias = 2*((utilizador.getPeso() * 0.0175 + utilizador.getAltura() * 0.025 +
                    utilizador.getIdade() * 0.005 + frequenciaCardiacaMedia * 0.0005)
                    + (this.repeticoes * 0.5));
        }
        else {
            consumoCalorias = (utilizador.getPeso() * 0.0175 + utilizador.getAltura() * 0.025 +
                    utilizador.getIdade() * 0.005 + frequenciaCardiacaMedia * 0.0005)
                    + (this.repeticoes * 0.5);
        }
    }

    public String toString() {
        return "--- Atividade de Repetições ---" + '\n' +
                "nome: " + this.nome + '\n' +
                "tempo dispendido: " + this.tempoDispendido + " minutos" + '\n' +
                "frequencia cardíaca média: " + this.frequenciaCardiacaMedia + " bpm" + '\n' +
                "é Hard: " + this.isHard + '\n' +
                "consumo de calorias: " + this.consumoCalorias + " kcal" + '\n' +
                "repetições: " + this.repeticoes + '\n';
    }
}