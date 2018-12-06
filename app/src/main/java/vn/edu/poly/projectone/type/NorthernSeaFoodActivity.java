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
        Food food = new Food(R.drawable.muc_xao_cay, getString(R.string.muc_xao_cay),
                getString(R.string.muc_xao_cay_1) + "\n" + getString(R.string.muc_xao_cay_2)
                        + "\n" + getString(R.string.muc_xao_cay_3) + "\n"
                        + getString(R.string.muc_xao_cay_4) + "\n" + getString(R.string.muc_xao_cay_5)
                        + "\n" + getString(R.string.muc_xao_cay_6) + "\n" + getString(R.string.muc_xao_cay_7)
                        + "\n" + getString(R.string.muc_xao_cay_8) + "\n"
                        + getString(R.string.muc_xao_cay_9),
                getString(R.string.muc_xao_cay_10) + "\n" + getString(R.string.muc_xao_cay_11)
                        + "\n" + getString(R.string.muc_xao_cay_12) + "\n"
                        + getString(R.string.muc_xao_cay_13) + "\n" + getString(R.string.muc_xao_cay_14));
        foodList.add(food);
        food = new Food(R.drawable.ghe_rang_me, getString(R.string.ghe_rang_me),
                getString(R.string.ghe_rang_me_1) + "\n" + getString(R.string.ghe_rang_me_2)
                        + "\n" + getString(R.string.ghe_rang_me_3) + "\n"
                        + getString(R.string.ghe_rang_me_4) + "\n" + getString(R.string.ghe_rang_me_5)
                        + "\n" + getString(R.string.ghe_rang_me_6),
                getString(R.string.ghe_rang_me_7) + "\n" + getString(R.string.ghe_rang_me_8)
                        + "\n" + getString(R.string.ghe_rang_me_9) + "\n"
                        + getString(R.string.ghe_rang_me_10));
        foodList.add(food);
        food = new Food(R.drawable.muc_chien_bo, getString(R.string.muc_chien_bo),
                getString(R.string.muc_chien_bo_1) + "\n" + getString(R.string.muc_chien_bo_2)
                        + "\n" + getString(R.string.muc_chien_bo_3) + "\n"
                        + getString(R.string.muc_chien_bo_4) + "\n" + getString(R.string.muc_chien_bo_5)
                        + "\n" + getString(R.string.muc_chien_bo_6),
                getString(R.string.muc_chien_bo_7) + "\n" + getString(R.string.muc_chien_bo_8)
                        + "\n" + getString(R.string.muc_chien_bo_9) + "\n"
                        + getString(R.string.muc_chien_bo_10) + "\n" + getString(R.string.muc_chien_bo_11));
        foodList.add(food);
        food = new Food(R.drawable.tom_hum_nuong_bo_toi, getString(R.string.tom_hum_nuong_bo_toi),
                getString(R.string.tom_hum_nuong_bo_toi_1) + "\n" + getString(R.string.tom_hum_nuong_bo_toi_2)
                        + "\n" + getString(R.string.tom_hum_nuong_bo_toi_3),
                getString(R.string.tom_hum_nuong_bo_toi_4) + "\n" + getString(R.string.tom_hum_nuong_bo_toi_5)
                        + "\n" + getString(R.string.tom_hum_nuong_bo_toi_6) + "\n"
                        + getString(R.string.tom_hum_nuong_bo_toi_7) + "\n" + getString(R.string.tom_hum_nuong_bo_toi_8));
        foodList.add(food);
        adapterNorthernSeaFood.notifyDataSetChanged();
    }
}
