package e1;

import java.time.LocalDate;

public class Billete {

    private String origenb;
    private String destinob;
    private double preciob;
    private LocalDate fechab;

    public Billete (String origen, String destino, double precio, String fecha) {
        this.origenb = origen;
        this.destinob = destino;
        this.preciob = precio;
        this.fechab = LocalDate.parse(fecha);

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

    public double getPrecio() {
        return preciob;
    }

    public void setPrecio(double precio) {
        this.preciob = precio;
    }

    public LocalDate getFecha() {
        return fechab;
    }

    public void setFecha(LocalDate fecha) {
        this.fechab = fecha;
    }

}

