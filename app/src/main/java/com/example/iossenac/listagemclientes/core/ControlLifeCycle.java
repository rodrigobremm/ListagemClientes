package com.example.iossenac.listagemclientes.core;

import android.app.Application;

import com.example.iossenac.listagemclientes.interfaces.ServicoClientes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by iossenac on 03/06/17.
 */

public class ControlLifeCycle extends Application{


    public static ServicoClientes service;


    @Override
    public void onCreate() {
        super.onCreate();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ServicoClientes.class);

    }
}
