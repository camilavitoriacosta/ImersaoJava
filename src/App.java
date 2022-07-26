import java.io.InputStream;
import java.net.URL;

public class App {
    public static void main(String[] args) throws Exception {
        var url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
        var extrator = new ExtratorDeConteudoDoIMDB();

        var http = new ClienteHttp();
        var json = http.buscaDados(url);

        var conteudos = extrator.extraiConteudos(json);

        var gerador = new GeradoraDeFigurinhas();

        for (int i = 0; i < 3; i++) {
            Conteudo conteudo = conteudos.get(i);
            InputStream arquivo = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = conteudo.getTitulo() + ".png";
            gerador.cria(arquivo, nomeArquivo);
        }
    }
}
