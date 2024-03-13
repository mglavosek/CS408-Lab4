package edu.jsu.mcis.cs408.lab4_1;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import edu.jsu.mcis.cs408.lab4_1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MemoAdapter adapter;

    private MemoModel model;
    private MemoController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        model = new MemoModel(getApplicationContext());
        controller = new MemoController(model);

        setupRecyclerView();
        setupAddMemoButton();
    }

    private void setupRecyclerView() {
        adapter = new MemoAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
        updateMemoList();
    }

    private void setupAddMemoButton() {
        binding.btnAddMemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String memoText = binding.editTextMemo.getText().toString();
                if (!memoText.isEmpty()) {
                    controller.addNewMemo(memoText);
                    updateMemoList();
                    binding.editTextMemo.getText().clear();
                }
            }
        });
    }

    private void updateMemoList() {
        adapter.swapCursor(controller.getAllMemos());
    }
}


