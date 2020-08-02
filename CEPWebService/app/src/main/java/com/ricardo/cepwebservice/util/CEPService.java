package com.ricardo.cepwebservice.util;

import com.ricardo.cepwebservice.model.CEP;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CEPService {
//    esta url complementa a que foi definida na configuração do retrofit
    @GET("{cep}/json/")
//    call é a classe com o qual o retrofit trabalha, ela é genérica e precisa saber que tipo
//    receberá, por isso passamos a classe CEP
    Call<CEP> buscarCEP(@Path("cep") String cep);
}
