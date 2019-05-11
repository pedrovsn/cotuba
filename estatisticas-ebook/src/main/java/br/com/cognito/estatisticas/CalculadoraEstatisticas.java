package br.com.cognito.estatisticas;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.plugin.AoFinalizarGeracao;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.text.Normalizer;
import java.util.function.Consumer;

public class CalculadoraEstatisticas implements AoFinalizarGeracao {

    @Override
    public void aposGeracao(Ebook ebook, Consumer<String> consumer) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();
        for(Capitulo capitulo : ebook.getCapitulos()){
            String html = capitulo.getConteudoHtml();

            Document document = Jsoup.parse(html);
            String texto = document.body().text();
            String textoSemPontuacao = texto.replaceAll("\\p{Punct}", "");
            textoSemPontuacao = Normalizer.normalize(textoSemPontuacao, Normalizer.Form.NFD);
            texto = textoSemPontuacao.replaceAll("^\\p{ASCII}", "");

            String[] palavras = texto.split("\\s+");

            for(String palavra : palavras){
                contagemPalavras.adicionaPalavra(palavra.toUpperCase());
            }

            for(ContagemPalavras.Contagem contagem : contagemPalavras) {
                String palavra = contagem.getPalavra();
                Integer ocorrencias = contagem.getOcorrencias();
                consumer.accept(palavra + ": " + ocorrencias);
            }
        }
    }
}
