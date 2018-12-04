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
        Food food = new Food(R.drawable.banh_canh_ghe, getString(R.string.banh_canh_ghe),
                getString(R.string.banh_canh_ghe_1) + "\n" + getString(R.string.banh_canh_ghe_2)
                        + "\n" + getString(R.string.banh_canh_ghe_3) + "\n"
                        + getString(R.string.banh_canh_ghe_4) + "\n" + getString(R.string.banh_canh_ghe_5)
                        + "\n" + getString(R.string.banh_canh_ghe_6) + "\n" + getString(R.string.banh_canh_ghe_7)
                        + "\n" + getString(R.string.banh_canh_ghe_8) + "\n"
                        + getString(R.string.banh_canh_ghe_9) + "\n" + getString(R.string.banh_canh_ghe_10),
                getString(R.string.banh_canh_ghe_11) + "\n" + getString(R.string.banh_canh_ghe_12)
                        + "\n" + getString(R.string.banh_canh_ghe_13) + "\n"
                        + getString(R.string.banh_canh_ghe_14) + "\n" + getString(R.string.banh_canh_ghe_15));
        foodList.add(food);
        food = new Food(R.drawable.hau_nuong_mo_hanh, getString(R.string.hau_nuong_mo_hanh),
                getString(R.string.hau_nuong_mo_hanh_1) + "\n" + getString(R.string.hau_nuong_mo_hanh_2)
                        + "\n" + getString(R.string.hau_nuong_mo_hanh_3) + "\n"
                        + getString(R.string.hau_nuong_mo_hanh_4),
                getString(R.string.hau_nuong_mo_hanh_5) + "\n" + getString(R.string.hau_nuong_mo_hanh_6)
                        + "\n" + getString(R.string.hau_nuong_mo_hanh_7) + "\n"
                        + getString(R.string.hau_nuong_mo_hanh_8));
        foodList.add(food);
        food = new Food(R.drawable.hau_nuong_pho_mai, getString(R.string.hau_nuong_pho_mai),
                getString(R.string.hau_nuong_pho_mai_1) + "\n" + getString(R.string.hau_nuong_pho_mai_2)
                        + "\n" + getString(R.string.hau_nuong_pho_mai_3) + "\n"
                        + getString(R.string.hau_nuong_pho_mai_4) + "\n" + getString(R.string.hau_nuong_pho_mai_5)
                        + "\n" + getString(R.string.hau_nuong_pho_mai_6),
                getString(R.string.hau_nuong_pho_mai_7) + "\n" + getString(R.string.hau_nuong_pho_mai_8)
                        + "\n" + getString(R.string.hau_nuong_pho_mai_9) + "\n"
                        + getString(R.string.hau_nuong_pho_mai_10) + "\n" + getString(R.string.hau_nuong_pho_mai_11));
        foodList.add(food);
        food = new Food(R.drawable.bach_tuoc_nuong_muoi_ot, getString(R.string.bach_tuoc_nuong_muoi_ot),
                getString(R.string.bach_tuoc_nuong_muoi_ot_1) + "\n" + getString(R.string.bach_tuoc_nuong_muoi_ot_2)
                        + "\n" + getString(R.string.bach_tuoc_nuong_muoi_ot_3) + "\n"
                        + getString(R.string.bach_tuoc_nuong_muoi_ot_4),
                getString(R.string.bach_tuoc_nuong_muoi_ot_5) + "\n" + getString(R.string.bach_tuoc_nuong_muoi_ot_6)
                        + "\n" + getString(R.string.bach_tuoc_nuong_muoi_ot_7) + "\n"
                        + getString(R.string.bach_tuoc_nuong_muoi_ot_8));
        foodList.add(food);
        adapterCentralSeaFood.notifyDataSetChanged();
    }
}
