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
import vn.edu.poly.projectone.adapter.south.AdapterSouthCow;
import vn.edu.poly.projectone.model.Food;

public class SouthCowActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterSouthCow adapterSouthCow;
    private Toolbar toolBar;
    SearchView searchView;
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
                adapterSouthCow.setfilter(filtermodelist);
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
