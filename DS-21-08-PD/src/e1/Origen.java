package e1;

import java.util.List;
import java.util.Objects;

public class Origen extends Criterios {

    private String origen;

    public Origen(String origen) {
        this.origen = origen;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public List<Billete> hacerBusqueda(List<Billete> billetesGeneral) { //para que tengo esa lista de billetesGeneral
        var billetesSeleccionadosO = getListaBilletes();

        if (getListaBilletes().size() != 0) {
            for (Billete b : getListaBilletes()) {
                if (Objects.equals(b.getOrigen(), origen)) {
                    billetesSeleccionadosO.add(b);
                }
            }
            setListaBilletes(billetesSeleccionadosO);
        }
        return billetesSeleccionadosO;
    }
}
