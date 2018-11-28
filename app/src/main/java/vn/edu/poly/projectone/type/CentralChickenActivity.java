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
import vn.edu.poly.projectone.adapter.central.AdapterCentralChicken;
import vn.edu.poly.projectone.model.Food;

public class CentralChickenActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterCentralChicken adapterCentralChicken;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_chicken);
        initView();
        initData();
    }
    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterCentralChicken = new AdapterCentralChicken(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterCentralChicken);
        toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_back);
        toolBar.setTitle(R.string.thit_ga);
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initData() {
        Food food = new Food(R.drawable.ga_nuong_lu_xoi_chay, getString(R.string.ga_nuong_lu_xoi_chay), "","");
        foodList.add(food);
        food = new Food(R.drawable.com_ga_tam_ky, getString(R.string.com_ga_tam_ky), "","");
        foodList.add(food);
        food = new Food(R.drawable.mi_quang_ga, getString(R.string.mi_quang_ga), "","");
        foodList.add(food);
        food = new Food(R.drawable.ga_kho_sa, getString(R.string.ga_kho_sa), "","");
        foodList.add(food);
        adapterCentralChicken.notifyDataSetChanged();
    }
}
