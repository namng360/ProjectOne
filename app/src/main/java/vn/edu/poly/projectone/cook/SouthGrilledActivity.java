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
import vn.edu.poly.projectone.adapter.south.AdapterSouthGrilled;
import vn.edu.poly.projectone.model.Food;

public class SouthGrilledActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterSouthGrilled adapterSouthGrilled;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_south_grilled);

        initView();
        initData();
    }
    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterSouthGrilled = new AdapterSouthGrilled(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterSouthGrilled);
        toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_back);
        toolBar.setTitle(getString(R.string.mon_nuong));
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initData() {
        Food food = new Food(R.drawable.hau_nuong_mo_hanh, getString(R.string.hau_nuong_mo_hanh), "","");
        foodList.add(food);
        food = new Food(R.drawable.hau_nuong_pho_mai, getString(R.string.hau_nuong_pho_mai), "","");
        foodList.add(food);
        food = new Food(R.drawable.bo_nuong_la_lot, getString(R.string.bo_nuong_la_lot), "","");
        foodList.add(food);
        food = new Food(R.drawable.bach_tuoc_nuong_muoi_ot, getString(R.string.bach_tuoc_nuong_muoi_ot), "","");
        foodList.add(food);
        food = new Food(R.drawable.bach_tuoc_nuong_sa_te, getString(R.string.bach_tuoc_nuong_sa_te), "","");
        foodList.add(food);
        adapterSouthGrilled.notifyDataSetChanged();
    }
}
