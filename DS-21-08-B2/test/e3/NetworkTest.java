package e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NetworkTest {

    private Network network;
    private Network network2;

    @BeforeEach
    void setUp() {
        network = new Network(new NetworkMap());
        network2 = new Network(new NetworkTable());
        List<TopicOfInterest> topicListAux = new ArrayList<>();
        List<TopicOfInterest> topicListAux2 = new ArrayList<>();
        List<TopicOfInterest> topicListAux3 = new ArrayList<>();
        List<TopicOfInterest> topicListAux4 = new ArrayList<>();
        topicListAux.add(TopicOfInterest.Trading);
        topicListAux.add(TopicOfInterest.Videojuegos);
        topicListAux2.add(TopicOfInterest.Moda);
        topicListAux2.add(TopicOfInterest.Programacion);
        topicListAux2.add(TopicOfInterest.Videojuegos);
        topicListAux3.add(TopicOfInterest.Series);
        topicListAux4.add(TopicOfInterest.Deporte);
        topicListAux4.add(TopicOfInterest.Moda);

        network.altaUsuario("Juanito19",topicListAux);
        network.altaUsuario("Joselito22", topicListAux2);

        network2.altaUsuario("Andresito12", topicListAux3);
        network2.altaUsuario("Antoncito33", topicListAux4);
    }

    @Test
    void altaUsuario() {
        network = new Network(new NetworkMap());
        network2 = new Network(new NetworkTable());
        List<TopicOfInterest> topicListAux = new ArrayList<>();
        List<TopicOfInterest> topicListAux2 = new ArrayList<>();
        topicListAux.add(TopicOfInterest.Moda);
        topicListAux.add(TopicOfInterest.Series);
        topicListAux.add(TopicOfInterest.Peliculas);
        topicListAux.add(TopicOfInterest.Musica);

        assertFalse(network.devolverUsuarios().contains("lala"));
        assertFalse(network2.devolverUsuarios().contains("lolo"));

        network.altaUsuario("lala", topicListAux);
        network2.altaUsuario("lolo", topicListAux2);

        assertTrue(network.devolverUsuarios().contains("lala"));
        assertEquals(network.devolverInteresesUsuario("lala"), topicListAux);
        assertTrue(network2.devolverUsuarios().contains("lolo"));
        assertEquals(network2.devolverInteresesUsuario("lolo"), topicListAux2);
    }

    @Test
    void bajaUsuario() {
        assertTrue(network.devolverUsuarios().contains("Joselito22"));
        assertTrue(network2.devolverUsuarios().contains("Antoncito33"));

        network.bajaUsuario("Joselito22");
        network2.bajaUsuario("Antoncito33");

        assertFalse(network.devolverUsuarios().contains("Joselito22"));
        assertFalse(network2.devolverUsuarios().contains("Antoncito33"));
    }

    @Test
    void altaInteres() {
        assertFalse(network.devolverIntereses().contains(TopicOfInterest.Deporte));
        assertFalse(network2.devolverIntereses().contains(TopicOfInterest.Trading));

        network.altaInteres("Juanito19", TopicOfInterest.Deporte);
        network2.altaInteres("Antoncito33", TopicOfInterest.Trading);

        assertTrue(network.devolverIntereses().contains(TopicOfInterest.Deporte));
        assertTrue(network2.devolverIntereses().contains(TopicOfInterest.Trading));
    }

    @Test
    void bajaInteres() {
        assertTrue(network.devolverIntereses().contains(TopicOfInterest.Trading));
        assertTrue(network2.devolverIntereses().contains(TopicOfInterest.Moda));

        network.bajaInteres("Juanito19", TopicOfInterest.Trading);
        network2.bajaInteres("Antoncito33", TopicOfInterest.Moda);

        assertFalse(network.devolverIntereses().contains(TopicOfInterest.Trading));
        assertFalse(network2.devolverIntereses().contains(TopicOfInterest.Moda));
    }

    @Test
    void devolverUsuarios() {
        List<String> userListAux = new ArrayList<>();
        List<String> userListAux2 = new ArrayList<>();
        userListAux.add("Juanito19");
        userListAux.add("Joselito22");
        userListAux2.add("Andresito12");
        userListAux2.add("Antoncito33");

        assertEquals(network.devolverUsuarios(), userListAux);
        assertEquals(network2.devolverUsuarios(), userListAux2);
    }

    @Test
    void devolverIntereses() {
        List<TopicOfInterest> topicListAux = new ArrayList<>();
        List<TopicOfInterest> topicListAux2 = new ArrayList<>();
        topicListAux.add(TopicOfInterest.Trading);
        topicListAux.add(TopicOfInterest.Videojuegos);
        topicListAux.add(TopicOfInterest.Moda);
        topicListAux.add(TopicOfInterest.Programacion);
        topicListAux2.add(TopicOfInterest.Series);
        topicListAux2.add(TopicOfInterest.Deporte);
        topicListAux2.add(TopicOfInterest.Moda);

        assertEquals(network.devolverIntereses(), topicListAux);
        assertEquals(network2.devolverIntereses(), topicListAux2);//fallo null
    }

    @Test
    void devolverInteresesUsuario() {
        List<TopicOfInterest> topicListAux = new ArrayList<>();
        List<TopicOfInterest> topicListAux2 = new ArrayList<>();
        topicListAux.add(TopicOfInterest.Trading);
        topicListAux.add(TopicOfInterest.Videojuegos);
        topicListAux2.add(TopicOfInterest.Series);

        assertEquals(network.devolverInteresesUsuario("Juanito19"), topicListAux);
        assertEquals(network2.devolverInteresesUsuario("Andresito12"), topicListAux2);
    }
}