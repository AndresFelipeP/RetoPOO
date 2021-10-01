package co.reto1.app;

import co.reto1.dominio.Calculadora;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    /*
    David Camilo Ayala Marín
    Jorge Andrés Carmona Ramírez
    Yenny Marcela Vargas Rincón
    Andrés Felipe Pinzón Franco
     */

    private static final ImageIcon icono = new ImageIcon("C:\\POO archivos\\Reto\\POO.png");
    private static final int SUMAR = 0;
    private static final int RESTAR = 1;
    private static final int MULTIPLICAR = 2;
    private static final int DIVIDIR = 3;
    private static final int RESULTADO = 1;
    private static final int AGREGAR = 0;
    public static void main(String[] args) {
        JCheckBox redondear = new JCheckBox("Redondear");
        do {
            int seleccion = JOptionPane.showOptionDialog(null, "Selecciona la operación que deseas realizar.", "Calculadora", 0, JOptionPane.PLAIN_MESSAGE, icono, Arrays.asList("Sumar", "Restar", "Multiplicar", "Dividir", redondear).toArray(), null);
            switch (seleccion){
                case SUMAR:{
                    Calculadora calculadora = new Calculadora(ingresar(seleccion));
                    double suma = calculadora.sumar();
                    if (redondear.isSelected()){
                        suma = calculadora.redondear(suma);
                    }
                    mostrarResultado(suma, "Sumar");
                    break;
                }
                case RESTAR:{
                    Calculadora calculadora = new Calculadora(ingresar(seleccion));
                    double resta = calculadora.restar();
                    if (redondear.isSelected()){
                        resta = calculadora.redondear(resta);
                    }
                    mostrarResultado(resta, "Restar");
                    break;
                }
                case MULTIPLICAR:{
                    Calculadora calculadora = new Calculadora(ingresar(seleccion));
                    double multiplicacion = calculadora.multiplicar();
                    if (redondear.isSelected()){
                        multiplicacion = calculadora.redondear(multiplicacion);
                    }
                    mostrarResultado(multiplicacion, "Multiplicar");
                    break;
                }
                case DIVIDIR:{
                    Calculadora calculadora = new Calculadora(ingresar(seleccion));
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
    private static List<Double> ingresar(int opcion){
        List<Double> numeros = new ArrayList<>();
        boolean ciclo = true;
        do{
            try{
                Double num = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese un numero: ", "Calculadora", JOptionPane.QUESTION_MESSAGE));
                if (opcion == DIVIDIR && numeros.size() >= 1 && num == 0){
                    JOptionPane.showMessageDialog(null, "Ingrese un numero válido.","Calculadora", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                numeros.add(num);
            }
            catch(Exception error){
                JOptionPane.showMessageDialog(null, "Ingrese un numero válido.","Calculadora", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            if (numeros.size()<2){
                ciclo = true;
            }
            else {
                int seleccion = JOptionPane.showOptionDialog(null, "¿Desea agregar otro número?", "Calculadora", 0, JOptionPane.WARNING_MESSAGE
                        , null, Arrays.asList("Agregar", "Resultado").toArray(), null);
                switch (seleccion) {
                    case AGREGAR: {
                        ciclo = true;
                        break;
                    }
                    case RESULTADO: {
                        ciclo = false;
                        break;
                    }
                    case JOptionPane.CLOSED_OPTION: {
                        System.exit(0);
                    }
                }
            }
        }while(ciclo);
        return numeros;
    }
}
