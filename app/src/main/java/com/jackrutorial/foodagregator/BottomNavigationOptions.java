package com.jackrutorial.foodagregator;


import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationOptions {
     HistoryFragment historyFragment;
    private ConstraintLayout constraintLayout;


    public static void setupBottomNavigatiomViewEx(BottomNavigationViewEx bottomNavigationViewEx){
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
        bottomNavigationViewEx.enableAnimation(false);

    }
    /*public static void enableNavigation(final Activity context, BottomNavigationViewEx view) {

        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectFragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        Intent intent = new Intent(context,MainActivity.class);
                        context.startActivity(intent);
                        break;
                    case R.id.nav_history:
                        //setFragment(historyFragment);
                        return true;
                    default:
                        return false;

                }
                //getSupportFragmentManager
                return true;
            }
        });

    }*/
}
