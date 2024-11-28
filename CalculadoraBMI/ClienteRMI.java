package CalculadoraBMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClienteRMI {
    public static void main(String[] args) {
        // Obtener registro en el puerto indicando
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);

            // Crear instancia de la implementación de la interfaz
            BMIRemoto objetoRemoto = (BMIRemoto) registro.lookup("ClienteRemoto");
            Scanner scanner = new Scanner(System.in);
            boolean continuar = true;

            double peso = 0;
            double altura = 0;

            while (continuar) {

                System.out.println("Escoja una opción: ");
                System.out.println("1. Calculo de BMI");
                System.out.println("2. Categoria de BMI");
                System.out.println("3. Salir");
                int opcion = scanner.nextInt();

                if (opcion != 3) {
                    System.out.println("Ingrese el peso (kg): ");
                    peso = scanner.nextDouble();
                    System.out.println("Ingrese la altura (m): ");
                    altura = scanner.nextDouble();
                }

                if (opcion == 1) {
                    double bmi = objetoRemoto.BMI(peso, altura);
                    System.out.println("El BMI es: " + bmi);
                } else if (opcion == 2) {
                    double bmi = objetoRemoto.BMI(peso, altura);
                    String categoria = objetoRemoto.getBMICategory(bmi);
                    System.out.println("La categoría del BMI es: " + categoria);
                } else if (opcion == 3) {
                    continuar = false;
                    System.out.println("Saliendo");
                } else {
                    System.out.println("Opción no válida");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
