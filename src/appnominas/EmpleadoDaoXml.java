/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnominas;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.nio.file.*;
import java.util.*;

/**
 *
 * @author israel
 */
public class EmpleadoDaoXml implements EmpleadoDao {

    private Path path;

    public EmpleadoDaoXml(String path) {
        this.path = Paths.get(path);

    }

    @Override
    public List<Empleado> listar() throws DaoException {
        List<Empleado> listado = null;

        XStream xstream = new XStream(new DomDriver());

        return listado;

    }

    @Override
    public int insertar(List<Empleado> empleados) throws DaoException {

    }

}
