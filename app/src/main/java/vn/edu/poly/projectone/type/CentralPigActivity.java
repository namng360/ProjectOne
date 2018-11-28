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
import vn.edu.poly.projectone.adapter.central.AdapterCentralPig;
import vn.edu.poly.projectone.model.Food;

public class CentralPigActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterCentralPig adapterCentralPig;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_pig);
        initView();
        initData();
    }
    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterCentralPig = new AdapterCentralPig(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterCentralPig);
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
        Food food = new Food(R.drawable.thit_xao_mam_ruoc, getString(R.string.thit_xao_mam_ruoc), "","");
        foodList.add(food);
        food = new Food(R.drawable.thit_heo_ngam_nuoc_mam, getString(R.string.thit_heo_ngam_nuoc_mam), "","");
        foodList.add(food);
        food = new Food(R.drawable.banh_trang_cuon_thit_heo, getString(R.string.banh_trang_cuon_thit_heo), "","");
        foodList.add(food);
        food = new Food(R.drawable.bun_thit_nuong, getString(R.string.bun_thit_nuong), "","");
        foodList.add(food);
        food = new Food(R.drawable.thit_heo_muoi, getString(R.string.thit_heo_muoi), "","");
        foodList.add(food);
        adapterCentralPig.notifyDataSetChanged();
    }
}
