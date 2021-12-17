package e1;

import java.util.List;
import java.util.Objects;

public class Or extends Logica {

    public Or(Expresion e1, Expresion e2) {
        super(e1, e2);

    }

    @Override
    public List<Billete> hacerBusqueda(List<Billete> billetesGeneral) {
        var billetesSeleccionadosE1 = e1.hacerBusqueda(billetesGeneral);
        var billetesSeleccionadosE2 = e2.hacerBusqueda(billetesGeneral);

        if(billetesSeleccionadosE1.size() !=0 && billetesSeleccionadosE2.size() != 0) {
            for (Billete b : billetesSeleccionadosE2) {
                if (!billetesSeleccionadosE1.contains(b)) {
                    billetesSeleccionadosE1.add(b);
                }
            }
        }
    return billetesSeleccionadosE1;
    }
}
