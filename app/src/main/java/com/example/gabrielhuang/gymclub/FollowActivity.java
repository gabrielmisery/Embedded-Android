package com.example.gabrielhuang.gymclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class FollowActivity extends AppCompatActivity {
    private List<FollowActivity.Person> persons;

    class Person {
        String name;
        String age;
        int photoId;

        Person(String name, String age, int photoId) {
            this.name = name;
            this.age = age;
            this.photoId = photoId;
        }
    }

    public void initializeData() {
        persons = new ArrayList<>();
        persons.add(new FollowActivity.Person("游泳", "60分钟", R.drawable.swimming));
        persons.add(new FollowActivity.Person("俯卧撑", "30分钟", R.drawable.fuwoch));
        persons.add(new FollowActivity.Person("跑步", "90分钟", R.drawable.running));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);
        RecyclerView rv = findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        initializeData();
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new RVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0: {
                        Intent intent = new Intent(FollowActivity.this, VideoActivity.class);
                        startActivity(intent);
                    }
                    case 1: {

                    }
                    case 2: {

                    }
                }
            }
        });
    }
}
