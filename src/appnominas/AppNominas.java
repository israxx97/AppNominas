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
        int opcion, opcion2, horas;
        String dni, nombre;
        float salario, salarioHora;
        Empleado empleado;
        SistemaNominas sn = new SistemaNominas();

        opcion = getOpcion();

        while (opcion != 0) {
            switch (opcion) {
                case 1:
                    opcion2 = getOpcion2();

                    while (opcion2 != 0) {
                        switch (opcion2) {
                            case 1:
                                System.out.print("Introduce dni: ");
                                dni = sc.nextLine();
                                System.out.print("Introduce nombre: ");
                                nombre = sc.nextLine();
                                System.out.print("Introduce salario: ");
                                salario = sc.nextFloat();
                                sc.nextLine();

                                empleado = new EmpleadoFijo(dni, nombre, salario);

                                if (sn.incluirEmpleado(empleado)) {
                                    System.out.println("Empleado fijo con dni " + dni + " incluido correctamente.");

                                } else {
                                    System.out.println("NO se ha podido incluir empleado con dni " + dni + ".");

                                }

                                break;

                            case 2:
                                System.out.print("Introduce dni: ");
                                dni = sc.nextLine();
                                System.out.print("Introduce nombre: ");
                                nombre = sc.nextLine();
                                System.out.print("Salario hora: ");
                                salarioHora = sc.nextFloat();
                                System.out.print("Horas: ");
                                horas = sc.nextInt();
                                sc.nextLine();

                                empleado = new EmpleadoEventual(dni, nombre, salarioHora, horas);

                                if (sn.incluirEmpleado(empleado)) {
                                    System.out.println("Empleado eventual con dni " + dni + " incluido correctamente.");

                                } else {
                                    System.out.println("NO se ha podido incluir empleado con dni " + dni + ".");

                                }

                                break;

                        }

                        opcion2 = getOpcion2();

                    }

                    break;

                case 2:
                    System.out.print("Introduce dni: ");
                    dni = sc.nextLine();

                    if (sn.eliminarEmpleado(dni)) {
                        System.out.println("Empleado con dni " + dni + " eliminado correctamente.");

                    } else {
                        System.out.println("NO se ha podido eliminar empleado con dni " + dni + ".");

                    }

                    break;

                case 3:
                    System.out.print(sn.listarEmpleados());

                    break;

                case 4:
                    System.out.print(sn.getTotalSalarios());

                    break;

                case 5:

                    break;

                case 6:

                    break;

            }

            opcion = getOpcion();

        }

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
                + "0.- Salir.\n");

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
                + "0.- Salir.\n");

        do {
            System.out.print("Introduce una opción: ");
            opcion = sc.nextInt();

        } while (opcion < 0 || opcion > 2);

        return opcion;

    }

}
