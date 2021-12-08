package e1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Gestion {
    private List<Billete> listabilletes = new ArrayList<>();

    private final String origen1;
    private final String origen2;
    private final Logica puertaO;
    private final String destino1;
    private final String destino2;
    private final Logica puertaD;
    private final float precio1;
    private final float precio2;
    private final Logica puertaP;
    private final int fecha1;
    private final int fecha2;
    private final Logica puertaF;
    private int index = 0;

    public Gestion(String origen1, String origen2, Logica puertaO, String destino1, String destino2,
                   Logica puertaD, float precio1, float precio2, Logica puertaP, int fecha1, int fecha2,
                   Logica puertaF) {
        if (precio1 <= 0 || precio2 <= 0 || fecha1 <= 0 || fecha2 <= 0)
            throw new IllegalArgumentException();
        //this.listabilletes = new ArrayList<>();
        this.origen1 = origen1;
        this.origen2 = origen2;
        this.puertaO = puertaO;
        this.destino1 = destino1;
        this.destino2 = destino2;
        this.puertaD = puertaD;
        this.precio1 = precio1;
        this.precio2 = precio2;
        this.puertaP = puertaP;
        this.fecha1 = fecha1;
        this.fecha2 = fecha2;
        this.puertaF = puertaF;
    }

    public void addBillete (String origen, String destino, float precio, int fecha) {
        Billete billete = new Billete(origen, destino, precio, fecha);
        listabilletes.add(billete);
    }

    IteradorLista iteradorLista = new IteradorLista(listabilletes,0);

    public Gestion hacerbusqueda(String origen1, String origen2, Logica puertaO, String destino1, String destino2,
                                 Logica puertaD, float precio1, float precio2, Logica puertaP, int fecha1, int fecha2,
                                 Logica puertaF) {
        return new Gestion(origen1, origen2, puertaO, destino1, destino2, puertaD, precio1, precio2, puertaP,
                fecha1, fecha2, puertaF);
    }

    public List<Billete> resultadoBusqOrigen (Gestion busqueda) {
        List<Billete> billetesSeleccionados = new ArrayList<>();
        int index = 0;
        if (busqueda.puertaO == null) {
            while (iteradorLista.hasNext()) {
                if (Objects.equals(busqueda.origen1, listabilletes.get(index).getOrigen()))
                    billetesSeleccionados.add(listabilletes.get(index));
                iteradorLista.next();
            }
        } else if (busqueda.puertaO == Logica.OR) {
            while (iteradorLista.hasNext()) {
                if (Objects.equals(busqueda.origen1, listabilletes.get(index).getOrigen()) ||
                        Objects.equals(busqueda.origen2, listabilletes.get(index).getOrigen()))
                    billetesSeleccionados.add(listabilletes.get(index));
                iteradorLista.next();
            }
        } else if (busqueda.puertaO == Logica.AND || busqueda.puertaD == Logica.AND || busqueda.puertaP == Logica.AND
                || busqueda.puertaF == Logica.AND)
            return null;
        return billetesSeleccionados;
    }

    public List<Billete> resultadoBusqDestino (Gestion busqueda, List<Billete> billetesOrigen) {
        List<Billete> billetesSeleccionados = new ArrayList<>();
        int index = 0;
        IteradorLista iteradorLista1 = new IteradorLista(billetesOrigen, index);
        if (busqueda.puertaD == null) {
            while (iteradorLista1.hasNext()) {
                if (Objects.equals(busqueda.destino1, billetesOrigen.get(index).getDestino()))
                    billetesSeleccionados.add(billetesOrigen.get(index));
                iteradorLista1.next();
            }
        } else if (busqueda.puertaD == Logica.OR) {
            while (iteradorLista1.hasNext()) {
                if (Objects.equals(busqueda.destino1, billetesOrigen.get(index).getDestino()) ||
                        Objects.equals(busqueda.destino2, billetesOrigen.get(index).getDestino()))
                    billetesSeleccionados.add(billetesOrigen.get(index));
                iteradorLista1.next();
            }
        }
        return billetesSeleccionados;
    }

    public List<Billete> resultadoBusqPrecio (Gestion busqueda, List<Billete> billetesOrigenyDestino) {
        List<Billete> billetesSeleccionados = new ArrayList<>();
        int index = 0;
        IteradorLista iteradorLista2 = new IteradorLista(billetesOrigenyDestino, index);
        if (busqueda.puertaP == null) {
            while (iteradorLista2.hasNext()) {
                if (Objects.equals(busqueda.precio1, billetesOrigenyDestino.get(index).getPrecio()))
                    billetesSeleccionados.add(billetesOrigenyDestino.get(index));
                iteradorLista2.next();
            }
        } else if (busqueda.puertaP == Logica.OR) {
            while (iteradorLista2.hasNext()) {
                if (Objects.equals(busqueda.precio1, billetesOrigenyDestino.get(index).getPrecio()) ||
                        Objects.equals(busqueda.precio2, billetesOrigenyDestino.get(index).getPrecio()))
                    billetesSeleccionados.add(billetesOrigenyDestino.get(index));
                iteradorLista2.next();
            }
        }
        return billetesSeleccionados;
    }

    public List<Billete> resultadoBusqFecha (Gestion busqueda, List<Billete> billetesOrigenyDestinoyPrecio) {
        List<Billete> billetesSeleccionados = new ArrayList<>();
        int index = 0;
        IteradorLista iteradorLista3 = new IteradorLista(billetesOrigenyDestinoyPrecio, index);
        if (busqueda.puertaF == null) {
            while (iteradorLista3.hasNext()) {
                if (Objects.equals(busqueda.fecha1, billetesOrigenyDestinoyPrecio.get(index).getFecha()))
                    billetesSeleccionados.add(billetesOrigenyDestinoyPrecio.get(index));
                iteradorLista3.next();
            }
        } else if (busqueda.puertaF == Logica.OR) {
            while (iteradorLista3.hasNext()) {
                if (Objects.equals(busqueda.fecha1, billetesOrigenyDestinoyPrecio.get(index).getFecha()) ||
                        Objects.equals(busqueda.fecha2, billetesOrigenyDestinoyPrecio.get(index).getFecha()))
                    billetesSeleccionados.add(billetesOrigenyDestinoyPrecio.get(index));
                iteradorLista3.next();
            }
        }
        return billetesSeleccionados;
    }
}