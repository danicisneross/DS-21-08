package e1;

import java.util.ArrayList;
import java.util.List;

public class And extends Logica {

    public And(Expresion e1, Expresion e2) {
        super(e1, e2);
    }

    @Override
    public List<Billete> hacerBusqueda(List<Billete> billetesGeneral) {
        var billetesSeleccionadosE1 = e1.hacerBusqueda(billetesGeneral);
        var billetesSeleccionadosE2 = e2.hacerBusqueda(billetesGeneral);
        List<Billete> billetesSeleccionadosGeneral = new ArrayList<>();

        if (billetesSeleccionadosE1.size() != 0 && billetesSeleccionadosE2.size() != 0) {
            for (Billete b : billetesSeleccionadosE2) {
                if (billetesSeleccionadosE1.contains(b)) {
                    billetesSeleccionadosGeneral.add(b);
                }
            }
        }
        return billetesSeleccionadosGeneral;
    }
}
