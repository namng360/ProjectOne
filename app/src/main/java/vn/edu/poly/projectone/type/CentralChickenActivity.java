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
import vn.edu.poly.projectone.adapter.central.AdapterCentralChicken;
import vn.edu.poly.projectone.model.Food;

public class CentralChickenActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterCentralChicken adapterCentralChicken;
    private Toolbar toolBar;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_chicken);
        initView();
        initData();
    }
    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterCentralChicken = new AdapterCentralChicken(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterCentralChicken);
        toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_back);
        toolBar.setTitle(R.string.thit_ga);
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initData() {
        Food food = new Food(R.drawable.ga_nuong_lu_xoi_chay, getString(R.string.ga_nuong_lu_xoi_chay),
                getString(R.string.ga_nuong_lu_xoi_chay_1) + "\n" + getString(R.string.ga_nuong_lu_xoi_chay_2)
                        + "\n" + getString(R.string.ga_nuong_lu_xoi_chay_3) + "\n"
                        + getString(R.string.ga_nuong_lu_xoi_chay_4) + "\n" + getString(R.string.ga_nuong_lu_xoi_chay_5)
                        + "\n" + getString(R.string.ga_nuong_lu_xoi_chay_6),
                getString(R.string.ga_nuong_lu_xoi_chay_7) + "\n" + getString(R.string.ga_nuong_lu_xoi_chay_8)
                        + "\n" + getString(R.string.ga_nuong_lu_xoi_chay_9) + "\n"
                        + getString(R.string.ga_nuong_lu_xoi_chay_10) + "\n" + getString(R.string.ga_nuong_lu_xoi_chay_11)
                        + "\n" + getString(R.string.ga_nuong_lu_xoi_chay_12));
        foodList.add(food);
        food = new Food(R.drawable.com_ga_tam_ky, getString(R.string.com_ga_tam_ky),
                getString(R.string.com_ga_tam_ky_1) + "\n" + getString(R.string.com_ga_tam_ky_2)
                        + "\n" + getString(R.string.com_ga_tam_ky_3) + "\n"
                        + getString(R.string.com_ga_tam_ky_4) + "\n" + getString(R.string.com_ga_tam_ky_5),
                getString(R.string.com_ga_tam_ky_6) + "\n" + getString(R.string.com_ga_tam_ky_7)
                        + "\n" + getString(R.string.com_ga_tam_ky_8) + "\n"
                        + getString(R.string.com_ga_tam_ky_9) + "\n" + getString(R.string.com_ga_tam_ky_10)
                        + "\n" + getString(R.string.com_ga_tam_ky_11) + "\n" + getString(R.string.com_ga_tam_ky_12)
                        + "\n" + getString(R.string.com_ga_tam_ky_13)
                        + "\n" + getString(R.string.com_ga_tam_ky_14));
        foodList.add(food);
        food = new Food(R.drawable.mi_quang_ga, getString(R.string.mi_quang_ga),
                getString(R.string.mi_quang_ga_1) + "\n" + getString(R.string.mi_quang_ga_2)
                        + "\n" + getString(R.string.mi_quang_ga_3) + "\n"
                        + getString(R.string.mi_quang_ga_4) + "\n" + getString(R.string.mi_quang_ga_5)
                        + "\n" + getString(R.string.mi_quang_ga_6) + "\n" + getString(R.string.mi_quang_ga_7)
                        + "\n" + getString(R.string.mi_quang_ga_8)
                        + "\n" + getString(R.string.mi_quang_ga_9) + "\n"
                        + getString(R.string.mi_quang_ga_10),
                getString(R.string.mi_quang_ga_11) + "\n" + getString(R.string.mi_quang_ga_12)
                        + "\n" + getString(R.string.mi_quang_ga_13) + "\n"
                        + getString(R.string.mi_quang_ga_14) + "\n" + getString(R.string.mi_quang_ga_15));
        foodList.add(food);
        food = new Food(R.drawable.ga_kho_sa, getString(R.string.ga_kho_sa),
                getString(R.string.ga_kho_sa_1) + "\n" + getString(R.string.ga_kho_sa_2)
                        + "\n" + getString(R.string.ga_kho_sa_3) + "\n"
                        + getString(R.string.ga_kho_sa_4) + "\n" + getString(R.string.ga_kho_sa_5)
                        + "\n" + getString(R.string.ga_kho_sa_6) + "\n" + getString(R.string.ga_kho_sa_7),
                getString(R.string.ga_kho_sa_8) + "\n" + getString(R.string.ga_kho_sa_9)
                        + "\n" + getString(R.string.ga_kho_sa_10) + "\n"
                        + getString(R.string.ga_kho_sa_11) + "\n" + getString(R.string.ga_kho_sa_12));
        foodList.add(food);
        adapterCentralChicken.notifyDataSetChanged();
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
                adapterCentralChicken.setfilter(filtermodelist);
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
