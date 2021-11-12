package e2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ComparadorPrecioTTest {

    @Test
    void compare() {
        ComparadorPrecioT comparador = new ComparadorPrecioT();
        ArrayList<Integer> precioGarAux = new ArrayList<>();
        ArrayList<Integer> precioGarAux2 = new ArrayList<>();
        ArrayList<Integer> precioGarAux3 = new ArrayList<>();
        ArrayList<Integer> precioGarAux4 = new ArrayList<>();
        precioGarAux.add(4500);
        precioGarAux.add(5000);
        precioGarAux3.add(9500);
        precioGarAux4.add(5000);
        precioGarAux4.add(5000);
        String dirAux = "Calle pequeña";
        String dirAux2 = "Calle grande";
        String dirAux3 = "Calle mediana";

        Anuncio anuncioAux = new Anuncio(50, 100000, precioGarAux, 120, 12000, dirAux);
        Anuncio anuncioAux2 = new Anuncio(45, 100000, precioGarAux2, 110, 11999, dirAux2);
        Anuncio anuncioAux3 = new Anuncio(75, 100000, precioGarAux4, 150, 9999, dirAux3);
        Anuncio anuncioAux4 = new Anuncio(85, 100000, precioGarAux3, 120, 19999, dirAux);

        assertTrue(comparador.compare(anuncioAux, anuncioAux2) > 0);
        assertEquals(0, comparador.compare(anuncioAux, anuncioAux4));
        assertTrue(comparador.compare(anuncioAux, anuncioAux3) < 0);
    }
}