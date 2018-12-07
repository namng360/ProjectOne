package vn.edu.poly.projectone.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.projectone.R;
import vn.edu.poly.projectone.adapter.AdapterDiary;
import vn.edu.poly.projectone.dao.DiaryDAO;
import vn.edu.poly.projectone.database.DatabaseHelper;
import vn.edu.poly.projectone.model.Diary;

public class DiaryActivity extends AppCompatActivity {
    private RecyclerView rcView;
    private AdapterDiary adapterDiary;
    private List<Diary> diaryList;
    private DatabaseHelper databaseHelper;
    private DiaryDAO diaryDAO;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        innitView();

    }

    private void innitView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.menu_diary));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiaryActivity.this, AddDiaryActivity.class);
                startActivity(intent);
                finish();
            }
        });
        databaseHelper = new DatabaseHelper(this);
        diaryDAO = new DiaryDAO(databaseHelper);
        rcView = findViewById(R.id.rcView);
        diaryList = new ArrayList<>();
        diaryList = diaryDAO.getAllDiarys();
        adapterDiary = new AdapterDiary(this, diaryList, diaryDAO);
        rcView.setAdapter(adapterDiary);
        linearLayoutManager = new LinearLayoutManager(this);
        rcView.setLayoutManager(linearLayoutManager);
    }

}
