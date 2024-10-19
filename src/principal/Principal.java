    package principal;

    import com.aluracursos.desafio.modelos.ConsultaMoneda;
    import com.aluracursos.desafio.modelos.Moneda;

    import java.util.Map;
    import java.util.Scanner;

    public class Principal {
        public static void main(String[] args) {
            //Crear un objeto scanner para capturar la entrada del usuario
            Scanner teclado = new Scanner(System.in);

            //Pedir al usuario que ingrese el tipo de moneda
            System.out.println("Digite el tipo de moneda: USD, COP, ARS");
            String monedaBase = teclado.nextLine().toUpperCase();

            //Pedir al usuario que ingrese la cantidad de dinero
            System.out.println("Digite la cantidad de: " + monedaBase);
            double cantidad = teclado.nextDouble();

            ConsultaMoneda consulta = new ConsultaMoneda(monedaBase, cantidad);
            Moneda moneda = consulta.conversorDeMoneda(monedaBase);
            //System.out.println(moneda);

            //Pedir al usuario que ingrese el tipo de moneda convertir
            System.out.println("Digite el tipo de moneda: USD, COP, ARS a convertir");
            teclado.nextLine();
            String monedaDestino = teclado.nextLine().toUpperCase();

            //Obtenemos la tasa de cambio
            Map<String, Double> conversionRates = moneda.getConversion_rates();
            Double tasaDestino = conversionRates.get(monedaDestino);

            if (tasaDestino != null){
                //Realizar la conversión
                double cantidadConvertida = cantidad * tasaDestino;
                System.out.println(String.format("%.2f %s equivalen a: %.2f %s",
                        cantidad, monedaBase, cantidadConvertida, monedaDestino));
            } else {
                System.out.println("Lo siento, el tipo de moneda no fue encontrado");
            }

            /*double tasaARS = conversionRates.get("ARS");
            System.out.println("Peso Argentino " + tasaARS);
            Realizar la conversión
            double cantidadEnCOP = (cantidadUSD * tasaCOP);
            Ejemplo para obtener el valor de COP
            double tasaUSD = conversionRates.get("USD");

            System.out.println(String.format("%.1f USD dólares, equivalen a: $%.2f pesos colombianos",
                    cantidadUSD, cantidadEnCOP));*/

        }
    }
