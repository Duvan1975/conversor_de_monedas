package com.aluracursos.desafio.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    private String moneda;
    private double valor;

    public ConsultaMoneda(String moneda, double valor) {
        this.moneda = moneda;
        this.valor = valor;
    }

    public Moneda conversorDeMoneda (String itemMoneda){

        URI direccion = URI.create(
                "https://v6.exchangerate-api.com/v6/90630bcfb8cf39cf41f573cf/latest/"
                        +itemMoneda);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //Imprime todo el cuerpo de la API
            //System.out.println(response.body());
        } catch (Exception  e) {
            throw new RuntimeException("No se encontró la moneda");
        }
        return new Gson().fromJson(response.body(), Moneda.class);
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
