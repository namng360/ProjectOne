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
import vn.edu.poly.projectone.adapter.south.AdapterSouthSaute;
import vn.edu.poly.projectone.model.Food;

public class SouthSauteActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterSouthSaute adapterSouthSaute;
    private Toolbar toolBar;
    SearchView searchView;
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
        Food food = new Food(R.drawable.tom_xao_cay, getString(R.string.tom_xao_cay),
                getString(R.string.tom_xao_cay_1) + "\n" + getString(R.string.tom_xao_cay_2)
                        + "\n" + getString(R.string.tom_xao_cay_3) + "\n"
                        + getString(R.string.tom_xao_cay_4) + "\n" + getString(R.string.tom_xao_cay_5)
                        + "\n" + getString(R.string.tom_xao_cay_6),
                getString(R.string.tom_xao_cay_7) + "\n" + getString(R.string.tom_xao_cay_8)
                        + "\n" + getString(R.string.tom_xao_cay_9) + "\n"
                        + getString(R.string.tom_xao_cay_10) + "\n" + getString(R.string.tom_xao_cay_11));
        foodList.add(food);
        food = new Food(R.drawable.ga_xao_cay, getString(R.string.ga_xao_cay),
                getString(R.string.ga_xao_cay_1) + "\n" + getString(R.string.ga_xao_cay_2)
                        + "\n" + getString(R.string.ga_xao_cay_3) + "\n"
                        + getString(R.string.ga_xao_cay_4),
                getString(R.string.ga_xao_cay_5) + "\n" + getString(R.string.ga_xao_cay_6)
                        + "\n" + getString(R.string.ga_xao_cay_7) + "\n"
                        + getString(R.string.ga_xao_cay_8) + "\n" + getString(R.string.ga_xao_cay_9));
        foodList.add(food);
        food = new Food(R.drawable.sup_lo_xao_suc_xich, getString(R.string.sup_lo_xao_suc_xich),
                getString(R.string.sup_lo_xao_suc_xich_1) + "\n" + getString(R.string.sup_lo_xao_suc_xich_2)
                        + "\n" + getString(R.string.sup_lo_xao_suc_xich_3) + "\n"
                        + getString(R.string.sup_lo_xao_suc_xich_4),
                getString(R.string.sup_lo_xao_suc_xich_5) + "\n" + getString(R.string.sup_lo_xao_suc_xich_6)
                        + "\n" + getString(R.string.sup_lo_xao_suc_xich_7) + "\n"
                        + getString(R.string.sup_lo_xao_suc_xich_8));
        foodList.add(food);
        food = new Food(R.drawable.bong_cai_xao_suc_xich, getString(R.string.bong_cai_xao_thit_bo),
                getString(R.string.bong_cai_xao_thit_bo_1) + "\n" + getString(R.string.bong_cai_xao_thit_bo_2)
                        + "\n" + getString(R.string.bong_cai_xao_thit_bo_3) + "\n"
                        + getString(R.string.bong_cai_xao_thit_bo_4) + "\n"
                        + getString(R.string.bong_cai_xao_thit_bo_5) + "\n" + getString(R.string.bong_cai_xao_thit_bo_6)
                        + "\n" + getString(R.string.bong_cai_xao_thit_bo_7) + "\n"
                        + getString(R.string.bong_cai_xao_thit_bo_8) + "\n" + getString(R.string.bong_cai_xao_thit_bo_9)
                        + "\n" + getString(R.string.bong_cai_xao_thit_bo_10),
                getString(R.string.bong_cai_xao_thit_bo_11) + "\n" + getString(R.string.bong_cai_xao_thit_bo_12)
                        + "\n" + getString(R.string.bong_cai_xao_thit_bo_13) + "\n"
                        + getString(R.string.bong_cai_xao_thit_bo_14) + "\n" + getString(R.string.bong_cai_xao_thit_bo_15));
        foodList.add(food);
        adapterSouthSaute.notifyDataSetChanged();
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
                adapterSouthSaute.setfilter(filtermodelist);
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
