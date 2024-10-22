package principal;

import com.aluracursos.desafio.modelos.ConsultaMoneda;
import com.aluracursos.desafio.modelos.ConversorDeMoneda;
import com.aluracursos.desafio.modelos.GeneradorDeHistorial;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import static com.aluracursos.desafio.modelos.ConversorDeMoneda.convertirMoneda;

public class Principal {
    public static void main(String[] args) {
        GeneradorDeHistorial generadorDeHistorial = new GeneradorDeHistorial();

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
            double cantidadConvertida;

            //Relizar la conversión según la opción
            switch (indice){


                case 1 :
                    System.out.println("Realizando conversión... de dólares a pesos colombianos");
                    convertirMoneda("USD", "COP", cantidad);
                    generadorDeHistorial.agregarConversion(new ConversorDeMoneda(
                            "USD","COP", cantidad, cantidadConvertida));
                    break;
                case 2 :
                    System.out.println("Realizando conversión... de pesos colombianos a dolares");
                    convertirMoneda("COP", "USD", cantidad);
                    generadorDeHistorial.agregarConversion(new ConversorDeMoneda(
                            "COP", "USD", cantidad, cantidadConvertida));
                    break;
                /*case 3 :
                    System.out.println("Realizando conversión... de dólares a pesos argentinos");
                    convertirMoneda("USD", "ARS", cantidad);
                    generadorDeHistorial.agregarConversion(new ConversorDeMoneda());

                    break;
                case 4 :
                    System.out.println("Realizando conversión... de pesos argentinos a dolares");
                    convertirMoneda("ARS","USD", cantidad);
                    generadorDeHistorial.agregarConversion(new ConversorDeMoneda());
                    break;
                case 5 :
                    System.out.println("Realizando conversión... de dólares a Boliviano bolivianos");
                    convertirMoneda("USD","BOB", cantidad);
                    generadorDeHistorial.agregarConversion(new ConversorDeMoneda());
                    break;
                case 6 :
                    System.out.println("Realizando conversión... de Boliviano bolivianos a dolares");
                    convertirMoneda("BOB","USD", cantidad);
                    generadorDeHistorial.agregarConversion(new ConversorDeMoneda());
                    break;
                case 7 :
                    System.out.println("Realizando conversión... de dólares a Reales brasileños");
                    convertirMoneda("USD","BRL", cantidad);
                    generadorDeHistorial.agregarConversion(new ConversorDeMoneda());
                    break;
                case 8 :
                    System.out.println("Realizando conversión... de Reales brasileños a dolares");
                    convertirMoneda("BRL","USD", cantidad);
                    generadorDeHistorial.agregarConversion(new ConversorDeMoneda());
                    break;
                case 9 :
                    System.out.println("Realizando conversión... de dólares a pesos chilenos");
                    convertirMoneda("USD","CLP", cantidad);
                    generadorDeHistorial.agregarConversion(new ConversorDeMoneda());
                    break;
                case 10 :
                    System.out.println("Realizando conversión... de pesos chilenos a dolares");
                    convertirMoneda("CLP","USD", cantidad);
                    generadorDeHistorial.agregarConversion(new ConversorDeMoneda());
                    break;*/
            }

            //Opciones para continuar o salir del menú
            try {
                System.out.println("");
                System.out.println("Opción:\n1 - Volver al Menú\n2 - Salir");
                opcion = teclado.nextInt();

                //validando las opciones
                if (opcion == 1) {
                    entradaValida = false;
                } else if (opcion == 2){
                    System.out.println("¡Gracias! por utilizar nuestro conversor de moneda");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Opción NO válida, ¡Hasta pronto!");
                break;
            }

        }

        generadorDeHistorial.guardarHistorial();

        /*
        //Crear el historial
        GeneradorDeHistorial generadorDeHistorial = new GeneradorDeHistorial();
        //Realizar una conversión
        ConversorDeMoneda conversion = new ConversorDeMoneda("USD", "COP", 100, 200, "2024");
        conversion.getFechaConversion();
        //Agregar la conversion al historial
        generadorDeHistorial.agregarConversion(conversion);
        //Guardar el historial en un archivo JSON
        generadorDeHistorial.guardarHistorial();*/
    }

}