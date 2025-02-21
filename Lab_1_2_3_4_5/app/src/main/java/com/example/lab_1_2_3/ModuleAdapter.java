package com.example.lab_1_2_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ViewHolder> {
    private Context context;
    private List<Module> modules;
    private OnItemClickListener listener;

    // Constructor with listener
    public ModuleAdapter(Context context, List<Module> modules, OnItemClickListener listener) {
        this.context = context;
        this.modules = modules;
        this.listener = listener;
    }

    // Interface to handle item clicks
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_module, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Module module = modules.get(position);

        holder.title.setText(module.getTitle());
        holder.description.setText(module.getDescription());
        holder.platform.setText(module.getPlatform());

        // Load image using Picasso
        Picasso.get()
                .load(module.getImageURL())
                .into(holder.imageView);

        // Set click listener on the item
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(position);  // Pass the clicked item position
            }
        });
    }

    @Override
    public int getItemCount() {
        return modules.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        TextView platform;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.moduleTitle);
            description = itemView.findViewById(R.id.moduleDescription);
            platform = itemView.findViewById(R.id.modulePlatform);
            imageView = itemView.findViewById(R.id.moduleImage);
        }
    }
}
