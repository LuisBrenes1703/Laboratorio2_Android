package io;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountryApiAdapter {
    private static DiagnosticVetApiService API_SERVICE;
    private String nombrePaísA;
    public static DiagnosticVetApiService getApiService() {

        // Creamos un interceptor y le indicamos el log level a usar
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Asociamos el interceptor a las peticiones
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);


        String  baseUrl = "https://api.covid19api.com/";


        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build()) // <-- usamos el log level
                    .build();

            API_SERVICE = retrofit.create(DiagnosticVetApiService.class);


        }

        return API_SERVICE;
    }

    //public String getNombrePaís() {return nombrePaís; }

    //public void setNombrePaís(String nombrePaís) { this.nombrePaís = nombrePaís; }
}
