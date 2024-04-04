package co.edu.escuelaing.AREPPT2;

import java.util.ArrayList;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

public class ParcialT2 {

    public static void main(String[] args) {
        port(getPort());

        staticFiles.location("/public");

        get("/hello", (req,res) -> "Hello!");

        get("/collatz", (req, resp) -> {
            String value = req.queryParams("value");
            String respuesta = ecuacionCollatz(value);
            String response = String.format("{  \"Mi respuesta\": \"%s\" }", respuesta);
            resp.type("application/json");
            return response;
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4500;
    }

    private static String ecuacionCollatz(String numero) {
        String respuesta;
        int valor = Integer.parseInt(numero);
        ArrayList<Integer> secuencia_numeros_resultantes = new ArrayList<>();
        secuencia_numeros_resultantes.add(valor);
        while (valor > 1){
            if(valor % 2 == 0){
                valor = valor/2;
            } else{
                valor = (valor*3)+1;
            }
            secuencia_numeros_resultantes.add(valor);
        }
        respuesta = secuencia_numeros_resultantes.toString().replace("[", "").replace("]", "").replace(", ", " -> ");
        return respuesta;
    }
}