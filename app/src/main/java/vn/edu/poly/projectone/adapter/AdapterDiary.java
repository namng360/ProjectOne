package vn.edu.poly.projectone.adapter;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import vn.edu.poly.projectone.R;
import vn.edu.poly.projectone.activity.AddDiaryActivity;
import vn.edu.poly.projectone.dao.DiaryDAO;
import vn.edu.poly.projectone.holder.HolderDiary;
import vn.edu.poly.projectone.model.Diary;


public class AdapterDiary extends RecyclerView.Adapter<HolderDiary> {
    private Activity activity;
    private List<Diary> diaryList;
    private DiaryDAO diaryDAO;

    public AdapterDiary(Activity activity, List<Diary> diaryList, DiaryDAO diaryDAO) {
        this.activity = activity;
        this.diaryList = diaryList;
        this.diaryDAO = diaryDAO;
    }

    @NonNull
    @Override
    public HolderDiary onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_diary, viewGroup, false);
        return new HolderDiary(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDiary holderDiary, final int i) {
        final Diary diary = diaryList.get(i);
        holderDiary.tvTitle.setText(diary.title);
        final String date = new Date(diary.date).toString();
        holderDiary.tvTitle.setText(diary.title + "\n" + date);
        holderDiary.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.dialog_edit_diary);
                final EditText edtTitle;
                final EditText edtDes;
                Button btnSave;
                Button btnCancel;
                edtTitle = dialog.findViewById(R.id.edtTitle);
                edtDes = dialog.findViewById(R.id.edtDes);
                btnSave = dialog.findViewById(R.id.btnSave);
                btnCancel = dialog.findViewById(R.id.btnCancel);

                edtTitle.setText(diary.title);
                edtDes.setText(diary.describe);

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Diary diary1 = new Diary();
                        diary1.title = diary.title;

                        String title = edtTitle.getText().toString().trim();
                        String des = edtDes.getText().toString().trim();

                        diary1.title = title;
                        diary1.describe = des;

                        long result = diaryDAO.updateDiary(diary);
                        if (title.equals("") || des.equals("")) {
                            Toast.makeText(activity, R.string.error, Toast.LENGTH_SHORT).show();
                        } else {
                            diaryList.get(i).title = title;
                            diaryList.get(i).describe = des;
                            // f5 listview
                            notifyDataSetChanged();
                            dialog.dismiss();
                        }
                    }
                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });



        holderDiary.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long result = diaryDAO.deleteDiary(diary.title);
                if (result < 0) {
                    Toast.makeText(activity, R.string.err, Toast.LENGTH_SHORT).show();
                } else {
                    diaryList.remove(i);
                    notifyDataSetChanged();
                }
            }
        });
    }

//    private void showDatePickerDialog() {
//        Calendar calendar = Calendar.getInstance();
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH);
//        final int day = calendar.get(Calendar.DAY_OF_MONTH);
//
//        // thiet lap thong tin cho date picker
//
//        final DatePickerDialog datePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                Integer yy = year;
//                Integer mm = month;
//                Integer dd = dayOfMonth;
//                Calendar calendar = Calendar.getInstance();
//                calendar.set(year, month, dayOfMonth);
//                long startTime = calendar.getTimeInMillis();
//                activity.datePicker = calendar.getTimeInMillis();
//                tvChoose.setText(new Date(startTime).toString());
//            }
//        }, year, month, day);
//
//        datePicker.show();
//
//    }


    @Override
    public int getItemCount() {
        return diaryList.size();
    }
}
