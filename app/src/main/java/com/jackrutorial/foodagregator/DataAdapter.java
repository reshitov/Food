package com.jackrutorial.foodagregator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>  {
    private LayoutInflater inflater;
    private List<Food> foods;
    private OnClickListener onClickListener;

    DataAdapter(Context context, List<Food> foods) {
        this.foods = foods;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.macket, parent, false);
        return new ViewHolder(view);
    }
    public void setOnClickListener(OnClickListener onClickListener) { //****
        this.onClickListener = onClickListener;
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        Food food = foods.get(position);
        holder.imageView.setImageResource(food.get_idImage());
        holder.nameView.setText(food.getvTitle());
        holder.companyView.setText(food.getvName());

    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView nameView, companyView;
        ViewHolder(View view){
            super(view);
            imageView = (ImageView)view.findViewById(R.id.iv_food);
            nameView = (TextView) view.findViewById(R.id.tv_title);
            companyView = (TextView) view.findViewById(R.id.tv_descr);
            view.setOnClickListener(new View.OnClickListener() {    //*********
                @Override
                public void onClick(View v) {
                    if (onClickListener != null) {
                        onClickListener.onClick(getAdapterPosition());
                    }
                }
            });
        }


    }
    public interface OnClickListener { //****
        void onClick(int position);
    }
}
