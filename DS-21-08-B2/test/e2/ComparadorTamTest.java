package e2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ComparadorTamTest {

    @Test
    void compare() {
        ComparadorTam comparador = new ComparadorTam();
        ArrayList<Integer> precioGarAux = new ArrayList<>();
        ArrayList<Integer> precioGarAux2 = new ArrayList<>();
        ArrayList<Integer> precioGarAux3 = new ArrayList<>();
        precioGarAux.add(4500);
        precioGarAux.add(5000);
        precioGarAux3.add(7990);
        String dirAux = "Calle pequeña";
        String dirAux2 = "Calle grande";
        String dirAux3 = "Calle mediana";

        Anuncio anuncioAux = new Anuncio(50, 100000, precioGarAux, 120, 12000, dirAux);
        Anuncio anuncioAux2 = new Anuncio(45, 129000, precioGarAux2, 90, 11999, dirAux2);
        Anuncio anuncioAux3 = new Anuncio(75, 299999, precioGarAux3, 120, 9999, dirAux3);
        Anuncio anuncioAux4 = new Anuncio(85, 289999, precioGarAux, 150, 19999, dirAux);

        assertTrue(comparador.compare(anuncioAux, anuncioAux2) > 0);
        assertEquals(0, comparador.compare(anuncioAux, anuncioAux3));
        assertTrue(comparador.compare(anuncioAux, anuncioAux4) < 0);
    }
}