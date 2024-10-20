package principal;

import com.aluracursos.desafio.modelos.ConsultaMoneda;
import com.aluracursos.desafio.modelos.Moneda;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        //Crear un objeto scanner para capturar la entrada del usuario
        Scanner teclado = new Scanner(System.in);
        int indice = 0;
        int opcion = 0;
        boolean entradaValida = false;

        while (!entradaValida){
            //Mostrar menú de usuario
            System.out.println("Conversor de moneda. Seleccione la opción \n");
            System.out.println(" 1. De Dólar Estadounidense a Peso colombiano");
            System.out.println(" 2. De Peso colombiano a Dólar Estadounidense");
            System.out.println(" 3. De Dólar Estadounidense a Peso argentino");
            System.out.println(" 4. De Peso argentino a Dólar Estadounidense");
            System.out.println(" 5. De Dólar Estadounidense a Boliviano boliviano");
            System.out.println(" 6. De Boliviano boliviano a Dólar Estadounidense");
            System.out.println(" 7. De Dólar Estadounidense a Real brasileño");
            System.out.println(" 8. De Real brasileño a Dólar Estadounidense");
            System.out.println(" 9. De Dólar Estadounidense a Peso chileno");
            System.out.println("10. De Peso chileno a Dólar Estadounidense\n");

            //Pedir al usuario que seleccione una opción hasta que esta sea válida
            while (!entradaValida) {
                try {
                    System.out.println("Digite una de las opciones del menú entre 1 y 10");
                    indice = teclado.nextInt();

                    if (indice >= 1 && indice <= 10){
                        entradaValida = true;
                    } else {
                        System.out.println("¡Error! fuera del rango establecido");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Opción NO válida, inténtalo de nuevo");
                    teclado.next();
                }
            }
            entradaValida = false; //Reiniciamos la variable para reutilizarla en el bucle
            double cantidad = 0;

            //Pedir al usuario que ingrese la cantidad de dinero a convertir
            while (!entradaValida){
                try{
                    System.out.println("Digite la cantidad de dinero a convertir");
                    cantidad = teclado.nextDouble();
                    if (cantidad > 0){
                        entradaValida = true;
                    } else {
                        System.out.println("El valor digitado debe ser mayor a cero");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Opción NO válida, (solo se admite números y una coma, si es del caso) ¡Inténtalo de nuevo!");
                    teclado.next();
                }
            }
            //Relizar la conversión según la opción
            switch (indice){
                case 1 :
                    System.out.println("Realizando conversión... de dólares a pesos colombianos");
                    convertirMoneda("USD", "COP", cantidad);
                    break;
                case 2 :
                    System.out.println("Realizando conversión... de pesos colombianos a dolares");
                    convertirMoneda("COP", "USD", cantidad);
                    break;
                case 3 :
                    System.out.println("Realizando conversión... de dólares a pesos argentinos");
                    convertirMoneda("USD", "ARS", cantidad);
                    break;
                case 4 :
                    System.out.println("Realizando conversión... de pesos argentinos a dolares");
                    convertirMoneda("ARS","USD", cantidad);
                    break;
                case 5 :
                    System.out.println("Realizando conversión... de dólares a Boliviano bolivianos");
                    convertirMoneda("USD","BOB", cantidad);
                    break;
                case 6 :
                    System.out.println("Realizando conversión... de Boliviano bolivianos a dolares");
                    convertirMoneda("BOB","USD", cantidad);
                    break;
                case 7 :
                    System.out.println("Realizando conversión... de dólares a Reales brasileños");
                    convertirMoneda("USD","BRL", cantidad);
                    break;
                case 8 :
                    System.out.println("Realizando conversión... de Reales brasileños a dolares");
                    convertirMoneda("BRL","USD", cantidad);
                    break;
                case 9 :
                    System.out.println("Realizando conversión... de dólares a pesos chilenos");
                    convertirMoneda("USD","CLP", cantidad);
                    break;
                case 10 :
                    System.out.println("Realizando conversión... de pesos chilenos a dolares");
                    convertirMoneda("CLP","USD", cantidad);
                    break;
            }
            //Opciones para continuar o salir del menú
            System.out.println("");
            System.out.println("Opción:\n1 - Volver al Menú\n2 - Salir");
            opcion = teclado.nextInt();

            //validando las opciones
            if (opcion == 1) {
                entradaValida = false;
            } else if (opcion == 2){
                System.out.println("¡Gracias! por utilizar nuestro conversor de moneda");
                break;
            } else {
                System.out.println("Opción NO válida, ¡Hasta pronto!");
                break;
            }
        }
    }
    //Metodo que maneja la conversión de cualquier par de monedas
    public static void convertirMoneda(String monedaOrigen, String monedaDestino, double cantidad){
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
            }
        } else {
            System.out.println("¡Error!, no se pudo realizar la conversión");
        }
    }
}