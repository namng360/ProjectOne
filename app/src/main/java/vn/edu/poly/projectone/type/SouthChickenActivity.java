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
import vn.edu.poly.projectone.adapter.south.AdapterSouthChicken;
import vn.edu.poly.projectone.model.Food;

public class SouthChickenActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterSouthChicken adapterSouthChicken;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_south_chicken);

        initView();
        initData();
    }
    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterSouthChicken = new AdapterSouthChicken(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterSouthChicken);
        toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_back);
        toolBar.setTitle(getString(R.string.thit_ga));
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initData() {
        Food food = new Food(R.drawable.ga_xao_cay, getString(R.string.ga_xao_cay), "","");
        foodList.add(food);
        food = new Food(R.drawable.cari_ga_mien_nam, getString(R.string.cari_ga_mien_nam), "","");
        foodList.add(food);
        food = new Food(R.drawable.ga_kho_rau_ram, getString(R.string.ga_kho_rau_ram), "","");
        foodList.add(food);
        food = new Food(R.drawable.goi_ga_xe_phay, getString(R.string.goi_ga_xe_phay) , "","");
        foodList.add(food);
        adapterSouthChicken.notifyDataSetChanged();
    }
}
