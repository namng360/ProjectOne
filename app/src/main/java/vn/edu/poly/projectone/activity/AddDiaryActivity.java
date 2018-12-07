package vn.edu.poly.projectone.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import vn.edu.poly.projectone.R;
import vn.edu.poly.projectone.dao.DiaryDAO;
import vn.edu.poly.projectone.database.DatabaseHelper;
import vn.edu.poly.projectone.model.Diary;

public class AddDiaryActivity extends AppCompatActivity {
    private Toolbar toolBar;
    private DiaryDAO diaryDAO;
    private DatabaseHelper databaseHelper;
    private long datePicker = -1;
    TextView tvChoose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_diary);
        databaseHelper = new DatabaseHelper(this);
        diaryDAO = new DiaryDAO(databaseHelper);
        toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_back);
        toolBar.setTitle(getString(R.string.your_diary));
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        final EditText edtTitle;
        final EditText edtChoose;
        final EditText edtDes;
        final Button btnOpen;
        Button btnSave;

        edtTitle = findViewById(R.id.edtTitle);
        tvChoose = findViewById(R.id.tvChoose);
        edtDes = findViewById(R.id.edtDes);
        btnOpen = findViewById(R.id.btnOpen);
        btnSave = findViewById(R.id.btnSave);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("btnAdd", "btnAdd");

                Diary diary = diaryDAO.getDiaryByTitle(edtTitle.getText().toString().trim());

                if (diary == null) {
                    diary = new Diary();
                    String title = edtTitle.getText().toString().trim();
                    String des = edtDes.getText().toString().trim();
                    diary.title = title;
                    diary.describe = des;

                    long result = diaryDAO.insertDiary(diary);

                    if (title.equals("") || des.equals("")){
                        Toast.makeText(AddDiaryActivity.this, "Khong duoc bo trong!", Toast.LENGTH_SHORT).show();
                    }

                    else {

                        // f5 list view
                        Intent intent = new Intent(AddDiaryActivity.this, DiaryActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }

            }
        });
    }
    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        // thiet lap thong tin cho date picker

        final DatePickerDialog datePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Integer yy = year;
                Integer mm = month;
                Integer dd = dayOfMonth;


                Calendar calendar = Calendar.getInstance();

                calendar.set(year, month, dayOfMonth);

                //
                long startTime = calendar.getTimeInMillis();

                AddDiaryActivity.this.datePicker = calendar.getTimeInMillis();

                tvChoose.setText(new Date(startTime).toString());


            }
        }, year, month, day);

        datePicker.show();

    }
}
