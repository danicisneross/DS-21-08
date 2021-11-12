package e1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    Estudiante miembro1 = new Estudiante("Hermione","Granger",16,3,"Gryffindor");
    Fantasma miembro2 = new Fantasma("Baron","Sanguinario",45,1,"Slytherin");
    Docente miembro3 = new Docente("Minerva","McGonagall",40,1,"Transformaciones");
    Guardabosques miembro4 = new Guardabosques("Rubeus","Hagrid",60,2);
    Docente miembro5 = new Docente("Severus","Snape",48,2, "Defensa");
    Conserje miembro6 = new Conserje("Argus","Flich",62,0);
    Docente miembro7 = new Docente("Pomona","Sprout",55,1, "Herbologia");
    Docente miembro8 = new Docente("Horacle","Flaccus",52,2, "Pociones");
    Docente miembro9 = new Docente("Cuthbert","Binns",80,1, "Historia");

    @Test
    void TestBasic() {

        //Revisamos que introduce bien los datos
        assertEquals("Hermione", miembro1.getNombre());
        assertEquals("Granger", miembro1.getApellido());
        assertEquals("Gryffindor", miembro1.getCasa().toString());
        assertEquals(16, miembro1.getEdad());
        assertEquals(3, miembro1.getHorrocruxes());

        assertEquals("Minerva", miembro3.getNombre());
        assertEquals("McGonagall", miembro3.getApellido());
        assertEquals("Transformaciones", miembro3.getMateria());
        assertEquals(40, miembro3.getEdad());
        assertEquals(1, miembro3.getHorrocruxes());

        assertEquals("Rubeus", miembro4.getNombre());
        assertEquals("Hagrid", miembro4.getApellido());
        assertEquals(60, miembro4.getEdad());
        assertEquals(2, miembro4.getHorrocruxes());


        assertEquals("Argus", miembro6.getNombre());
        assertEquals("Flich", miembro6.getApellido());
        assertEquals(62, miembro6.getEdad());
        assertEquals(0, miembro6.getHorrocruxes());

        //Exepciones
        assertThrows(IllegalArgumentException.class, () -> new Estudiante("Luna","Lovegood",0,2,"Ravenclaw"));
        assertThrows(IllegalArgumentException.class, () -> new Estudiante("Luna","Lovegood",-12,2,"Hufflepuff"));
        assertThrows(IllegalArgumentException.class, () -> new Estudiante("Draco","Malfoy",17,-3,"Slytherin"));
        assertThrows(IllegalArgumentException.class, () -> new Estudiante("Draco","Malfoy",17,2,"Rock"));
        assertThrows(IllegalArgumentException.class, () -> new Docente("Pomona","Sprout",55,10, "Arte"));
    }

    @Test
    void getRecompensa() {

        //Revisamos que esta devolviendo bien las recompensas
        assertEquals(270f, miembro1.getRecompensa());
        assertEquals(160f, miembro2.getRecompensa());
        assertEquals(50f, miembro3.getRecompensa());
        assertEquals(150f, miembro4.getRecompensa());
        assertEquals(75f, miembro5.getRecompensa());
        assertEquals(0f, miembro6.getRecompensa());
        assertEquals(50f, miembro7.getRecompensa());
        assertEquals(100f, miembro8.getRecompensa());
        assertEquals(50f, miembro9.getRecompensa());

        //Exepciones
        assertThrows(IllegalArgumentException.class, () -> new Estudiante("Luna","Lovegood",15,-1,"Ravenclaw"));
        assertThrows(IllegalArgumentException.class, () -> miembro1.setGaleones(-20));
    }

    @Test
    void salario() {

        //Revisamos que esta devolviendo bien los salarios
        assertEquals(400f, miembro3.getSalario());
        assertEquals(180f, miembro4.getSalario());
        assertEquals(500f, miembro5.getSalario());
        assertEquals(160f, miembro6.getSalario());
        assertEquals(250f, miembro7.getSalario());
        assertEquals(350f, miembro8.getSalario());
        assertEquals(200f, miembro9.getSalario());

        assertEquals("Minerva McGonagall (Docente de Transformaciones): 400.0 galeones", miembro3.toStringSalario());
        assertEquals("Rubeus Hagrid (Guardabosques): 180.0 galeones", miembro4.toStringSalario());
        assertEquals("Severus Snape (Docente de Defensa): 500.0 galeones", miembro5.toStringSalario());
        assertEquals("Argus Flich (Conserje): 160.0 galeones", miembro6.toStringSalario());
        assertEquals("Pomona Sprout (Docente de Herbologia): 250.0 galeones", miembro7.toStringSalario());
        assertEquals("Horacle Flaccus (Docente de Pociones): 350.0 galeones", miembro8.toStringSalario());
        assertEquals("Cuthbert Binns (Docente de Historia): 200.0 galeones", miembro9.toStringSalario());

        //Exepciones
        assertThrows(IllegalArgumentException.class, () -> miembro3.setSalario_base(-20));
        assertThrows(IllegalArgumentException.class, () -> miembro4.setSalario_base(0));
    }

    @Test
    void ColegioTest() {
        Colegio colegio = new Colegio();

        assertEquals("Hermione Granger (Estudiante de Gryffindor, 3 horrocruxes): 270.0 galeones", miembro1.toString());
        assertEquals("Baron Sanguinario (Fantasma de Slytherin, 1 horrocruxes): 160.0 galeones", miembro2.toString());
        assertEquals("Minerva McGonagall (Docente de Transformaciones, 1 horrocruxes): 50.0 galeones", miembro3.toString());
        assertEquals("Rubeus Hagrid (Guardabosques, 2 horrocruxes): 150.0 galeones", miembro4.toString());
        assertEquals("Severus Snape (Docente de Defensa, 2 horrocruxes): 75.0 galeones", miembro5.toString());
        assertEquals("Argus Flich (Conserje, 0 horrocruxes): 0.0 galeones", miembro6.toString());
        assertEquals("Pomona Sprout (Docente de Herbologia, 1 horrocruxes): 50.0 galeones", miembro7.toString());
        assertEquals("Horacle Flaccus (Docente de Pociones, 2 horrocruxes): 100.0 galeones", miembro8.toString());
        assertEquals("Cuthbert Binns (Docente de Historia, 1 horrocruxes): 50.0 galeones", miembro9.toString());

        colegio.addResidente(miembro1);
        colegio.addResidente(miembro2);
        colegio.addPersonal(miembro3);
        colegio.addPersonal(miembro4);
        colegio.addPersonal(miembro5);
        colegio.addPersonal(miembro6);
        colegio.addPersonal(miembro7);
        assertEquals("""
                Hermione Granger (Estudiante de Gryffindor, 3 horrocruxes): 270.0 galeones
                Baron Sanguinario (Fantasma de Slytherin, 1 horrocruxes): 160.0 galeones
                Minerva McGonagall (Docente de Transformaciones, 1 horrocruxes): 50.0 galeones
                Rubeus Hagrid (Guardabosques, 2 horrocruxes): 150.0 galeones
                Severus Snape (Docente de Defensa, 2 horrocruxes): 75.0 galeones
                Argus Flich (Conserje, 0 horrocruxes): 0.0 galeones
                Pomona Sprout (Docente de Herbologia, 1 horrocruxes): 50.0 galeones
                La recompensa total del Colegio Hogwarts es de 755.0 galeones""", colegio.imprimirRecompensa());

        assertEquals("""
                Minerva McGonagall (Docente de Transformaciones): 400.0 galeones
                Rubeus Hagrid (Guardabosques): 180.0 galeones
                Severus Snape (Docente de Defensa): 500.0 galeones
                Argus Flich (Conserje): 160.0 galeones
                Pomona Sprout (Docente de Herbologia): 250.0 galeones
                El gasto de Hogwarts en personal es de 1490.0 galeones""", colegio.imprimirSalarios());
    }
}