package com.ricardo.cepwebservice.util;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {
    private final Retrofit retrofit;

//    o construtor serve para configurar o retrofit
    public RetrofitConfig() {
//        o builder constrói o objeto, baseUrl define a url, jackson converte o JSON
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://viacep.com.br/ws/" )
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

//    com este método podemos executar o request com o retrofit
    public CEPService getCEPService() {
        return this.retrofit.create(CEPService.class);
    }
}
