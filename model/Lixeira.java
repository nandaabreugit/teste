package model;

import observer.ColetorObserver;
import java.util.*;

public class Lixeira {
    private int id;
    private String localizacao;
    private double nivelLixo;
    private List<ColetorObserver> observers = new ArrayList<>();

    public Lixeira(int id, String localizacao) {
        this.id = id;
        this.localizacao = localizacao;
        this.nivelLixo = 0;
    }

    public void adicionarLixo(double qtd) {
        this.nivelLixo += qtd;
        if (nivelLixo >= 70) {
            notificar();
        }
    }

    public double getNivel() {
        return nivelLixo;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public int getId() {
        return id;
    }

    public void registrarObserver(ColetorObserver obs) {
        observers.add(obs);
    }

    private void notificar() {
        for (ColetorObserver obs : observers) {
            obs.atualizar(this);
        }
    }
}
