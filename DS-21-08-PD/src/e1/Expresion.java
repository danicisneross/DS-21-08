package e1;

import java.util.ArrayList;
import java.util.List;

public abstract class Expresion {

    public abstract List<Billete> hacerBusqueda(List<Billete> billetesGeneral);

    private List<Billete> listaBilletes = new ArrayList<>();

    public List<Billete> getListaBilletes() {
        return listaBilletes;
    }

    public void setListaBilletes(List<Billete> listaBilletes) {
        this.listaBilletes = listaBilletes;
    }
}
