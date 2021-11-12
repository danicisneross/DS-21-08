package e2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Gestion {
    ArrayList<Anuncio> listaapartamentos;

    Comparator<Anuncio> criterio;

    public Gestion(Comparator<Anuncio> criterio) {
        this.listaapartamentos = new ArrayList<>();
        this.criterio = criterio;
    }

    public void anhadirApartamento(int num, int precioB, ArrayList<Integer> precioG,
                                   int tamanho, int codp, String dir) {
        if(num > 0 && precioB > 0 && tamanho > 0 && codp > 0) {
            for (Integer integer : precioG)
                if (integer >= 0);
                else throw new IllegalArgumentException();
            Anuncio anuncio = new Anuncio(num, precioB, precioG,
                    tamanho, codp, dir);
            listaapartamentos.add(anuncio);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void modificarCriterio(Comparator<Anuncio> nuevoCriterio) {
        if (nuevoCriterio == null)
            this.criterio = null;
        if (Objects.equals(nuevoCriterio, new ComparadorPrecioB()) || Objects.equals(nuevoCriterio, new ComparadorPrecioT())
                || Objects.equals(nuevoCriterio, new ComparadorCP()) || Objects.equals(nuevoCriterio, new ComparadorTam()))
            throw new IllegalArgumentException();
        else this.criterio = nuevoCriterio;
    }

    public void reordenarLista() {
        if (criterio == null) {
            Collections.sort(listaapartamentos);
        } else {
            if (criterio.equals(new ComparadorPrecioB())) {
                Collections.sort(listaapartamentos, new ComparadorPrecioB());
            } else if (criterio.equals(new ComparadorPrecioT())) {
                Collections.sort(listaapartamentos, new ComparadorPrecioT());
            } else if (criterio.equals(new ComparadorCP())) {
                Collections.sort(listaapartamentos, new ComparadorCP());
            } else if (criterio.equals(new ComparadorTam())) {
                Collections.sort(listaapartamentos, new ComparadorTam());
            }
        }
    }
}
