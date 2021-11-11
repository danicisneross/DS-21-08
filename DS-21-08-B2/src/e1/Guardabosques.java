package e1;

public class Guardabosques extends Personal {

    /**
     * Constructor de la clase Guardabosques.
     *
     * @param nombre      datos del miembro.
     * @param apellido    datos del miembro.
     * @param edad        datos del miembro.
     * @param horrocruxes numero de horrocruxes destruidos.
     *                    Los galeones por horrocrux (heredados de Member) dependen de cada clase. Los
     *                    utilizaremos para calcular la recompensa_anual.
     *                    Tenemos el salario_base y la compensacion por nocturnidad inicializadas
     *                    que heredamos de Personal utilizadas para calcular el salario.
     */

    public Guardabosques(String nombre, String apellido, int edad, int horrocruxes) {
        super(nombre, apellido, edad, horrocruxes);
        setGaleones(75);
        setSalario_base(170f);
        setComp_nocturnidad(10);
        setRecompensa(getHorrocruxes() * getGaleones() );

//        if (!galeonesValido()) {
//            throw new IllegalArgumentException();
//        }
    }

    @Override
    public String toString() {
        return getNombre() + " " + getApellido() + " (Guardabosques, " + getHorrocruxes() + " horrocruxes): " + getRecompensa() + " galeones";
    }

    @Override
    public String toStringSalario() {

        return getNombre() + " " + getApellido() + " (Guardabosques): " + getSalario() + " galeones";
    }
}