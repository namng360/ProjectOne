package vn.edu.poly.projectone.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import vn.edu.poly.projectone.R;

public class HolderDiary extends RecyclerView.ViewHolder {
    public TextView tvTitle;
    public ImageView btnDelete;


    public HolderDiary(@NonNull View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        btnDelete = itemView.findViewById(R.id.btnDelete);
    }
}
