package vn.edu.poly.projectone.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import vn.edu.poly.projectone.R;

public class GuideActivity extends AppCompatActivity {
    TextView tvTitle;
    TextView tvResources;
    TextView tvCook;
    String name, re, cook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
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
