package e2;

import java.util.Comparator;

public class ComparadorNombre implements Comparator<Tarea> {
    @Override
    public int compare(Tarea o1, Tarea o2) {
        return o1.getNombre() - o2.getNombre();
    }
}
