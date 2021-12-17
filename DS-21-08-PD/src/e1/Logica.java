package e1;

import java.util.List;

public abstract class Logica extends Expresion {

    Expresion e1;
    Expresion e2;

    public Logica(Expresion e1, Expresion e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public Expresion getE1() {
        return e1;
    }

    public void setE1(Expresion e1) {
        this.e1 = e1;
    }

    public Expresion getE2() {
        return e2;
    }

    public void setE2(Expresion e2) {
        this.e2 = e2;
    }

    @Override
    public List<Billete> hacerBusqueda(List<Billete> billetesGeneral) {
        return null;
    }
}
