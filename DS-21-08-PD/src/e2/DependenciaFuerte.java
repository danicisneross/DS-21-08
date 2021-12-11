package e2;

import java.util.List;

public class DependenciaFuerte extends AlgoritmoOrdenacion {
    private List<Tarea> listaOrdenada;
    private List<Tarea> listaAuxiliar;
    @Override
    public List<Tarea> ordena(ListaTareas listaTareas) {
        for (int i = 0; i < listaTareas.getListaTareas().size(); i++) {
            if (listaTareas.getListaTareas().get(i).getDependeDe() == null) {
                listaAuxiliar.add(listaTareas.getListaTareas().get(i));
            }
        }



        return listaOrdenada;
    }
}
