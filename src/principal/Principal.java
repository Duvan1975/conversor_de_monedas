    package principal;

    import com.aluracursos.desafio.modelos.ConsultaMoneda;
    import com.aluracursos.desafio.modelos.Moneda;

    import java.util.Map;
    import java.util.Scanner;

    public class Principal {
        public static void main(String[] args) {
            //Crear un objeto scanner para capturar la entrada del usuario
            Scanner teclado = new Scanner(System.in);

            //Pedir al usuario que ingrese la cantidad de dólares USD
            System.out.println("Digite la cantidad de dólares");
            double cantidadUSD = teclado.nextDouble();

            ConsultaMoneda consulta = new ConsultaMoneda("USD", cantidadUSD);
            Moneda moneda = consulta.conversorDeMoneda("USD");
            //System.out.println(moneda);

            //Obtenemos la tasa de cambio de COP
            Map<String, Double> conversionRates = moneda.getConversion_rates();
            double tasaCOP = conversionRates.get("COP");
            double tasaARS = conversionRates.get("ARS");
            System.out.println("Peso Argentino " + tasaARS);

            //Realizar la conversión
            double cantidadEnCOP = (cantidadUSD * tasaCOP);
            //Ejemplo para obtener el valor de COP
            //double tasaUSD = conversionRates.get("USD");

            System.out.println(String.format("%.1f USD dólares, equivalen a: $%.2f pesos colombianos",
                    cantidadUSD, cantidadEnCOP));
        }
    }
