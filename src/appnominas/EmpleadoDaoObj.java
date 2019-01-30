/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnominas;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author israel
 */
public class EmpleadoDaoObj implements EmpleadoDao {

    private Path path;

    public EmpleadoDaoObj(String path) {
        this.path = Paths.get(path);

    }

    @Override
    public List<Empleado> listar() throws DaoException {
        ObjectInputStream fichero = null;
        List<Empleado> lista = new ArrayList<>();
        Empleado empleado;

        try {
            fichero = new ObjectInputStream(Files.newInputStream(path));

            while (true) {
                empleado = (Empleado) fichero.readObject();
                lista.add(empleado);

            }

        } catch (EOFException eofe) {
            System.out.println(eofe.toString());

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.toString());

        } finally {
            try {
                fichero.close();

            } catch (IOException ioe) {
                System.out.println(ioe.toString());

            }

        }

        return lista;

    }

    @Override
    public int insertar(List<Empleado> empleados) throws DaoException {
        ObjectOutputStream fichero = null;

        try {
            fichero = new ObjectOutputStream(Files.newOutputStream(path));
            for (Empleado empleado : empleados) {
                fichero.writeObject(empleado);

            }

        } catch (IOException ioe) {
            throw new DaoException(ioe.toString());

        } finally {
            try {
                fichero.close();

            } catch (IOException ioe) {
                System.out.println(ioe.toString());

            }

        }

        return empleados.size();

    }

}
