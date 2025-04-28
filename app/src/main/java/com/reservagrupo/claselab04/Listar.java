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

public class Listar extends AppCompatActivity implements View.OnClickListener {

    TextView txtSeleccion;
    Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        txtSeleccion = (TextView) findViewById(R.id.txtSeleccion);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        Bundle objBundle = getIntent().getExtras();
        txtSeleccion.setText(objBundle.getString("clave"));
        btnRegresar.setOnClickListener(this);
    }

    public void regresar() {
        Intent objIntent = new Intent(Listar.this, MainActivity.class);
        startActivity(objIntent);
        finish();
    }

    @Override
    public void onClick(View v) {
        regresar();
    }
}