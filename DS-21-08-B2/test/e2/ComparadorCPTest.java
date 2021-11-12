package e2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ComparadorCPTest {

    @Test
    void compare() {
        ComparadorCP comparador = new ComparadorCP();
        ArrayList<Integer> precioGarAux = new ArrayList<>();
        ArrayList<Integer> precioGarAux2 = new ArrayList<>();
        ArrayList<Integer> precioGarAux3 = new ArrayList<>();
        precioGarAux.add(4500);
        precioGarAux.add(5000);
        precioGarAux3.add(7990);
        String dirAux = "Calle pequeña";
        String dirAux2 = "Calle grande";
        String dirAux3 = "Calle mediana";

        Anuncio anuncioAux = new Anuncio(50, 289999, precioGarAux, 130, 12000, dirAux);
        Anuncio anuncioAux2 = new Anuncio(90, 129000, precioGarAux2, 160, 10000, dirAux3);
        Anuncio anuncioAux3 = new Anuncio(1, 200000, precioGarAux3, 110, 15000, dirAux2);
        Anuncio anuncioAux4 = new Anuncio(50, 289999, precioGarAux, 90, 12000, dirAux);

        assertTrue(comparador.compare(anuncioAux, anuncioAux2) > 0);
        assertEquals(0, comparador.compare(anuncioAux, anuncioAux4));
        assertTrue(comparador.compare(anuncioAux, anuncioAux3) < 0);
    }
}