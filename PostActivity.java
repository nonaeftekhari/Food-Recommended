package com.app.foodrecommendedtest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostActivity extends AppCompatActivity {
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Rest>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Rest>>() {
            @Override
            public void onResponse(Call<List<Rest>> call, Response<List<Rest>> response) {
                if(!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Rest> rests = response.body();


                for(Rest rest : rests) {
                    String content="";
                    content += "ID: " + rest.getId() + "\n";
                    content += "Restaurant Name: " + rest.getRestName() + "\n";
                    content += rest.getBanner();
                    //Bitmap banner = BitmapFactory.decodeFile(rest.getBanner());
                    //content += banner + "\n";
                    content += "Zipcode: " + rest.getZipcode() + "\n";
                    content += "Website: " + rest.getWebsite() + "\n";
                    content += "Phone number: " + rest.getPhone() + "\n";
                    content += "Avg Price: " + rest.getRestPrice() + "\n\n";
                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Rest>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
