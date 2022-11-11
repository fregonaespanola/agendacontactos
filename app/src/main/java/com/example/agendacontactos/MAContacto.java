package com.example.agendacontactos;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MAContacto extends AppCompatActivity{

    TextView txtNombre;
    TextView txtTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_contacto);

        txtNombre=findViewById(R.id.txtNombre);

        Intent intent2=getIntent();

        Bundle b = intent2.getExtras();
        contacto p = (contacto) b.getSerializable(MainActivity.CONTACTO);

        txtNombre.setText(p.getNombre()+" Email: "+ p.getTelefono());

    }
}
