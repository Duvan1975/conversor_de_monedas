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
            boolean entradaValida = false;

            //Mostrar menú de usuario
            System.out.println("Conversor de moneda. Seleccione la opción");
            System.out.println("1. USD >> COP (Dólar Estadounidense a Peso colombiano)");
            System.out.println("2. COP >> USD (Peso colombiano a Dólar Estadounidense)");

            //Pedir al usuario que seleccione una opción hasta que esta sea válida
            while (!entradaValida){
                try {
                    System.out.println("Digite la opción correcta. (solo números)");
                    indice = teclado.nextInt();
                    entradaValida = true;
                } catch (InputMismatchException e){
                    System.out.println("Opción NO válida, inténtalo de nuevo");
                    teclado.next();
                }
            }

            //Pedir al usuario que ingrese la cantidad de dinero
            System.out.println("Digite la cantidad de dinero a convertir");
            double cantidad = teclado.nextDouble();

            switch (indice){
                case 1 : ConsultaMoneda consultaUSD = new ConsultaMoneda("USD", cantidad);
                    Moneda monedaUSD = consultaUSD.conversorDeMoneda("USD");

                    //Obtenemos la tasa de cambio
                    Map<String, Double> conversionRatesUSD = monedaUSD.getConversion_rates();
                    Double tasaCOP = conversionRatesUSD.get("COP");

                    if (tasaCOP != null){
                        double cantidadConvertidaCOP = cantidad * tasaCOP;
                        System.out.println(String.format("USD %.2f dólar(es) Estado Unidenses equivalen a: $%.2f pesos colombianos"
                                ,cantidad, cantidadConvertidaCOP) );

                    } else {
                        System.out.println("No se encontro la tasa de cambio para pesos colombianos");
                    }
                    break;
                case 2 : ConsultaMoneda consultaCOP = new ConsultaMoneda("COP", cantidad);
                    Moneda monedaCOP = consultaCOP.conversorDeMoneda("COP");

                    //Obtenemos la tasa de cambio
                    Map<String, Double> conversionRatesCOP = monedaCOP.getConversion_rates();
                    Double tasaUSD = conversionRatesCOP.get("USD");

                    if (tasaUSD != null){
                        double cantidadCovertidaUSD = cantidad * tasaUSD;
                        System.out.println(String.format("$%.2f pesos colombianos equivalen a: USD %.2f dólares Estado Unidenses"
                                ,cantidad, cantidadCovertidaUSD));
                    } else {
                        System.out.println("No se encontro la tasa de cambio para el dólar");
                    }
                    break;
                case 3 : 
                default:
                    System.out.println("Opción NO válida");
                    break;
            }
        }
    }
