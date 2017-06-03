package com.example.iossenac.listagemclientes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.iossenac.listagemclientes.Adapter.ClientesAdapter;
import com.example.iossenac.listagemclientes.core.ControlLifeCycle;
import com.example.iossenac.listagemclientes.model.Cliente;
import com.example.iossenac.listagemclientes.model.ContainerClientes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);





        Call<ContainerClientes> call =
            ControlLifeCycle.service.listaCliente();


        call.enqueue(new Callback<ContainerClientes>() {
            @Override
            public void onResponse(
                    Call<ContainerClientes> call,
                    Response<ContainerClientes> response) {
                ContainerClientes container = response.body();
                for (Cliente cliente : container.clientes){
                    Log.e("Cliente",cliente.nome);
                }

                // specify an adapter (see also next example)
                mAdapter = new ClientesAdapter(container.clientes);
                mRecyclerView.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(Call<ContainerClientes> call, Throwable t) {

            }
        });
    }
}
