package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.domain.FormatoEbook;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {

    public void executa(ParametrosCotuba parametros){

        Path diretorioDosMD = parametros.getDiretorioDosMD();
        Path arquivoSaida = parametros.getArquivoSaida();
        FormatoEbook formato = parametros.getFormato();

        RenderizadorMDParaHTML renderizadorMDParaHtml = RenderizadorMDParaHTML.cria();
        List<Capitulo> capitulos = renderizadorMDParaHtml.renderiza(diretorioDosMD);

        Ebook ebook = new Ebook();
        ebook.setTitulo("Primeiro ebook pelo Cotuba");
        ebook.setCapitulos(capitulos);
        ebook.setArquivoSaida(arquivoSaida);
        ebook.setFormatoEbook(formato);

        GeradorEbook geradorEbook = GeradorEbook.cria(ebook);
        geradorEbook.gera(ebook);
    }
}
