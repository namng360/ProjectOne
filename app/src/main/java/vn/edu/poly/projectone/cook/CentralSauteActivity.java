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
import vn.edu.poly.projectone.adapter.central.AdapterCentralSaute;
import vn.edu.poly.projectone.model.Food;

public class CentralSauteActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterCentralSaute adapterCentralSaute;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_saute);

        initView();
        initData();
    }
    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterCentralSaute = new AdapterCentralSaute(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterCentralSaute);
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
        Food food = new Food(R.drawable.bo_xao_pho, getString(R.string.bo_xao_pho),
                getString(R.string.bo_xao_pho_1) + "\n" + getString(R.string.bo_xao_pho_2) + "\n" + getString(R.string.bo_xao_pho_3) + "\n"
                        + getString(R.string.bo_xao_pho_4) + "\n" + getString(R.string.bo_xao_pho_5) + "\n" + getString(R.string.bo_xao_pho_6)
                        + "\n" + getString(R.string.bo_xao_pho_7)+ "\n" + getString(R.string.bo_xao_pho_8)
                        + "\n" + getString(R.string.bo_xao_pho_10),
                getString(R.string.bo_xao_pho_11) + "\n" + getString(R.string.bo_xao_pho_12) + "\n" + getString(R.string.bo_xao_pho_13) + "\n"
                        + getString(R.string.bo_xao_pho_14) + "\n" + getString(R.string.bo_xao_pho_15));
        foodList.add(food);
        food = new Food(R.drawable.thit_xao_mam_ruoc, getString(R.string.thit_xao_mam_ruoc),
                getString(R.string.thit_xao_mam_ruoc_1) + "\n" + getString(R.string.thit_xao_mam_ruoc_2) + "\n" + getString(R.string.thit_xao_mam_ruoc_3) + "\n"
                        + getString(R.string.thit_xao_mam_ruoc_4) + "\n" + getString(R.string.thit_xao_mam_ruoc_5)+ "\n" + getString(R.string.thit_xao_mam_ruoc_6),
                getString(R.string.thit_xao_mam_ruoc_7) + "\n" + getString(R.string.thit_xao_mam_ruoc_8) + "\n" + getString(R.string.thit_xao_mam_ruoc_9));
        foodList.add(food);
        food = new Food(R.drawable.bun_nghe_xao_long, getString(R.string.bun_nghe_xao_long),
                getString(R.string.bun_nghe_xao_long_1) + "\n" + getString(R.string.bun_nghe_xao_long_2) + "\n" + getString(R.string.bun_nghe_xao_long_3) + "\n"
                        + getString(R.string.bun_thit_nuong_4) + "\n" + getString(R.string.bun_nghe_xao_long_5)+ "\n" + getString(R.string.bun_nghe_xao_long_6),
                getString(R.string.bun_nghe_xao_long_7) + "\n" + getString(R.string.bun_nghe_xao_long_8) + "\n" + getString(R.string.bun_nghe_xao_long_9) + "\n"
                        + getString(R.string.bun_nghe_xao_long_10) + "\n" + getString(R.string.bun_nghe_xao_long_11));
        foodList.add(food);
        food = new Food(R.drawable.oc_hut_xao_dua, getString(R.string.oc_hut_xao_dua),
                getString(R.string.oc_hut_xao_dua_1) + "\n" + getString(R.string.oc_hut_xao_dua_2) + "\n" + getString(R.string.oc_hut_xao_dua_3) + "\n"
                        + getString(R.string.oc_hut_xao_dua_4),
                getString(R.string.oc_hut_xao_dua_5) + "\n" + getString(R.string.oc_hut_xao_dua_6) + "\n" + getString(R.string.oc_hut_xao_dua_7) + "\n"
                        + getString(R.string.oc_hut_xao_dua_8));
        foodList.add(food);
        adapterCentralSaute.notifyDataSetChanged();
    }
}
