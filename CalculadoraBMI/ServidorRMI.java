package CalculadoraBMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {
    public static void main(String[] args) {

        try {
            // creamos una instancia de la implementacion de la interfaz
            BMIRemoto objetoRemoto = new BMIRemotoImpl();

            // crear y obtener el registro de nombres en un puerto específico
            Registry registro = LocateRegistry.createRegistry(1099);

            // Vincular el objeto remoto con un nombre específico
            registro.rebind("ClienteRemoto", objetoRemoto);

            // Confirmar que el servidor está listo
            System.out.println("Servidor RMI listo y esperando conexiones...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}