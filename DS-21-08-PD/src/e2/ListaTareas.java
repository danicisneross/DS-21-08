package e2;

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

    public void removeTarea (char nombre) {
        int index = 0;
        boolean existe = false;
        for (int i = 0; i < listaTareas.size(); i++) {
            if (listaTareas.get(i).getNombre() == nombre) {
                index = i;
                existe = true;
                break;
            }
        }
        if (existe)
            listaTareas.remove(index);
    }
}

