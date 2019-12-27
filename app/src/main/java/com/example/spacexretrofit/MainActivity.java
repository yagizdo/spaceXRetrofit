package com.example.spacexretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ResInterface resInterface;
    TextView deneme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resInterface=ApiClient.getClient().create(ResInterface.class);

        deneme = findViewById(R.id.deneme);
        Call<List<Repo>> call=resInterface.getRepo();

        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> repoList=new ArrayList<>();
                repoList=response.body();
                for (int i=0;i<repoList.size();i++){
                    System.out.println("YAGO"+repoList.get(i).rocket.rocketId+"\n");
                    deneme.setText(" Ad : " + repoList.get(3).rocket.rocketName);
                }
            }
            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
            }
        });


    }
}
