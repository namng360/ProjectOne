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
import vn.edu.poly.projectone.adapter.south.AdapterSouthSaute;
import vn.edu.poly.projectone.model.Food;

public class SouthSauteActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterSouthSaute adapterSouthSaute;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_south_saute);

        initView();
        initData();
    }
    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterSouthSaute = new AdapterSouthSaute(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterSouthSaute);
        toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_back);
        toolBar.setTitle("Món xào");
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initData() {
        Food food = new Food(R.drawable.tom_xao_cay, getString(R.string.tom_xao_cay), "","");
        foodList.add(food);
        food = new Food(R.drawable.ga_xao_cay, getString(R.string.ga_xao_cay), "","");
        foodList.add(food);
        food = new Food(R.drawable.sup_lo_xao_suc_xich, getString(R.string.sup_lo_xao_suc_xich), "","");
        foodList.add(food);
        food = new Food(R.drawable.bong_cai_xao_suc_xich, getString(R.string.bong_cai_xao_thit_bo), "","");
        foodList.add(food);
        adapterSouthSaute.notifyDataSetChanged();
    }
}
