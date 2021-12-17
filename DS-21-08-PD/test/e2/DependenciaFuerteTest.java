package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DependenciaFuerteTest {
    private List<Tarea> tareaList;

    @BeforeEach
    void setUp() {
        tareaList = new ArrayList<>();
        Tarea tareaD = new Tarea('D', null, false);
        Tarea tareaF = new Tarea('F', null, false);

        List<Tarea> dependeDeA = new ArrayList<>();
        dependeDeA.add(tareaF);
        Tarea tareaA = new Tarea('C', dependeDeA, false);

        List<Tarea> dependeDeG = new ArrayList<>();
        dependeDeG.add(tareaA);
        dependeDeG.add(tareaF);
        Tarea tareaG = new Tarea('G', dependeDeG, false);

        List<Tarea> dependeDeBD = new ArrayList<>();
        dependeDeBD.add(tareaA);
        dependeDeBD.add(tareaD);
        Tarea tareaB = new Tarea('B', dependeDeBD, false);
        Tarea tareaC = new Tarea('C', dependeDeBD, false);

        List<Tarea> dependeDeE = new ArrayList<>();
        dependeDeE.add(tareaD);
        Tarea tareaE = new Tarea('E', dependeDeE, false);

        List<Tarea> dependeDeH = new ArrayList<>();
        dependeDeH.add(tareaG);
        dependeDeH.add(tareaC);
        Tarea tareaH = new Tarea('H', dependeDeH, false);

        List<Tarea> dependeDeI = new ArrayList<>();
        dependeDeI.add(tareaF);
        dependeDeI.add(tareaA);
        Tarea tareaI = new Tarea('I', dependeDeI, false);

        tareaList.add(tareaC);
        tareaList.add(tareaD);
        tareaList.add(tareaG);
        tareaList.add(tareaA);
        tareaList.add(tareaF);
        tareaList.add(tareaI);
        tareaList.add(tareaH);
        tareaList.add(tareaB);
        tareaList.add(tareaE);
    }

    @Test
    void ordena() {
        AlgoritmoOrdenacion dependenciaDebil = new DependenciaDebil();
        ListaTareas gestor = new ListaTareas(tareaList);
        dependenciaDebil.ordena(gestor);

        assertEquals(gestor.getListaTareas().get(0).getNombre(), 'C');
        assertEquals(gestor.getListaTareas().get(1).getNombre(), 'D');
        assertEquals(gestor.getListaTareas().get(2).getNombre(), 'G');
        assertEquals(gestor.getListaTareas().get(3).getNombre(), 'C');
        assertEquals(gestor.getListaTareas().get(4).getNombre(), 'F');
        assertEquals(gestor.getListaTareas().get(5).getNombre(), 'I');
        assertEquals(gestor.getListaTareas().get(6).getNombre(), 'H');
        assertEquals(gestor.getListaTareas().get(7).getNombre(), 'B');
        assertEquals(gestor.getListaTareas().get(8).getNombre(), 'E');
    }
}