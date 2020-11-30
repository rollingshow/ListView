package com.example.customadapterdemo;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    UserListAdapter adapter;
    ListView listView;
    ArrayList<User> users;

    Button button_name;
    Button button_sex;
    Button button_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);

        InputStream stream = null;
        try {
            stream=getAssets().open("userlist.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        User[] users_arr=gson.fromJson(new InputStreamReader(stream), User[].class);
       users = new ArrayList<>(Arrays.asList(users_arr));

       Log.d("mytag", "users:" + users_arr.length);

       // TODO: реализовать загрузку данных из JSON-файла
        // который загрузить в папку assets

//        for (int i = 0; i < 10; i++) {
//            users.add(new User("Petya", "123", Sex.MAN));
//            users.add(new User("Vasya", "234", Sex.MAN));
//            users.add(new User("Valya", "456", Sex.WOMAN));
//            users.add(new User("UFO", "@@@", Sex.UNKNOWN));
//        }


        adapter = new UserListAdapter(this, users);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }


    public void onNameClick (View view) {
        Collections.sort(users, new NameComparator());
        adapter = new UserListAdapter(this,users);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }


    public void onNumberClick (View view) {
        Collections.sort(users, new NumberComparator());
        adapter = new UserListAdapter(this,users);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }

    public void onSexClick (View view) {
        Collections.sort(users, new SexComparator());
        adapter = new UserListAdapter(this,users);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }
}
