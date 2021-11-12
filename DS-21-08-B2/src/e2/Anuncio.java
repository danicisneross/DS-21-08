package e2;

import java.util.ArrayList;
import java.util.Objects;

public class Anuncio implements Comparable<Anuncio>{
    public int numRef;
    public int precioBase;
    public ArrayList<Integer> precioGaraje;
    public int tamano;
    public int cp;
    public String direccion;

    public Anuncio(int numRef, int precioBase, ArrayList<Integer> precioGaraje,
                   int tamano, int cp, String direccion) {
        this.numRef = numRef;
        this.precioBase = precioBase;
        this.precioGaraje = precioGaraje;
        this.tamano = tamano;
        this.cp = cp;
        this.direccion = direccion;

        for (Integer integer : precioGaraje)
            if (numRef <= 0 || precioBase <= 0 || integer <= 0 || tamano <= 0 || cp <= 0 || direccion == null)
                throw new IllegalArgumentException();
    }

    @Override
    public int compareTo(Anuncio o) {
        return this.numRef - o.numRef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anuncio anuncio1 = (Anuncio) o;
        return this.precioBase == anuncio1.precioBase && this.precioGaraje == anuncio1.precioGaraje && this.cp == anuncio1.cp
                && this.tamano == anuncio1.tamano && Objects.equals(this.direccion, anuncio1.direccion);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + tamano;
        hash = 31 * hash + cp;
        hash = 31 * hash + precioBase;
        hash = 31 * hash + (precioGaraje == null ? 0 : precioGaraje.hashCode());
        hash = 31 * hash + (direccion == null ? 0 : direccion.hashCode());
        return hash;
    }
}

