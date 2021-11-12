package e2;

import java.util.Comparator;

public class ComparadorPrecioT implements Comparator<Anuncio> {
    @Override
    public int compare(Anuncio o1, Anuncio o2) {
        int i, j;
        int precioGar1 = 0;
        int precioGar2 = 0;
        for (i = 0; i < o1.precioGaraje.size(); i++) {
            precioGar1 = precioGar1 + o1.precioGaraje.get(i);
        }
        for (j = 0; j < o2.precioGaraje.size(); j++) {
            precioGar2 = precioGar2 + o2.precioGaraje.get(j);
        }
        return precioGar1 - precioGar2;
    }
}
