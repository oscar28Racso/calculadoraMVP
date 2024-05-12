package com.utec.calculadoramvp;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.utec.calculadoramvp.model.CalculadoraModel;
import com.utec.calculadoramvp.presenter.CalculadoraPresentador;
import com.utec.calculadoramvp.view.CalculadoraInterface;

public class MainActivity extends AppCompatActivity implements CalculadoraInterface {
    private EditText num1EditText;
    private EditText num2EditText;
    private TextView resultTextView;
    private CalculadoraPresentador presenter;


    private void obtenerNumeros(String operador) {
        String num1Str = num1EditText.getText().toString();
        String num2Str = num2EditText.getText().toString();


        if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            presenter.onButtonClicked(num1, num2, operador);
        } else {

            displayError("Ingrese ambos números.");
        }
    }
    private void borrar() {
        num1EditText.setText("");
        num2EditText.setText("");
        resultTextView.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1EditText = findViewById(R.id.txtdigito1);
        num2EditText = findViewById(R.id.txtDigito2);
        resultTextView = findViewById(R.id.txtResultado);

        presenter = new CalculadoraPresentador(this, new CalculadoraModel());

        findViewById(R.id.btnSumar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperationButtonClicked("+");
                obtenerNumeros("+");
            }
        });
        findViewById(R.id.btnRestar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperationButtonClicked("-");
                obtenerNumeros("-");
            }
        });
        findViewById(R.id.btnMultiplicar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperationButtonClicked("*");
                obtenerNumeros("*");
            }
        });
        findViewById(R.id.btnDividir).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperationButtonClicked("/");
                obtenerNumeros("/");
            }
        });
        findViewById(R.id.btnBorrar).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
              borrar();
            }
        });

    }



    @Override
    public void displayResult(double result) {
        resultTextView.setText(String.valueOf(result));
    }

    @Override
    public void displayError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void onOperationButtonClicked(String operator) {

    }
}
