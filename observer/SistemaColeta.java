package observer;

import model.Lixeira;

public class SistemaColeta implements ColetorObserver {
    @Override
    public void atualizar(Lixeira lixeira) {
        System.out.println("[ALERTA] Lixeira cheia em: " + lixeira.getLocalizacao());
    }
}
