package e1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Busqueda extends Criterios {

    private List<Criterios> listaCriterios = new ArrayList<>();
    private List<Logica> listaPuertasL = new ArrayList<>();

    public void addCriterios(Criterios c, Logica p) {
        if (listaCriterios.size() != 0) {
            this.listaPuertasL.add(p);
        }
        this.listaCriterios.add(c);
    }

    public List<Criterios> getListaCriterios() {
        return listaCriterios;
    }

    @Override
    public List<Billete> hacerBusqueda(List<Billete> billetesGeneral) {
        List<Billete> billetesSeleccionados = getListaBilletes();
        boolean origen = true, destino = true, fecha = true, precio = true;
        int a = 0, x = 0; //

        if (listaCriterios.size() != 0 && (listaPuertasL.size() == listaCriterios.size() - 1)) {
            for (int i = 0; i < listaPuertasL.size(); i++) {
                var c = listaCriterios.get(i);
                var p = listaPuertasL.get(i);
                var l = c.getListaBilletes();

                if (p == Logica.AND) {
                    for (int j = 1; j < l.size(); j++) {
                        var b = l.get(j);
                        if (!Objects.equals(l.get(0).getOrigen(), b.getOrigen())) {
                            origen = false;
                        }
                        if (!Objects.equals(l.get(0).getDestino(), b.getDestino())) {
                            destino = false;
                        }
                        if (!Objects.equals(l.get(0).getPrecio(), b.getPrecio())) {
                            precio = false;
                        }
                        if (!Objects.equals(l.get(0).getFecha(), b.getFecha())) {
                            fecha = false;
                        }
                    }
                    if (origen)     a = 1;
                    if (destino)    a = 2;
                    if (precio)     a = 3;
                    if (fecha)      a = 4;
                    if (a == 0 || x == 0){
                        x = a;
                        billetesSeleccionados.addAll(l);
                    } else {
                        if (a == x) {
                            return new ArrayList<>();
                        } else {
                            billetesSeleccionados.addAll(l);
                        }
                    }
                } else {
                    billetesSeleccionados.addAll(l);
                }
            }
        }
        return null;
    }
}