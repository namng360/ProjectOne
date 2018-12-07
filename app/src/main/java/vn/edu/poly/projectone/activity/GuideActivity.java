package vn.edu.poly.projectone.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import vn.edu.poly.projectone.R;

public class GuideActivity extends AppCompatActivity {
    TextView tvTitle;
    TextView tvResources;
    TextView tvCook;
    String name, re, cook;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_back);
        toolBar.setTitle(getString(R.string.huong_dan));
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        tvTitle = findViewById(R.id.tvTitle);
        tvResources = findViewById(R.id.tvResources);
        tvCook = findViewById(R.id.tvCook);

        Intent in = getIntent();
        Bundle bundle = in.getExtras();
        name = bundle.getString("NAME");
        re = bundle.getString("RE");
        cook = bundle.getString("COOK");

        tvTitle.setText(name);
        tvResources.setText(re);
        tvCook.setText(cook);
    }
}
