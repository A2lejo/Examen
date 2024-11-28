package CalculadoraBMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BMIRemoto extends Remote{

    //metodos que el cliente puede llamar

    double BMI(double peso, double altura) throws RemoteException;
    
    String getBMICategory(double bmi) throws RemoteException;

}
