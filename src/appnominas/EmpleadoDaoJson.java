/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnominas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author israel
 */
public class EmpleadoDaoJson implements EmpleadoDao {

    private Path path;

    public EmpleadoDaoJson(String path) {
        this.path = Paths.get(path);

    }

    @Override
    public List<Empleado> listar() throws DaoException {
        List<Empleado> lista = null;
        java.lang.reflect.Type tipo = new TypeToken<List<Empleado>>() {
        }.getType();
        RuntimeTypeAdapterFactory<Empleado> empleadoAdapter = RuntimeTypeAdapterFactory.of(Empleado.class, "type");
        empleadoAdapter.registerSubtype(EmpleadoFijo.class, "Fijo");
        empleadoAdapter.registerSubtype(EmpleadoEventual.class, "Eventual");
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.registerTypeAdapterFactory(empleadoAdapter);
        Gson gson = builder.create();

        try (BufferedReader br = Files.newBufferedReader(path)) {
            lista = gson.fromJson(br, tipo);

        } catch (IOException ioe) {
            throw new DaoException(ioe.toString());

        }

        return lista;

    }

    @Override
    public int insertar(List<Empleado> empleados) throws DaoException {
        java.lang.reflect.Type tipo = new TypeToken<List<Empleado>>() {
        }.getType();
        RuntimeTypeAdapterFactory<Empleado> empleadoAdapter = RuntimeTypeAdapterFactory.of(Empleado.class, "type");
        empleadoAdapter.registerSubtype(EmpleadoFijo.class, "Fijo");
        empleadoAdapter.registerSubtype(EmpleadoEventual.class, "Eventual");
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.registerTypeAdapterFactory(empleadoAdapter);
        Gson gson = builder.create();

        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            gson.toJson(empleados, tipo, bw);

        } catch (IOException ioe) {
            throw new DaoException(ioe.toString());

        }

        return empleados.size();

    }

}
