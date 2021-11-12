package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AnuncioTest {

    private Anuncio simpleAnuncio;
    private Anuncio simpleAnuncioAuxiliar;

    private ArrayList<Integer> precioGar;

    private String direc;

    @BeforeEach
    void setUp() {
        precioGar = new ArrayList<>();
        precioGar.add(5000);
        direc = "Calle San Diego 34";

        simpleAnuncio = new Anuncio(3, 50000, precioGar, 120, 15897, direc);
    }

    @Test
    void testBasic() {
        ArrayList<Integer>precioGarAux = new ArrayList<>();
        precioGarAux.add(5000);

        assertEquals(3, simpleAnuncio.numRef);
        assertEquals(50000, simpleAnuncio.precioBase);
        assertEquals(precioGarAux, simpleAnuncio.precioGaraje);
        assertEquals(120, simpleAnuncio.tamano);
        assertEquals(15897, simpleAnuncio.cp);
        assertEquals("Calle San Diego 34", simpleAnuncio.direccion);
    }

    @Test
    void compareTo() {
        ArrayList<Integer> precioGarAux = new ArrayList<>();
        precioGarAux.add(5000);
        precioGarAux.add(3200);

        direc = "Calle San Juian 33";
        String direc2 = "Avenida de Messi 88";
        String direccionAux = "Avenida Ferrocarril";

        Anuncio simpleAnuncio2 = new Anuncio(2, 50000, precioGarAux, 110, 15893, direc2);
        Anuncio simpleAnuncio3 = new Anuncio(4, 55000, precioGarAux, 120, 15897, direc);
        Anuncio simpleAnuncio4 = new Anuncio(3, 50500, precioGar, 110, 15896, direccionAux);

        assertEquals(-1, simpleAnuncio2.compareTo(simpleAnuncio));
        assertEquals(0, simpleAnuncio4.compareTo(simpleAnuncio));
        assertEquals(1, simpleAnuncio3.compareTo(simpleAnuncio));
    }

    @Test
    void testEquals() {
        ArrayList<Integer> precioGarAux = new ArrayList<>();
        precioGarAux.add(2500);
        precioGarAux.add(4000);

        String direcAux = "Calle Diego Maradona 10";

        Anuncio simpleAnuncioAux = new Anuncio(5, 75000, precioGarAux, 150, 15000, direcAux);
        Anuncio simpleAnuncioAux2 = new Anuncio(5, 75000, precioGarAux, 150, 15000, direcAux);
        Anuncio simpleAnuncioAux3 = new Anuncio(10, 75000, precioGarAux, 150, 15000, direcAux);

        assertEquals(simpleAnuncioAux, simpleAnuncioAux2);
        assertEquals(simpleAnuncioAux, simpleAnuncioAux3);

        assertEquals(simpleAnuncioAux.hashCode(), simpleAnuncioAux2.hashCode());
        assertEquals(simpleAnuncioAux.hashCode(), simpleAnuncioAux3.hashCode());
    }

    @Test
    void testEqualsTypes() {
        assertEquals(simpleAnuncio, simpleAnuncio);
        assertNotEquals(null, simpleAnuncio);
        assertNotEquals(50000, simpleAnuncio);
    }

    @Test
    void notEqualsPrecioB() {
        ArrayList<Integer> precioGarAux = new ArrayList<>();
        ArrayList<Integer> precioGarAux2 = new ArrayList<>();
        precioGarAux.add(3500);
        precioGarAux2.add(3500);
        String dir = "Calle Pablo Picasso";

        Anuncio a1 = new Anuncio(5, 50000, precioGarAux, 100, 15000, dir);
        Anuncio a2 = new Anuncio(5, 60000, precioGarAux2, 100, 15000, dir);

        assertNotEquals(a1, a2);
    }

    @Test
    void notEqualsPrecioG() {
        ArrayList<Integer> precioGarAux = new ArrayList<>();
        ArrayList<Integer> precioGarAux2 = new ArrayList<>();
        precioGarAux.add(3500);
        precioGarAux2.add(4500);
        String dir = "Calle Pablo Picasso";

        Anuncio a1 = new Anuncio(5, 50000, precioGarAux, 100, 15000, dir);
        Anuncio a2 = new Anuncio(5, 50000, precioGarAux2, 100, 15000, dir);

        assertNotEquals(a1, a2);
    }

    @Test
    void notEqualsTam() {
        ArrayList<Integer> precioGarAux = new ArrayList<>();
        precioGarAux.add(3500);

        String dir = "Calle Pablo Picasso";

        Anuncio a1 = new Anuncio(5, 50000, precioGarAux, 100, 15000, dir);
        Anuncio a2 = new Anuncio(5, 50000, precioGarAux, 110, 15000, dir);

        assertNotEquals(a1, a2);
    }

    @Test
    void notEqualsCP() {
        ArrayList<Integer> precioGarAux = new ArrayList<>();
        precioGarAux.add(3500);

        String dir = "Calle Pablo Picasso";

        Anuncio a1 = new Anuncio(5, 50000, precioGarAux, 100, 15000, dir);
        Anuncio a2 = new Anuncio(5, 50000, precioGarAux, 100, 16000, dir);

        assertNotEquals(a1, a2);
    }

    @Test
    void notEqualsDir() {
        ArrayList<Integer> precioGarAux = new ArrayList<>();
        precioGarAux.add(3500);

        String dir = "Calle Pablo Picasso";
        String dir2 = "Calle Don Manuel";

        Anuncio a1 = new Anuncio(5, 50000, precioGarAux, 100, 15000, dir);
        Anuncio a2 = new Anuncio(5, 50000, precioGarAux, 100, 15000, dir2);

        assertNotEquals(a1, a2);
    }

    @Test
    void testExections() {
        ArrayList<Integer> precioGarAux = new ArrayList<>();
        ArrayList<Integer> precioGarAux2 = new ArrayList<>();
        precioGarAux.add(3500);
        precioGarAux2.add(-3000);
        String dir = "Calle Pablo Picasso";

        assertThrows(IllegalArgumentException.class, () -> simpleAnuncioAuxiliar = new Anuncio(0, 50000, precioGarAux, 150, 14000, dir));
        assertThrows(IllegalArgumentException.class, () -> simpleAnuncioAuxiliar = new Anuncio(56, -50000, precioGarAux, 150, 14000, dir));
        assertThrows(IllegalArgumentException.class, () -> simpleAnuncioAuxiliar = new Anuncio(23, 50000, precioGarAux2, -150, 14000, dir));
        assertThrows(IllegalArgumentException.class, () -> simpleAnuncioAuxiliar = new Anuncio(256, 50000, precioGarAux, -1, 14000, dir));
        assertThrows(IllegalArgumentException.class, () -> simpleAnuncioAuxiliar = new Anuncio(98, 50000, precioGarAux, 150, 0, dir));
        assertThrows(IllegalArgumentException.class, () -> simpleAnuncioAuxiliar = new Anuncio(65, 50000, precioGarAux, 150, 14000, null));
    }
}