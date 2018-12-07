package vn.edu.poly.projectone.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;

import android.view.View;
import android.widget.LinearLayout;

import java.util.Locale;

import vn.edu.poly.projectone.R;

public class ChageLanguageActivity extends AppCompatActivity {
    private LinearLayout lnEn, lnVn;
    Locale locale;
    private Toolbar toolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chage_language);
        toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_back);
        toolBar.setTitle(getString(R.string.chage_language));
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        lnEn = findViewById(R.id.lnEn);
        lnVn = findViewById(R.id.lnVn);

        lnEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locale = new Locale("en", "GB");
                chageLangguage(locale);
            }
        });
        lnVn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locale = new Locale("vi", "VN");
                chageLangguage(locale);
            }
        });
    }


    public void chageLangguage(Locale locale){
        DisplayMetrics displayMetrics = getBaseContext().getResources().getDisplayMetrics();
        Configuration config = new Configuration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
            config.setLocale(locale);
        } else {
            config.locale = locale;
        }

        getBaseContext().getResources().updateConfiguration(config, displayMetrics);
        Intent intent = new Intent(ChageLanguageActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }
}
