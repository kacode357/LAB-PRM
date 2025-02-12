package com.example.minigame2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {

    private List<Player> players;
    private List<Integer> selectedPositions = new ArrayList<>(); // Lưu danh sách vị trí chọn
    private Context context;

    public PlayerAdapter(Context context, List<Player> players) {
        this.context = context;
        this.players = players;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_item, parent, false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        Player player = players.get(position);
        holder.name.setText(player.getName());
        holder.dogBreed.setText(player.getDogBreed());
        holder.win.setText("Win: " + player.getWin());
        holder.id.setText("" + player.getId());

        // Kiểm tra nếu đã chọn
        holder.itemView.setSelected(selectedPositions.contains(position));

        // Xử lý sự kiện click
        holder.itemView.setOnClickListener(v -> {
            if (selectedPositions.contains(position)) {
                selectedPositions.remove(Integer.valueOf(position)); // Bỏ chọn nếu đã chọn trước đó
            } else {
                if (selectedPositions.size() < 2) {
                    selectedPositions.add(position); // Thêm vào danh sách chọn
                } else {
                    // Khi chọn con thứ 3, hiển thị Activity cảnh báo
                    Intent intent = new Intent(context, MaxSelectionDialogActivity.class);
                    context.startActivity(intent);
                }
            }
            notifyDataSetChanged(); // Cập nhật giao diện
        });
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public List<Integer> getSelectedPositions() {
        return selectedPositions;
    }

    public static class PlayerViewHolder extends RecyclerView.ViewHolder {
        TextView name, dogBreed, win, id;

        public PlayerViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.player_name);
            dogBreed = itemView.findViewById(R.id.player_dog);
            win = itemView.findViewById(R.id.player_win);
            id = itemView.findViewById(R.id.player_id);
        }
    }
}
