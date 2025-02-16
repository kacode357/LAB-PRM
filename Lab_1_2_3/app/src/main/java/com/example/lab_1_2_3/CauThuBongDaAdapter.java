package com.example.lab_1_2_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CauThuBongDaAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<CauThuBongDa> cauThuBongDaList;

    public CauThuBongDaAdapter(Context context, int layout, List<CauThuBongDa> cauThuBongDaList) {
        this.context = context;
        this.layout = layout;
        this.cauThuBongDaList = cauThuBongDaList;
    }

    @Override
    public int getCount() {
        return cauThuBongDaList.size();
    }

    @Override
    public Object getItem(int position) {
        return cauThuBongDaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        TextView txtTen = convertView.findViewById(R.id.textviewTen);
        TextView txtMota = convertView.findViewById(R.id.textviewMota);
        ImageView imgHinh = convertView.findViewById(R.id.imageviewHinh);

        CauThuBongDa cauThuBongDa = cauThuBongDaList.get(position);
        txtTen.setText(cauThuBongDa.getTen());
        txtMota.setText(cauThuBongDa.getMota());

        Picasso.get()
                .load(cauThuBongDa.getHinh())
                .placeholder(R.drawable.noimg)
                .error(R.drawable.error)
                .into(imgHinh);

        return convertView;
    }
}
