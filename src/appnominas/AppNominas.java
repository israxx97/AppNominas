/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnominas;

import java.util.Scanner;

/**
 *
 * @author daw2
 */
public class AppNominas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion, opcion2;

    }

    private static int getOpcion() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.print("1.- Crear empleado.\n"
                + "2.- Eliminar empleado.\n"
                + "3.- Listar empleados.\n"
                + "4.- Consultar total salarios.\n"
                + "5.- Guardar empleados.\n"
                + "6.- Cargar empleados.\n"
                + "0.- Salir.");

        do {
            System.out.print("Introduce una opción: ");
            opcion = sc.nextInt();

        } while (opcion < 0 || opcion > 6);

        return opcion;

    }

    private static int getOpcion2() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.print("1.- Crear empleado fijo.\n"
                + "2.- Crear empleado eventual.\n"
                + "0.- Salir.");

        do {
            System.out.print("Introduce una opción: ");
            opcion = sc.nextInt();

        } while (opcion < 0 || opcion > 2);

        return opcion;

    }

}
