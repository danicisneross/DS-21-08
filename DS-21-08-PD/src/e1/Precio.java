package e1;

import java.util.List;

public class Precio extends Criterio { //hacer getter y setter

    private double precio;

    public Precio(double precio) {
        this.precio = precio;

        if(precio <= 0){
            throw new IllegalArgumentException();
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    @Override
    public List<Billete> hacerBusqueda(List<Billete> billetesGeneral) {
        var billetesSeleccionadosP = getListaBilletes();

        if (billetesGeneral.size() != 0) {
            for (Billete b : billetesGeneral) {
                if (b.getPrecio() == precio) {
                    billetesSeleccionadosP.add(b);
                }
            }
            setListaBilletes(billetesSeleccionadosP);
        }
        return billetesSeleccionadosP;
    }
}
