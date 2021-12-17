package e1;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


public class Fecha extends Criterio {

    private LocalDate fecha;

    public Fecha(String fecha) {
        this.fecha = LocalDate.parse(fecha);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public List<Billete> hacerBusqueda(List<Billete> billetesGeneral) {
        var billetesSeleccionadosF = getListaBilletes();

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
