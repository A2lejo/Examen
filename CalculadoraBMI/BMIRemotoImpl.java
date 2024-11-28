package CalculadoraBMI;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class BMIRemotoImpl extends UnicastRemoteObject implements BMIRemoto{

    //Constructor 
    public BMIRemotoImpl() throws RemoteException{
        super();
    }
    // Implemetar los metodos de la interfaz
    public String mensaje() throws RemoteException{
        return "Hola desde el servidor";
    }

    public double operacion(double a, double b) throws RemoteException{
        return  a + b;
    }
    @Override
    public double BMI(double peso, double altura) throws RemoteException {
        return peso / (altura * altura);
    }

    @Override
    public String getBMICategory(double bmi) throws RemoteException {
        if (bmi < 18.5) {
            return "Bajo peso";
        } else if (18.5 <= bmi && bmi <= 24.9) {
            return "Normal";
        } else if (25 <= bmi && bmi <= 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }
}
