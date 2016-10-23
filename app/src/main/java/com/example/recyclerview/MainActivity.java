package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    private String[] dataset;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private LinearLayoutManager layoutManager;
    private DividerItemDecoration dividerItemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataset = new String[] {
                "Item 1",
                "Item 2",
                "Item 3"
        };

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // To improve performance
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MyAdapter(dataset);
        recyclerView.setAdapter(adapter);

        // Item click listener
        adapter.setClickListener(this);

        // Add divider
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                                                        layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, dataset[position], Toast.LENGTH_SHORT).show();
    }
}
