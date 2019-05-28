package com.jackrutorial.foodagregator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends AppCompatActivity   {
    RelativeLayout relativeLayout;
    CardView cardView;
    List<Food> foods = new ArrayList<>();
    DataAdapter adapter;
    private Toolbar toolbar;
    public static final String FOOD_ID = "foodId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza);
       // toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
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

        foods.add(new Food ("От 200 рублей","Греческий","Пепперони",  R.drawable.pepperonipeperoni));
        foods.add(new Food ("От 350 рублей","Salat","Четыре сыра", R.drawable.quattro));
        foods.add(new Food ("От 390 рублей", "Salat","Диабло", R.drawable.diablo));
        foods.add(new Food ("От 450 рублей", "Salat","Маргарита", R.drawable.margaritamargarita));
    }
    public void setRecyclerList() { //************
        adapter.setOnClickListener(new DataAdapter.OnClickListener() {
            @Override
            public void onClick(Food food, int position) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent(getBaseContext(),Information.class);
                bundle.putSerializable(Information.FOOD_DATE, food);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {

       // getMenuInflater().inflate(R.menu.example_menu,menu);

       // MenuItem menuItem = menu.findItem(R.id.action_search);
       // SearchView searchView = (SearchView) menuItem.getActionView();
       // searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        /*newText = newText.toLowerCase();
        List<Food> foodSearch = new ArrayList<>();
        for(Food food : foods){
            String name = food.getvTitle().toLowerCase();
            if(name.contains(newText))
                foods.add(food);
        }

        adapter.updateList(foodSearch);
        return false;
    }*/
}

