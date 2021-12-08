package e1;

public class Billete {
    private String origen;
    private String destino;
    private float precio;
    private int fecha;

    public Billete (String origen, String destino, float precio, int fecha) {
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.fecha = fecha;

        if (precio <= 0 || fecha <= 0)
            throw new IllegalArgumentException();
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }
}

