package com.reservagrupo.claselab04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<String> lstOp;
    ArrayAdapter<String> adptador;
    ListView lstOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstOpciones = (ListView) findViewById(R.id.lstOpciones);
        lstOpciones.setOnItemClickListener(this);
        lstOp = cargarOpciones();
        adptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lstOp);
        lstOpciones.setAdapter(adptador);
    }

    public ArrayList<String> cargarOpciones() {
        lstOp = new ArrayList<String>();
        lstOp.add("REGISTRAR");
        lstOp.add("LISTAR");
        return lstOp;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                Intent objIntent = new Intent(MainActivity.this, Registrar.class);
                startActivity(objIntent);
                finish();
                break;
            case 1:
                Intent objIntent2 = new Intent(MainActivity.this, Listar.class);
                Bundle objBundle = new Bundle();
                String strSeleccion = lstOp.get(position);
                objBundle.putString("clave", strSeleccion);
                objIntent2.putExtras(objBundle);
                startActivity(objIntent2);
                finish();
                break;
        }
    }
}