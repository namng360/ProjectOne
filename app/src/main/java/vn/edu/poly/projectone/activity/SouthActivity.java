package vn.edu.poly.projectone.activity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.widget.LinearLayout;

import vn.edu.poly.projectone.R;
import vn.edu.poly.projectone.cook.NorthernGrilledActivity;
import vn.edu.poly.projectone.cook.SouthFriedActivity;
import vn.edu.poly.projectone.cook.SouthGrilledActivity;
import vn.edu.poly.projectone.cook.SouthSauteActivity;
import vn.edu.poly.projectone.type.SouthChickenActivity;
import vn.edu.poly.projectone.type.SouthCowActivity;
import vn.edu.poly.projectone.type.SouthPigActivity;
import vn.edu.poly.projectone.type.SouthSeaFoodActivity;

public class SouthActivity extends AppCompatActivity {

    private Toolbar toolBar;
    private LinearLayout lnNuong, lnCow, lnSaute, lnFried, lnChicken, lnPig, lnSeaFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_south);
        initView();
    }

    private void initView() {
        toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_back);
        toolBar.setTitle("Miền Nam");
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        lnNuong = findViewById(R.id.lnNuong);
        lnNuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SouthActivity.this, SouthGrilledActivity.class);
                startActivity(intent);
            }
        });
        lnSaute = findViewById(R.id.lnSaute);
        lnSaute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SouthActivity.this, SouthSauteActivity.class);
                startActivity(intent);
            }
        });
        lnFried = findViewById(R.id.lnFried);
        lnFried.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SouthActivity.this, SouthFriedActivity.class);
                startActivity(intent);
            }
        });
        lnCow = findViewById(R.id.lnCow);
        lnCow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SouthActivity.this, SouthCowActivity.class);
                startActivity(intent);
            }
        });
        lnChicken = findViewById(R.id.lnChicken);
        lnChicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SouthActivity.this, SouthChickenActivity.class);
                startActivity(intent);
            }
        });
        lnPig = findViewById(R.id.lnPig);
        lnPig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SouthActivity.this, SouthPigActivity.class);
                startActivity(intent);
            }
        });
        lnSeaFood = findViewById(R.id.lnSeaFood);
        lnSeaFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SouthActivity.this, SouthSeaFoodActivity.class);
                startActivity(intent);
            }
        });
    }
}
