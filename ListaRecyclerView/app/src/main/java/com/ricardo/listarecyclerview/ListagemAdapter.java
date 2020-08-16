package com.ricardo.listarecyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

import com.squareup.picasso.Picasso;


public class ListagemAdapter extends RecyclerView.Adapter<ListagemAdapter.ReceitaHolder> {

    private Context context;
    private LinkedList<ReceitaModel> listaDeReceitas;
//    serve para apresentar/inflar o layout
    private final LayoutInflater mInflater;
    private ReceitaModel umaReceita;

//    passe o contexto pra poder manipular eventos, pois o RecyclerView não tem consciência
//    da existência desses eventos
    public ListagemAdapter(Context context, LinkedList listaDeReceitas) {
        this.context = context;
        this.listaDeReceitas = listaDeReceitas;
//        passa o context para o inflater
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ReceitaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        escolhe qual layout vai ser usado para inflar a listagem
        View itemView = mInflater.inflate(R.layout.item_list, parent, false);

        return new ReceitaHolder(itemView);
    }

    // Replace the contents of a view (invoked by the layout manager)
//    declare o holder e a posição como final, para garantir que cada holder mandará o index
//    correto para o click listener
    @Override
    public void onBindViewHolder(@NonNull final ReceitaHolder holder, final int position) {
//        esse método é executado para cada item da lista. Ele sabe a quantidade de itens pq
//        dissemos pra ele no método getItemCount()
        umaReceita = listaDeReceitas.get(position);

        String titulo = umaReceita.getName();
        String mensagem = umaReceita.getDescription();
        String imagemUrl = umaReceita.getUrl();

//        passa as strings para as text views
        holder.mTitulo.setText(titulo);
        holder.mMensagem.setText(mensagem);
        Picasso.get().load(imagemUrl).resize(0, 120).into(holder.mImagem);

        // pode implementar um click listener para adicionar essa funcionalidade ao holder
//      note que o holder e a posição devem ter sido declaradas como final no bind acima, ou então
//      o click listener sempre apontará para o bind realizado mais recentemente/último
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // cria uma intent para ir para a activity 'detalhes'
                Intent intent = new Intent(context, DetalhesActivity.class);
                intent.putExtra("nome", listaDeReceitas.get(position).getName());
                intent.putExtra("descricao", listaDeReceitas.get(position).getDescription());
                intent.putExtra("url", listaDeReceitas.get(position).getUrl());
                context.startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listaDeReceitas.size();
    }

    class ReceitaHolder extends RecyclerView.ViewHolder {
        public TextView mTitulo;
        public TextView mMensagem;
        public ImageView mImagem;
        public ConstraintLayout mComponentePai;

        public ReceitaHolder(@NonNull View itemView) {
            super(itemView);

            mTitulo = itemView.findViewById(R.id.titulo);
            mMensagem = itemView.findViewById(R.id.mensagem);
            mImagem = itemView.findViewById(R.id.imagem);
            mComponentePai = itemView.findViewById(R.id.componente_pai);
        }
    }
}
