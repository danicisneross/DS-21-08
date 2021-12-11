package e2;

import java.util.List;

public class Tarea {
    private char nombre;
    private List<Tarea> dependeDe;
    private boolean realizada;

    public Tarea(char nombre, List<Tarea> dependeDe, boolean realizada) {
        if (Character.isLowerCase(nombre))
            throw new IllegalArgumentException();
        this.nombre = nombre;
        this.dependeDe = dependeDe;
        this.realizada = realizada;
    }

    public char getNombre() {
        return nombre;
    }

    public void setNombre(char nombre) {
        this.nombre = nombre;
    }

    public List<Tarea> getDependeDe() {
        return dependeDe;
    }

    public void setDependeDe(List<Tarea> dependeDe) {
        this.dependeDe = dependeDe;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }
}
