package vn.edu.poly.projectone.type;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.projectone.R;
import vn.edu.poly.projectone.adapter.central.AdapterCentralPig;
import vn.edu.poly.projectone.model.Food;

public class CentralPigActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterCentralPig adapterCentralPig;
    private Toolbar toolBar;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_pig);
        initView();
        initData();
    }
    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterCentralPig = new AdapterCentralPig(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterCentralPig);
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
        Food food = new Food(R.drawable.thit_xao_mam_ruoc, getString(R.string.thit_xao_mam_ruoc),
                getString(R.string.thit_xao_mam_ruoc_1) + "\n" + getString(R.string.thit_xao_mam_ruoc_2) + "\n" + getString(R.string.thit_xao_mam_ruoc_3) + "\n"
                        + getString(R.string.thit_xao_mam_ruoc_4) + "\n" + getString(R.string.thit_xao_mam_ruoc_5)+ "\n" + getString(R.string.thit_xao_mam_ruoc_6),
                getString(R.string.thit_xao_mam_ruoc_7) + "\n" + getString(R.string.thit_xao_mam_ruoc_8) + "\n" + getString(R.string.thit_xao_mam_ruoc_9));
        foodList.add(food);;
        foodList.add(food);
        food = new Food(R.drawable.thit_heo_ngam_nuoc_mam, getString(R.string.thit_heo_ngam_nuoc_mam),
                getString(R.string.thit_heo_ngam_nuoc_mam_1) + "\n" + getString(R.string.thit_heo_ngam_nuoc_mam_2)
                        + "\n" + getString(R.string.thit_heo_ngam_nuoc_mam_3) + "\n"
                        + getString(R.string.thit_heo_ngam_nuoc_mam_4) + "\n" + getString(R.string.thit_heo_ngam_nuoc_mam_5),
                getString(R.string.thit_heo_ngam_nuoc_mam_6) + "\n" + getString(R.string.thit_heo_ngam_nuoc_mam_7) + "\n" + getString(R.string.thit_heo_ngam_nuoc_mam_8) + "\n"
                        + getString(R.string.thit_heo_ngam_nuoc_mam_9) + "\n" + getString(R.string.thit_heo_ngam_nuoc_mam_10)+ "\n" + getString(R.string.thit_heo_ngam_nuoc_mam_11));
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
        food = new Food(R.drawable.bun_thit_nuong, getString(R.string.bun_thit_nuong),
                getString(R.string.bun_thit_nuong_1) + "\n" + getString(R.string.bun_thit_nuong_2) + "\n" + getString(R.string.bun_thit_nuong_3) + "\n"
                        + getString(R.string.bun_thit_nuong_4) + "\n" + getString(R.string.bun_thit_nuong_5) + "\n" + getString(R.string.bun_thit_nuong_6)
                        + "\n" + getString(R.string.bun_thit_nuong_7) + "\n" + getString(R.string.bun_thit_nuong_8),
                getString(R.string.bun_thit_nuong_9) + "\n" + getString(R.string.bun_thit_nuong_10) + "\n" + getString(R.string.bun_thit_nuong_11));
        foodList.add(food);
        adapterCentralPig.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        final MenuItem myActionMenuItem = menu.findItem(R.id.search);
        searchView = (SearchView) myActionMenuItem.getActionView();
        changeSearchViewTextColor(searchView);
        ((EditText) searchView.findViewById(
                android.support.v7.appcompat.R.id.search_src_text)).
                setHintTextColor(getResources().getColor(R.color.white));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                final  List<Food> filtermodelist=filter(foodList,newText);
                adapterCentralPig.setfilter(filtermodelist);
                return true;
            }
        });
        return true;
    }
    private List<Food> filter(List<Food> pl,String query) {
        query=query.toLowerCase();
        final List<Food> filteredModeList=new ArrayList<>();
        for (Food model:pl)
        {
            final String text=model.getTitle().toLowerCase();
            if (text.startsWith(query)) {
                filteredModeList.add(model);
            }
        }
        return filteredModeList;
    }
    //for changing the text color of searchview
    private void changeSearchViewTextColor(View view) {
        if (view != null) {
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(Color.BLACK);
                return;
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    changeSearchViewTextColor(viewGroup.getChildAt(i));
                }
            }
        }
    }
}
