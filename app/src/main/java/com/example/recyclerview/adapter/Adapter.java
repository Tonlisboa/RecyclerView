package com.example.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.model.Filme;

import java.util.List;
//O Adapter necessita de um ViewHolder para reaproveitar as visualizações

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private  List<Filme> listaFilmes;
    public Adapter(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    @NonNull
    @Override
    //Necessta de arquivo XML para definir o Layout
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Converte o XLM do layout adapter_lista m view (É necessário inflar o XML
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista,parent,false);
        //Retorna o layout para o ViewHolder (Preeenhe com o Layout)
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //Visualizar os itens da lista de filmes
        Filme filme = listaFilmes.get(position);
        holder.titulo.setText(filme.getTituloFilme());
        holder.genero.setText(filme.getGenero());
        holder.ano.setText(filme.getAno());
    }

    @Override
    //Define a quantidade de itens
    public int getItemCount() {
        return listaFilmes.size();
    }

    //A Classe do viewholder
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titulo;
        TextView ano;
        TextView genero;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //Localiza os componentes do Layout XML adater Lista com ItemView
            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }
    }
}
