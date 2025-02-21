package com.example.lab_1_2_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FoodAdapter extends BaseAdapter {

    private Context context;
    private int layoutResourceId;
    private List<Food> foodList;

    public FoodAdapter(Context context, int layoutResourceId, List<Food> foodList) {
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layoutResourceId, null);
        }

        ImageView imageViewFood = view.findViewById(R.id.imageviewFood);
        TextView textViewFoodName = view.findViewById(R.id.textviewFoodName);
        TextView textViewFoodDescription = view.findViewById(R.id.textviewFoodDescription);
        TextView textViewFoodPrice = view.findViewById(R.id.textviewFoodPrice);
        Button btnMinus = view.findViewById(R.id.btnMinus);
        Button btnPlus = view.findViewById(R.id.btnPlus);
        TextView textViewQuantity = view.findViewById(R.id.textviewQuantity);

        Food food = foodList.get(position);

        textViewFoodName.setText(food.getTen());
        textViewFoodDescription.setText(food.getMota());
        textViewFoodPrice.setText("Giá: " + food.getGia() + " VND");

        Picasso.get()
                .load(food.getHinhanh()) // Đường dẫn đến hình ảnh
                .placeholder(R.drawable.noimg)
                .error(R.drawable.error)
                .into(imageViewFood);

        final int[] quantity = {food.getQuantity()}; // Đọc số lượng từ model food
        textViewQuantity.setText(String.valueOf(quantity[0]));

        // Nút giảm số lượng
        btnMinus.setOnClickListener(v -> {
            if (quantity[0] > 0) {
                quantity[0]--;
                food.setQuantity(quantity[0]); // Cập nhật số lượng trong model
                textViewQuantity.setText(String.valueOf(quantity[0]));
            }
        });

        // Nút tăng số lượng
        btnPlus.setOnClickListener(v -> {
            quantity[0]++;
            food.setQuantity(quantity[0]); // Cập nhật số lượng trong model
            textViewQuantity.setText(String.valueOf(quantity[0]));
        });

        return view;
    }
}
