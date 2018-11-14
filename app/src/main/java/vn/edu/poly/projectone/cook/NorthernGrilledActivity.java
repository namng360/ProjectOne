package vn.edu.poly.projectone.cook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.projectone.R;
import vn.edu.poly.projectone.adapter.AdapterNorthernGrilled;
import vn.edu.poly.projectone.model.Food;

public class NorthernGrilledActivity extends AppCompatActivity {

    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterNorthernGrilled adapterNorthernGrilled;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_northern_grilled);
        
        initView();
        initData();
    }

    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterNorthernGrilled = new AdapterNorthernGrilled(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterNorthernGrilled);
        toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_back);
        toolBar.setTitle("Món nướng");
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initData() {
        Food food = new Food(R.drawable.ba_chi, getString(R.string.thit_ba_chi));
        foodList.add(food);
        food = new Food(R.drawable.xien_nuong, getString(R.string.thit_xien_nuong));
        foodList.add(food);
        food = new Food(R.drawable.moon_cake, getString(R.string.moon_cake));
        foodList.add(food);
        food = new Food(R.drawable.muoi_ot, getString(R.string.banh_my_muoi_ot));
        foodList.add(food);
        adapterNorthernGrilled.notifyDataSetChanged();
    }
}
