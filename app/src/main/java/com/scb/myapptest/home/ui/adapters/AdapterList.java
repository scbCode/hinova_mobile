package com.scb.myapptest.home.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.scb.myapptest.R;
import com.scb.myapptest.home.domain.models.OficinaEntity;
import com.scb.myapptest.home.ui.detail_oficina.DetalhesOficinaActivity;

import java.util.List;

public class AdapterList extends
        RecyclerView.Adapter<AdapterList.ViewHolder> {

    private LayoutInflater mInflater;
    List<OficinaEntity> mData;
    Context context;
    public AdapterList(Context context, List<OficinaEntity> mData){
        this.context = context;
        this.mData = mData;
        this.mInflater = LayoutInflater.from(context);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView nome = holder.itemView.findViewById(R.id.txt_nome);
        TextView desc = holder.itemView.findViewById(R.id.text_desc);
        nome.setText(mData.get(position).nome);
        desc.setText(mData.get(position).descricao);
        holder.oficinaEntity = mData.get(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nome;
        TextView desc;
        OficinaEntity oficinaEntity;

        ViewHolder(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.txt_nome);
            desc = itemView.findViewById(R.id.text_desc);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent in = new Intent(context, DetalhesOficinaActivity.class);
            in.putExtra("nome", oficinaEntity.nome);
            in.putExtra("tell", oficinaEntity.telefone);
            in.putExtra("descricao", oficinaEntity.descricao);
            in.putExtra("end", oficinaEntity.endereco);
            context.startActivity(in);
        }

    }
}
