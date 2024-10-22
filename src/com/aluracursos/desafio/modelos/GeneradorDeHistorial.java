package com.aluracursos.desafio.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneradorDeHistorial {

    private List<ConversorDeMoneda> historial = new ArrayList<>();
    private Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    public GeneradorDeHistorial(){
    }
    //Metodo para agregar una conversión al historial
    public void agregarConversion(ConversorDeMoneda conversion){
        historial.add(conversion);
    }
    //Metodo para guardar el historial en un archivo JSON
    public void guardarHistorial(){

        try(FileWriter escritura = new FileWriter("historial.json")){
            gson.toJson(historial, escritura);
            System.out.println("Historial guardado correctamente");
        } catch (IOException e) {
            System.out.println("¡Error! al escribir el archivo " + e.getMessage());
        }
    }
    public List<ConversorDeMoneda> getHistorial() {
        return historial;
    }
}
