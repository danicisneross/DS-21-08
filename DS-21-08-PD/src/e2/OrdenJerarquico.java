package e2;

import java.util.Collections;
import java.util.List;

public class OrdenJerarquico extends AlgoritmoOrdenacion {
    private List<Tarea> listaOrdenada;
    private List<Tarea> listaAuxiliar;
    private List<Tarea> listaAuxiliar2;
    private boolean disponible = false;

    @Override
    public List<Tarea> ordena (ListaTareas listaTareas) {
        Collections.sort(listaTareas.getListaTareas(), new ComparadorNombre());
        for (int i = 0; i < listaTareas.getListaTareas().size(); i++) {
            if (listaTareas.getListaTareas().get(i).getDependeDe() == null) {
                listaTareas.getListaTareas().get(i).setRealizada(true);
                listaOrdenada.add(listaTareas.getListaTareas().get(i));
                listaTareas.getListaTareas().remove(i);
            }
        }

        for (int i = 0; i < listaTareas.getListaTareas().size(); i++) {
            for (int j = 0; j < listaTareas.getListaTareas().get(i).getDependeDe().size(); j++) {
                if (listaTareas.getListaTareas().get(i).getDependeDe().get(j).isRealizada()) {
                    disponible = true;
                    break;
                }
            }
            if (disponible) {
                listaTareas.getListaTareas().get(i).setRealizada(true);
                listaOrdenada.add(listaTareas.getListaTareas().get(i));
                listaTareas.getListaTareas().remove(i);
            }
        }
        return listaOrdenada;
    }
}
