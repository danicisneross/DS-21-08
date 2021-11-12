package e1;

/**
 * Member: clase abstracta que contiene las caracteristicas comunes
 * de todos los miembros pertenecientes a Hogwarts.
 */

public abstract class Member {
    private final String nombre;
    private final String apellido;
    private final int edad, horrocruxes;
    private float recompensa, galeones;

    public Member(String nombre, String apellido, int edad, int horrocruxes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.horrocruxes = horrocruxes;

        if(!(this.edadValidada() && this.horrocruxValido())) {
            throw new IllegalArgumentException();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public int getHorrocruxes() {
        return horrocruxes;
    }

    public boolean edadValidada() {
        return getEdad() > 0;
    }

    public boolean horrocruxValido() {
        return getHorrocruxes() >= 0;
    }

    public float getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(float recompensa) {
        this.recompensa =  recompensa;
    }

    public void setGaleones(float galeones) {
        this.galeones = galeones;

        if(galeonesValido()) {
            throw new IllegalArgumentException();
        }
    }

    public float getGaleones() {
        return galeones;
    }

    public boolean galeonesValido() {
        return !(getGaleones() > 0);
    }
}