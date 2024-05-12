package com.utec.calculadoramvp.model;

public class CalculadoraModel {
    public double suma(double num1, double num2){
        return num1+num2;
    }
    public double resta(double num1, double num2){
        return num1-num2;
    }
    public double multiplicar(double num1, double num2){
        return num1*num2;
    }
    public double divide(double num1, double num2){
        if (num2 == 0) {
            throw new IllegalArgumentException("no se puede dividir entre 0");
        }
        return num1/num2;
    }
}
