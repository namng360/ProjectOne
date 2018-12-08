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
import vn.edu.poly.projectone.adapter.central.AdapterCentralCow;
import vn.edu.poly.projectone.model.Food;

public class CentralCowActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterCentralCow adapterCentralCow;
    private Toolbar toolBar;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_cow);
        initView();
        initData();
    }

    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterCentralCow = new AdapterCentralCow(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterCentralCow);
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
        Food food = new Food(R.drawable.cha_bo, getString(R.string.cha_bo),
                getString(R.string.cha_bo_1) + "\n" + getString(R.string.cha_bo_2)
                        + "\n" + getString(R.string.cha_bo_3),
                getString(R.string.cha_bo_4) + "\n" + getString(R.string.cha_bo_5)
                        + "\n" + getString(R.string.cha_bo_6) + "\n"
                        + getString(R.string.cha_bo_7));
        foodList.add(food);
        food = new Food(R.drawable.thit_bo_rim, getString(R.string.thit_bo_rim),
                getString(R.string.thit_bo_rim_1) + "\n" + getString(R.string.thit_bo_rim_2)
                        + "\n" + getString(R.string.thit_bo_rim_3) + "\n"
                        + getString(R.string.thit_bo_rim_4) + "\n" + getString(R.string.thit_bo_rim_5),
                getString(R.string.thit_bo_rim_6) + "\n" + getString(R.string.thit_bo_rim_7)
                        + "\n" + getString(R.string.thit_bo_rim_8) + "\n"
                        + getString(R.string.thit_bo_rim_9));
        foodList.add(food);
        food = new Food(R.drawable.de_bo, getString(R.string.de_bo_tay_son),
                getString(R.string.de_bo_tay_son_1) + "\n" + getString(R.string.de_bo_tay_son_2)
                        + "\n" + getString(R.string.de_bo_tay_son_3) + "\n"
                        + getString(R.string.de_bo_tay_son_4) + "\n" + getString(R.string.de_bo_tay_son_5)
                        + "\n" + getString(R.string.de_bo_tay_son_6) + "\n" + getString(R.string.de_bo_tay_son_7),
                getString(R.string.de_bo_tay_son_8) + "\n" + getString(R.string.de_bo_tay_son_9)
                        + "\n" + getString(R.string.de_bo_tay_son_10) + "\n"
                        + getString(R.string.de_bo_tay_son_11) + "\n" + getString(R.string.de_bo_tay_son_12));
        foodList.add(food);
        food = new Food(R.drawable.bo_xao_pho, getString(R.string.bo_xao_pho),
                getString(R.string.bo_xao_pho_1) + "\n" + getString(R.string.bo_xao_pho_2)
                        + "\n" + getString(R.string.bo_xao_pho_3) + "\n"
                        + getString(R.string.bo_xao_pho_4) + "\n" + getString(R.string.bo_xao_pho_5)
                        + "\n" + getString(R.string.bo_xao_pho_6) + "\n" + getString(R.string.bo_xao_pho_7)
                        + "\n" + getString(R.string.bo_xao_pho_8)
                        + "\n" + getString(R.string.bo_xao_pho_10),
                getString(R.string.bo_xao_pho_11) + "\n" + getString(R.string.bo_xao_pho_12)
                        + "\n" + getString(R.string.bo_xao_pho_13) + "\n"
                        + getString(R.string.bo_xao_pho_14) + "\n" + getString(R.string.bo_xao_pho_15));
        foodList.add(food);
        adapterCentralCow.notifyDataSetChanged();
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
                adapterCentralCow.setfilter(filtermodelist);
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
