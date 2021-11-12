package e1;

abstract class Personal extends Member {
    private int comp_nocturnidad;
    private float salario_base;

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

    public boolean salario_baseValido() {
        return salario_base <= 0;
    }

    public String toStringSalario() {
        return "";
    }
}
