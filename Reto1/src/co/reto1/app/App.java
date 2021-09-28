package co.reto1.app;

import co.reto1.dominio.Calculadora;

import javax.swing.*;
import java.util.Arrays;

public class App {
    /*
    David Camilo Ayala Marín
    Jorge Andrés Carmona Ramírez
    Yenny Marcela Vargas Rincón
    Andrés Felipe Pinzón Franco
     */

    private static final ImageIcon icono = new ImageIcon("C:\\POO archivos\\Reto\\POO.png");
    private static final int SUMAR = 0;//Operacion sumar
    private static final int RESTAR = 1;//operacion restar
    private static final int MULTIPLICAR = 2;
    private static final int DIVIDIR = 3;
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        JCheckBox redondear = new JCheckBox("Redondear");
        do {
            int seleccion = JOptionPane.showOptionDialog(null, "Selecciona la operación que deseas realizar.", "Calculadora", 0, JOptionPane.PLAIN_MESSAGE, icono, Arrays.asList("Sumar", "Restar", "Multiplicar", "Dividir", redondear).toArray(), null);
            switch (seleccion){
                case SUMAR:{
                    double suma = calculadora.sumar();
                    if (redondear.isSelected()){
                        suma = calculadora.redondear(suma);
                    }
                    mostrarResultado(suma, "Sumar");
                    break;
                }
                case RESTAR:{
                    double resta = calculadora.restar();
                    if (redondear.isSelected()){
                        resta = calculadora.redondear(resta);
                    }
                    mostrarResultado(resta, "Restar");
                    break;
                }
                case MULTIPLICAR:{
                    double multiplicacion = calculadora.multiplicar();
                    if (redondear.isSelected()){
                        multiplicacion = calculadora.redondear(multiplicacion);
                    }
                    mostrarResultado(multiplicacion, "Multiplicar");
                    break;
                }
                case DIVIDIR:{
                    double division = calculadora.dividir();
                    if (redondear.isSelected()){
                        division = calculadora.redondear(division);
                    }
                    mostrarResultado(division, "Dividir");
                    break;
                }
                case JOptionPane.CLOSED_OPTION:{
                    System.exit(0);
                }
            }
        }while(true);
    }
    private static void mostrarResultado(double resultado, String titulo) {
        JOptionPane.showMessageDialog(null, "El resultado es: " + resultado, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}

