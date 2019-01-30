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
public class EmpleadoFijo extends Empleado {

    private float salario;

    public EmpleadoFijo(String dni, String nombre, float salario) {
        super(dni, nombre);
        this.salario = salario;

    }

    public float getSalario() {
        return salario;

    }

    public void setSalario(float salario) {
        this.salario = salario;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Salario: ").append(this.getSalario()).append("\n");

        return sb.toString();

    }

    @Override
    public float ingresos() {
        return this.getSalario();

    }

}
