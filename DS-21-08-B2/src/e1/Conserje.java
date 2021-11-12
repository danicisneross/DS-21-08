package e1;

public class Conserje extends Personal {

    /**
     * Constructor de la clase Conserje.
     * @param nombre datos del miembro.
     * @param apellido datos del miembro.
     * @param edad datos del miembro.
     * @param horrocruxes numero de horrocruxes destruidos.
     * Los galeones por horrocrux (heredados de Member) dependen de cada clase. Los utilizaremos
     * para calcular la recompensa_anual.
     * Tenemos el salario_base y la compensacion por nocturnidad inicializadas
     * que heredamos de Personal utilizadas para calcular el salario.
     */

    public Conserje(String nombre, String apellido, int edad, int horrocruxes) {
        super(nombre, apellido, edad, horrocruxes);
        setGaleones(65);
        setSalario_base(150f);
        setComp_nocturnidad(10);
        setRecompensa(getHorrocruxes() * getGaleones());

        if (galeonesValido()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return getNombre() + " " + getApellido() + " (Conserje, " + getHorrocruxes() + " horrocruxes): " + getRecompensa() + " galeones";
    }

    @Override
    public String toStringSalario() {
        return getNombre() + " " + getApellido() + " (Conserje): " + getSalario() + " galeones";
    }
}
