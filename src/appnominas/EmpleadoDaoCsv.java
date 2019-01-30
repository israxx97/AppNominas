/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnominas;

import java.nio.file.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author israel
 */
public class EmpleadoDaoCsv implements EmpleadoDao {

    private Path path;

    public EmpleadoDaoCsv(String path) {
        this.path = Paths.get(path);

    }

    @Override
    public List<Empleado> listar() throws DaoException {
        List<Empleado> empleados = new ArrayList<>();
        String linea;
        String[] l;
        Empleado e;
        
        try {
            BufferedReader fichero = Files.newBufferedReader(path);
            linea = fichero.readLine();
            
            while (linea != null) {
                l = linea.split(",");
                if (l.length == 3) {
                    e = new EmpleadoFijo((l[0]), l[1], Float.parseFloat(l[2]));
                    
                } else {
                    if (l.length == 4) {
                        e = new EmpleadoEventual((l[0]), l[1], Float.parseFloat(l[2]), Integer.parseInt(l[3]));
                        
                    } else {
                        throw new DaoException("Error en formato");
                        
                    }
                    
                }
                
                empleados.add(e);
                linea = fichero.readLine();
                
            }
            
        } catch (IOException ioe) {
            throw new DaoException(ioe.toString());

        }
        
        return empleados;
        
    }

    @Override
    public int insertar(List<Empleado> empleados) throws DaoException {
        BufferedWriter fichero = null;
        int n = 0;
        ListIterator<Empleado> li = empleados.listIterator();
        
        try {
            fichero = Files.newBufferedWriter(path);
            
            while (li.hasNext()) {
                fichero.write(li.next().toString());
                fichero.newLine();
                n++;
                
            }
            
        } catch (IOException ioe) {
            throw new DaoException(ioe.toString());
            
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                    
                }
                
            } catch (IOException ioe) {
                throw new DaoException(ioe.toString());
                
            }
            
        }
        
        return empleados.size();
        
    }

}
