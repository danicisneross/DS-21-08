package e1;

public class Estudiante extends Residente {

    public Estudiante(String nombre, String apellido, int edad, int horrocruxes, String casa) {
        super(nombre, apellido, edad, horrocruxes, casa);
        setGaleones(90);
        setRecompensa();

        if (galeonesValido()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return getNombre() +" "+ getApellido() + " (Estudiante de " + getCasa().toString() + ", " + getHorrocruxes() + " horrocruxes): " + getRecompensa()+ " galeones";
    }
}
