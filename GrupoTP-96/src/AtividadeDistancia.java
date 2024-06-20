package src;


public class AtividadeDistancia extends Atividade {
    protected double distancia;


    public AtividadeDistancia(String nome, boolean isHard) {
        super(nome, isHard);
        this.distancia = 0;
    }

    public AtividadeDistancia(String nome, double tempoDispendido, double frequenciaCardiacaMedia, boolean isHard, double distancia) {
        super(nome, tempoDispendido, frequenciaCardiacaMedia, isHard);
        this.distancia = distancia;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public void setConsumoCalorias(Utilizador utilizador) {
        if(this.isHard) {
            this.consumoCalorias = 2*((utilizador.getPeso()*0.0175 + utilizador.getAltura()*0.025 +
                    utilizador.getIdade()*0.005 + this.frequenciaCardiacaMedia*0.0005)
                    +((this.distancia/tempoDispendido)*1.036));
        }
        else {
            this.consumoCalorias = (utilizador.getPeso()*0.0175 + utilizador.getAltura()*0.025 +
                    utilizador.getIdade()*0.005 + this.frequenciaCardiacaMedia*0.0005)
                    +((this.distancia/tempoDispendido)*1.036);
        }
    }

    public String toString() {
        return "--- Atividade de Distância ---" + '\n' +
                "nome: " + this.nome + '\n' +
                "tempo dispendido: " + this.tempoDispendido + " minutos" + '\n' +
                "frequencia cardíaca média: " + this.frequenciaCardiacaMedia + " bpm" + '\n' +
                "é Hard: " + this.isHard + '\n' +
                "consumo de calorias: " + this.consumoCalorias + " kcal" + '\n' +
                "distância: " + this.distancia + " km" + '\n';
    }
}