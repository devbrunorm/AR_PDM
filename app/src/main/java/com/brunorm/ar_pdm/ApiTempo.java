package com.brunorm.ar_pdm;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiTempo {
    //"https://api.hgbrasil.com/weather?woeid=455918"
    @GET("weather?format=json&woeid=455918&locale=pt")
    Call<ApiPojo> getInfTempo();
}
