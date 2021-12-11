package e2;

import java.util.ArrayList;
import java.util.List;

public class ListaTareas {
    private List<Tarea> listaTareas;

    public ListaTareas(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public List<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public void addTarea (char nombre, List<Tarea> dependeDe, boolean realizada) {
        Tarea tarea = new Tarea(nombre, dependeDe, realizada);
        listaTareas.add(tarea);
    }
}
