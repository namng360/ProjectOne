package vn.edu.poly.projectone.activity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import vn.edu.poly.projectone.R;
import vn.edu.poly.projectone.cook.NorthernFriedActivity;
import vn.edu.poly.projectone.cook.NorthernGrilledActivity;
import vn.edu.poly.projectone.cook.NorthernSauteActivity;
import vn.edu.poly.projectone.type.NorthernChickenActivity;
import vn.edu.poly.projectone.type.NorthernCowActivity;
import vn.edu.poly.projectone.type.NorthernPigActivity;
import vn.edu.poly.projectone.type.NorthernSeaFoodActivity;


public class NorthernActivity extends AppCompatActivity {
    private Toolbar toolBar;
    private LinearLayout lnNuong, lnCow, lnSaute, lnFried, lnChicken, lnPig, lnSeaFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_northern);

        initView();

        }

    private void initView() {
        lnNuong = findViewById(R.id.lnNuong);
        lnNuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NorthernActivity.this, NorthernGrilledActivity.class);
                startActivity(intent);
            }
        });
        lnCow = findViewById(R.id.lnCow);
        lnCow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NorthernActivity.this, NorthernCowActivity.class);
                startActivity(intent);
            }
        });
        lnSaute = findViewById(R.id.lnSaute);
        lnSaute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NorthernActivity.this, NorthernSauteActivity.class);
                startActivity(intent);
            }
        });
        lnFried = findViewById(R.id.lnFried);
        lnFried.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NorthernActivity.this, NorthernFriedActivity.class);
                startActivity(intent);
            }
        });
        lnChicken = findViewById(R.id.lnChicken);
        lnChicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NorthernActivity.this, NorthernChickenActivity.class);
                startActivity(intent);
            }
        });
        lnPig = findViewById(R.id.lnPig);
        lnPig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NorthernActivity.this, NorthernPigActivity.class);
                startActivity(intent);
            }
        });
        lnSeaFood = findViewById(R.id.lnSeaFood);
        lnSeaFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NorthernActivity.this, NorthernSeaFoodActivity.class);
                startActivity(intent);
            }
        });
        toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_back);
        toolBar.setTitle("Miền Bắc");
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


}

