package e1;

import java.util.ArrayList;
import java.util.List;


public class Gestion {
    private List<Billete> listabilletes = new ArrayList<>();// = new ArrayList<>();
    //public List<Billete> billetesseleccionados;// = new ArrayList<>();

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

    IteradorLista iteradorLista = new IteradorLista(listabilletes,0);

    public void addBillete (String origen, String destino, float precio, int fecha) {
        Billete billete = new Billete(origen, destino, precio, fecha);
        listabilletes.add(billete);
    }

    public Gestion hacerbusqueda(String origen1, String origen2, Logica puertaO, String destino1, String destino2,
                                 Logica puertaD, float precio1, float precio2, Logica puertaP, int fecha1, int fecha2,
                                 Logica puertaF) {
        Gestion busqueda = new Gestion(origen1, origen2, puertaO, destino1, destino2, puertaD, precio1, precio2, puertaP,
                fecha1, fecha2, puertaF);
        return busqueda;
    }

    public List<Billete> resultadoBusqueda (Gestion busqueda) {
        List<Billete> billetesSeleccionados = new ArrayList<>();
        int index = 0;
        if (busqueda.puertaO == null) {
            while (iteradorLista.hasNext()) {
                if (busqueda.origen1 == listabilletes.get(index).getOrigen())
                    billetesSeleccionados.add(listabilletes.get(index));
            }
        }
        return billetesSeleccionados;
    }


/*
    public List<Billete> busquedaOrigen(Logica puerta, String origen1, String origen2) {
        if(puerta == null) {
            while (iteradorLista.hasNext()) {
                if ()
            }
        } else if(puerta == Logica.OR) {

        } else return null;
        return billetesseleccionados;
    }

    public List<Billete> busquedaDestino(Logica puerta, String destino1, String destino2) {
        if(puerta == null) {
            while (iteradorLista.hasNext()) {
                if ()
            }
        } else if(puerta == Logica.OR) {

        } else return null;
        return billetesseleccionados;
    }

    public List<Billete> busquedaPrecio(Logica puerta, float precio1, float precio2) {
        if(puerta == null) {
            while (iteradorLista.hasNext()) {
                if ()
            }
        } else if(puerta == Logica.AND) {

        } else if(puerta == Logica.OR) {

        }
        return billetesseleccionados;
    }

    public List<Billete> busquedaFecha(Logica puerta, int fecha1, int fecha2) {
        if(puerta == null) {
            while (iteradorLista.hasNext()) {
                if ()
            }
        } else if(puerta == Logica.AND) {

        } else if(puerta == Logica.OR) {

        }
        return billetesseleccionados;
    }

 */
}


