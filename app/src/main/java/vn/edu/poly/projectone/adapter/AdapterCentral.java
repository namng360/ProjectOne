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
import vn.edu.poly.projectone.cook.CentralFriedActivity;
import vn.edu.poly.projectone.cook.CentralGrilledActivity;
import vn.edu.poly.projectone.cook.CentralSauteActivity;
import vn.edu.poly.projectone.holder.HolderFood;
import vn.edu.poly.projectone.model.Food;
import vn.edu.poly.projectone.type.CentralChickenActivity;
import vn.edu.poly.projectone.type.CentralCowActivity;
import vn.edu.poly.projectone.type.CentralPigActivity;
import vn.edu.poly.projectone.type.CentralSeaFoodActivity;

public class AdapterCentral extends RecyclerView.Adapter<HolderFood>{
    private Activity activity;
    private List<Food> foodList;

    public AdapterCentral(Activity activity, List<Food> foodList) {
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
                        intent =  new Intent(activity, CentralGrilledActivity.class);
                        break;
                    case 1:
                        intent =  new Intent(activity, CentralSauteActivity.class);
                        break;
                    case 2:
                        intent =  new Intent(activity, CentralFriedActivity.class);
                        break;
                    case 3:
                        intent =  new Intent(activity, CentralCowActivity.class);
                        break;
                    case 4:
                        intent =  new Intent(activity, CentralChickenActivity.class);
                        break;
                    case 5:
                        intent =  new Intent(activity, CentralPigActivity.class);
                        break;
                    case 6:
                        intent =  new Intent(activity, CentralSeaFoodActivity.class);
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
