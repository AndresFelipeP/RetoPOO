package co.reto1.dominio;

import java.text.DecimalFormat;
import java.util.List;

public class Calculadora {
    private List<Double> numeros;

    public Calculadora(List<Double> numeros) {
        this.numeros = numeros;
    }

    public double sumar(){
        double suma = 0;
        for (double num : this.numeros) {
            suma += num;
        }
        return suma;
    }
    public double restar(){
        double resta = 0;
        for (double num : this.numeros) {
            resta -= num;
        }
        return resta;
    }
    public double dividir(){
        double division = 1;
        int contador = 1;
        for (double num : this.numeros) {
            if (contador==1){
                division = num;
            }
            else {
                division /= num;
            }
            contador++;
        }
        return division;
    }
    public double multiplicar(){
        double multiplicacion = 1;
        for (double num : this.numeros) {
            multiplicacion *= num;
        }
        return multiplicacion;
    }
    public double redondear(double num){
        DecimalFormat numRedondeado = new DecimalFormat("0.00");
        return Double.parseDouble(numRedondeado.format(num).replace(",", "."));
    }

}