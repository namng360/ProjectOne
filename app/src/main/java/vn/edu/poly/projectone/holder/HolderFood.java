package vn.edu.poly.projectone.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import vn.edu.poly.projectone.R;

public class HolderFood extends RecyclerView.ViewHolder {

    public ImageView imgFood;
    public TextView tvTittle;

    public HolderFood(@NonNull View itemView) {
        super(itemView);
        imgFood = itemView.findViewById(R.id.imgFood);
        tvTittle = itemView.findViewById(R.id.tvTitle);
    }
}
