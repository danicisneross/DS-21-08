package e2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenJerarquico extends AlgoritmoOrdenacion {
    private List<Tarea> listaOrdenada = new ArrayList<>();
    private List<Tarea> listaNivel1 = new ArrayList<>();
    private List<Tarea> listaNivel2 = new ArrayList<>();

    @Override
    public List<Tarea> ordena (ListaTareas gestor) {
        for (int i = 0; i < gestor.getListaTareas().size(); i++) {
            if (gestor.getListaTareas().get(i).getDependeDe() == null) {
                gestor.getListaTareas().get(i).setRealizada(true);
                listaNivel1.add(gestor.getListaTareas().get(i));
            }
        }
        Collections.sort(listaNivel1, new ComparadorNombre());
        listaOrdenada.addAll(listaNivel1);
        for (int k = 0; k < gestor.getListaTareas().size(); k++) {
            if (gestor.getListaTareas().get(k).getDependeDe() != null) {
                for (int h = 0; h < gestor.getListaTareas().get(k).getDependeDe().size(); h++) {
                    for (Tarea tarea : listaNivel1) {
                        if (gestor.getListaTareas().get(k).getDependeDe().get(h) == tarea) {
                            gestor.getListaTareas().get(k).setRealizada(true);
                            listaNivel2.add(gestor.getListaTareas().get(k));
                        }
                    }
                }
            }
        }
        Collections.sort(listaNivel2, new ComparadorNombre());
        listaOrdenada.addAll(listaNivel2);
        return listaOrdenada;
    }
}

