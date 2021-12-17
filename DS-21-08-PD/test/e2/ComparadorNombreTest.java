package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

    class ComparadorNombreTest {

        @Test
        void compare() {
            ComparadorNombre comparadorNombre = new ComparadorNombre();
            Tarea tarea1 = new Tarea('A', null, false);
            Tarea tarea2 = new Tarea('B', null, false);

            assertTrue(comparadorNombre.compare(tarea1, tarea2) < 0);
            assertTrue(comparadorNombre.compare(tarea2, tarea1) > 0);
        }
    }
