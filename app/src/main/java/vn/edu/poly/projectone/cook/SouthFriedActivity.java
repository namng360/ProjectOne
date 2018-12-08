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
import vn.edu.poly.projectone.adapter.south.AdapterSouthFried;
import vn.edu.poly.projectone.model.Food;

public class SouthFriedActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterSouthFried adapterSouthFried;
    private Toolbar toolBar;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_south_fried);
        initView();
        initData();
    }
    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterSouthFried = new AdapterSouthFried(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterSouthFried);
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
        Food food = new Food(R.drawable.nem_ruoi, getString(R.string.nem_ruoi),
                getString(R.string.nem_ruoi_1) + "\n" + getString(R.string.nem_ruoi_2) + "\n" + getString(R.string.nem_ruoi_3) + "\n"
                        + getString(R.string.nem_ruoi_4) + "\n" + getString(R.string.nem_ruoi_5)+ "\n" + getString(R.string.nem_ruoi_6)
                        + "\n" + getString(R.string.nem_ruoi_7) + "\n" + getString(R.string.nem_ruoi_8),
                getString(R.string.nem_ruoi_9) + "\n" + getString(R.string.nem_ruoi_10) + "\n" + getString(R.string.nem_ruoi_11) + "\n"
                        + getString(R.string.nem_ruoi_12) + "\n" + getString(R.string.nem_ruoi_13)+ "\n" + getString(R.string.nem_ruoi_14));
        foodList.add(food);
        food = new Food(R.drawable.bot_chien_trung, getString(R.string.bot_chien_trung),
                getString(R.string.bot_chien_trung_1) + "\n" + getString(R.string.bot_chien_trung_2) + "\n" + getString(R.string.bot_chien_trung_3) + "\n"
                        + getString(R.string.bot_chien_trung_4) + "\n" + getString(R.string.bot_chien_trung_5)+ "\n" + getString(R.string.bot_chien_trung_6)
                        + "\n" + getString(R.string.bot_chien_trung_7),
                getString(R.string.bot_chien_trung_8) + "\n" + getString(R.string.bot_chien_trung_9) + "\n" + getString(R.string.bot_chien_trung_10) + "\n"
                        + getString(R.string.bot_chien_trung_11) + "\n" + getString(R.string.bot_chien_trung_12)+ "\n" + getString(R.string.bot_chien_trung_13)
                        + "\n" + getString(R.string.bot_chien_trung_14) + getString(R.string.bot_chien_trung_15));
        foodList.add(food);
        food = new Food(R.drawable.vien_xoi_chien, getString(R.string.vien_xoi_chien),
                getString(R.string.vien_xoi_chien_1) + "\n" + getString(R.string.vien_xoi_chien_2) + "\n" + getString(R.string.vien_xoi_chien_3) + "\n"
                        + getString(R.string.vien_xoi_chien_5) + "\n" + getString(R.string.vien_xoi_chien_6),
                getString(R.string.vien_xoi_chien_7) + "\n" + getString(R.string.vien_xoi_chien_8) + "\n" + getString(R.string.vien_xoi_chien_9) + "\n"
                        + getString(R.string.vien_xoi_chien_10));
        foodList.add(food);
        food = new Food(R.drawable.trung_cut_lon_chien, getString(R.string.trung_cut_lon_chien),
                getString(R.string.trung_cut_lon_chien_1) + "\n" + getString(R.string.trung_cut_lon_chien_2) + "\n" + getString(R.string.trung_cut_lon_chien_3) + "\n"
                        + getString(R.string.trung_cut_lon_chien_4),
                getString(R.string.trung_cut_lon_chien_5) + "\n" + getString(R.string.trung_cut_lon_chien_6) + "\n" + getString(R.string.trung_cut_lon_chien_7) + "\n"
                        + getString(R.string.trung_cut_lon_chien_8) + "\n" + getString(R.string.trung_cut_lon_chien_9)+ "\n" + getString(R.string.trung_cut_lon_chien_10));
        foodList.add(food);
        adapterSouthFried.notifyDataSetChanged();
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
                adapterSouthFried.setfilter(filtermodelist);
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
