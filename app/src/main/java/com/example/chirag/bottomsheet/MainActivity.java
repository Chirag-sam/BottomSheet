package com.example.chirag.bottomsheet;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.support.design.widget.BottomSheetBehavior.STATE_COLLAPSED;
import static android.support.design.widget.BottomSheetBehavior.STATE_EXPANDED;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the bottom sheet view
        LinearLayout llBottomSheet = findViewById(R.id.bottom_sheet);

        //Initialize the bottom sheet behavior
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet);

        //Change the state of the bottom sheet. Other possible states are STATE_EXPANDED and STATE_HIDDEN.
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        //Set the peek height
        //bottomSheetBehavior.setPeekHeight(1000);

        //Set hideable or not
        bottomSheetBehavior.setHideable(false);

        //Set callback for changes
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                //The newState will be one of STATE_DRAGGING, STATE_SETTLING, STATE_EXPANDED, STATE_COLLAPSED, or STATE_HIDDEN.
                if(newState == STATE_EXPANDED) {
                    Toast.makeText(MainActivity.this,"Expanded",Toast.LENGTH_SHORT).show();
                }
                else if(newState == STATE_COLLAPSED) {
                    Toast.makeText(MainActivity.this,"Collapsed",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }
}
