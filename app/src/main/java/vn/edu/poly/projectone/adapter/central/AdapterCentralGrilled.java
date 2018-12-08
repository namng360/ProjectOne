package vn.edu.poly.projectone.adapter.central;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.projectone.R;
import vn.edu.poly.projectone.activity.GuideActivity;
import vn.edu.poly.projectone.holder.HolderFood;
import vn.edu.poly.projectone.model.Food;

public class AdapterCentralGrilled extends RecyclerView.Adapter<HolderFood> {
    private Activity activity;
    private List<Food> foodList;

    public AdapterCentralGrilled(Activity activity, List<Food> foodList) {
        this.activity = activity;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public HolderFood onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_food,viewGroup,false);
        return new HolderFood(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderFood holderFood, final int i) {
        final Food food = foodList.get(i);
        holderFood.tvTittle.setText(food.getTitle());
        holderFood.imgFood.setImageResource(food.getImg());
        holderFood.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, GuideActivity.class);
                Bundle b = new Bundle();
                b.putString("NAME", foodList.get(i).getTitle());
                b.putString("RE", foodList.get(i).getRe());
                b.putString("COOK", foodList.get(i).getCook());
                intent.putExtras(b);
                activity.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public void setfilter(List<Food> filtermodelist) {
        foodList=new ArrayList<>();
        foodList.addAll(filtermodelist);
        notifyDataSetChanged();
    }
}
