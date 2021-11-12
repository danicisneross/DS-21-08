package e1;

public class Conserje extends Personal {

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
