import controller.CentralColeta;
import model.Lixeira;
import observer.SistemaColeta;
import view.TelaPrincipal;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        CentralColeta central = CentralColeta.getInstancia();

        Lixeira l1 = new Lixeira(1, "Rua A");
        Lixeira l2 = new Lixeira(2, "Rua B");
        Lixeira l3 = new Lixeira(3, "Rua C");

        SistemaColeta sistema = new SistemaColeta();
        l1.registrarObserver(sistema);
        l2.registrarObserver(sistema);
        l3.registrarObserver(sistema);

        l1.adicionarLixo(60);
        l2.adicionarLixo(85);
        l3.adicionarLixo(40);

        central.registrarLixeira(l1);
        central.registrarLixeira(l2);
        central.registrarLixeira(l3);

        SwingUtilities.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }
}
