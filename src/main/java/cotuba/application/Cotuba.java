package cotuba;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {

    public void executa(String formato, Path diretorioDosMD, Path arquivoDeSaida){
        RenderizadorMDParaHtml renderizadorMDParaHtml = new RenderizadorMDParaHtml();
        List<Capitulo> capitulos = renderizadorMDParaHtml.renderiza(diretorioDosMD);
        Ebook ebook = new Ebook();
        ebook.setTitulo("Primeiro ebook pelo Cotuba");
        ebook.setCapitulos(capitulos);
        ebook.setArquivoSaida(arquivoDeSaida);
        ebook.setFormato(formato);

        if ("pdf".equals(formato)) {
            GeradorPDF geradorPdf = new GeradorPDF();
            geradorPdf.gera(ebook);
        } else if ("epub".equals(formato)) {
            GeradorEPUB geradorEpub = new GeradorEPUB();
            geradorEpub.gera(ebook);
        } else {
            throw new RuntimeException("Formato do ebook inválido: " + formato);
        }

        System.out.println("Arquivo gerado com sucesso: " + arquivoDeSaida);
    }
}
