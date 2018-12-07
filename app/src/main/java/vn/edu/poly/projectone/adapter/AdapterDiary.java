package vn.edu.poly.projectone.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.util.Date;
import java.util.List;
import vn.edu.poly.projectone.R;
import vn.edu.poly.projectone.activity.EditDiaryActivity;
import vn.edu.poly.projectone.activity.GuideActivity;
import vn.edu.poly.projectone.cook.CentralFriedActivity;
import vn.edu.poly.projectone.cook.CentralGrilledActivity;
import vn.edu.poly.projectone.cook.CentralSauteActivity;
import vn.edu.poly.projectone.dao.DiaryDAO;
import vn.edu.poly.projectone.holder.HolderDiary;
import vn.edu.poly.projectone.model.Diary;
import vn.edu.poly.projectone.type.CentralChickenActivity;
import vn.edu.poly.projectone.type.CentralCowActivity;
import vn.edu.poly.projectone.type.CentralPigActivity;
import vn.edu.poly.projectone.type.CentralSeaFoodActivity;


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
                .inflate(R.layout.item_diary,viewGroup,false);
        return new HolderDiary(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDiary holderDiary, final int i) {
        final Diary diary = diaryList.get(i);
        holderDiary.tvTitle.setText(diary.title);
        String date = new Date(diary.date).toString();
        holderDiary.tvTitle.setText(diary.title + "\n" + date);
        holderDiary.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, EditDiaryActivity.class);
                Bundle b = new Bundle();
                b.putString("TITLE", diaryList.get(i).getTitle());
                b.putString("DES", diaryList.get(i).getDes());
                intent.putExtras(b);
                activity.startActivity(intent);
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

    @Override
    public int getItemCount() {
        return diaryList.size();
    }
}
