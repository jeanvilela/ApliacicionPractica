package com.reservagrupo.claselab04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Registrar extends AppCompatActivity implements View.OnClickListener {

    TextView txtNombre;
   Button btnRegistrar, btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        btnRegistrar = (Button) findViewById(R.id.btnRegresar);
        btnRegistrar.setOnClickListener(this);
        txtNombre = (TextView) findViewById(R.id.txtNombre);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(this);
    }

    public void regresar() {
        Intent objIntent = new Intent(Registrar.this, MainActivity.class);
        startActivity(objIntent);
        finish();
    }

    public void guardar() {
        if(txtNombre.getText().toString().isEmpty()){
            txtNombre.setError("Ingrese un nombre");
            return;
        }
        String nombre = txtNombre.getText().toString();
        Intent objtIntent = new Intent(Registrar.this, MainActivity.class);
        Bundle objBundle = new Bundle();
        objBundle.putString("Nombre", nombre);
        objtIntent.putExtras(objBundle);
        startActivity(objtIntent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnRegresar) {
            regresar();
        } else if (v.getId() == R.id.btnGuardar) {
            guardar();
        }
    }
}