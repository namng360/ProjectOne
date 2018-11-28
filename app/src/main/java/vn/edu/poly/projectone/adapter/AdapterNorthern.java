package vn.edu.poly.projectone.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vn.edu.poly.projectone.R;
import vn.edu.poly.projectone.activity.CentralActivity;
import vn.edu.poly.projectone.activity.NorthernActivity;
import vn.edu.poly.projectone.activity.SouthActivity;
import vn.edu.poly.projectone.cook.CentralGrilledActivity;
import vn.edu.poly.projectone.cook.NorthernFriedActivity;
import vn.edu.poly.projectone.cook.NorthernGrilledActivity;
import vn.edu.poly.projectone.cook.NorthernSauteActivity;
import vn.edu.poly.projectone.cook.SouthSauteActivity;
import vn.edu.poly.projectone.holder.HolderFood;
import vn.edu.poly.projectone.model.Food;
import vn.edu.poly.projectone.type.NorthernChickenActivity;
import vn.edu.poly.projectone.type.NorthernCowActivity;
import vn.edu.poly.projectone.type.NorthernPigActivity;
import vn.edu.poly.projectone.type.NorthernSeaFoodActivity;

public class AdapterNorthern extends RecyclerView.Adapter<HolderFood>{
    private Activity activity;
    private List<Food> foodList;

    public AdapterNorthern(Activity activity, List<Food> foodList) {
        this.activity = activity;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public HolderFood onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_menu,viewGroup,false);
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
                Intent intent=new Intent();
                switch (i){
                    case 0:
                        intent =  new Intent(activity, NorthernGrilledActivity.class);
                        break;
                    case 1:
                        intent =  new Intent(activity, NorthernSauteActivity.class);
                        break;
                    case 2:
                        intent =  new Intent(activity, NorthernFriedActivity.class);
                        break;
                    case 3:
                        intent =  new Intent(activity, NorthernCowActivity.class);
                        break;
                    case 4:
                        intent =  new Intent(activity, NorthernChickenActivity.class);
                        break;
                    case 5:
                        intent =  new Intent(activity, NorthernPigActivity.class);
                        break;
                    case 6:
                        intent =  new Intent(activity, NorthernSeaFoodActivity.class);
                        break;
                }
                activity.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }
}
