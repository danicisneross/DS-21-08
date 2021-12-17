package e2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DependenciaFuerte extends AlgoritmoOrdenacion {
    private List<Tarea> listaOrdenada = new ArrayList<>();
    private boolean disponible = true;

    @Override
    public List<Tarea> ordena (ListaTareas gestor) {
        int tamano = gestor.getListaTareas().size();
        List<Tarea> disponibles;
        while (listaOrdenada.size() <= tamano) {
            disponibles = new ArrayList<>();
            for (int i = 0; i < gestor.getListaTareas().size(); i++) {
                if (gestor.getListaTareas().get(i).getDependeDe() != null) {
                    for (int j = 0; j < gestor.getListaTareas().get(i).getDependeDe().size(); j++) {
                        if (!gestor.getListaTareas().get(i).getDependeDe().get(j).isRealizada()) {
                            disponible = false;
                            break;
                        }
                    }
                    if (!gestor.getListaTareas().get(i).isRealizada() && disponible) {
                        disponibles.add(gestor.getListaTareas().get(i));
                    }
                } else {
                    disponibles.add(gestor.getListaTareas().get(i));
                }
            }
            Collections.sort(disponibles, new ComparadorNombre());
            for (int k = 0; k < gestor.getListaTareas().size(); k++) {
                if (gestor.getListaTareas().get(k) == disponibles.get(0)) {
                    gestor.getListaTareas().get(k).setRealizada(true);
                    listaOrdenada.add(gestor.getListaTareas().get(k));
                    break;
                }
            }
        }
        return listaOrdenada;
    }
}

