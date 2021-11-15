package com.brunorm.ar_pdm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView dataDiaSemana;
        TextView min;
        TextView max;
        TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dataDiaSemana = itemView.findViewById(R.id.dateText);
            min = itemView.findViewById(R.id.minText);
            max = itemView.findViewById(R.id.maxText);
            description = itemView.findViewById(R.id.descriptionText);
        }
    }

    private ArrayList<Forecast> listaDadosTempo;
    public ListAdapter(DadosTempo dados) {
        listaDadosTempo = dados.getLista();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.listing_item, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Forecast itemPosition = listaDadosTempo.get(position);

        String textDataDiaSemana = itemPosition.getDate() + " - " + itemPosition.getWeekday();
        String textDescription = itemPosition.getDescription();
        String textMax = itemPosition.getMax() + "°C";
        String textMin = itemPosition.getMin() + "°C";

        viewHolder.dataDiaSemana.setText(textDataDiaSemana);
        viewHolder.description.setText(textDescription);
        viewHolder.max.setText(textMax);
        viewHolder.min.setText(textMin);
    }

    @Override
    public int getItemCount() {
        return listaDadosTempo.size();
    }

}