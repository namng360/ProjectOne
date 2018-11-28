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
        Food food = new Food(R.drawable.bo_nuong_la_lot, getString(R.string.bo_nuong_la_lot), "","");
        foodList.add(food);
        food = new Food(R.drawable.bo_kho_mien_nam, getString(R.string.bo_kho_mien_nam), "","");
        foodList.add(food);
        food = new Food(R.drawable.bo_kho_nuoc_dua, getString(R.string.bo_kho_nuoc_dua), "","");
        foodList.add(food);
        food = new Food(R.drawable.bo_xot_tieu_xanh, getString(R.string.bo_xot_tieu_xanh), "","");
        foodList.add(food);
        adapterSouthCow.notifyDataSetChanged();
    }
}
