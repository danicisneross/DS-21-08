package e2;

import java.util.Collections;
import java.util.List;

abstract class AlgoritmoOrdenacion {
    public List<Tarea> ordena(ListaTareas listaTareas) {
        Collections.sort(listaTareas.getListaTareas(), new ComparadorNombre());
        return listaTareas.getListaTareas();
    }
}
