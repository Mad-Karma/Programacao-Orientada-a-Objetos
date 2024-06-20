package src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class PlanoDeTreino implements Serializable {
    private LocalDate data;
    private ArrayList<Atividade> atividades;

    public PlanoDeTreino(LocalDate data) {
        this.data = data;
        this.atividades = new ArrayList<>();
    }

    public void adicionarAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<Atividade> atividades) {
        this.atividades = atividades;
    }

    public void addAtividades(Atividade atividade) {
        this.atividades.add(atividade);
    }
}
