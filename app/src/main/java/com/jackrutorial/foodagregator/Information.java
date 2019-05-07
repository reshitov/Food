package com.jackrutorial.foodagregator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Information extends AppCompatActivity {
    public static final String FOOD_DATE = "FOOD_DATE";
    ImageView mImageViewInfo;
    ImageView mImageViewFood;
    TextView mTextViewInformation;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);

        Toolbar toolbar = findViewById(R.id.toolbar);
        mTextViewInformation = findViewById(R.id.informationTV);
        mImageViewFood =findViewById(R.id.iv_food);
        mImageViewInfo = findViewById(R.id.infoImage);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Food food = (Food) bundle.getSerializable(FOOD_DATE);
        mImageViewInfo.setImageDrawable(getDrawable(food.get_idImage()));
        mTextViewInformation.setText(food.getvTitle());
        Toast.makeText(this,food.getvName(),Toast.LENGTH_LONG).show();
    }
}
