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
import vn.edu.poly.projectone.adapter.south.AdapterSouthCow;
import vn.edu.poly.projectone.model.Food;

public class SouthCowActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterSouthCow adapterSouthCow;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_south_cow);
        initView();
        initData();
    }
    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterSouthCow = new AdapterSouthCow(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterSouthCow);
        toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_back);
        toolBar.setTitle(getString(R.string.thit_bo));
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initData() {
        Food food = new Food(R.drawable.bo_nuong_la_lot, getString(R.string.bo_nuong_la_lot),
                getString(R.string.bo_nuong_la_lot_1) + "\n" + getString(R.string.bo_nuong_la_lot_2)
                        + "\n" + getString(R.string.bo_nuong_la_lot_3) + "\n"
                        + getString(R.string.bo_nuong_la_lot_4) + "\n" + getString(R.string.bo_nuong_la_lot_5)
                        + "\n" + getString(R.string.bo_nuong_la_lot_6),
                getString(R.string.bo_nuong_la_lot_7) + "\n" + getString(R.string.bo_nuong_la_lot_8)
                        + "\n" + getString(R.string.bo_nuong_la_lot_9) + "\n"
                        + getString(R.string.bo_nuong_la_lot_10));
        foodList.add(food);
        food = new Food(R.drawable.bo_kho_mien_nam, getString(R.string.bo_kho_mien_nam),
                getString(R.string.bo_kho_mien_nam_1) + "\n" + getString(R.string.bo_kho_mien_nam_2)
                        + "\n" + getString(R.string.bo_kho_mien_nam_3) + "\n"
                        + getString(R.string.bo_kho_mien_nam_4) + "\n"
                + getString(R.string.bo_kho_mien_nam_5),
                getString(R.string.bo_kho_mien_nam_6) + "\n" + getString(R.string.bo_kho_mien_nam_7)
                        + "\n" + getString(R.string.bo_kho_mien_nam_8) + "\n"
                        + getString(R.string.bo_kho_mien_nam_9));
        foodList.add(food);
        food = new Food(R.drawable.bo_kho_nuoc_dua, getString(R.string.bo_kho_nuoc_dua),
                getString(R.string.bo_kho_nuoc_dua_1) + "\n" + getString(R.string.bo_kho_nuoc_dua_2)
                        + "\n" + getString(R.string.bo_kho_nuoc_dua_3) + "\n"
                        + getString(R.string.bo_kho_nuoc_dua_4) + "\n" + getString(R.string.bo_kho_nuoc_dua_5)
                + "\n" + getString(R.string.bo_kho_nuoc_dua_6),
                getString(R.string.bo_kho_nuoc_dua_7) + "\n" + getString(R.string.bo_kho_nuoc_dua_8)
                        + "\n" + getString(R.string.bo_kho_nuoc_dua_9) + "\n"
                        + getString(R.string.bo_kho_nuoc_dua_10) + "\n" + getString(R.string.bo_kho_nuoc_dua_11)
                + "\n" + getString(R.string.bo_kho_nuoc_dua_12));
        foodList.add(food);
        food = new Food(R.drawable.bo_xot_tieu_xanh, getString(R.string.bo_xot_tieu_xanh),
                getString(R.string.bo_xot_tieu_xanh_1) + "\n" + getString(R.string.bo_xot_tieu_xanh_2)
                        + "\n" + getString(R.string.bo_xot_tieu_xanh_3) + "\n"
                        + getString(R.string.bo_xot_tieu_xanh_4) + "\n" + getString(R.string.bo_xot_tieu_xanh_5)
                        + "\n" + getString(R.string.bo_xot_tieu_xanh_6) + "\n" + getString(R.string.bo_xot_tieu_xanh_7)
                        + "\n" + getString(R.string.bo_xot_tieu_xanh_8) + "\n" + getString(R.string.bo_xot_tieu_xanh_9) + "\n"
                        + getString(R.string.bo_xot_tieu_xanh_10),
                getString(R.string.bo_xot_tieu_xanh_11) + "\n" + getString(R.string.bo_xot_tieu_xanh_12)
                        + "\n" + getString(R.string.bo_xot_tieu_xanh_13) + "\n"
                        + getString(R.string.bo_xot_tieu_xanh_14) + "\n" + getString(R.string.bo_xot_tieu_xanh_15));
        foodList.add(food);
        adapterSouthCow.notifyDataSetChanged();
    }
}
