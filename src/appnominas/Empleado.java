/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnominas;

import java.util.Objects;

/**
 *
 * @author daw2
 */
public abstract class Empleado {

    private String dni;
    private String nombre;

    public Empleado(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;

    }

    public String getDni() {
        return dni;

    }

    public void setDni(String dni) {
        this.dni = dni;

    }

    public String getNombre() {
        return nombre;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Dni: ").append(this.getDni()).append("\n");
        sb.append("Nombre: ").append(this.getNombre()).append("\n");

        return sb.toString();

    }

    public int compareTo(Empleado empleado) {
        return this.getDni().compareTo(empleado.getDni());

    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    public abstract float ingresos();

}
