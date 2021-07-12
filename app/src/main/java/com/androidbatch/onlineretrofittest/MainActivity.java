package com.androidbatch.onlineretrofittest;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageAdapter imgAdp;
    List<ImageDetailsModel> list;
    RetrofitJson apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = ApiClient.getClient().create(RetrofitJson.class);
        fetchPosts();
    }

    private void fetchPosts() {
        Call<List<ImageDetailsModel>> getImages = apiInterface.getImages();

        getImages.enqueue(new Callback<List<ImageDetailsModel>>() {
            @Override
            public void onResponse(Call<List<ImageDetailsModel>> call, Response<List<ImageDetailsModel>> response) {

                list = response.body();
                Log.e("data",response.body()+"");
                imgAdp = new ImageAdapter(list, MainActivity.this);
                recyclerView.setAdapter(imgAdp);
            }

            @Override
            public void onFailure(Call<List<ImageDetailsModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}