package com.hfad.FreeChampions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private int[] champions;
    private String[] championNames;
    private Button next;
    private Button previous;
    private ImageView championPicture;
    private TextView championName;
    private List<Integer> championIds;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wirewidgets();
        searchChampions();
        champions = new int[433];
        champions[268] = R.drawable.azir;
        champions[432] = R.drawable.bard;
        champions[119] = R.drawable.draven;
        champions[104] = R.drawable.graves;
        champions[40] = R.drawable.janna;
        champions[236] = R.drawable.lucian;
        champions[267] = R.drawable.nami;
        champions[75] = R.drawable.nasus;
        champions[56] = R.drawable.nocturne;
        champions[421] = R.drawable.reksai;
        champions[17] = R.drawable.teemo;
        champions[106] = R.drawable.voibear;
        champions[83] = R.drawable.yorick;
        champions[115] = R.drawable.ziggs;
        championNames = new String[433];
        championNames[268] = "Azir";
        championNames[432] = "Bard";
        championNames[119] = "Draven";
        championNames[104] = "Graves";
        championNames[40] = "Janna";
        championNames[236] = "Lucian";
        championNames[267] = "Nami";
        championNames[75] = "Nasus";
        championNames[56] = "Nocturne";
        championNames[421] = "Rek'Sai";
        championNames[17] = "Teemo";
        championNames[106] = "Volibear";
        championNames[83] = "Yorick";
        championNames[115] = "Ziggs";

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i += 1;
                if (i > 13) {
                    i = 0;
                }
                displayPicture();
                displayChampionName();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i -= 1;
                if (i < 0) {
                    i = 13;
                }
                displayChampionName();
                displayPicture();
            }
        });
    }

    private void wirewidgets() {
        championPicture = findViewById(R.id.imageView_mainActivity_championPicture);
        championName = findViewById(R.id.textView_MainActivity_championName);
        next = findViewById(R.id.button_mainActivity_next);
        previous = findViewById(R.id.button_mainActivity_previous);
    }

    private void searchChampions() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://na1.api.riotgames.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RiotGamesService service = retrofit.create(RiotGamesService.class);


        Call<FreeChampions> freeChampionsCall = service.search("RGAPI-c4089a02-d733-47f7-bcb1-ae6267b59138");
        freeChampionsCall.enqueue(new Callback<FreeChampions>() {
            @Override
            public void onResponse(Call<FreeChampions> call, Response<FreeChampions> response) {
                FreeChampions newItem = response.body();
                Log.d("ENQUEUE", "onResponse: " + newItem.toString());
                championIds = newItem.getFreeChampionIds();
                displayPicture();
                displayChampionName();
                //List<FreeChampions> freeChampions = response.body().getResults();
               // Log.d("ENQUEUE", "onResponse: " + freeChampions);
            }

            @Override
            public void onFailure(Call<FreeChampions> call, Throwable t) {
                Log.d("ENQUEUE", "onFailure: " + t.getMessage());
            }
        });

    }
    private void displayPicture() {
        championPicture.setImageResource(champions[championIds.get(i)]);
    }
    private void displayChampionName(){
        championName.setText(championNames[championIds.get(i)]);
    }

}
