package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TareaTest {

    private Tarea tarea;
    private Tarea tareaAux;

    @BeforeEach
    void setUp() {
        Tarea tareaAux = new Tarea('G', null, false);
        List<Tarea> dependeDe = new ArrayList<>();
        dependeDe.add(tareaAux);
        tarea = new Tarea('H', dependeDe, false);
    }

    @Test
    void testBasic() {
        Tarea tareaAux = new Tarea('G', null, false);
        List<Tarea> dependeDeAux = new ArrayList<>();
        dependeDeAux.add(tareaAux);
        assertEquals(tarea.getNombre(), 'H');
        assertEquals(tarea.getDependeDe().get(0).getNombre(), dependeDeAux.get(0).getNombre());
        assertNull(tarea.getDependeDe().get(0).getDependeDe());
        assertFalse(tarea.getDependeDe().get(0).isRealizada());
        assertFalse(tarea.isRealizada());
    }

    @Test
    void testExections() {
        assertThrows(IllegalArgumentException.class, () -> tareaAux = new Tarea('a', null, false));
        assertThrows(IllegalArgumentException.class, () -> tareaAux = new Tarea('A', null, true));
    }
}