package vn.edu.poly.projectone.cook;

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
import vn.edu.poly.projectone.adapter.northern.AdapterNorthernFried;
import vn.edu.poly.projectone.model.Food;

public class NorthernFriedActivity extends AppCompatActivity {

    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterNorthernFried adapterNorthernFried;
    private Toolbar toolBar;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_northern_fried);

        initView();
        initData();
    }
    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterNorthernFried = new AdapterNorthernFried(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterNorthernFried);
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
        Food food = new Food(R.drawable.banh_tom, getString(R.string.banh_tom),
                getString(R.string.banh_tom_1) + "\n" + getString(R.string.banh_tom_2) + "\n" + getString(R.string.banh_tom_3) + "\n"
                        + getString(R.string.banh_tom_4) + "\n" + getString(R.string.banh_tom_5)+ "\n" + getString(R.string.banh_tom_6)
                        + "\n" + getString(R.string.banh_tom_7)+ "\n" + getString(R.string.banh_tom_8)+ "\n" + getString(R.string.banh_tom_9),
                getString(R.string.banh_tom_10) + "\n" + getString(R.string.banh_tom_11) + "\n" + getString(R.string.banh_tom_12) + "\n"
                        + getString(R.string.banh_tom_13) + "\n" + getString(R.string.banh_tom_14)+ "\n" + getString(R.string.banh_tom_15));
        foodList.add(food);
        food = new Food(R.drawable.dau_phu_chien_gion, getString(R.string.dau_phu_chien_xu),
                getString(R.string.dau_phu_chien_xu_1) + "\n" + getString(R.string.dau_phu_chien_xu_2) + "\n" + getString(R.string.dau_phu_chien_xu_3),
                getString(R.string.dau_phu_chien_xu_4) + "\n" + getString(R.string.dau_phu_chien_xu_5) + "\n" + getString(R.string.dau_phu_chien_xu_6));
        foodList.add(food);
        food = new Food(R.drawable.nem_ran, getString(R.string.nem_ran),
                getString(R.string.nem_ran_1) + "\n" + getString(R.string.nem_ran_2) + "\n" + getString(R.string.nem_ran_3) + "\n"
                        + getString(R.string.nem_ran_4) + "\n" + getString(R.string.nem_ran_5)+ "\n" + getString(R.string.nem_ran_6)
                        + "\n" + getString(R.string.nem_ran_7)+ "\n" + getString(R.string.nem_ran_8)+ "\n" + getString(R.string.nem_ran_9)
                        + "\n" + getString(R.string.nem_ran_10),
                getString(R.string.nem_ran_11) + "\n" + getString(R.string.nem_ran_12) + "\n" + getString(R.string.nem_ran_13) + "\n"
                        + getString(R.string.nem_ran_14));
        foodList.add(food);
        food = new Food(R.drawable.muc_chien_bo, getString(R.string.muc_chien_bo),
                getString(R.string.muc_chien_bo_1) + "\n" + getString(R.string.muc_chien_bo_2)
                        + "\n" + getString(R.string.muc_chien_bo_3) + "\n"
                        + getString(R.string.muc_chien_bo_4) + "\n" + getString(R.string.muc_chien_bo_5)
                        + "\n" + getString(R.string.muc_chien_bo_6),
                getString(R.string.muc_chien_bo_7) + "\n" + getString(R.string.muc_chien_bo_8)
                        + "\n" + getString(R.string.muc_chien_bo_9) + "\n"
                        + getString(R.string.muc_chien_bo_10) + "\n" + getString(R.string.muc_chien_bo_11));
        foodList.add(food);
        adapterNorthernFried.notifyDataSetChanged();
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
                adapterNorthernFried.setfilter(filtermodelist);
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
