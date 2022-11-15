package com.adsi5226.popayanturims;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.adsi5226.popayanturims.Adapter.Adapter;
import com.adsi5226.popayanturims.Modelo.TipoServicio;
import com.adsi5226.popayanturims.Retrofit_Data.RetrofitApiService;
import com.adsi5226.popayanturims.Retrofit_Data.RetrofitClient;
import com.adsi5226.popayanturims.databinding.ActivityTipoServicioBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TipoServicioActivity extends DrawerBaseActivity  implements Adapter.OnQueryTextListener  {



    private RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList<TipoServicio> tipoServicios;
    private RetrofitApiService retrofitApiService;
    private RetrofitClient retrofitClient;
    private SearchView svSearch;

ActivityTipoServicioBinding activityTipoServicioBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    activityTipoServicioBinding = ActivityTipoServicioBinding.inflate(getLayoutInflater());
        setContentView(activityTipoServicioBinding.getRoot());
        allocateActivityTitle("Tiposervicios");
        setContentView(R.layout.activity_tipo_servicio);



        recyclerView = findViewById(R.id.recyclerView);
        tipoServicios = new ArrayList<>();
        svSearch = findViewById(R.id.svSearch);
        retrofitApiService= RetrofitClient.getApiService();
        mostrarNoticias();

    }

    private void mostrarNoticias() {

        Call<List<TipoServicio>> call= retrofitApiService.getTiposervicios();
        call.enqueue(new Callback<List<TipoServicio>>() {


            @Override
            public void onResponse(Call<List<TipoServicio>> call, Response<List<TipoServicio>> response) {
                if (!response.isSuccessful()){

                    Toast.makeText(TipoServicioActivity.this, "Error codigo" +response.code(),Toast.LENGTH_SHORT).show();
                }

                List<TipoServicio> noticias= response.body();
                recyclerView.setLayoutManager(new LinearLayoutManager(TipoServicioActivity.this));
                adapter= new Adapter((Context) TipoServicioActivity.this,
                        (ArrayList<TipoServicio>) noticias);
                recyclerView.setAdapter(adapter);

            }



            @Override
            public void onFailure(Call<List<TipoServicio>> call, Throwable t) {

                Toast.makeText(TipoServicioActivity.this, "Fallo en conexion" +t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });



    }


}

