package starwarsapi;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaPelicula {
    public Pelicula buscaPelicula(int numeroDePelicula) {
        // no olvidar al final concatenar +"/" si no no funciona y no guarda el json en el archivo
        URI direccion = URI.create("https://swapi.py4e.com/api/films/" + numeroDePelicula+"/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar el código de respuesta y el cuerpo de la respuesta
            System.out.println("Código de estado: " + response.statusCode());
            System.out.println("Cuerpo de la respuesta: " + response.body());

            if (response.statusCode() == 200) {
                return new Gson().fromJson(response.body(), Pelicula.class);
            } else {
                throw new RuntimeException("Error en la respuesta de la API: " + response.statusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("No se encontró la película con número: " + numeroDePelicula);
        }
    }
}

