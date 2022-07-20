import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        var url = "https://alura-filmes.herokuapp.com/conteudos";
        var endereco = URI.create(url);

        var client = HttpClient.newHttpClient();

        // buscar dados da API
        var request = HttpRequest.newBuilder(endereco).GET().build();

        var response = client.send(request, BodyHandlers.ofString());

        var body = response.body();

        var parser = new JsonParser();
        var filmes = parser.parse(body);

        for (Map<String,String> filme : filmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println();
        }
    }
}
