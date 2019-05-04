package cotuba.tema;

import cotuba.domain.Capitulo;
import cotuba.plugin.Tema;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;

public class AplicadorTema {

    public void aplica(Capitulo capitulo){
        String html = capitulo.getConteudoHtml();
        Document document = Jsoup.parse(html);

        List<String> listaDeTemas = Tema.carregaTemas();

        for(String css : listaDeTemas){
            document.select("head").append("<style> " + css + "</style>");
        }

        capitulo.setConteudoHtml(document.html());
    }
}
