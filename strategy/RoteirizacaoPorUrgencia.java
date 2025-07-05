package strategy;

import model.Lixeira;
import java.util.*;

public class RoteirizacaoPorUrgencia implements EstrategiaRoteirizacao {
    public List<Lixeira> gerarRota(List<Lixeira> lixeiras) {
        lixeiras.sort((a, b) -> Double.compare(b.getNivel(), a.getNivel()));
        return lixeiras;
    }
}
