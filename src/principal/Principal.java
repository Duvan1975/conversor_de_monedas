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
            System.out.println("3. USD >> ARS (Dólar Estadounidense a Peso argentino)");

            //Pedir al usuario que seleccione una opción hasta que esta sea válida
            while (!entradaValida) {
                try {
                    System.out.println("Digite la opción correcta. (solo números)");
                    indice = teclado.nextInt();
                    entradaValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("Opción NO válida, inténtalo de nuevo");
                    teclado.next();
                }
            }

            //Pedir al usuario que ingrese la cantidad de dinero
            System.out.println("Digite la cantidad de dinero a convertir");
            double cantidad = teclado.nextDouble();

            //Relizar la conversión según la opción
            switch (indice){
                case 1 :
                    convertirMoneda("USD", "COP", cantidad);
                    System.out.println("hola");
                    break;
                case 2 :
                    convertirMoneda("COP", "USD", cantidad);
                    break;
                case 3 :
                    convertirMoneda("USD", "ARS", cantidad);
                    break;
                case 4 :
                    convertirMoneda("ARS","USD", cantidad);
                    break;
            }
        }
        //Método que maneja la conversión de cualquier par de monedas
        public static void convertirMoneda(String monedaOrigen, String monedaDestino, double cantidad){
            ConsultaMoneda consulta = new ConsultaMoneda(monedaOrigen, cantidad);
            Moneda moneda = consulta.conversorDeMoneda(monedaOrigen);

            //Obtenemos la tasa de cambio de la moneda destino
            Map<String, Double> conversioRates = moneda.getConversion_rates();
            Double tasaDestino = conversioRates.get(monedaDestino);

            System.out.println(tasaDestino);

            if (tasaDestino != null){
                double cantidadConvertida;
                if (monedaOrigen.equals("USD")){
                    cantidadConvertida = (cantidad * tasaDestino);
                    System.out.println(String.format("De %s a %s equivale a: %.2f %s"
                            ,monedaOrigen, monedaDestino, cantidadConvertida, monedaOrigen));
                } else {
                    cantidadConvertida = cantidad * tasaDestino;
                    System.out.println(String.format("De %s a %s equivale a: %.2f %s"
                            ,monedaOrigen, monedaDestino, cantidadConvertida, monedaOrigen));
                }

            } else {
                System.out.println("¡Error!, no se pudo realizar la conversión");
            }
        }
    }
    /*double cantidadConvertida = monedaOrigen.equals("USD")
            ? cantidad * tasaDestino
            : cantidad / tasaDestino;
                System.out.println(String.format("De %s a %s equivale a: %.2f %s"
            ,monedaOrigen, monedaDestino, cantidadConvertida, monedaOrigen));*/