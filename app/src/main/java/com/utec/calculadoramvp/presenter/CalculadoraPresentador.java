package com.utec.calculadoramvp.presenter;

import com.utec.calculadoramvp.model.CalculadoraModel;
import com.utec.calculadoramvp.view.CalculadoraInterface;

public class CalculadoraPresentador {
private CalculadoraInterface view;
private CalculadoraModel model;

public CalculadoraPresentador(CalculadoraInterface view, CalculadoraModel model){
    this.view=view;
    this.model=model;
}

public void onButtonClicked(double num1, double num2, String operador){
    try{
        double resultado;
        switch (operador){
            case"+":
                resultado= model.suma(num1,num2);
                break;
            case"-":
                resultado=model.resta(num1,num2);
                break;
            case"*":
                resultado=model.multiplicar(num1,num2);
                break;
            case"/":
                resultado=model.divide(num1,num2);
                break;
            default:
                resultado=0;
        }
        view.displayResult(resultado);
    } catch (IllegalArgumentException e){
        view.displayError(e.getMessage());
    }
}
}
