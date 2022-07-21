import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
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

        var gerador = new GeradoraDeFigurinhas();

        for (Map<String, String> filme : filmes) {

            String titulo = filme.get("title");
            String urlImagem = filme.get("image");

            System.out.println(titulo);
            System.out.println();

            InputStream arquivo = new URL(urlImagem).openStream();

            var nomeArquivo = titulo + ".png";

            gerador.cria(arquivo, nomeArquivo);
        }
    }
}
