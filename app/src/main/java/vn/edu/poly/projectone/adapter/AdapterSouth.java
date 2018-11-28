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
import vn.edu.poly.projectone.cook.SouthFriedActivity;
import vn.edu.poly.projectone.cook.SouthGrilledActivity;
import vn.edu.poly.projectone.cook.SouthSauteActivity;
import vn.edu.poly.projectone.holder.HolderFood;
import vn.edu.poly.projectone.model.Food;
import vn.edu.poly.projectone.type.SouthChickenActivity;
import vn.edu.poly.projectone.type.SouthCowActivity;
import vn.edu.poly.projectone.type.SouthPigActivity;
import vn.edu.poly.projectone.type.SouthSeaFoodActivity;

public class AdapterSouth extends RecyclerView.Adapter<HolderFood>{
    private Activity activity;
    private List<Food> foodList;

    public AdapterSouth(Activity activity, List<Food> foodList) {
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
                        intent =  new Intent(activity, SouthGrilledActivity.class);
                        break;
                    case 1:
                        intent =  new Intent(activity, SouthSauteActivity.class);
                        break;
                    case 2:
                        intent =  new Intent(activity, SouthFriedActivity.class);
                        break;
                    case 3:
                        intent =  new Intent(activity, SouthCowActivity.class);
                        break;
                    case 4:
                        intent =  new Intent(activity, SouthChickenActivity.class);
                        break;
                    case 5:
                        intent =  new Intent(activity, SouthPigActivity.class);
                        break;
                    case 6:
                        intent =  new Intent(activity, SouthSeaFoodActivity.class);
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
