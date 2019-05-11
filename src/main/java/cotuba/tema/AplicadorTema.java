package cotuba.tema;

import cotuba.plugin.Tema;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;

public class AplicadorTema {

    public String aplica(String html){
        Document document = Jsoup.parse(html);

        List<String> listaDeTemas = Tema.carregaTemas();

        for(String css : listaDeTemas){
            document.select("head").append("<style> " + css + "</style>");
        }

        return html;
    }
}
