package com.example.agendacontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String CONTACTO;
    private RecyclerView recyclerView;
    private ArrayList<contacto> datos;
    private Context context;


    String[] arrnombre = {"654878753", "678542693", "654878721", "654878542", "68878753", "698547253", "645218963", "612456378",
            "652078753", "654444453", "65555553", "654777753", "654878585", "624878753"};

    String[] arrnums = {"Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
            "Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
            "Caritina", "Carlota", "Baltazar"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        datos = new ArrayList<contacto>();


        for (int i = 0; i < 11; i++) {
            datos.add(new contacto("Nombre: " + arrnombre[i], "Telefono: " + arrnums[i]));
        }

        final adaptadorcontactos adaptador = new adaptadorcontactos(datos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adaptador);
/*
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(context, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                datos.add(new contacto("Nombre: " + arrnombre[position], "Telefono 1 click: " + (int) (Math.random() * 100000000)));
            }

            @Override
            public void onItemLongClick(View view, int position) {
                datos.add(new contacto("Nombre: " + arrnombre[position], "Telefono longo click: " + (int) (Math.random() * 100000000)));
            }
        }));*/
        adaptador.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.i("Mi App", "Pulsado el elemento " + recyclerView.getChildAdapterPosition(v));
                paginaSiguiente(v);
            }});

    }

    public void paginaSiguiente(View v){
        Intent intent= new Intent(this,MAContacto.class);
        contacto p = new contacto (arrnombre[recyclerView.getChildAdapterPosition(v)].toString(),arrnums[recyclerView.getChildAdapterPosition(v)].toString());
        Bundle b = new Bundle();
        b.putSerializable(CONTACTO, p);
        intent.putExtras(b);
        startActivity(intent);
    }



}