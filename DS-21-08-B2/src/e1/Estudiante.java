package e1;

public class Estudiante extends Residente {
    /**
     * Constructor de la clase Estudiante.
     * @param nombre datos del miembro.
     * @param apellido datos del miembro.
     * @param edad datos del miembro.
     * @param horrocruxes numero de horrocruxes destruidos.
     * @param casa a la cual pertenece dicho residente.
     * Los galeones por horrocrux (heredados de Member) dependen de cada clase. Los
     * utilizaremos para calcular la recompensa_anual.
     */

    public Estudiante(String nombre, String apellido, int edad, int horrocruxes, String casa) {
        super(nombre, apellido, edad, horrocruxes, casa);
        setGaleones(90);
        setRecompensa();

//        if (!galeonesValido()) {
//            throw new IllegalArgumentException();
//        }
  }

    @Override
    public String toString() {
        return getNombre() +" "+ getApellido() + " (Estudiante de " + getCasa().toString() + ", " + getHorrocruxes() + " horrocruxes): " + getRecompensa()+ " galeones";
    }
}