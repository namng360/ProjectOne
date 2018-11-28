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
import vn.edu.poly.projectone.adapter.central.AdapterCentralSeaFood;
import vn.edu.poly.projectone.model.Food;

public class CentralSeaFoodActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterCentralSeaFood adapterCentralSeaFood;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_sea_food);
        initView();
        initData();
    }
    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterCentralSeaFood = new AdapterCentralSeaFood(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterCentralSeaFood);
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
        Food food = new Food(R.drawable.banh_canh_ghe, getString(R.string.banh_canh_ghe), "","");
        foodList.add(food);
        food = new Food(R.drawable.bun_tom_mien_trung, getString(R.string.bun_tom_mien_trung), "","");
        foodList.add(food);
        food = new Food(R.drawable.bun_sua, getString(R.string.bun_sua), "","");
        foodList.add(food);
        food = new Food(R.drawable.cha_ram_tom, getString(R.string.cha_ram_tom), "","");
        foodList.add(food);
        adapterCentralSeaFood.notifyDataSetChanged();
    }
}
