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
import vn.edu.poly.projectone.adapter.AdapterGrilled;
import vn.edu.poly.projectone.model.Model;

public class NorthernGrilledActivity extends AppCompatActivity {

    private List<Model> modelList;
    private RecyclerView rcView;
    private AdapterGrilled adapterGrilled;
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
        modelList = new ArrayList<>();
        adapterGrilled = new AdapterGrilled(this, modelList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterGrilled);
        toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_back);
        toolBar.setTitle("Món nướng");
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initData() {
        Model model = new Model("", getString(R.string.thit_ba_chi));
        modelList.add(model);
        model = new Model("", getString(R.string.thit_xien_nuong));
        modelList.add(model);
        model = new Model("", getString(R.string.moon_cake));
        modelList.add(model);
        model = new Model("", getString(R.string.banh_my_muoi_ot));
        modelList.add(model);
        adapterGrilled.notifyDataSetChanged();
    }
}
