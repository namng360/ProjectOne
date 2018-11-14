package vn.edu.poly.projectone.activity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.widget.LinearLayout;

import vn.edu.poly.projectone.R;
import vn.edu.poly.projectone.cook.NorthernGrilledActivity;
import vn.edu.poly.projectone.cook.SouthGrilledActivity;
import vn.edu.poly.projectone.cook.SouthSauteActivity;

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
    }
}
