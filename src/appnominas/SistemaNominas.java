/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnominas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw2
 */
public class SistemaNominas {

    private List<Empleado> empleados;
    private EmpleadoDao empleadoDao;

    public SistemaNominas() {
        empleados = new ArrayList<>();

    }

    public List<Empleado> getEmpleados() {
        return empleados;

    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;

    }

    public EmpleadoDao getEmpleadoDao() {
        return empleadoDao;

    }

    public void setEmpleadoDao(EmpleadoDao empleadoDao) {
        this.empleadoDao = empleadoDao;

    }

    public boolean incluirEmpleado(Empleado empleado) {
        return true;
    }

    public boolean eliminarEmpleado(String dni) {
        return true;
    }

    public String listarEmpleados() {
        return null;
    }

    public float getTotalSalarios() {
        return 0;
    }

    public int guardarEmpleados() {
        return 0;
    }

    public int cargarEmpleados() {
        return 0;
    }

}
