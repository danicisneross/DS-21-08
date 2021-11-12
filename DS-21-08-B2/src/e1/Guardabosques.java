package e1;

public class Guardabosques extends Personal {

    public Guardabosques(String nombre, String apellido, int edad, int horrocruxes) {
        super(nombre, apellido, edad, horrocruxes);
        setGaleones(75);
        setSalario_base(170f);
        setComp_nocturnidad(10);
        setRecompensa(getHorrocruxes() * getGaleones() );

        if (galeonesValido()) {
            throw new IllegalArgumentException();
        }
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
