package e1;

public class Docente extends Personal {

    /**
     * Enumerado que contiene las asignaturas que imparten los docentes. Cada asignatura es
     * impartida por un unico docente.
     */

    private enum Asignaturas {Historia, Transformaciones, Defensa, Herbologia, Pociones}

    public String materia;

    public boolean materiaValida() {
        return (Docente.Asignaturas.valueOf(this.materia) == Docente.Asignaturas.valueOf(Asignaturas.Historia.toString())
                || Docente.Asignaturas.valueOf(this.materia) == Docente.Asignaturas.valueOf(Asignaturas.Transformaciones.toString())
                || Docente.Asignaturas.valueOf(this.materia) == Docente.Asignaturas.valueOf(Asignaturas.Defensa.toString())
                || Docente.Asignaturas.valueOf(this.materia) == Docente.Asignaturas.valueOf(Asignaturas.Herbologia.toString())
                || Docente.Asignaturas.valueOf(this.materia) == Docente.Asignaturas.valueOf(Asignaturas.Pociones.toString()));
    }

    public Docente(String nombre, String apellido, int edad, int horrocruxes, String materia) {
        super(nombre, apellido, edad, horrocruxes);
        setGaleones(50);
        this.materia = materia;
        setSalario();
        setRecompensa();

        if (!materiaValida() || galeonesValido()) {
            throw new IllegalArgumentException();
        }
    }

    public String getMateria() {
        return Asignaturas.valueOf(materia).toString();
    }

    public void setRecompensa() {
        if (this.getMateria().equals(Asignaturas.Defensa.toString())) {
            float porcentaje = (float) (getHorrocruxes() * getGaleones() * 0.25);
            super.setRecompensa(getHorrocruxes() * getGaleones() - porcentaje);
        } else {
            super.setRecompensa(getHorrocruxes() * getGaleones());
        }
    }
    
    //el salario en los docentes depende de la materia que imparten.
    public void setSalario() {

        switch (getMateria()) {
            case "Historia" -> setSalario_base(200);
            case "Transformaciones" -> setSalario_base(400);
            case "Defensa" -> setSalario_base(500);
            case "Herbologia" -> setSalario_base(250);
            case "Pociones" -> setSalario_base(350);
        }
    }

    @Override
    public String toString() {
        return getNombre() + " " + getApellido() + " (Docente de " + getMateria() + ", " + getHorrocruxes() + " horrocruxes): " + getRecompensa() + " galeones";
    }

    @Override
    public String toStringSalario() {
        return getNombre() + " " + getApellido() + " (Docente de " + getMateria() + "): " + getSalario() + " galeones";
    }
}
