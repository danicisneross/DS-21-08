package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GestionTest {

    private Gestion gestor;
    private Anuncio anuncioAux;

    @BeforeEach
    void setUp() {
        gestor = new Gestion(null);
        gestor.listaapartamentos = new ArrayList<>();
        ArrayList<Integer> precioGar = new ArrayList<>();
        ArrayList<Integer> precioGar2 = new ArrayList<>();
        ArrayList<Integer> precioGar3 = new ArrayList<>();
        precioGar.add(3000);
        precioGar.add(4000);
        precioGar2.add(5500);

        String dir = "Calle uno";
        String dir2 = "Calle dos";
        String dir3 = "Calle tres";

        gestor.anhadirApartamento(1, 60000, precioGar, 120, 15000, dir);
        gestor.anhadirApartamento(3, 55000, precioGar2, 130, 15050, dir3);
        gestor.anhadirApartamento(2, 50000, precioGar3, 125, 15100, dir2);
    }

    @Test
    void testBasic() {
        ArrayList<Integer> precioGarAux = new ArrayList<>();
        precioGarAux.add(3000);
        precioGarAux.add(4000);

        String dir = "Calle uno";

        assertEquals(1, gestor.listaapartamentos.get(0).numRef);
        assertEquals(60000, gestor.listaapartamentos.get(0).precioBase);
        assertEquals(precioGarAux, gestor.listaapartamentos.get(0).precioGaraje);
        assertEquals(120, gestor.listaapartamentos.get(0).tamano);
        assertEquals(15000, gestor.listaapartamentos.get(0).cp);
        assertEquals(dir, gestor.listaapartamentos.get(0).direccion);
    }

    @Test
    void anhadirApartamento() {
        gestor = new Gestion(null);
        gestor.listaapartamentos = new ArrayList<>();
        ArrayList<Integer> precioGarAux = new ArrayList<>();
        ArrayList<Integer> precioGarAux2 = new ArrayList<>();
        precioGarAux.add(7500);
        precioGarAux2.add(3000);
        precioGarAux2.add(-5000);
        String dirAux = "Calle nueva";

        assertThrows(IllegalArgumentException.class, () -> gestor.anhadirApartamento(-3, 55000, precioGarAux, 150, 14000, dirAux));
        assertThrows(IllegalArgumentException.class, () -> gestor.anhadirApartamento(3, 0, precioGarAux, 150, 14000, dirAux));
        assertThrows(IllegalArgumentException.class, () -> gestor.anhadirApartamento(3, 55000, precioGarAux2, 120, 15000, dirAux));
        assertThrows(IllegalArgumentException.class, () -> gestor.anhadirApartamento(3, 55000, precioGarAux, -5000, 14000, dirAux));
        assertThrows(IllegalArgumentException.class, () -> gestor.anhadirApartamento(3, 55000, precioGarAux, 150, -7, dirAux));
    }

    @Test
    void modificarCriterio() {
    }

    @Test
    void reordenarLista() {
        gestor.reordenarLista();

        assertEquals(1, gestor.listaapartamentos.get(0).numRef);
        assertEquals(2, gestor.listaapartamentos.get(1).numRef);
        assertEquals(3, gestor.listaapartamentos.get(2).numRef);

        gestor.modificarCriterio(new ComparadorTam());
        gestor.reordenarLista();

        assertEquals(120, gestor.listaapartamentos.get(0).tamano);
        assertEquals(125, gestor.listaapartamentos.get(1).tamano);
        assertEquals(130, gestor.listaapartamentos.get(2).tamano);
    }
}