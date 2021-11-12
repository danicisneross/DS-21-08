package e1;

public class Fantasma extends Residente {

    public Fantasma(String nombre, String apellido, int edad, int horrocruxes, String casa) {
        super(nombre, apellido, edad, horrocruxes, casa);
        setGaleones(80);
        setRecompensa();

        if (galeonesValido()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return getNombre() +" "+ getApellido() + " (Fantasma de " + getCasa().toString() + ", " + getHorrocruxes() + " horrocruxes): " + getRecompensa() + " galeones";
    }
}
