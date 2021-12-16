package e1;

import java.time.LocalDate;

public class Billete {

    private String origenb;
    private String destinob;
    private float preciob;
    private LocalDate fechab;

    public Billete (String origen, String destino, float precio, LocalDate fecha) {
        this.origenb = origen;
        this.destinob = destino;
        this.preciob = precio;
        this.fechab = fecha;

        if (precio <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public String getOrigen() {
        return origenb;
    }

    public void setOrigen(String origen) {
        this.origenb = origen;
    }

    public String getDestino() {
        return destinob;
    }

    public void setDestino(String destino) {
        this.destinob = destino;
    }

    public float getPrecio() {
        return preciob;
    }

    public void setPrecio(float precio) {
        this.preciob = precio;
    }

    public LocalDate getFecha() {
        return fechab;
    }

    public void setFecha(LocalDate fecha) {
        this.fechab = fecha;
    }

}

