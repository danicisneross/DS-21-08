package e1;

public class Fantasma extends Residente {

    /**
     * Constructor de la clase Fantasma.
     * @param nombre datos del miembro.
     * @param apellido datos del miembro.
     * @param edad datos del miembro.
     * @param horrocruxes numero de horrocruxes destruidos.
     * @param casa a la cual pertenece dicho residente.
     * Los galeones por horrocrux (heredados de Member) dependen de cada clase. Los
     * utilizaremos para calcular la recompensa_anual.
     */

    public Fantasma(String nombre, String apellido, int edad, int horrocruxes, String casa) {
        super(nombre, apellido, edad, horrocruxes, casa);
        setGaleones(80);
        setRecompensa();

        if (!galeonesValido()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {

        return getNombre() +" "+ getApellido() + " (Fantasma de " + getCasa().toString() + ", " + getHorrocruxes() + " horrocruxes): " + getRecompensa() + " galeones";
    }
}
