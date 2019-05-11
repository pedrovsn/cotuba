package cotuba.application;

import cotuba.cli.ImprimeNoConsole;
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

        Ebook ebook = new Ebook();
        ebook.setTitulo("Primeiro ebook pelo Cotuba");
        ebook.setCapitulos(capitulos);
        ebook.setArquivoSaida(arquivoSaida);
        ebook.setFormatoEbook(formato);

        GeradorEbook geradorEbook = GeradorEbook.cria(ebook);
        geradorEbook.gera(ebook);

        AoFinalizarGeracao.gerou(ebook, acaoPosGeracao);
    }
}
