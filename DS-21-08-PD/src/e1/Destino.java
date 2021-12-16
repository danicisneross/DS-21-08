package e1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Destino extends Criterios {

    public String destino;

    public Destino(String destino) {
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public List<Billete> hacerBusqueda(List<Billete> billetesGeneral) { //para que tengo esa lista de billetesGeneral
        List<Billete> billetesSeleccionadosD = new ArrayList<>();

        if (getListaBilletes().size() != 0) {
            for (Billete b : getListaBilletes()) {
                if (Objects.equals(b.getDestino(), destino)) {
                    billetesSeleccionadosD.add(b);
                }
            }
            setListaBilletes(billetesSeleccionadosD);
        }
        return billetesSeleccionadosD;
    }
}
