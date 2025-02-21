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

public class DrinkAdapter extends BaseAdapter {

    private Context context;
    private int layoutResourceId;
    private List<Drink> drinkList;

    public DrinkAdapter(Context context, int layoutResourceId, List<Drink> drinkList) {
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.drinkList = drinkList;
    }

    @Override
    public int getCount() {
        return drinkList.size();
    }

    @Override
    public Object getItem(int position) {
        return drinkList.get(position);
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

        ImageView imageViewDrink = view.findViewById(R.id.imageviewDrink);
        TextView textViewDrinkName = view.findViewById(R.id.textviewDrinkName);
        TextView textViewDrinkDescription = view.findViewById(R.id.textviewDrinkDescription);
        TextView textViewDrinkPrice = view.findViewById(R.id.textviewDrinkPrice);
        Button btnMinus = view.findViewById(R.id.btnMinus);
        Button btnPlus = view.findViewById(R.id.btnPlus);
        TextView textViewQuantity = view.findViewById(R.id.textviewQuantity);

        Drink drink = drinkList.get(position);

        // Thiết lập tên, mô tả và giá của đồ uống
        textViewDrinkName.setText(drink.getTen());
        textViewDrinkDescription.setText(drink.getMota());
        textViewDrinkPrice.setText("Giá: " + drink.getGia() + " VND");

        // Tải hình ảnh sử dụng Picasso
        Picasso.get()
                .load(drink.getHinhanh()) // Đường dẫn đến hình ảnh
                .placeholder(R.drawable.noimg)
                .error(R.drawable.error)
                .into(imageViewDrink);

        final int[] quantity = {drink.getQuantity()}; // Đọc số lượng từ model drink
        textViewQuantity.setText(String.valueOf(quantity[0]));

        // Nút giảm số lượng
        btnMinus.setOnClickListener(v -> {
            if (quantity[0] > 0) {
                quantity[0]--;
                drink.setQuantity(quantity[0]); // Cập nhật số lượng trong model
                textViewQuantity.setText(String.valueOf(quantity[0]));
            }
        });

        // Nút tăng số lượng
        btnPlus.setOnClickListener(v -> {
            quantity[0]++;
            drink.setQuantity(quantity[0]); // Cập nhật số lượng trong model
            textViewQuantity.setText(String.valueOf(quantity[0]));
        });

        return view;
    }
}
