package com.example.lab_1_2_3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Question1Lab5Activity extends AppCompatActivity {
    // Declare a variable for the user list
    ArrayList<User> userList;
    UserAdapter adapter;
    EditText edtUsername, edtFullname, edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        // Lookup the RecyclerView in Activity layout
        RecyclerView rvUser = findViewById(R.id.rvUser);

        // Initialize the EditTexts for user input
        edtUsername = findViewById(R.id.edtTitlex);  // Assume edtTitle is for username
        edtFullname = findViewById(R.id.edtDescription); // Assume edtDescription is for fullname
        edtEmail = findViewById(R.id.edtPlatform); // Assume edtPlatform is for email

        // Initialize the user list
        userList = new ArrayList<>();
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "Nguyentt@ftp.edu.vn"));
        userList.add(new User("Antv", "Tran Van An", "antv@gmail.com"));
        userList.add(new User("BangTT", "Tran Thanh Bang", "bangtt@gmail.com"));
        userList.add(new User("KhangTT", "Tran Thanh Khang", "khangtt@gmail.com"));
        userList.add(new User("BaoNT", "Nguyen Thanh Bao", "baont@gmail.com"));
        userList.add(new User("HungVH", "Vũ Huy Hùng", "hungvh@gmail.com"));

        // Create adapter passing in the sample user data
        adapter = new UserAdapter(userList);

        // Attach the Adapter to the RecyclerView to populate the item
        rvUser.setAdapter(adapter);

        // Set layout manager to position the items
        rvUser.setLayoutManager(new LinearLayoutManager(this));

        // Set a listener for item clicks
        adapter.setOnItemClickListener(new UserAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Fill the EditTexts with the selected user's information
                User clickedUser = userList.get(position);
                edtUsername.setText(clickedUser.getUsername());
                edtFullname.setText(clickedUser.getFullname());
                edtEmail.setText(clickedUser.getEmail());
            }
        });

        // Handle the Add button click
        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input from the EditText fields
                String username = edtUsername.getText().toString();
                String fullname = edtFullname.getText().toString();
                String email = edtEmail.getText().toString();

                // Add new user to the list
                if (!username.isEmpty() && !fullname.isEmpty() && !email.isEmpty()) {
                    User newUser = new User(username, fullname, email);
                    userList.add(newUser);
                    adapter.notifyItemInserted(userList.size() - 1);  // Notify RecyclerView about the new item
                    Toast.makeText(Question1Lab5Activity.this, "User Added!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Question1Lab5Activity.this, "Please fill in all fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Handle the Delete button click
        Button btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the username from the EditText fields
                String username = edtUsername.getText().toString();

                // Find the user and remove them
                for (int i = 0; i < userList.size(); i++) {
                    if (userList.get(i).getUsername().equals(username)) {
                        userList.remove(i);
                        adapter.notifyItemRemoved(i);  // Notify RecyclerView about the removed item
                        Toast.makeText(Question1Lab5Activity.this, "User Deleted!", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }
        });

        // Handle the Update button click
        Button btnUpdate = findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input from the EditText fields
                String oldUsername = edtUsername.getText().toString();  // Current username
                String newUsername = edtUsername.getText().toString(); // Updated username (if changed)
                String fullname = edtFullname.getText().toString();
                String email = edtEmail.getText().toString();

                // Find the user and update their information (including username)
                for (int i = 0; i < userList.size(); i++) {
                        userList.get(i).setUsername(newUsername); // Update username
                        userList.get(i).setFullname(fullname); // Update fullname
                        userList.get(i).setEmail(email); // Update email
                        adapter.notifyItemChanged(i);  // Notify RecyclerView about the updated item
                        Toast.makeText(Question1Lab5Activity.this, "User Updated!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        Button btnBack = findViewById(R.id.btnBackQuestion1Lab5);
        btnBack.setOnClickListener(v -> {
            // Close the current activity and return to the previous one
            finish();
        });
    }
}
