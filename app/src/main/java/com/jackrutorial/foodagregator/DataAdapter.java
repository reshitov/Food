package com.jackrutorial.foodagregator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<Food> foods;
    private List<Food> foodsFull;
    private OnClickListener onClickListener;

    DataAdapter(Context context, List<Food> foods) {
        this.foods = foods;
        this.inflater = LayoutInflater.from(context);
      //  foodsFull = new ArrayList<>(foods);
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

        ViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.iv_food);
            nameView = (TextView) view.findViewById(R.id.tv_title);
            companyView = (TextView) view.findViewById(R.id.tv_descr);
            view.setOnClickListener(new View.OnClickListener() {    //*********
                @Override
                public void onClick(View v) {
                    if (onClickListener != null) {
                        onClickListener.onClick(foods != null && foods.size() != 0 ? foods.get(getAdapterPosition()) : null, getAdapterPosition()); //есть ли в списке элементы и есть ли он вообще, (?) означает,если тру до двоеточего и тд
                    }
                }
            });
        }


    }

    public interface OnClickListener { //****
        void onClick(Food food, int position);
    }
}

   /* @Override
    public Filter getFilter() {
        return foodsFilter;
    }

    private Filter foodsFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Food> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(foodsFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Food item : foodsFull) {
                    if (item.getvTitle().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

            @Override
            protected void publishResults (CharSequence constraint, FilterResults results){
                foods.clear();
                foods.addAll((List) results.values);
                notifyDataSetChanged();

            }
        };


    }*/

