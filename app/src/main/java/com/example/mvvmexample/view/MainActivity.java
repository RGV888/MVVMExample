package com.example.mvvmexample.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mvvmexample.Models.Hit;
import com.example.mvvmexample.R;
import com.example.mvvmexample.viewmodel.StoryViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Toolbar toolbar;
    private TextView counterTv;
    private StoryViewModel storyViewModel;
    private StoryListAdapter mAdapter;
    private List<Hit> storyList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initi();
        setSupportActionBar(toolbar);

        storyViewModel= ViewModelProviders.of(this).get(StoryViewModel.class);
        storyList=new ArrayList<>();
        RecylerViewSetup();



    }

    private void RecylerViewSetup() {

        mAdapter=new StoryListAdapter(MainActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);

        updateDataObserver();
    }

    private void updateDataObserver() {
        storyViewModel.getStoryList().observe(this, new Observer<List<Hit>>() {
            @Override
            public void onChanged(List<Hit> hits) {

                if(hits==null)
                    return;

                storyList.addAll(hits);
                mAdapter.notifyDataSetChanged();
            }
        });

    }

    private void initi() {
        recyclerView=findViewById(R.id.recyclerView);
        swipeRefreshLayout=findViewById(R.id.swipeRefreshLayout);
        toolbar=findViewById(R.id.toolbar);
        counterTv=toolbar.findViewById(R.id.counter);
    }
}
