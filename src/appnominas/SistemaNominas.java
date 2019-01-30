/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnominas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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
        boolean incluido = false;

        if (!empleados.contains(empleado)) {
            incluido = true;
            empleados.add(empleado);

        }

        return incluido;

    }

    public boolean eliminarEmpleado(String dni) {
        boolean eliminado = false;
        int posicion = -1;

        for (int i = 0; i < empleados.size() && posicion == -1; i++) {
            if (empleados.get(i).getDni().equals(dni)) {
                posicion = i;

            }

        }

        if (posicion != -1) {
            eliminado = true;
            empleados.remove(posicion);

        }

        return eliminado;

    }

    public String listarEmpleados() {
        StringBuilder sb = new StringBuilder();
        ListIterator<Empleado> li = empleados.listIterator();

        while (li.hasNext()) {
            sb.append(li.next());

        }

        return sb.toString();

    }

    public float getTotalSalarios() {
        float acumulador = 0;

        for (Empleado empleado : empleados) {
            acumulador += empleado.ingresos();

        }

        return acumulador;

    }

    public int guardarEmpleados() throws DaoException {
        int n = 0;

        if (empleadoDao != null) {
            n = empleadoDao.insertar(empleados);

        }

        return n;

    }

    public int cargarEmpleados() throws DaoException {
        int n = 0;

        if (empleadoDao != null) {
            empleados = empleadoDao.listar();
            n = empleados.size();

        }

        return n;

    }

}
