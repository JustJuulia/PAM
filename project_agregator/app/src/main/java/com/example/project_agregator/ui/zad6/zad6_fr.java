package com.example.project_agregator.ui.zad6;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_agregator.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AlertDialog;

public class zad6_fr extends Fragment {

    private TaskDatabaseHelper dbHelper;
    private TaskAdapter taskAdapter;

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zad6, container, false);

        dbHelper = new TaskDatabaseHelper(requireContext());
        recyclerView = view.findViewById(R.id.zad6_recyclerView);
        FloatingActionButton addButton = view.findViewById(R.id.zad6_add);
        if (addButton == null) {
            Log.e("zad6_fr", "FloatingActionButton not found!");
        } else {
            Log.d("zad6_fr", "FloatingActionButton is initialized.");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        taskAdapter = new TaskAdapter(dbHelper.getAllTasks(), dbHelper);
        recyclerView.setAdapter(taskAdapter);

        addButton.setOnClickListener(v -> showAddTaskDialog());

        return view;
    }

    private void showAddTaskDialog() {

        LayoutInflater inflater = LayoutInflater.from(requireContext());
        View dialogView = inflater.inflate(R.layout.dialog_add_task, null);

        EditText inputTask = dialogView.findViewById(R.id.dialog_task_input);
        Button dialogAddButton = dialogView.findViewById(R.id.dialog_add_button);
        AlertDialog alertDialog = new AlertDialog.Builder(requireContext())
                .setView(dialogView)
                .create();

        dialogAddButton.setOnClickListener(v -> {
            String task = inputTask.getText().toString();
            if (!TextUtils.isEmpty(task)) {
                dbHelper.addTask(task);
                taskAdapter.updateTasks(dbHelper.getAllTasks());
                alertDialog.dismiss(); // Close the dialog
            }
        });

        alertDialog.show();
    }
}
