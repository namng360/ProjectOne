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
import vn.edu.poly.projectone.adapter.central.AdapterCentralFried;
import vn.edu.poly.projectone.model.Food;

public class CentralFriedActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterCentralFried adapterCentralFried;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_fried);

        initView();
        initData();
    }
    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterCentralFried = new AdapterCentralFried(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterCentralFried);
        toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_back);
        toolBar.setTitle(getString(R.string.mon_chien));
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initData() {
        Food food = new Food(R.drawable.ram_bap, getString(R.string.ram_bap),
                getString(R.string.ram_bap_1)+"\n"+ getString(R.string.ram_bap_2)+"\n"+getString(R.string.ram_bap_3)
                        +"\n"+getString(R.string.ram_bap_4)+"\n"+getString(R.string.ram_bap_5)+"\n"+getString(R.string.ram_bap_6)
                        +"\n"+getString(R.string.ram_bap_7)+"\n"+getString(R.string.ram_bap_8),
                getString(R.string.ram_bap_9)+"\n"+ getString(R.string.ram_bap_10)+"\n"+getString(R.string.ram_bap_11)
                        +"\n"+getString(R.string.ram_bap_12));
        foodList.add(food);
        food = new Food(R.drawable.banh_can, getString(R.string.banh_can), getString(R.string.banh_can_1)+"\n"
                    + getString(R.string.banh_can_2)+"\n"+getString(R.string.banh_can_3)+"\n"+getString(R.string.banh_can_4)+"\n"
                    + getString(R.string.banh_can_5)+"\n"+getString(R.string.banh_can_6)+"\n"+getString(R.string.banh_can_7)+"\n"
                    + getString(R.string.banh_can_8),
                getString(R.string.banh_can_9)+"\n"+getString(R.string.banh_can_10)+"\n"+getString(R.string.banh_can_11)+"\n"
                    + getString(R.string.banh_can_12)+"\n"+getString(R.string.banh_can_13));
        foodList.add(food);
        food = new Food(R.drawable.trung_chien_mien, getString(R.string.trung_chien_mien),
                getString(R.string.trung_chien_mien_1)+"\n" + getString(R.string.trung_chien_mien_2)+ "\n"
                    + getString(R.string.trung_chien_mien_3) + "\n" + getString(R.string.trung_chien_mien_4),
                getString(R.string.trung_chien_mien_5)+ "\n" + getString(R.string.trung_chien_mien_6)+ "\n"
                    + getString(R.string.trung_chien_mien_7) + "\n" + getString(R.string.trung_chien_mien_8) + "\n"
                    + getString(R.string.trung_chien_mien_9));
        foodList.add(food);
        food = new Food(R.drawable.banh_xeo, getString(R.string.banh_xeo),
                getString(R.string.banh_xeo_1)+"\n" + getString(R.string.banh_xeo_2)+ "\n"
                        + getString(R.string.banh_xeo_3) + "\n" + getString(R.string.banh_xeo_4) + "\n"
                        + getString(R.string.banh_xeo_5) + "\n" + getString(R.string.banh_xeo_5) + "\n"
                        + getString(R.string.banh_xeo_6) + "\n" + getString(R.string.banh_xeo_7) + "\n"
                        + getString(R.string.banh_xeo_8) + "\n" + getString(R.string.banh_xeo_9),
                getString(R.string.banh_xeo_10)+"\n" + getString(R.string.banh_xeo_11)+ "\n"
                        + getString(R.string.banh_xeo_12));
        foodList.add(food);
        adapterCentralFried.notifyDataSetChanged();
    }
}
