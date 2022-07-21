import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void cria(InputStream url, String arquivoSaida) throws Exception {
        // leitura da imagem
        // InputStream url = new
        // URL("https://m.media-amazon.com/images/M/MV5BMzE5MDM1NDktY2I0OC00YWI5LTk2NzUtYjczNDczOWQxYjM0XkEyXkFqcGdeQXVyMTQxNzMzNDI@.jpg").openStream();
        var imagemOriginal = ImageIO.read(url);

        // cria nova imagem em memoria com transparencia e com tamanho novo
        var largura = imagemOriginal.getWidth();
        var altura = imagemOriginal.getHeight();

        var novaAltura = altura + 200;

        var novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem (em memoria)
        var graphics = (Graphics2D) novaImagem.getGraphics();

        graphics.drawImage(imagemOriginal, 0, 0, null);

        // escrever uma frase na nova imagem
        // configurar fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 32);
        graphics.setFont(fonte);
        graphics.setColor(Color.MAGENTA);
        graphics.drawString("Top", 100, novaAltura - 100);

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(arquivoSaida));
    }
}
