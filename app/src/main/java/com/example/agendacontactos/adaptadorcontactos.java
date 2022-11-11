package com.example.agendacontactos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adaptadorcontactos extends RecyclerView.Adapter<adaptadorcontactos.ContactosViewHolder> implements View.OnClickListener{

    private ArrayList<contacto> datos;
    private View.OnClickListener listener;

    public adaptadorcontactos(ArrayList<contacto> datos) {
        this.datos = datos;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    public static class ContactosViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNombre;
        private TextView txtTelefono;

        public ContactosViewHolder(View itemView) {
            super(itemView);
            this.txtNombre = itemView.findViewById(R.id.nombre);
            this.txtTelefono = itemView.findViewById(R.id.telefono);
        }

        public void bindContacto(contacto contacto){
            txtNombre.setText(contacto.getNombre());
            txtTelefono.setText(contacto.getTelefono());
        }
    }

    //Construye la vista
    @Override
    public ContactosViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemcomponente, viewGroup, false);

        itemView.setOnClickListener(this);

        ContactosViewHolder tvh = new ContactosViewHolder(itemView);
        return tvh;
    }

    //asigna cada componente
    @Override
    public void onBindViewHolder(@NonNull ContactosViewHolder holder, int position){
        contacto contacto = datos.get(position);
        holder.bindContacto(contacto);
    }

    //Devuelve el tamaño del array
    @Override
    public int getItemCount(){
        return datos.size();
    }



}