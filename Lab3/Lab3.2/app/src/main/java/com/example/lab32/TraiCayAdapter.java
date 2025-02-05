package com.example.lab32;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import java.util.List;

public class TraiCayAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TraiCay> traiCayList;

    public TraiCayAdapter(Context context, int layout, List<TraiCay> traiCayList) {
        this.context = context;
        this.layout = layout;
        this.traiCayList = traiCayList;
    }

    @Override
    public int getCount() {
        return traiCayList.size();
    }

    @Override
    public Object getItem(int position) {
        return traiCayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        // Ánh xạ view
        TextView txtTen = convertView.findViewById(R.id.textviewTen);
        TextView txtMota = convertView.findViewById(R.id.textviewMota);
        ImageView imgHinh = convertView.findViewById(R.id.imageviewHinh);

        // Gán giá trị
        TraiCay traiCay = traiCayList.get(position);
        txtTen.setText(traiCay.getTen());
        txtMota.setText(traiCay.getMota());

        // Dùng Picasso để load ảnh từ URL
        Picasso.get()
                .load(traiCay.getHinh()) // URL ảnh
                .placeholder(R.drawable.noimg) // Ảnh hiển thị trong lúc tải
                .error(R.drawable.error) // Ảnh hiển thị nếu lỗi
                .into(imgHinh);

        return convertView;
    }
}
