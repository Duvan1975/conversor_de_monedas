package principal;

import com.aluracursos.desafio.modelos.ConsultaMoneda;
import com.aluracursos.desafio.modelos.Moneda;

public class Principal {
    public static void main(String[] args) {

        ConsultaMoneda consulta = new ConsultaMoneda("USD", 4323);
        Moneda moneda = consulta.conversorDeMoneda("USD");
        System.out.println(moneda);
    }
}
