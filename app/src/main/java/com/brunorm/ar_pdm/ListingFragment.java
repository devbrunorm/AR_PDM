package com.brunorm.ar_pdm;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListingFragment extends Fragment{

    public ListingFragment() {}

    private static final String TAG = "ListFragment";

    DadosTempo dados;
    TextView cidade;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedinstanceState) {
        View v = inflater.inflate(R.layout.fragment_listing, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_main);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        dados = new DadosTempo();

        Retrofit client = new Retrofit.Builder()
                .baseUrl("https://api.hgbrasil.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiTempo httpRequest = client.create(ApiTempo.class);

        Call<ApiPojo> call = httpRequest.getInfTempo();
        call.enqueue(callback);

        mAdapter = new ListAdapter(dados);
        mRecyclerView.setAdapter(mAdapter);

        cidade = v.findViewById(R.id.cityText);

        return v;
    }

    private Callback<ApiPojo> callback = new Callback<ApiPojo>() {
        @Override
        public void onResponse(Call<ApiPojo> call, Response<ApiPojo> response) {
            Log.e(TAG, response.body().getResults().getCityName());
            dados.setCidade(response.body().getResults().getCityName());
            dados.setLista(response.body().getResults().getForecast());

            cidade.setText(dados.getCidade());

            mAdapter.notifyDataSetChanged();
        }

        @Override
        public void onFailure(Call<ApiPojo> call, Throwable t) {
            Log.e(TAG, "Falha no Retrofit: "+ t.toString());
        }
    };
}
