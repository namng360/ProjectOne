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
import vn.edu.poly.projectone.adapter.northern.AdapterNorthernGrilled;
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
        toolBar.setTitle(R.string.mon_nuong);
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initData() {
        Food food = new Food(R.drawable.ba_chi, getString(R.string.thit_ba_chi),
                getString(R.string.thit_ba_chi_1) + "\n" + getString(R.string.thit_ba_chi_2) + "\n" + getString(R.string.thit_ba_chi_3) + "\n"
                        + getString(R.string.thit_ba_chi_4) + "\n" + getString(R.string.thit_ba_chi_5)+ "\n" + getString(R.string.thit_ba_chi_6)
                        + "\n" + getString(R.string.thit_ba_chi_7),
                getString(R.string.thit_ba_chi_8) + "\n" + getString(R.string.thit_ba_chi_9) + "\n" + getString(R.string.thit_ba_chi_10) + "\n"
                        + getString(R.string.thit_ba_chi_11));
        foodList.add(food);
        food = new Food(R.drawable.xien_nuong, getString(R.string.thit_xien_nuong),
                getString(R.string.thit_xien_nuong_1) + "\n" + getString(R.string.thit_xien_nuong_2) + "\n" + getString(R.string.thit_xien_nuong_3) + "\n"
                        + getString(R.string.thit_xien_nuong_4) + "\n" + getString(R.string.thit_xien_nuong_5)+ "\n" + getString(R.string.thit_xien_nuong_6)
                        + "\n" + getString(R.string.thit_xien_nuong_7),
                getString(R.string.thit_xien_nuong_8) + "\n" + getString(R.string.thit_xien_nuong_9) + "\n" + getString(R.string.thit_xien_nuong_10) + "\n"
                        + getString(R.string.thit_xien_nuong_11) + "\n" + getString(R.string.thit_xien_nuong_12));
        foodList.add(food);
        food = new Food(R.drawable.moon_cake, getString(R.string.moon_cake),
                getString(R.string.moon_cake_1) + "\n" + getString(R.string.moon_cake_2) + "\n" + getString(R.string.moon_cake_3) + "\n"
                        + getString(R.string.moon_cake_4) + "\n" + getString(R.string.moon_cake_5)+ "\n" + getString(R.string.moon_cake_6),
                getString(R.string.moon_cake_7) + "\n" + getString(R.string.moon_cake_8) + "\n" + getString(R.string.moon_cake_9) + "\n"
                        + getString(R.string.moon_cake_10) + "\n" + getString(R.string.moon_cake_11)+ "\n" + getString(R.string.moon_cake_12));
        foodList.add(food);
        food = new Food(R.drawable.muoi_ot, getString(R.string.banh_my_muoi_ot),
                getString(R.string.banh_my_muoi_ot_1) + "\n" + getString(R.string.banh_my_muoi_ot_2)
                        + "\n" + getString(R.string.banh_my_muoi_ot_3) + "\n"
                        + getString(R.string.banh_my_muoi_ot_4) + "\n" + getString(R.string.banh_my_muoi_ot_5),
                getString(R.string.banh_my_muoi_ot_6) + "\n" + getString(R.string.banh_my_muoi_ot_7) + "\n" + getString(R.string.banh_my_muoi_ot_8) + "\n"
                        + getString(R.string.banh_my_muoi_ot_9) + "\n" + getString(R.string.banh_my_muoi_ot_10)+ "\n" + getString(R.string.banh_my_muoi_ot_11));
        foodList.add(food);
        food = new Food(R.drawable.tom_hum_nuong_bo_toi, getString(R.string.tom_hum_nuong_bo_toi),
                getString(R.string.tom_hum_nuong_bo_toi_1) + "\n" + getString(R.string.tom_hum_nuong_bo_toi_2)
                        + "\n" + getString(R.string.tom_hum_nuong_bo_toi_3),
                getString(R.string.tom_hum_nuong_bo_toi_4) + "\n" + getString(R.string.tom_hum_nuong_bo_toi_5)
                        + "\n" + getString(R.string.tom_hum_nuong_bo_toi_6) + "\n"
                        + getString(R.string.tom_hum_nuong_bo_toi_7) + "\n" + getString(R.string.tom_hum_nuong_bo_toi_8));
        foodList.add(food);
        adapterNorthernGrilled.notifyDataSetChanged();
    }
}
