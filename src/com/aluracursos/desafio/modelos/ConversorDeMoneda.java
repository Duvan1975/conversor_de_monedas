package com.aluracursos.desafio.modelos;

import java.util.Map;

public class ConversorDeMoneda {

    //Metodo que maneja la conversión de cualquier par de monedas
    public static double convertirMoneda(String monedaOrigen, String monedaDestino, double cantidad){
        ConsultaMoneda consulta = new ConsultaMoneda(monedaOrigen, cantidad);
        Moneda moneda = consulta.conversorDeMoneda(monedaOrigen);

        //Obtenemos la tasa de cambio de la moneda destino
        Map<String, Double> conversioRates = moneda.getConversion_rates();
        Double tasaDestino = conversioRates.get(monedaDestino);

        if (tasaDestino != null){
            double cantidadConvertida;

            if (monedaOrigen.equals("USD")){
                cantidadConvertida = (cantidad * tasaDestino);
                System.out.println(String.format("%.2f dólares equivalen a: %.2f %s"
                        ,cantidad, cantidadConvertida, monedaDestino));

            } else {
                cantidadConvertida = cantidad * tasaDestino;
                System.out.println(String.format("%.2f %s equivalen a: %.2f dólares estadounidenses"
                        ,cantidad, monedaOrigen, cantidadConvertida));
                return cantidadConvertida;
            }
            System.out.println("\nÚltima actualización de la tasa de cambio: " + moneda.getTime_last_update_utc());
        } else {
            System.out.println("¡Error!, no se pudo realizar la conversión");
            return 0;
        }
        return cantidad;
    }

    private String monedaOrigen;
    private String monedaDestino;
    private double cantidad;
    private double cantidadConvertida;

    public ConversorDeMoneda(String monedaOrigen, String monedaDestino, double cantidad, double cantidadConvertida) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.cantidad = cantidad;
        this.cantidadConvertida = cantidadConvertida;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidadConvertida(double cantidadConvertida) {
        this.cantidadConvertida = cantidadConvertida;
    }

    public double getCantidadConvertida() {
        return cantidadConvertida;
    }


}
