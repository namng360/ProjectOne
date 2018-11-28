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
import vn.edu.poly.projectone.adapter.northern.AdapterNorthernFried;
import vn.edu.poly.projectone.model.Food;

public class NorthernFriedActivity extends AppCompatActivity {

    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterNorthernFried adapterNorthernFried;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_northern_fried);

        initView();
        initData();
    }
    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterNorthernFried = new AdapterNorthernFried(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterNorthernFried);
        toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_back);
        toolBar.setTitle(getString(R.string.mon_chien));
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initData() {
        Food food = new Food(R.drawable.banh_tom, getString(R.string.banh_tom), "","");
        foodList.add(food);
        food = new Food(R.drawable.dau_phu_chien_gion, getString(R.string.dau_phu_chien_xu), "","");
        foodList.add(food);
        food = new Food(R.drawable.nem_ran, getString(R.string.nem_ran), "","");
        foodList.add(food);
        adapterNorthernFried.notifyDataSetChanged();
    }
}
