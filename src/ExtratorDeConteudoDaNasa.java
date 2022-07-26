import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo{
    
    public List<Conteudo> extraiConteudos(String json){
        var parser = new JsonParser();
        List<Map<String, String>>  atributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        for( Map<String, String> atributo : atributos){
            String titulo = atributo.get("title");
            String urlImagem = atributo.get("url");

            Conteudo conteudo = new Conteudo(titulo, urlImagem);
            
            conteudos.add(conteudo);
        }

        return conteudos;
    }
}