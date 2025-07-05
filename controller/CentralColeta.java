package controller;

import model.Lixeira;
import strategy.EstrategiaRoteirizacao;
import java.util.*;

public class CentralColeta {
    private static CentralColeta instancia;
    private List<Lixeira> lixeiras = new ArrayList<>();

    private CentralColeta() {}

    public static CentralColeta getInstancia() {
        if (instancia == null) {
            instancia = new CentralColeta();
        }
        return instancia;
    }

    public void registrarLixeira(Lixeira lixeira) {
        lixeiras.add(lixeira);
    }

    public List<Lixeira> designarRota(EstrategiaRoteirizacao estrategia) {
        return estrategia.gerarRota(new ArrayList<>(lixeiras));
    }

    public List<Lixeira> getLixeiras() {
        return lixeiras;
    }
}
