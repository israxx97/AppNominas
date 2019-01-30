/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnominas;

/**
 *
 * @author daw2
 */
public class EmpleadoEventual extends Empleado {

    private float salarioHora;
    private int horas;

    public EmpleadoEventual(String dni, String nombre, float salarioHora, int horas) {
        super(dni, nombre);
        this.salarioHora = salarioHora;
        this.horas = horas;

    }

    public float getSalarioHora() {
        return salarioHora;

    }

    public void setSalarioHora(float salarioHora) {
        this.salarioHora = salarioHora;

    }

    public int getHoras() {
        return horas;

    }

    public void setHoras(int horas) {
        this.horas = horas;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Salario hora: ").append(this.getSalarioHora()).append("€").append("\n");
        sb.append("Horas: ").append(this.getHoras()).append("h").append("\n");

        return sb.toString();

    }

    @Override
    public float ingresos() {
        return this.getSalarioHora() * this.getHoras();

    }

}
