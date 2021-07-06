package com.example.restapiretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        processData();
    }

    private void processData() {
        Call<List<ModelDataFetch>> dataCall = ApiController.getInstance().getApi().getFetchData();
        dataCall.enqueue(new Callback<List<ModelDataFetch>>() {
            @Override
            public void onResponse(Call<List<ModelDataFetch>> call, Response<List<ModelDataFetch>> response) {
                List<ModelDataFetch> fetchData = response.body();
                adapter = new MyAdapter(fetchData);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ModelDataFetch>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: "+t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}