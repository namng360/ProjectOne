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
import vn.edu.poly.projectone.adapter.northern.AdapterNorthernSeaFood;
import vn.edu.poly.projectone.model.Food;

public class NorthernSeaFoodActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterNorthernSeaFood adapterNorthernSeaFood;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_northern_sea_food);

        initView();
        initData();
    }
    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterNorthernSeaFood = new AdapterNorthernSeaFood(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterNorthernSeaFood);
        toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_back);
        toolBar.setTitle(getString(R.string.hai_san));
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initData() {
        Food food = new Food(R.drawable.muc_xao_cay, getString(R.string.muc_xao_cay), "","");
        foodList.add(food);
        food = new Food(R.drawable.ghe_rang_me, getString(R.string.ghe_rang_me), "","");
        foodList.add(food);
        food = new Food(R.drawable.muc_chien_bo, getString(R.string.muc_chien_bo), "","");
        foodList.add(food);
        food = new Food(R.drawable.tom_hum_nuong_bo_toi, getString(R.string.tom_hum_nuong_bo_toi), "","");
        foodList.add(food);
        adapterNorthernSeaFood.notifyDataSetChanged();
    }
}
