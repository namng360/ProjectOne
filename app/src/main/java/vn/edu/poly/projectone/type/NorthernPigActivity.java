package vn.edu.poly.projectone.type;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.projectone.R;
import vn.edu.poly.projectone.adapter.northern.AdapterNorthernPig;
import vn.edu.poly.projectone.model.Food;

public class NorthernPigActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterNorthernPig adapterNorthernPig;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_northern_pig);

        initView();
        initData();
    }
    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterNorthernPig = new AdapterNorthernPig(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterNorthernPig);
        toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_back);
        toolBar.setTitle(getString(R.string.thit_lon));
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initData() {
        Food food = new Food(R.drawable.thit_lon_rim_nuoc_mam, getString(R.string.thit_lon_rim_nuoc_mam), "","");
        foodList.add(food);
        food = new Food(R.drawable.thit_lon_nau_dong, getString(R.string.thit_lon_nau_dong), "","");
        foodList.add(food);
        food = new Food(R.drawable.thit_kho_tau, getString(R.string.thit_kho_tau), "","");
        foodList.add(food);
        food = new Food(R.drawable.pate_lon, getString(R.string.pate_lon), "","");
        foodList.add(food);
        adapterNorthernPig.notifyDataSetChanged();
    }
}
