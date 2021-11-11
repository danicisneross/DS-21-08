package e1;

import java.util.ArrayList;
import java.util.List;


public class Colegio {

    private final List<Residente> listaResidentes = new ArrayList<>();
    private final List<Personal> listaPersonal = new ArrayList<>();

    public void addResidente(Residente r) {
        this.listaResidentes.add(r);
    }

    public void addPersonal(Personal p) {
        this.listaPersonal.add(p);
    }

    public String imprimirRecompensa() {
        StringBuilder tablaRecompensas = new StringBuilder();
        float recompensa_total = 0;

        for (Residente r : listaResidentes) {
            tablaRecompensas.append(r.toString()).append("\n");
            recompensa_total += r.getRecompensa();
        }

        for (Personal p : listaPersonal) {
            tablaRecompensas.append(p.toString()).append("\n");
            recompensa_total += p.getRecompensa();
        }

        tablaRecompensas.append("La recompensa total del Colegio Hogwarts es de ").append(recompensa_total).append(" galeones");
        return tablaRecompensas.toString();
    }

    public String imprimirSalarios() {
        StringBuilder tablaSalarios = new StringBuilder();
        float gasto_total = 0;

        for (Personal p : listaPersonal) {
            tablaSalarios.append(p.toStringSalario()).append("\n");
            gasto_total += p.getSalario();
        }

        tablaSalarios.append("El gasto de Hogwarts en personal es de ").append(gasto_total).append(" galeones");
        return tablaSalarios.toString();
    }
}