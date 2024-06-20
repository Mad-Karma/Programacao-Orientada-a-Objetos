package src;

public class AtividadeDistanciaAltimetria extends AtividadeDistancia {
    private int altimetria;


    public AtividadeDistanciaAltimetria(String nome, boolean isHard) {
        super(nome, isHard);
        this.altimetria = 0;
    }

    public AtividadeDistanciaAltimetria(String nome, double tempoDispendido, double frequenciaCardiacaMedia, boolean isHard,
                                        double distancia, int altimetria) {
        super(nome, tempoDispendido, frequenciaCardiacaMedia, isHard, distancia);
        this.altimetria = altimetria;
    }

    public int getAltimetria() {
        return altimetria;
    }

    public void setAltimetria(int altimetria) {
        this.altimetria = altimetria;
    }

    @Override
    public void setConsumoCalorias(Utilizador utilizador) {
        if(this.isHard) {
            this.consumoCalorias = 2*((utilizador.getPeso() * 0.0175 + utilizador.getAltura() * 0.1 +
                    utilizador.getIdade() * 0.005 + frequenciaCardiacaMedia * 0.0005)
                    + ((distancia / tempoDispendido) * 1.036));
        }
        else {
            this.consumoCalorias = (utilizador.getPeso() * 0.0175 + utilizador.getAltura() * 0.1 +
                    utilizador.getIdade() * 0.005 + frequenciaCardiacaMedia * 0.0005)
                    + ((distancia / tempoDispendido) * 1.036);
        }
    }

    public String toString() {
        return "--- Atividade de Distância e Altimetria ---" + '\n' +
                "nome: " + this.nome + '\n' +
                "tempo dispendido: " + this.tempoDispendido + " minutos" + '\n' +
                "frequencia cardíaca média: " + this.frequenciaCardiacaMedia + " bpm" + '\n' +
                "é Hard: " + this.isHard + '\n' +
                "consumo de calorias: " + this.consumoCalorias + " kcal" + '\n' +
                "distância: " + this.distancia + " km" + '\n' +
                "altimetria: " + this.altimetria + " m" + '\n';
    }
}