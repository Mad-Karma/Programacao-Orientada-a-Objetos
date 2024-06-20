package src;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Store implements Serializable {
    private Map <Integer, Utilizador> storeUtilizadores;
    private Map <String, Atividade> storeAtividades;
    private int user;

    public Store() {
        this.storeUtilizadores = new HashMap<>();
        this.storeAtividades = new HashMap<>();
        this.user = 0;
    }

    public Store(Map <Integer, Utilizador> storeUtilizadores, Map <String, Atividade> storeAtividades) {
        this.storeUtilizadores = storeUtilizadores;
        this.storeAtividades = storeAtividades;
    }

    public Map<Integer, Utilizador> getStoreUtilizadores() {
        return storeUtilizadores;
    }

    public Utilizador getUtilizador(int codigo) {
        return this.storeUtilizadores.get(codigo);
    }

    public void setUtilizador(int codigo, Utilizador utilizador) {
        this.storeUtilizadores.put(codigo, utilizador);
    }

    public void addUtilizadores(int codigo, Utilizador utilizador) {
        storeUtilizadores.put(codigo, utilizador);
    }

    public void removeUtilizadores(int codigo) {
        storeUtilizadores.remove(codigo);
    }

    public Map<String, Atividade> getStoreAtividades() {
        return storeAtividades;
    }

    public Atividade getAtividade(String codigo) {
        return storeAtividades.get(codigo);
    }

    public void addAtividade(String nome, Atividade atividade) {
        storeAtividades.put(nome, atividade);
    }

    public void removeAtividade(String nome) {
        storeAtividades.remove(nome);
    }

    public int getUser() {
        return this.user;
    }

    public void setUser(int userNovo) {
        this.user = userNovo;
    }

    public void imprimirStoreAtividades(Map<String, Atividade> mapAtividades) {
        for (Map.Entry<String, Atividade> entry : mapAtividades.entrySet()) {
            Atividade atividade = entry.getValue();
            System.out.println(atividade);
        }
    }

    public void imprimirStoreUtilizadores(Map<Integer, Utilizador> mapUtilizadores) {
        for (Map.Entry<Integer, Utilizador> entry : mapUtilizadores.entrySet()) {
            Utilizador utilizador = entry.getValue();
            System.out.println(utilizador);
        }
    }

    public static void salvarStore(Store store, String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(store);
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Store carregarStore(String filename) {
        Store store = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            store = (Store) inputStream.readObject();
            System.out.println("Dados carregados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return store;
    }
}
