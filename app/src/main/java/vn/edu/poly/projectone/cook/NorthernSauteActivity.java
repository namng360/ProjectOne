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
import vn.edu.poly.projectone.adapter.northern.AdapterNorthernSaute;
import vn.edu.poly.projectone.model.Food;

public class NorthernSauteActivity extends AppCompatActivity {

    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterNorthernSaute adapterNorthernSaute;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_northern_saute);

        initView();
        initData();
    }

    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterNorthernSaute = new AdapterNorthernSaute(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterNorthernSaute);
        toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_back);
        toolBar.setTitle(getString(R.string.mon_xao));
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initData() {
        Food food = new Food(R.drawable.bo_xao_pho, getString(R.string.bo_xao_pho), "","");
        foodList.add(food);
        food = new Food(R.drawable.gia_do_xao_dau, getString(R.string.gia_do_xao_dau), "","");
        foodList.add(food);
        food = new Food(R.drawable.rau_muong_xao_thit_bo, getString(R.string.rau_muong_xao_thit_bo), "","");
        foodList.add(food);

        adapterNorthernSaute.notifyDataSetChanged();
    }
}
