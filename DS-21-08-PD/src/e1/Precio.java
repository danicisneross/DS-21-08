package e1;

import java.util.List;

public class Precio extends Criterios { //hacer getter y setter

    private float precio;

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Precio(float precio, List<Precio> listaPrecios) {
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
