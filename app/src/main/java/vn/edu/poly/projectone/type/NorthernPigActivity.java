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
        Food food = new Food(R.drawable.thit_lon_rim_nuoc_mam, getString(R.string.thit_lon_rim_nuoc_mam),
                getString(R.string.thit_lon_rim_nuoc_mam_1) + "\n" + getString(R.string.thit_lon_rim_nuoc_mam_2)
                        + "\n" + getString(R.string.thit_lon_rim_nuoc_mam_3) + "\n"
                        + getString(R.string.thit_lon_rim_nuoc_mam_4) + "\n" + getString(R.string.thit_lon_rim_nuoc_mam_5),
                getString(R.string.thit_lon_rim_nuoc_mam_6) + "\n" + getString(R.string.thit_lon_rim_nuoc_mam_7)
                        + "\n" + getString(R.string.thit_lon_rim_nuoc_mam_8) + "\n"
                        + getString(R.string.thit_lon_rim_nuoc_mam_9) + "\n" + getString(R.string.thit_lon_rim_nuoc_mam_10));
        foodList.add(food);
        food = new Food(R.drawable.thit_lon_nau_dong, getString(R.string.thit_lon_nau_dong),
                getString(R.string.thit_lon_nau_dong_1) + "\n" + getString(R.string.thit_lon_nau_dong_2)
                        + "\n" + getString(R.string.thit_lon_nau_dong_3) + "\n"
                        + getString(R.string.thit_lon_nau_dong_4),
                getString(R.string.thit_lon_nau_dong_5) + "\n" + getString(R.string.thit_lon_nau_dong_6)
                        + "\n" + getString(R.string.thit_lon_nau_dong_7) + "\n"
                        + getString(R.string.thit_lon_nau_dong_8) + "\n" + getString(R.string.thit_lon_nau_dong_9)
                        + "\n" + getString(R.string.thit_lon_nau_dong_10));
        foodList.add(food);
        food = new Food(R.drawable.thit_kho_tau, getString(R.string.thit_kho_tau),
                getString(R.string.thit_kho_tau_1) + "\n" + getString(R.string.thit_kho_tau_2)
                        + "\n" + getString(R.string.thit_kho_tau_3) + "\n"
                        + getString(R.string.thit_kho_tau_4),
                getString(R.string.thit_kho_tau_5) + "\n" + getString(R.string.thit_kho_tau_6)
                        + "\n" + getString(R.string.thit_kho_tau_7) + "\n"
                        + getString(R.string.thit_kho_tau_8) + "\n" + getString(R.string.thit_kho_tau_9));
        foodList.add(food);
        food = new Food(R.drawable.pate_lon, getString(R.string.pate_lon),
                getString(R.string.pate_lon_1) + "\n" + getString(R.string.pate_lon_2)
                        + "\n" + getString(R.string.pate_lon_3) + "\n"
                        + getString(R.string.pate_lon_4) + "\n" + getString(R.string.pate_lon_5)
                        + "\n" + getString(R.string.pate_lon_6) + "\n" + getString(R.string.pate_lon_7)
                        + "\n" + getString(R.string.pate_lon_8) + "\n"
                        + getString(R.string.pate_lon_9),
                getString(R.string.pate_lon_10) + "\n" + getString(R.string.pate_lon_11)
                        + "\n" + getString(R.string.pate_lon_12) + "\n"
                        + getString(R.string.pate_lon_13) + "\n" + getString(R.string.pate_lon_14)
                        + "\n" + getString(R.string.pate_lon_15) + "\n" + getString(R.string.pate_lon_16)
                        + "\n" + getString(R.string.pate_lon_17) + "\n"
                        + getString(R.string.pate_lon_18) + "\n" + getString(R.string.pate_lon_19));
        foodList.add(food);
        adapterNorthernPig.notifyDataSetChanged();
    }
}
