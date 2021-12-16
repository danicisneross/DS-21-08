package e1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Fecha extends Criterios {

    public LocalDate fecha;

    public Fecha(LocalDate fecha, List<Fecha> listaFechas) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public List<Billete> hacerBusqueda(List<Billete> billetesGeneral) {
        List<Billete> billetesSeleccionadosF = getListaBilletes();

        if (getListaBilletes().size() != 0) {
            for (Billete b : getListaBilletes()) {
                if (Objects.equals(b.getFecha(), fecha)) {
                    billetesSeleccionadosF.add(b);
                }
            }
            setListaBilletes(billetesSeleccionadosF);
        }
        return billetesSeleccionadosF;
    }
}
