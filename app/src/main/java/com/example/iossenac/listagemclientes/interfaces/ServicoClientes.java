package com.example.iossenac.listagemclientes.interfaces;

import com.example.iossenac.listagemclientes.model.ContainerClientes;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by iossenac on 03/06/17.
 */

public interface ServicoClientes {

    @GET("v2/5932e64c1300005d02fa0b46")
    Call<ContainerClientes> listaCliente();

}
