package strategy;

import model.Lixeira;
import java.util.List;

public interface EstrategiaRoteirizacao {
    List<Lixeira> gerarRota(List<Lixeira> lixeiras);
}
