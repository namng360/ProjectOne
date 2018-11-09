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
import vn.edu.poly.projectone.cook.MoonCakeActivity;
import vn.edu.poly.projectone.cook.MuoiOtActivity;
import vn.edu.poly.projectone.cook.ThitBaChiActivity;
import vn.edu.poly.projectone.cook.ThitXienNuongActivity;
import vn.edu.poly.projectone.holder.HolderFood;
import vn.edu.poly.projectone.model.Food;

public class AdapterGrilled extends RecyclerView.Adapter<HolderFood> {

    private Activity activity;
    private List<Food> foodList;

    public AdapterGrilled(Activity activity, List<Food> foodList) {
        this.activity = activity;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public HolderFood onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_northern_grilled,viewGroup,false);
        return new HolderFood(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderFood holderFood, final int i) {
        final Food food = foodList.get(i);
        holderFood.tvTittle.setText(food.getTitle());
        holderFood.imgFood.setImageResource(food.getImg());
        /*Sự kiện click vào item*/
        holderFood.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                switch (i){
                    case 0:
                        intent =  new Intent(activity, ThitBaChiActivity.class);
                        break;
                    case 1:
                        intent =  new Intent(activity, ThitXienNuongActivity.class);
                        break;
                    case 2:
                        intent =  new Intent(activity, MoonCakeActivity.class);
                        break;
                    case 3:
                        intent =  new Intent(activity, MuoiOtActivity.class);
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
