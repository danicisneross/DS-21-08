package e1;

abstract class Residente extends Member {

    /**
     * Enumerado que contiene las 4 casas posibles a las que pueden pertenecer
     * los estudiantes o fantasmas.
     */

    public enum Casa {Gryffindor, Hufflepuff, Ravenclaw, Slytherin}

    private final String casa;

    public boolean casaValida() {
    return (Casa.valueOf(this.casa) == Casa.valueOf(Casa.Gryffindor.toString())
            || Casa.valueOf(this.casa) == Casa.valueOf(Casa.Hufflepuff.toString())
            || Casa.valueOf(this.casa) == Casa.valueOf(Casa.Ravenclaw.toString())
            || Casa.valueOf(this.casa) == Casa.valueOf(Casa.Slytherin.toString()));
    }

    public Residente(String nombre, String apellido, int edad, int horrocruxes, String casa) {
        super(nombre, apellido, edad, horrocruxes);
        this.casa = casa;

        if(!casaValida()) {
            throw new IllegalArgumentException();
        }
    }

    public Casa getCasa() {
        return Casa.valueOf(casa);
    }

    public void setRecompensa() {
        if (this.getCasa().equals(Casa.Slytherin)) {
            super.setRecompensa( getHorrocruxes() * getGaleones() * 2 );
        } else {
            super.setRecompensa(getHorrocruxes() * getGaleones());
        }
    }
}
