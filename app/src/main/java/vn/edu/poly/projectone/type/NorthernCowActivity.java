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
import vn.edu.poly.projectone.adapter.AdapterCow;
import vn.edu.poly.projectone.model.Food;

public class NorthernCowActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterCow adapterCow;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_northern_cow);

        initView();
        initData();
    }

    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterCow = new AdapterCow(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterCow);
        toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_back);
        toolBar.setTitle("Thịt bò");
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initData() {
        Food food = new Food(R.drawable.mienbac, getString(R.string.bo_sot_vang));
        foodList.add(food);
        food = new Food(R.drawable.miennam, getString(R.string.bo_sot_tieu));
        foodList.add(food);
        food = new Food(R.drawable.mientrung, getString(R.string.pho_bo));
        foodList.add(food);
        food = new Food(R.drawable.hai_san, getString(R.string.bun_bo_bac_bo));
        foodList.add(food);
        adapterCow.notifyDataSetChanged();
    }
}
