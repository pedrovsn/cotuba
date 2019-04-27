package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {

    public void executa(ParametrosCotuba parametros){
        Path diretorioDosMD = parametros.getDiretorioDosMD();
        Path arquivoSaida = parametros.getArquivoSaida();
        String formato = parametros.getFormato();

        RenderizadorMDParaHTML renderizadorMDParaHtml = RenderizadorMDParaHTML.cria();
        List<Capitulo> capitulos = renderizadorMDParaHtml.renderiza(diretorioDosMD);
        Ebook ebook = new Ebook();
        ebook.setTitulo("Primeiro ebook pelo Cotuba");
        ebook.setCapitulos(capitulos);
        ebook.setArquivoSaida(arquivoSaida);
        ebook.setFormato(formato);

        GeradorEbook geradorEbook = GeradorEbook.cria(formato);
        geradorEbook.gera(ebook);
    }
}
