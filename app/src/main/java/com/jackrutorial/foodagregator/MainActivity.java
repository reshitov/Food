package com.jackrutorial.foodagregator;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout relativeLayout;
    List<Food> foods = new ArrayList<>();
    ImageView imageViewPizza;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewPizza = findViewById(R.id.imageView17);
        //historyFragment = new HistoryFragment();
       // constraintLayout = findViewById(R.id.constraintLayout);

        setupNavigation();
        imageViewPizza.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView17:
                Intent intent = new Intent(this,Pizza.class);
                startActivity(intent);
        }
    }

    private void setupNavigation(){
        BottomNavigationViewEx bottomNavigationViewEx=(BottomNavigationViewEx) findViewById(R.id.bottom_navigatiom_view_id);
        //BottomNavigationOptions.enableNavigation(MainActivity.this,bottomNavigationViewEx);
        BottomNavigationOptions.setupBottomNavigatiomViewEx(bottomNavigationViewEx);


    }

   /* private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.constraintLayout,fragment);
        fragmentTransaction.commit();
    }*/


}
