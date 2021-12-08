package e1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteradorLista implements Iterator<Billete> {
    private List<Billete> listabilletes;
    private int index = 0;

    public IteradorLista(List<Billete> listabilletes, int index) {
        this.listabilletes = listabilletes;
        this.index = index;
    }

    @Override
    public boolean hasNext() {
        return index < listabilletes.size();
    }

    @Override
    public Billete next() {
        return hasNext() ? listabilletes.get(index++) : null;
    }
}
