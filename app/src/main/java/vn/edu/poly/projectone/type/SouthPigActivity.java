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
import vn.edu.poly.projectone.adapter.south.AdapterSouthPig;
import vn.edu.poly.projectone.model.Food;

public class SouthPigActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterSouthPig adapterSouthPig;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_south_pig);

        initView();
        initData();
    }
    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterSouthPig = new AdapterSouthPig(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterSouthPig);
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
        Food food = new Food(R.drawable.thit_ba_chi_kho_trung, getString(R.string.thit_ba_chi_kho_trung),
                getString(R.string.thit_ba_chi_kho_trung_1) + "\n" + getString(R.string.thit_ba_chi_kho_trung_2)
                        + "\n" + getString(R.string.thit_ba_chi_kho_trung_3) + "\n"
                        + getString(R.string.thit_ba_chi_kho_trung_4),
                getString(R.string.thit_ba_chi_kho_trung_5) + "\n" + getString(R.string.thit_ba_chi_kho_trung_6)
                        + "\n" + getString(R.string.thit_ba_chi_kho_trung_7) + "\n"
                        + getString(R.string.thit_ba_chi_kho_trung_8) + "\n" + getString(R.string.thit_ba_chi_kho_trung_9)
                        + "\n" + getString(R.string.thit_ba_chi_kho_trung_10));
        foodList.add(food);
        food = new Food(R.drawable.thit_quay_gion_bi, getString(R.string.thit_quay_gion_bi),
                getString(R.string.thit_quay_gion_bi_1) + "\n" + getString(R.string.thit_quay_gion_bi_2)
                        + "\n" + getString(R.string.thit_quay_gion_bi_3) + "\n"
                        + getString(R.string.thit_quay_gion_bi_4) + "\n" + getString(R.string.thit_quay_gion_bi_5)
                        + "\n" + getString(R.string.thit_quay_gion_bi_6) + "\n" + getString(R.string.thit_quay_gion_bi_7)
                        + "\n" + getString(R.string.thit_quay_gion_bi_8),
                getString(R.string.thit_quay_gion_bi_9) + "\n" + getString(R.string.thit_quay_gion_bi_10)
                        + "\n" + getString(R.string.thit_quay_gion_bi_11) + "\n"
                        + getString(R.string.thit_quay_gion_bi_12) + "\n" + getString(R.string.thit_quay_gion_bi_13));
        foodList.add(food);
        food = new Food(R.drawable.kho_quet, getString(R.string.kho_quet),
                getString(R.string.kho_quet_1) + "\n" + getString(R.string.kho_quet_2)
                        + "\n" + getString(R.string.kho_quet_3) + "\n"
                        + getString(R.string.kho_quet_4) + "\n" + getString(R.string.kho_quet_5)
                        + "\n" + getString(R.string.kho_quet_6) + "\n" + getString(R.string.kho_quet_7)
                        + "\n" + getString(R.string.kho_quet_8),
                getString(R.string.kho_quet_9) + "\n" + getString(R.string.kho_quet_10)
                        + "\n" + getString(R.string.kho_quet_11) + "\n"
                        + getString(R.string.kho_quet_12) + "\n" + getString(R.string.kho_quet_13)
                        + "\n" + getString(R.string.kho_quet_14));
        foodList.add(food);
        food = new Food(R.drawable.banh_trang_cuon_thit_heo, getString(R.string.banh_trang_cuon_thit_heo),
                getString(R.string.banh_trang_cuon_thit_heo_1) + "\n" + getString(R.string.banh_trang_cuon_thit_heo_2)
                        + "\n" + getString(R.string.banh_trang_cuon_thit_heo_3) + "\n"
                        + getString(R.string.banh_trang_cuon_thit_heo_4) + "\n" + getString(R.string.banh_trang_cuon_thit_heo_5)
                        + "\n" + getString(R.string.banh_trang_cuon_thit_heo_6),
                getString(R.string.banh_trang_cuon_thit_heo_7) + "\n" + getString(R.string.banh_trang_cuon_thit_heo_8)
                        + "\n" + getString(R.string.banh_trang_cuon_thit_heo_9) + "\n"
                        + getString(R.string.banh_trang_cuon_thit_heo_10) + "\n" + getString(R.string.banh_trang_cuon_thit_heo_11));
        foodList.add(food);
        adapterSouthPig.notifyDataSetChanged();
    }
}
