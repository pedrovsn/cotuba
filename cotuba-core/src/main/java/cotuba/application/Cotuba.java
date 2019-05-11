package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.domain.FormatoEbook;
import cotuba.plugin.AoFinalizarGeracao;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Consumer;

public class Cotuba {

    public void executa(ParametrosCotuba parametros, Consumer<String> acaoPosGeracao){

        Path diretorioDosMD = parametros.getDiretorioDosMD();
        Path arquivoSaida = parametros.getArquivoSaida();
        FormatoEbook formato = parametros.getFormato();

        RenderizadorMDParaHTML renderizadorMDParaHtml = RenderizadorMDParaHTML.cria();
        List<Capitulo> capitulos = renderizadorMDParaHtml.renderiza(diretorioDosMD);

        Ebook ebook = new Ebook("Primeiro ebook pelo Cotuba", capitulos, formato, arquivoSaida);

        GeradorEbook geradorEbook = GeradorEbook.cria(ebook);
        geradorEbook.gera(ebook);

        AoFinalizarGeracao.gerou(ebook, acaoPosGeracao);
    }
}
