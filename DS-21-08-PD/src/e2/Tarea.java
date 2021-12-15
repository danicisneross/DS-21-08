package e2;

import java.util.List;

public class Tarea {
    private final char nombre;
    private final List<Tarea> dependeDe;
    private boolean realizada;

    public Tarea(char nombre, List<Tarea> dependeDe, boolean realizada) {
       
        this.nombre = nombre;
        this.dependeDe = dependeDe;
        this.realizada = realizada;
         
        if (Character.isLowerCase(nombre))
            throw new IllegalArgumentException();
    }

    public char getNombre() {
        return nombre;
    }

    public List<Tarea> getDependeDe() {
        return dependeDe;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }
}
