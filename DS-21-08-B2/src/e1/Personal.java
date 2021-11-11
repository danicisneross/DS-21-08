package e1;

abstract class Personal extends Member {
    private int comp_nocturnidad;
    private float salario_base;

    /**
     * Constructor de la clase Personal.
     * @param nombre datos del miembro.
     * @param apellido datos del miembro.
     * @param edad datos del miembro.
     * @param horrocruxes numero de horrocruxes destruidos.
     */

    public Personal(String nombre, String apellido, int edad, int horrocruxes) {
        super(nombre, apellido, edad, horrocruxes);
    }

    public void setComp_nocturnidad(int comp_nocturnidad) {
        this.comp_nocturnidad = comp_nocturnidad;
    }

    public float getSalario() {
        return salario_base + comp_nocturnidad;
    }

    public void setSalario_base(float salario_base) {
        this.salario_base = salario_base;

        if(salario_baseValido()) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * El personal que trabaja en Hogwarts cobra un salario dependiendo de que
     * funcion desempeña; aquellos que trabajan de noche tendran una compensacion por
     * nocturnidad.
     * @return salario.
     */

    public boolean salario_baseValido() {
        return salario_base <= 0;
    }

    public String toStringSalario() {
        return "";
    }
}