package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListaTareasTest {

    private List<Tarea> tareaList;
    private ListaTareas listaTareas;
    private Tarea tarea1;
    private Tarea tarea2;
    private Tarea tarea3;

    @BeforeEach
    void setUp() {
        tareaList = new ArrayList<>();
        tarea1 = new Tarea('A', null, false);
        tarea2 = new Tarea('B', null, false);
        List<Tarea> dependeDe = new ArrayList<>();
        dependeDe.add(tarea1);
        dependeDe.add(tarea2);
        tarea3 = new Tarea('C', dependeDe, false);
        tareaList.add(tarea1);
        tareaList.add(tarea2);
        tareaList.add(tarea3);
        listaTareas = new ListaTareas(tareaList);
    }

    @Test
    void addTarea() {
        List<Tarea> dependeDe = new ArrayList<>();
        dependeDe.add(tarea3);
        listaTareas.addTarea('D', dependeDe, false);

        assertEquals(listaTareas.getListaTareas().get(3).getNombre(), 'D');
        assertEquals(listaTareas.getListaTareas().get(3).getDependeDe().get(0).getNombre(), 'C');
        assertEquals(listaTareas.getListaTareas().get(3).getDependeDe().get(0).getDependeDe().get(0).getNombre(), 'A');
        assertFalse(listaTareas.getListaTareas().get(3).getDependeDe().get(0).isRealizada());
        assertFalse(listaTareas.getListaTareas().get(3).isRealizada());
    }

    @Test
    void removeTarea() {
        assertEquals(listaTareas.getListaTareas().get(1).getNombre(), 'B');
        listaTareas.removeTarea('B');
        assertEquals(listaTareas.getListaTareas().get(1).getNombre(), 'C');
    }
}