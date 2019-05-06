package com.jackrutorial.foodagregator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends AppCompatActivity {
    RelativeLayout relativeLayout;
    CardView cardView;
    List<Food> foods = new ArrayList<>();
    DataAdapter adapter;
    public static final String FOOD_ID = "foodId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza);
        setInitialData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        cardView = findViewById(R.id.card_view);
        // создаем адаптер
         adapter = new DataAdapter(this, foods);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
        setRecyclerList();
    }
    private void setInitialData(){

        foods.add(new Food ("Греческий салат с курицей","salat","Греческий","Греческий",  R.drawable.lul));
        foods.add(new Food ("Мясо", "Salat","Salat","Мясо", R.drawable.scale_600));
        foods.add(new Food ("Пицца на толстом и тонком тесте, разные виды роллов", "Salat","Salat","Пицца и Суши", R.drawable.pizza));
        foods.add(new Food ("Шашлык из баранины", "Salat","Salat","Шашлык", R.drawable.shashlik));
    }
    public void setRecyclerList() { //************
        adapter.setOnClickListener(new DataAdapter.OnClickListener() {
            @Override
            public void onClick(int position) {
               //Toast.makeText(getBaseContext(),foods.get(position).getvName(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getBaseContext(),Information.class);
                startActivity(intent);
            }
        });
    }
}
